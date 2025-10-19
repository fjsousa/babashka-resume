(ns yaml-to-edn
  (:require [clj-yaml.core :as yaml]
            [template :refer [template]]
            [hiccup2.core :as hiccup2]
            [pod.babashka.fswatcher :as fw]
            [babashka.fs :as fs]
            [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def source-file "resume.yaml")
(def destination-file "html/index.html")
(def page-one-html "html/page-one.html")
(def page-two-html "html/page-two.html")
(def page-one-html-info "html/personal-info/page-one.html")
;; page two has no personal info for now
;; (def page-two-html-info "html/personal-info/page-two.html")
(def details (edn/read-string (slurp ".details.edn")))

(assert (= #{:address :email :phone}
           (set (keys details)))
        "Missing .detail.edn file with email, address and phone n.")

(def latest-css
  (subs (->> (io/file "html")
             (.listFiles)
             (filter #(.isFile %))
             (filter #(#{".css"} (re-find #".css" (str %))))

             (sort-by #(.lastModified %))
             (reverse)
             (first)
             str) 5))

(defn -main
  [& args]
  ;;main index.html
  (let [parsed-resume (yaml/parse-string
                        (slurp source-file))]

    (spit destination-file (hiccup2/html
                             (template
                               (-> parsed-resume
                                   (assoc :source-code? true
                                          :web true)
                                   (assoc-in [:personal-info :email] nil)
                                   (assoc-in [:personal-info :phone] nil))
                               {:css-filename latest-css})))

    ;; sanitized version
    (spit page-one-html (hiccup2/html
                          (template
                            (-> parsed-resume
                                (update :experience #(take 5 %))
                                (dissoc :education
                                        :papers
                                        :certificates
                                        :awards
                                        :papers
                                        :tech-community)
                                (assoc-in [:personal-info :email] nil)
                                (assoc-in [:personal-info :phone] nil))
                            {:css-filename latest-css})))
    (spit page-two-html (hiccup2/html
                          (template
                            (-> parsed-resume
                                (update :experience #(subvec (vec %) 5))
                                (assoc :page 2)
                                (dissoc :summary
                                        :skills
                                        :toolbox
                                        :aws
                                        :personal-info
                                        :languages
                                        :skills))
                            {:css-filename latest-css})))

    ;; personal-info-version
    (spit page-one-html-info (hiccup2/html
                               (template
                                 (-> parsed-resume
                                     (update :experience #(take 5 %))
                                     (dissoc :education
                                             :papers
                                             :certificates
                                             :awards
                                             :papers
                                             :tech-community)
                                     (assoc-in [:personal-info :email] (:email details))
                                     (assoc-in [:personal-info :phone] (:phone details)))
                                 {:css-filename latest-css})))
    ;; page two has no personal info
    ))

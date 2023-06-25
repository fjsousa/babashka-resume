(ns yaml-to-edn
  (:require [clj-yaml.core :as yaml]
            [template :refer [template]]
            [hiccup2.core :as hiccup2]
            [pod.babashka.fswatcher :as fw]
            [babashka.fs :as fs]
            [clojure.java.io :as io]))

(def source-file "resume.yaml")
(def destination-file "html/index.html")
(def page-one-html "html/page-one.html")
(def page-two-html "html/page-two.html")


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
                             (assoc parsed-resume
                                    :source-code? true
                                    :web true)
                             {:css-filename latest-css})))

    ;;page one
    (spit page-one-html (hiccup2/html
                         (template
                          (-> parsed-resume
                              (update :experience #(take 5 %))
                              (dissoc :education
                                      :papers
                                      :certificates
                                      :awards
                                      :papers
                                      :tech-community))
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
                          {:css-filename latest-css})))))

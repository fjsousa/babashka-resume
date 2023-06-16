(ns yaml-to-edn
  (:require [clj-yaml.core :as yaml]
            [template :refer [template]]
            [hiccup2.core :as hiccup2]
            [pod.babashka.fswatcher :as fw]
            [babashka.fs :as fs]))

(def source-file "resume.yaml")
(def destination-file "html/index.html")
(def page-one-html "html/page-one.html")
(def page-two-html "html/page-two.html")

(defn -main
  [& args]
  ;;main index.html
  (let [parsed-resume (yaml/parse-string
                       (slurp source-file))]

    (spit destination-file (hiccup2/html
                            (template
                             parsed-resume)))

    ;;page one
    (spit page-one-html (hiccup2/html
                         (template
                          (-> parsed-resume
                              (update :experience #(take 2 %))
                              (dissoc :papers
                                      :certificates
                                      :awards
                                      :papers)))))
    (spit page-two-html (hiccup2/html
                         (template
                          (-> parsed-resume
                              (update :experience #(subvec (vec %) 2))
                              (dissoc :summary
                                      :education
                                      :skills
                                      :toolbox
                                      :aws
                                      :personal-info
                                      :languages
                                      :skills)))))))



#_(defn watch
    [& args]

    (println "Watching current directory for changes... Press Ctrl-C to quit.")

    (fw/watch "." (fn [{:keys [type path]}]
                    (when (or
                           (= path "./resume.yaml")
                           (= (fs/extension path) "clj"))

                      (println path " changed.")
                      (-main))
                    ) {:delay-ms 1000})

    @(promise))

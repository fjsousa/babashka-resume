(ns yaml-to-edn
  (:require [clj-yaml.core :as yaml]
            [template :refer [template]]
            [hiccup2.core :as hiccup2]
            [pod.babashka.fswatcher :as fw]
            [babashka.fs :as fs]))

(def source-file "resume.yaml")
(def destination-file "html/index.html")


(defn -main
  [& args]
  (spit destination-file (hiccup2/html
                          (template
                           (yaml/parse-string
                            (slurp source-file))))))


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

(ns yaml-to-edn
  (:require [clj-yaml.core :as yaml]
            [template :refer [template]]
            [hiccup2.core :as hiccup2]))

(defn -main
  [& args]
  (yaml/parse-string
   (slurp "resume.yaml"))
  (spit "html/index.html" (hiccup2/html template)))

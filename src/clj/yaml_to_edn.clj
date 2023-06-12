(ns yaml-to-edn
  (:require [clj-yaml.core :as yaml]
            [template :as template]))

(defn -main
  [& args]
  (yaml/parse-string
   (slurp "resume.yaml")))

(-main)

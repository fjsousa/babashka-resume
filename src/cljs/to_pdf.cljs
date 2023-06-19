(ns to-pdf
  (:require ["puppeteer$default" :as puppeteer]
            [clojure.string :as str]
            [promesa.core :as p]))


(def print-options
  {:preferCSSPageSize true ;;to set margin = 0
   :scale 0.59
   :pageRanges "1"})

(p/let [browser (.launch puppeteer #js {:headless true})
        page (.newPage browser)]
  (.goto page "http://localhost:1337/page-one.html")
  (.pdf page (clj->js (merge
                       {:path "/home/fsousa/src/resume/pdf/page-one.pdf"}
                       print-options)))
  (.goto page "http://localhost:1337/page-two.html")
  (.pdf page (clj->js (merge
                       {:path "/home/fsousa/src/resume/pdf/page-two.pdf"}
                       print-options)))
  (.close browser)
  )

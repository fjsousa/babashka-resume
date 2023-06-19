(ns template
  (:require [clojure.string :as str]))

(defn ->short-date
  [date-string]
  (if (= "present" date-string)
    "Present"
    (.format
     (java.time.LocalDate/parse (str/join "-" (reverse (str/split date-string #"/"))))
     (java.time.format.DateTimeFormatter/ofPattern "MMM yyyy"))))

(defn ->year
  [date-string]
  (.format
   (java.time.LocalDate/parse (str/join "-" (reverse (str/split date-string #"/"))))
   (java.time.format.DateTimeFormatter/ofPattern "yyyy")))

(defn head []
  [:head
   [:meta {:charset "utf-8"}] [:meta {:name "viewport" :content "initial-scale=1, width=device-width"}]
   [:link {:rel "stylesheet" :href "./global.css"}]
   [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Playfair Display:wght@700&display=swap"}]
   [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Inter:ital,wght@0,400;0,500;0,700;1,400&display=swap"}]])

(def link-box
  [:svg
   {:stroke "#000000",
    :fill "none",
    :stroke-linejoin "round",
    :width "800px",
    :xmlns "http://www.w3.org/2000/svg",
    :stroke-linecap "round",
    :stroke-width "1.5",
    :version "1.1",
    :viewBox "0 0 16 16",
    #_#_:height "800px"}
   [:polyline
    {:points "8.25 2.75,2.75 2.75,2.75 13.25,13.25 13.25,13.25 7.75"}]
   [:path {:d "m13.25 2.75-5.5 5.5m3-6.5h3.5v3.5"}]])

(defn experience-hiccup
  [{:keys [title company location dates description achievements technologies] :as experience-entry}]
  [:div.w-44.flex.flex-col.items-start.justify-start.gap-013

   [:div.self-stretch.flex.flex-row.items-center.justify-start.gap-013

    [:b.flex-1.relative.leading-148.text-h2

     (if company
       (format "%s at %s" title company)
       title)]

    ;;dates
    (when dates
      [:div.relative.text-base.font-medium.text-dimgray
       (format "%s - %s" (->short-date (first dates)) (->short-date (last dates)))])]
   [:div.text-base.font-medium.text-dimgray.text-right {:class "mt-[-0.4rem]"}location]


   ;;description
   [:div.relative.text-body.leading-110.inline-block.w-44



    [:p description]
    (when achievements
      (into [:ul.list-dash.pl-0]
            (conj (mapv (fn [item]
                          [:li.pl-s.pb-m item])
                        (drop-last achievements))
                  [:li.pl-s (last achievements)])))

    ;;technologies
    [:p.leading-148.pl-0 {:class "tracking-[4px]"} (interpose " - " (map str/upper-case technologies))]]])

(defn template [{:keys [personal-info skills toolbox summary education experience
                        awards papers languages certificates aws
                        source-code?
                        page
                        tech-community] :as resume-data}]
  [:html (head)

   ;;had to remove the page limit: h-[112.5rem]
   [:div {:class
          "relative bg-white w-full  overflow-hidden flex flex-row p-[6.00rem] box-border items-start justify-start gap-5 text-left text-lg text-gray font-nunito"}

    [:div.self-stretch.w-21.flex.flex-col.items-start.justify-start.gap-5

     [:div
      (when-let [pic (:pic personal-info)]
        [:img.rounded-full {:class "w-[12rem] mb-[2rem]" :src pic}])

      ;; NAME
      (when personal-info
        [:b.self-stretch.relative.text-name.leading-120.font-roboto
         (:name personal-info)])

      (when-let [title (:title personal-info)]
        [:p.font-reboto.text-h1 {:class "w-[16rem]"}[:b title]])]

     ;;ADDRESS, EMAIL, ETC
     (when personal-info
       [:div.self-stretch.relative.leading-152
        [:p.m-0 (:email personal-info)]
        [:p.m-0 (:phone personal-info)]
        [:p.m-0 (:address personal-info)]

        ;;linkedin
        (when-let [{:keys [url name]} (:linkedin personal-info)]
          [:p.m-0.flex.items-center name
           [:a.decoration-none.inline-flex
            {:href url :target "_blank" :class "w-[1rem]"}
            [:img.w-full {:src "/link.svg"}]]])])

     [:div.self-stretch.flex-1.flex.flex-col.items-start.justify-start.gap-5.text-3xl

      [:div.flex.flex-row.justify-between {:class "w-[19rem]"}

       ;;Languages, databases, TOOLBOX
       (when toolbox
         [:div.flex.flex-col.items-start.justify-start.gap-025
          [:b.relative.leading-152.inline-block.text-h2
           "Toolbox"]
          [:div.relative.text-body.leading-148.font-medium.inline-block

           (map (fn [tool]
                  [:p.m-0 tool]) toolbox)]])
       ;; Main skill
       (when skills
         (into
          [:div.flex.flex-col.items-start.justify-start.gap-025
           [:b.relative.leading-152.inline-block.text-h2
            "Main skills"]

           (into
            [:div.relative.text-body.leading-148.font-medium.inline-block]
            (map (fn [skill]
                   [:p.m-0 skill]) skills))]))]

      ;;AWS
      (when aws
        (into
         [:div.flex.flex-col.items-start.justify-start.gap-025
          [:b.relative.leading-152.inline-block.text-h2
           "AWS"]

          (into
           [:div.relative.text-body.leading-148.font-medium.inline-block]
           (map (fn [item]
                  [:p.m-0 item]) aws))]))

      ;;Human languages

      (when languages
        [:div.w-21.flex.flex-col.items-start.justify-start.gap-025.text-h2

         [:b {:class "relative leading-152 inline-block w-21"}
          "Languages"]

         [:div.relative.text-body.leading-148.font-medium.inline-block.w-21

          [:p.m-0 "Portuguese (Native)"]
          [:p.m-0 "English (Advanced)"]]])]

     (when tech-community
       [:div.flex.flex-col.items-start.justify-start.gap-025

        [:b.relative.leading-152.inline-block.text-h2
         "Tech comunnity"]

        [:div.relative.text-body.font-medium.inline-block.leading-120

         (let [item-fn (fn [{:keys [title url year]}]
                         [[:span title]
                          [:span.items-center.flex
                           [:span.text-dimgray.text-base (str year ".")]
                           (when url
                             [:a.decoration-none.inline-flex.gray-link-box
                              {:href url :target "_blank" :class "w-[1rem]"}
                              link-box])]])]
           (into [:ul.pl-0.list-dash]
                 (conj
                  (mapv (fn [item]
                          (into
                           [:li.pb-m.pl-s]
                           (item-fn item))) (drop-last tech-community))
                  (into [:li.pl-s] (item-fn (last tech-community))))))]])

     ;;papers
     (when papers
       [:div.flex.flex-col.items-start.justify-start.gap-025

        [:b.relative.leading-152.inline-block.text-h2
         "Research Papers"]

        [:div.relative.text-body.font-medium.inline-block.leading-120

         (let [item-fn (fn [{:keys [title doi date]}]
                         [[:span (str title ", ")]
                          [:span (str (->year date) ". ")]
                          [:a.text-inherit {:href doi :target "_blank"} "doi"]])]
           (into [:ul.pl-0.list-dash]
                 (conj
                  (mapv (fn [paper]
                          (into
                           [:li.pb-m.pl-s]
                           (item-fn paper))) (drop-last papers))
                  (into [:li.pb-m.pl-s] (item-fn (last papers))))))]])

     ;;awards
     (when awards
       [:div.flex.flex-col.items-start.justify-start.gap-025

        [:b.relative.leading-152.inline-block.text-h2
         "Awards"]

        [:div.relative.text-body.font-medium.inline-block.leading-120

         (into [:ul.pl-0.list-dash]
               (conj
                (mapv (fn [item]
                        [:li.pb-m.pl-s item])
                      (drop-last awards))
                [:li.pl-s (last awards)]))]])

     (when certificates
       [:div.flex.flex-col.items-start.justify-start.gap-025

        [:b.relative.leading-152.inline-block.text-h2
         "Training and certificates"]

        [:div.relative.text-body.font-medium.inline-block.leading-120

         (let [item-fn (fn [{:keys [title certificate place year]}]
                         [[:span title]
                          [:span.items-center.flex
                           [:span.text-dimgray.text-base (str place ", " year ". ")]
                           (when certificate
                             [:a.decoration-none.inline-flex.gray-link-box
                              {:href certificate :target "_blank" :class "w-[1rem]"}
                              link-box])]])]
           (into [:ul.pl-0.list-dash]
                 (conj
                  (mapv (fn [paper]
                          (into
                           [:li.pb-m.pl-s]
                           (item-fn paper))) (drop-last certificates))
                  (into [:li.pl-s] (item-fn (last certificates))))))]])


     ;;Updated on ...

     #_[:div
        {:class
         "relative leading-[148%] font-medium text-dimgray inline-block w-21"}
        "Updated on May 2023"]]


    [:div.self-stretch.flex-1.flex.flex-col.items-start.justify-start.gap-5.text-3xl

     ;; Summary
     (into

      (if summary
        [:i.self-stretch.relative.leading-140]
        [:div])

      (when summary (map (fn [summary-paragraph]
                           [:p.text-body {:class "last:mb-0 first:mt-0"} summary-paragraph]) summary)))

     ;; Education
     (into
      [:div.self-stretch.flex-1.flex.flex-col.items-start.justify-start.gap-25.text-h1


       (when education
         [:b.relative.text-5xl.inline-block.bg-black.text-white.print
          {:class "px-[0.3rem]"}
          "Education"])]

      ;;Education
      [(when education
         (map
          (fn [education-entry]
            [:div.w-44.flex.flex-col.items-start.justify-start.gap-013

             [:div.self-stretch.flex.flex-row.items-center.justify-start.gap-013

              [:b.flex-1.relative.leading-148.text-h3

               (format "%s at %s"
                       (:degree education-entry)
                       (:university education-entry))]

              [:div.relative.text-base.leading-148.font-medium.text-dimgray

               (str (->short-date (first (:dates education-entry)))
                    " - "
                    (->short-date (last (:dates education-entry))))]]

             (when (:activities education-entry)
               [:div.relative.text-body2.leading-120.inline-block.w-44

                (apply str
                       (flatten

                        ;;activities
                        [(interpose ". " (:activities education-entry))

                         ". "
                         ;;grades
                         (when (:grade education-entry)
                           ["Grade: " (:grade education-entry) "."])]))])])
          education))



       ;;EXPERIENCE
       (when-not (= 2 page)
         [:b.relative.text-h1.inline-block.bg-black.text-white.print
          {:class "px-[0.3rem]"}
          "Experience"])

       ;; GROUP
       (when-let [group-exp (first (filter (comp #{"group"} :type) experience))]
         (let [{:keys [title
                       company
                       dates
                       entries]} group-exp
               from (->short-date (first dates))
               to (if (= 2 (count dates))
                    (->short-date (second dates))
                    "Present")]
           [:div.w-44.flex.flex-col.items-start.justify-start.gap-013
            [:div.self-stretch.flex.flex-row.items-center.justify-start.gap-013
             [:b.flex-1.relative.leading-148.text-h2
              (format "%s at %s" title company)]

             ;;dates
             [:div.relative.text-base.leading-148.font-medium.text-dimgray
              (format " %s - %s" from to)]]

            ;;description
            (map experience-hiccup entries)]))

       (map experience-hiccup (filter (comp not #{"group"} :type) experience))])
     (when source-code?
       [:div
        {:class
         "self-stretch relative text-[1.13rem] leading-[148%] text-dimgray text-right"}
        [:a.text-inherit {:href "https://github.com/fjsousa/babashka-resume" :target "_blank"} "Source code"]])]]
   (when (not (System/getenv "RELEASE"))
     [:script {:src "live.js"}])])

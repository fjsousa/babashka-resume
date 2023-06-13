(ns template
  (:require [clojure.string :as str]))

(defn ->short-date
  [date-string]
  (.format
   (java.time.LocalDate/parse (str/join "-" (reverse (str/split date-string #"/"))))
   (java.time.format.DateTimeFormatter/ofPattern "MMM yyyy")))

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

(defn template [{:keys [personal-info skills toolbox summary education experience
                        awards papers] :as resume-data}]
  [:html (head)

   ;;had to remove the page limit: h-[112.5rem]
   [:div {:class
          "relative bg-white w-full  overflow-hidden flex flex-row p-[8.25rem] box-border items-start justify-start gap-5 text-left text-lg text-gray font-inter"}

    [:div.self-stretch.w-21.flex.flex-col.items-start.justify-start.gap-5

     ;; NAME
     [:b.self-stretch.relative.text-mega.leading-120.font-playfair-display
      (:name personal-info)]

     ;;ADDRESS, EMAIL, ETC
     [:div.self-stretch.relative.leading-152
      [:p.m-0 (:email personal-info)]
      [:p.m-0 (:phone personal-info)]
      [:p.m-0 (:address personal-info)]]

     [:div.self-stretch.flex-1.flex.flex-col.items-start.justify-start.gap-5.text-3xl

      ;; Main skill

      [:div.w-21.flex.flex-col.items-start.justify-start.gap-025

       [:b.relative.leading-152.inline-block.w-21
        "Main skills"]

       (into
        [:div.relative.text-xl.leading-148.font-medium.inline-block.w-21]

        (map (fn [skill]
               [:p.m-0 skill]) skills))]

      ;;Languages, databases, etc
      [:div.w-21.flex.flex-col.items-start.justify-start.gap-025

       [:b.relative.leading-152.inline-block.w-21
        "Toolbox"]

       [:div.relative.text-xl.leading-148.font-medium.inline-block.w-21

        (map (fn [tool]
               [:p.m-0 tool]) toolbox)]]

      ;;Human languages

      [:div.w-21.flex.flex-col.items-start.justify-start.gap-025

       [:b {:class "relative leading-152 inline-block w-21"}
        "Languages"]

       [:div.relative.text-xl.leading-148.font-medium.inline-block.w-21

        [:p.m-0 "Spanish (Native)"]
        [:p.m-0 "English (Advanced)"]]]]

     ;;papers
     [:div.w-21.flex.flex-col.items-start.justify-start.gap-025

      [:b.relative.leading-152.inline-block.w-21
       "Research Papers"]

      [:div.relative.text-xl.leading-148.font-medium.inline-block.w-21

       (map (fn [{:keys [title doi date]}]
              [:p.m-0
               [:span (str "- "title ", ")]
               [:span (str (->year date) ". ")]
               [:a {:href doi :target "_blank"} "doi"]]) papers)]]

     ;;awards
     [:div.w-21.flex.flex-col.items-start.justify-start.gap-025

      [:b.relative.leading-152.inline-block.w-21
       "Awards"]

      [:div.relative.text-xl.leading-148.font-medium.inline-block.w-21

       (map (fn [item]
              [:p.m-0 (str "- " item)]) awards)]]

     ;;Updated on ...

     #_[:div
        {:class
         "relative leading-[148%] font-medium text-dimgray inline-block w-21"}
        "Updated on May 2023"]]


    [:div.self-stretch.flex-1.flex.flex-col.items-start.justify-start.gap-5.text-3xl

     ;; Summary
     (into

      [:i.self-stretch.relative.leading-140]

      (map (fn [summary-paragraph]
             [:p summary-paragraph]) summary))

     ;; Education
     (into
      [:div.self-stretch.flex-1.flex.flex-col.items-start.justify-start.gap-25.text-xl


       [:b.relative.text-5xl.inline-block.w-21

        "Education"]]

      ;;Education
      [(map
        (fn [education-entry]
          [:div.w-44.flex.flex-col.items-start.justify-start.gap-013

           [:div.self-stretch.flex.flex-row.items-center.justify-start.gap-013

            [:b.flex-1.relative.leading-148

             (format "%s at %s"
                     (:degree education-entry)
                     (:university education-entry))]

            [:div.relative.text-base.leading-148.font-medium.text-dimgray

             (str (->short-date (first (:dates education-entry)))
                  " - "
                  (->short-date (last (:dates education-entry))))]]

           [:div.relative.text-lg.leading-120.inline-block.w-44

            (apply str
                   (flatten

                    ;;activities
                    [(when (:activities education-entry)
                       (interpose ". " (:activities education-entry)))

                     ". "
                     ;;grades
                     (when (:grade education-entry)
                       ["Grade: " (:grade education-entry) "."])]))]])
        education)



       ;;EXPERIENCE
       [:b.relative.text-5xl.inline-block.w-21

        "Experience"]

       (map (fn [experience-entry]
              [:div.w-44.flex.flex-col.items-start.justify-start.gap-013

               [:div.self-stretch.flex.flex-row.items-center.justify-start.gap-013

                [:b.flex-1.relative.leading-148

                 (format "%s at %s"
                         (:title experience-entry)
                         (:company experience-entry))]
                ;;dates
                [:div.relative.text-base.leading-148.font-medium.text-dimgray

                 (str (->short-date (first (:dates experience-entry)))
                      " - "
                      (->short-date (last (:dates experience-entry))))]]

               ;;description
               [:div.relative.text-lg.leading-120.inline-block.w-44

                [:p (:description experience-entry)]
                [:ul (map (fn [item] [:li item]) (:achievements experience-entry))]
                [:p (interpose " - " (:technologies experience-entry))]]])

            experience)])
     [:div
      {:class
       "self-stretch relative text-[1.13rem] leading-[148%] text-dimgray text-right"}
      "Learn more in my LinkedIn profile:"
      [:span {:class "[text-decoration:underline]"} "in/username"]]]]
   (when (not (System/getenv "RELEASE"))
     [:script {:src "live.js"}])])

(ns template)

(defn head []
  [:head
   [:meta {:charset "utf-8"}] [:meta {:name "viewport" :content "initial-scale=1, width=device-width"}]
   [:link {:rel "stylesheet" :href "./global.css"}]
   [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Playfair Display:wght@700&display=swap"}]
   [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Inter:ital,wght@0,400;0,500;0,700;1,400&display=swap"}]])

(defn template [{:keys [personal-info skills toolbox summary] :as resume-data}]
  [:html (head)
   [:div
    {:class
     "relative bg-white w-full h-[112.5rem] overflow-hidden flex flex-row p-[8.25rem] box-border items-start justify-start gap-[5rem] text-left text-[1.13rem] text-gray font-inter"}
    [:div
     {:class
      "self-stretch w-[21.25rem] flex flex-col items-start justify-start gap-[5rem]"}

     ;;name
     [:b {:class
          "self-stretch relative text-[3.75rem] leading-[120%] font-playfair-display"}
      (:name personal-info)]

     ;;address, email, etc
     [:div
      {:class "self-stretch relative leading-[152.62%]"}
      [:p {:class "m-0"} (:email personal-info)]
      [:p {:class "m-0"} (:phone personal-info)]
      [:p {:class "m-0"} (:address personal-info)]]

     [:div
      {:class
       "self-stretch flex-1 flex flex-col items-start justify-start gap-[5rem] text-[1.38rem]"}

      ;; Main skills
      [:div
       {:class
        "w-[21.25rem] flex flex-col items-start justify-start gap-[0.25rem]"}
       [:b
        {:class "relative leading-[152.62%] inline-block w-[21.25rem]"}
        "Main skills"]
       (into
        [:div
         {:class
          "relative text-[1.25rem] leading-[148%] font-medium inline-block w-[21.25rem]"}]
        (map (fn [skill]
               [:p {:class "m-0"} skill]) skills))]

      ;;Languages, databases, etc
      [:div
       {:class
        "w-[21.25rem] flex flex-col items-start justify-start gap-[0.25rem]"}

       [:b
        {:class "relative leading-[152.62%] inline-block w-[21.25rem]"}
        "Toolbox"]

       [:div
        {:class
         "relative text-[1.25rem] leading-[148%] font-medium inline-block w-[21.25rem]"}

        (map (fn [tool]
               [:p {:class "m-0"} tool]) toolbox)]]
      ;;Human languages

      [:div
       {:class
        "w-[21.25rem] flex flex-col items-start justify-start gap-[0.25rem]"}
       [:b
        {:class "relative leading-[152.62%] inline-block w-[21.25rem]"}
        "Languages"]
       [:div
        {:class
         "relative text-[1.25rem] leading-[148%] font-medium inline-block w-[21.25rem]"}
        [:p {:class "m-0"} "Spanish (Native)"]
        [:p {:class "m-0"} "English (Advanced)"]]]]

     ;;Updated on ...

     #_[:div
        {:class
         "relative leading-[148%] font-medium text-dimgray inline-block w-[21.25rem]"}
        "Updated on May 2023"]]


    [:div
     {:class
      "self-stretch flex-1 flex flex-col items-start justify-start gap-[5rem] text-[1.38rem]"}

     ;; Summary
     (into
      [:i
       {:class "self-stretch relative leading-[140%]"}]
      (map (fn [summary-paragraph]
             [:p summary-paragraph]) summary))

     ;; Education
     (into
      [:div
       {:class
        "self-stretch flex-1 flex flex-col items-start justify-start gap-[2.5rem] text-[1.25rem]"}
       [:b
        {:class "relative text-[1.5rem] inline-block w-[21.25rem]"}
        "Education"]]

      [#_[:div
          {:class
           "w-[44.75rem] flex flex-col items-start justify-start gap-[0.13rem]"}
          [:div
           {:class
            "self-stretch flex flex-row items-center justify-start gap-[0.13rem]"}
           [:b
            {:class "flex-1 relative leading-[148%]"}
            "Course at Institution"]
           [:div
            {:class
             "relative text-[1rem] leading-[148%] font-medium text-dimgray"}
            "Apr 2021 - Apr 2022"]]
          [:div
           {:class
            "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
           "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]

       #_[:b
          {:class "relative text-[1.5rem] inline-block w-[21.25rem]"}
          "Experience"]
       #_[:div
          {:class
           "w-[44.75rem] flex flex-col items-start justify-start gap-[0.13rem]"}
          [:div
           {:class
            "self-stretch flex flex-row items-center justify-start gap-[0.13rem]"}
           [:b
            {:class "flex-1 relative leading-[148%]"}
            "Job Title at Company Name"]
           [:div
            {:class
             "relative text-[1rem] leading-[148%] font-medium text-dimgray"}
            "Apr 2020 - Apr 2021"]]
          [:div
           {:class
            "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
           "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]]
       )
     [:div
      {:class
       "self-stretch relative text-[1.13rem] leading-[148%] text-dimgray text-right"}
      "Learn more in my LinkedIn profile:"
      [:span {:class "[text-decoration:underline]"} "in/username"]]]]
   (when (not (System/getenv "RELEASE"))
     [:script {:src "live.js"}])])

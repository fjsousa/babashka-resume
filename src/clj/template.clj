(ns template)





(def template
  [:html [:head
          [:meta {:charset "utf-8"}] [:meta {:name "viewport" :content "initial-scale=1, width=device-width"}]
          [:link {:rel "stylesheet" :href "./global.css"}]
          [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Playfair Display:wght@700&display=swap"}]
          [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Inter:ital,wght@0,400;0,500;0,700;1,400&display=swap"}]]

   [:div
    {:class
     "relative bg-white w-full h-[112.5rem] overflow-hidden flex flex-row p-[8.25rem] box-border items-start justify-start gap-[5rem] text-left text-[1.13rem] text-gray font-inter"}
    [:div
     {:class
      "self-stretch w-[21.25rem] flex flex-col items-start justify-start gap-[5rem]"}
     [:b
      {:class
       "self-stretch relative text-[3.75rem] leading-[120%] font-playfair-display"}
      "Name Lastname"]
     [:div
      {:class "self-stretch relative leading-[152.62%]"}
      [:p {:class "m-0 [text-decoration:underline]"} "website.com"]
      [:p {:class "m-0 [text-decoration:underline]"} "email@domain.com"]
      [:p {:class "m-0"} "(123) 456-7890"]]
     [:div
      {:class
       "self-stretch flex-1 flex flex-col items-start justify-start gap-[5rem] text-[1.38rem]"}
      [:div
       {:class
        "w-[21.25rem] flex flex-col items-start justify-start gap-[0.25rem]"}
       [:b
        {:class "relative leading-[152.62%] inline-block w-[21.25rem]"}
        "Main skills"]
       [:div
        {:class
         "relative text-[1.25rem] leading-[148%] font-medium inline-block w-[21.25rem]"}
        [:p {:class "m-0"} "User Research"]
        [:p {:class "m-0"} "Design Sprints"]
        [:p {:class "m-0"} "Concept Design"]
        [:p {:class "m-0"} "Prototyping"]
        [:p {:class "m-0"} "Usability Testing"]
        [:p {:class "m-0"} "Design Systems"]
        [:p {:class "m-0"} "Agile Practices"]]]
      [:div
       {:class
        "w-[21.25rem] flex flex-col items-start justify-start gap-[0.25rem]"}
       [:b
        {:class "relative leading-[152.62%] inline-block w-[21.25rem]"}
        "Preferred tools"]
       [:div
        {:class
         "relative text-[1.25rem] leading-[148%] font-medium inline-block w-[21.25rem]"}
        [:p {:class "m-0"} "Miro - FigJam"]
        [:p {:class "m-0"} "Figma - Penpot"]
        [:p {:class "m-0"} "Abstract"]
        [:p {:class "m-0"} "Maze / Usertesting"]
        [:p {:class "m-0"} "Webflow - Framer"]
        [:p {:class "m-0"} "Notion / GDocs"]
        [:p {:class "m-0"} "Zeroheight"]
        [:p {:class "m-0"} "Jira / Asana"]]]
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
     [:div
      {:class
       "relative leading-[148%] font-medium text-dimgray inline-block w-[21.25rem]"}
      "Updated on May 2023"]]
    [:div
     {:class
      "self-stretch flex-1 flex flex-col items-start justify-start gap-[5rem] text-[1.38rem]"}
     [:i
      {:class "self-stretch relative leading-[140%]"}
      "In dui lectus, molestie lacinia lectus et, elementum fringilla lorem.\n          Morbi elementum massa a erat finibus commodo. Duis id porttitor\n          tortor. Praesent mauris ipsum, mattis nec pretium nec, semper\n          convallis nisl. Aliquam vulputate iaculis dui eu blandit. Class aptent\n          taciti sociosqu ad litora torquent per conubia nostra, per inceptos\n          himenaeos. Integer et ullamcorper diam."]
     [:div
      {:class
       "self-stretch flex-1 flex flex-col items-start justify-start gap-[2.5rem] text-[1.25rem]"}
      [:b
       {:class "relative text-[1.5rem] inline-block w-[21.25rem]"}
       "Education"]
      [:div
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
         "Apr 2022 - Present"]]
       [:div
        {:class
         "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]
      [:div
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
      [:b
       {:class "relative text-[1.5rem] inline-block w-[21.25rem]"}
       "Experience"]
      [:div
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
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]
      [:div
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
         "Apr 2019 - Apr 2020"]]
       [:div
        {:class
         "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]
      [:div
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
         "Apr 2018 - Apr 2019"]]
       [:div
        {:class
         "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]
      [:div
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
         "Apr 2017 - Apr 2018"]]
       [:div
        {:class
         "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]
      [:div
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
         "Apr 2017 - Apr 2018"]]
       [:div
        {:class
         "relative text-[1.13rem] leading-[120%] inline-block w-[44.75rem]"}
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas\n              varius orci a nisl suscipit, et molestie ligula semper. Cras in\n              bibendum augue. Phasellus lacinia a turpis a ullamcorper."]]]
     [:div
      {:class
       "self-stretch relative text-[1.13rem] leading-[148%] text-dimgray text-right"}
      "Learn more in my LinkedIn profile:"
      [:span {:class "[text-decoration:underline]"} "in/username"]]]]])

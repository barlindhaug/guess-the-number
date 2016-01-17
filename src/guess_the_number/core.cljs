(ns guess-the-number.core
  (:require [quiescent.core :as q]
            [quiescent.dom :as dom]))

(enable-console-print!)

(def container (.getElementById js/document "main"))

(q/defcomponent Game []
  (dom/div {}
           (dom/p {} "Which number between 1 and 30?")))

(defn render-game [container]
  (q/render (Game) container))

(render-game container)

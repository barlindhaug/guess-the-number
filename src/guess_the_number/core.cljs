(ns guess-the-number.core
  (:require [quiescent.core :as q]
            [quiescent.dom :as dom]))

(enable-console-print!)

(def container (.getElementById js/document "main"))

(defn enter-key? [evt]
  (= 13 (.-keyCode evt)))

(q/defcomponent Guess []
  (dom/input {
       :placeholder "Guess and press enter"
       :onKeyDown (fn [event]
                    (when (enter-key? event)
                      (println (.-value (.-target event)))))}))

(q/defcomponent Game []
  (dom/div {}
           (dom/p {} "Which number between 1 and 30?")
           (Guess)))

(defn render-game [container]
  (q/render (Game) container))

(render-game container)

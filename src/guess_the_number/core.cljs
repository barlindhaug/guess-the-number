(ns guess-the-number.core
  (:require [quiescent.core :as q]
            [quiescent.dom :as dom]))

(enable-console-print!)

(defonce app-state (atom
                    {:number (rand-int 31)}))

(def container (.getElementById js/document "main"))

(defn enter-key? [evt]
  (= 13 (.-keyCode evt)))

(q/defcomponent Guess []
  (dom/input {
       :placeholder "Guess and press enter"
       :onKeyDown (fn [event]
                    (when (enter-key? event)
                      (println (.-value (.-target event)))))}))

(q/defcomponent Game [state]
  (dom/div {}
           (dom/p {} "Which number between 1 and 30?")
           (Guess)))

(defn render-game [container state]
  (q/render (Game state) container))

(render-game container @app-state)

(add-watch app-state :watch
           (fn [_ _ _ new-state]
             (render-game container new-state)))

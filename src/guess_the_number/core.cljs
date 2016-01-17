(ns guess-the-number.core
  (:require [quiescent.core :as q]
            [quiescent.dom :as dom]))

(enable-console-print!)

(def container (.getElementById js/document "main"))

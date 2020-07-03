(ns heron.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args])

(defn square
  [x]
  (* x x))

(defn abs
  [x]
  (if (< x 0)
    (- x)
    x))

;; (defn good-enough?
;;   [y x]
;;   (< (abs (- x (square y))) 0.00001))

(defn avg
  [x y]
  (/ (+ x y) 2))

(defn improve
  [y x]
  (avg y (/ x y)))

(defn heron-sqrt
  [y x i n]
  
  (println "Step: " i) 
  (if (< i n)
    (do
      (println (double y))
      (heron-sqrt (improve y x) x (+ i 1) n))
    y))

(println "Result: " (double (heron-sqrt 1 2 1 6)))
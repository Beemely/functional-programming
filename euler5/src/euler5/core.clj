(ns euler5.core
  (:gen-class))

(defn inc20
  [number]
  (+ number 20))

(defn remainder
  [num]
  (reduce + (map mod (repeat 20 num) (range 1 20))))

(defn euler
  [num]
  (if (zero? (remainder num))
    num
    (recur (inc20 num)))
  )

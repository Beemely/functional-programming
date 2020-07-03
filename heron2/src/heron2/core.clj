  (ns heron2.core
    (:gen-class))
  
    (defn -main
      "I don't do a whole lot ... yet."
      [& args])
  
    (defn cube
      [x]
      (* x x x))
    
    (defn abs
      [x]
      (if (< x 0)
        (- x)
        x))
    
    (defn good-enough?
      [y x]
      (< (abs (- x (cube y))) 0.00001))
    
    (defn avg
      [x y]
      (/ (+ x y) 3))
    
    (defn improve
      [y x]
      (avg (/ x (* y y)) (* y 2)))
   
    
    (defn heron-cube
      [y x i]
      (if (not= i 1) (println (double y))())
      (if (good-enough? y x)
        y
        (do
          (println "Step" i ":")
          (heron-cube (improve y x) x (+ i 1)))
        ))
    
    (println "Result" (double (heron-cube 1 27 1)))
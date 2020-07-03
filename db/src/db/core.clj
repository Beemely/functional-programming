(ns db.core
  (:gen-class))
 
  (defonce persons-atom (atom {}))
  
  (defn add-person!
    [email firstName lastName street number postalCode city]
    (swap! persons-atom assoc
           email {:firstName firstName
                  :lastName lastName
                  :street street
                  :number number
                  :postal postalCode
                  :city city}))
  (defn firstName
    [email]
    (:firstName (@persons-atom email)))
  (defn lastName
    [email]
    (:lastName (@persons-atom email)))
  (defn address
    [email]
    (str
     (str "e-mail (" email ") address: ")
     (:street (@persons-atom email)) " "
     (:number (@persons-atom email)) ", "
     (:postal (@persons-atom email)) " "
     (:city (@persons-atom email))
     ))
  
 

  (defn -main
    "I don't do a whole lot ... yet."
    [& args]
  
    (add-person!"dominik@mail.com" "Dominik" "Kacprzak" "Kilinskiego" "96" "95-040" "lodz")
    (add-person!"jkowalski@mail.com" "Jan" "Kowalski" "Sienkiewicza" "123" "32-145" "lodz")
    (println (address "dominik@mail.com"))
    (println (address "jkowalski@mail.com"))
    )
  
  
  
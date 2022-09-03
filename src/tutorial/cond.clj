(ns tutorial.cond)

(defn condIf
  []
  (println "\ncondIf:")
  (if (= 5 5)
    (println "true")
    (println "false")
    )
  )

(condIf)

(defn condIfDo
  []
  (println "\ncondIfDo:")
  (if (= 5 4)
    (do (println "Both are equal")
        (println "Congrats!"))
    (do (println "Neither are equal")
        (println "Sorry!"))
    )
  )

(condIfDo)

(defn condCase
  [pet]
  (println "\ncondCase:")
  (case pet
    "Dog" (println "Bark!")
    "Cat" (println "Meow!")
    "Fish" (println "Glu Glu!")
    )
  )

(condCase "Cat")

(defn condCond
  [amount]
  (println "\ncondCond:")
  (cond
    (< amount 0) (println "negative amount")
    (> amount 100) (println "amount too big")
    (>= amount 0) (println "acceptable")
    :else (println "impossible ?")
    )
  )

(condCond -1)
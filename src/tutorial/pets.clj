(ns tutorial.pets
  (:gen-class))

(defn petToHumanAge
  "returns ratio for pet age"
  [x]
  (def petStore {'dog 7, 'cat 5, 'fish 10})
  (get petStore x))

(defn getPetAge
  "returns the pet age in human years"
  [petName petType petAge]
  (def ratio (petToHumanAge petType))
  (println petName "is" (* ratio petAge) "years old"))

(getPetAge "Bruno" 'dog 1)
(getPetAge "Michu" 'cat 3)
(getPetAge "Lucas" 'fish 9)
(ns tutorial.struct_maps)

(defn Pets
  []
  (defstruct pet :Type :Name)
  (def myPet (struct pet "Dog" "Bruno"))
  (println myPet)

  (def myOtherPet (struct-map pet :Name "Michu" :Type "Cat"))
  (println myOtherPet)

  (println (:Type myPet))
  (println (:Name myOtherPet))

  (def myNewPet (assoc myPet :Name "Max"))
  (println myNewPet)

  (def myNewOtherPet (assoc myOtherPet :Age 10))
  (println myNewOtherPet)
  )

(Pets)

(ns tutorial.sequences)

(defn Seq
  []
  (def colors (seq ["white" "blue" "red"]))
  (println colors)

  (println (cons "black" colors))
  (println (cons colors "black"))

  (println (conj colors "black"))
  (println (conj ["blue" "yellow" "gray"] "black"))

  (println (concat colors (seq ["green" "purple"])))
  (println (distinct (seq [1 1 3 5 3 8 8 2 9 0 0])))

  (println (reverse colors))

  (println (first colors))
  (println (rest colors))
  (println (last colors))

  (println (sort (seq [1 1 3 5 3 8 8 2 9 0 0])))
  )

(Seq)
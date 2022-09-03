(ns tutorial.loops)

(defn Loop
  []
  (println "\nLoop:")
  (loop [x 0]
    (when (< x 10)
      (println x)
      (recur (inc x))
      )
    )
  )

(Loop)

(defn DoTimes
  []
  (println "\nDoTimes:")
  (dotimes [x 10]
    (println x)
    )
  )

(DoTimes)

(defn WhileDo
  [times]
  (println "\nWhileDo:")
  (def x (atom 0))
  (while (< @x times)
    (do
      (println @x)
      (swap! x inc)
      )
    )
  )

(WhileDo 10)

(defn DoSeq
  [seq]
  (println "\nDoSeq:")
  (doseq [x seq]
    (println (inc x))
    )
  )

(DoSeq [1 2 3 4 5])
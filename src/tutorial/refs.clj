(ns tutorial.refs)

(defn Refs
  []
  (def amount (ref 100))
  (println @amount)

  (dosync
    (ref-set amount 110)
    )
  (println @amount)

  (try
    (dosync
      (ref-set amount "a")
      (alter amount inc)
      )
    (catch Exception e
      (println (.getMessage e))
      )
    )
  (println @amount)

  (dosync
    (alter amount inc)
    )
  (println @amount)
  )

(Refs)
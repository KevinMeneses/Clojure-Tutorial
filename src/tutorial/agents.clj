(ns tutorial.agents)

(defn Agents
  []
  (def amount (agent 100))
  (println @amount)

  (send amount inc)
  (println @amount)
  (println "need some time to update")
  (println @amount)

  (send amount inc)
  (await-for 1000 amount)
  (println @amount)

  (println (agent-error amount))
  )

(Agents)
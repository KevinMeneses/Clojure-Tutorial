(ns tutorial.macros)

(macroexpand-1 '(when (= 2 2) (println "Hello")))

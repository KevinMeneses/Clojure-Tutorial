(ns tutorial.bank-challenge
  (:import (javax.print.attribute.standard PrinterInfo)))

(defstruct account :Name :Money)
(defstruct product :Name :Price)

(def buyer (struct account "buyer" (ref 100)))
(def merchant (struct account "merchant" (ref 0)))

(def pen (struct product "pen" 19))
(def notebook (struct product "notebook" 15))
(def backpack (struct product "backpack" 10))

(def boughtItems (ref (seq [])))

(defn GetItemsPrice
  [items]
  (def totalPrice (atom 0))
  (doseq [item items]
    (reset! totalPrice (+ @totalPrice (:Price item)))
    )
  @totalPrice
  )

(defn BuyerHasEnoughFunds
  [items]
  (>= @(:Money buyer) (GetItemsPrice items))
  )

(defn PrintInfo
  []
  (println "\nAccounts balance:")
  (println (:Name buyer) @(:Money buyer))
  (println (:Name merchant) @(:Money merchant))
  (println "\nItems bought:")
  (doseq [item @boughtItems] (println (:Name item)))
  )

(defn BuyItem
  [items]
  (if (BuyerHasEnoughFunds items)
    (dosync
      (ref-set (:Money buyer) (- @(:Money buyer) (GetItemsPrice items)))
      (ref-set (:Money merchant) (+ @(:Money merchant) (GetItemsPrice items)))
      (def newItems (concat @boughtItems items))
      (ref-set boughtItems newItems)
      (println "\nTransaction successful")
      (PrintInfo)
      )
    (println "\nThe buyer does not have enough funds")
    )
  )

(BuyItem [backpack pen pen notebook])
(BuyItem [pen notebook pen notebook])
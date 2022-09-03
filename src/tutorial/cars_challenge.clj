(ns tutorial.cars-challenge)

(defstruct car :Name :Price)
(def bmw (struct car "BMW" 60000))
(def ferrari (struct car "Ferrari" 100000))
(def fiat (struct car "Fiat" 20000))

(def cars [bmw ferrari fiat])

(defstruct discountCoupon :Code :Discount)
(def validCoupon (struct discountCoupon "KMP28" 0.2))

(defn GetCarDiscountPrice
  [car]
  (def price (:Price car))
  (def discount (:Discount validCoupon))
  (- price (* price discount))
  )

(defn GetCarsWithDiscount
  [budget]
  (doseq [car cars]
    (if (<= (GetCarDiscountPrice car) budget)
      (println (:Name car) (GetCarDiscountPrice car)))
    )
  )

(defn GetCars
  [budget]
  (doseq [car cars]
    (if (<= (:Price car) budget)
      (println (:Name car) (:Price car)))
    )
  )

(defn GetCarPricesWithCoupon
  [budget couponCode]
  (if (= couponCode (:Code validCoupon))
    (do
      (println "The coupon is valid")
      (GetCarsWithDiscount budget))
    (do
      (println "The coupon is invalid")
      (GetCars budget))
    )
  )

(GetCarPricesWithCoupon 80000 "KMP28")

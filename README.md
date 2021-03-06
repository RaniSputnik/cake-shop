# Connascent Cakes

My attempt at Bob's "Cake shop Kata" - learning Kotlin.

---

Connascent Cakes is an artisan baker that sells custom-made cakes for delivery. Two friends, Sandro and Marco own the shop. Marco does all the baking, while Sandro does decorations.

Sandro and Marco want to start selling cakes online and need you to write code that can calculate the delivery date for their cakes.

The "lead time" is the number of days that it takes to make a cake. The delivery date is the date the cake was ordered, plus the lead time. For example, if a cake is ordered on the 1st of the month, and has a lead time of 2 days, the delivery date is the 3rd of the month.

* Marco works from Monday-Friday, and Sandro works from Tuesday-Saturday.
* Cakes are always delivered on the day they're finished. Nobody likes stale cake.
* Small cakes have a lead time of 2 days.
* Big cakes have a lead time of 3 days.
* If Marco receives a cake order in the morning (ie, before 12pm) he starts on the same day.
* Custom frosting adds 2 days extra lead time. You can only frost a baked cake.
* The shop can gift-wrap cakes in fancy boxes. Fancy boxes have a lead time of 3 days. Boxes can arrive while the friends are working on the cake,
* The shop can decorate cakes with nuts. Unfortunately, Sandro is allergic to nuts, so Marco does this job. Decorating a cake with nuts takes 1 extra day, and has to happen after any frosting has finished.
* The shop closes for Christmas from the 23rd of December and is open again on the 2nd of January. Cakes that would be complete in that period will be unable to start production until re-opening. Fancy boxes will continue to arrive throughout the festive period.

### My Assumptions

* No decorating is needed unless extras are bought for the cakes - a small cake with no custom frosting can be completed on a Monday when Sandro isn't working.
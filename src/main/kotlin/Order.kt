import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime

class Order(private val cake: Cake, private val orderDate: LocalDateTime) {

    fun getDeliveryDate(): LocalDate {
        val orderedOn = LocalDate.from(this.orderDate)

        val bakingTime = cake.bakingTime()
        val decoratingTime = cake.decoratingTime()

        val day = orderedOn.dayOfWeek.value
        val daysUntilWeekend = DayOfWeek.SATURDAY.value - day
        val idleBakingDays = if (bakingTime >= daysUntilWeekend) 2 else 0

        val leadTime = bakingTime + idleBakingDays + decoratingTime
        return orderedOn.plusDays(leadTime.toLong())
    }
}
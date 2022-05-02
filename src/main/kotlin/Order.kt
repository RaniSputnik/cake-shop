import java.time.LocalDate
import java.time.LocalDateTime

class Order(private val cake: Cake, private val orderDate: LocalDateTime) {

    fun getDeliveryDate(): LocalDate {
        val orderedOn = LocalDate.from(this.orderDate)
        val leadTime = cake.bakingTime() + cake.decoratingTime()
        return orderedOn.plusDays(leadTime.toLong())
    }
}
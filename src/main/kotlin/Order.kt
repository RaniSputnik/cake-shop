import java.time.LocalDate
import java.time.LocalDateTime

class Order(val product: Product, val orderDate: LocalDateTime) {

    fun getDeliveryDate(): LocalDate {
        val orderedOn = LocalDate.from(this.orderDate)
        return orderedOn.plusDays(2)
    }
}
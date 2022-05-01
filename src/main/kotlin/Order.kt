import java.time.LocalDate
import java.time.LocalDateTime

class Order(product: Product, orderDate: LocalDateTime) {
    fun getDeliveryDate(): LocalDate {
        return LocalDate.of(2022, 3,3)
    }
}
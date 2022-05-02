import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

internal class OrderTest {
    private fun afternoon(date: String): LocalDateTime {
        return LocalDateTime.parse("${date}T14:00:00")
    }

    private fun expect(date: String): LocalDate {
        return LocalDate.parse(date)
    }

    @Test
    fun testSmallCakesHaveALeadTimeOfTwoDays() {
        val smallCakeOrder = Order(Product.SmallCake, afternoon("2022-03-01"))
        assertEquals(expect("2022-03-03"), smallCakeOrder.getDeliveryDate())

        val anotherOrder = Order(Product.SmallCake, afternoon("2022-05-04"))
        assertEquals(expect("2022-05-06"), anotherOrder.getDeliveryDate())
    }
}
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

internal class OrderTest {
    @Test
    fun testSmallCakesHaveALeadTimeOfTwoDays() {
        val orderDate = LocalDateTime.parse("2022-03-01T14:00:00")
        val smallCakeOrder = Order(Product.SmallCake, orderDate)
        val expected = LocalDate.parse("2022-03-03")
        assertEquals(expected, smallCakeOrder.getDeliveryDate())
    }
}
import org.junit.jupiter.api.Nested
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

    @Nested
    inner class ProductLeadTimes {

        @Test
        fun testSmallCakesHaveALeadTimeOfTwoDays() {
            val smallCakeOrder = Order(Cake.small(), afternoon("2022-03-01"))
            assertEquals(expect("2022-03-03"), smallCakeOrder.getDeliveryDate())

            val anotherOrder = Order(Cake.small(), afternoon("2022-05-04"))
            assertEquals(expect("2022-05-06"), anotherOrder.getDeliveryDate())
        }

        @Test
        fun testBigCakesHaveALeadTimeOfThreeDays() {
            val smallCakeOrder = Order(Cake.big(), afternoon("2022-03-01"))
            assertEquals(expect("2022-03-04"), smallCakeOrder.getDeliveryDate())

            val anotherOrder = Order(Cake.big(), afternoon("2022-05-03"))
            assertEquals(expect("2022-05-06"), anotherOrder.getDeliveryDate())
        }

        @Test
        fun testCustomFrostingAddsTwoDaysLeadTime() {
            val smallCakeOrder = Order(Cake.small().withCustomFrosting(), afternoon("2022-03-01"))
            assertEquals(expect("2022-03-05"), smallCakeOrder.getDeliveryDate())

            val anotherOrder = Order(Cake.big().withCustomFrosting(), afternoon("2022-03-07"))
            assertEquals(expect("2022-03-12"), anotherOrder.getDeliveryDate())
        }
    }

    @Nested
    inner class NoBakingOverWeekends {
        @Test
        fun testACakeOrderedOnFridayStartsProductionOnMonday() {
            val fridayOrder = Order(Cake.small(), afternoon("2022-03-04"))
            assertEquals(expect("2022-03-08"), fridayOrder.getDeliveryDate())
        }

        @Test
        fun testASmallCakeOrderedOnThursdayIsStartedOnFridayAndFinishedOnMonday() {
            val thursdayOrder = Order(Cake.small(), afternoon("2022-03-03"))
            assertEquals(expect("2022-03-07"), thursdayOrder.getDeliveryDate())
        }

        @Test
        fun testABigCakeOrderedOnWednesdayIsFinishedTheFollowingWeek() {
            val thursdayOrder = Order(Cake.big(), afternoon("2022-03-09"))
            assertEquals(expect("2022-03-14"), thursdayOrder.getDeliveryDate())
        }
    }
}
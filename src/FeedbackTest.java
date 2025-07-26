
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class FeedbackTest {
    
    private Feedback feedback;

    @BeforeEach
    void setUp() {
        feedback = new Feedback();
    }

    @Test
    void testIsExpiredWhenExpiryDateIsNull() {
        feedback.setExpiryDate(null);
        assertFalse(feedback.isExpired());
    }

    @Test
    void testIsExpiredWhenFeedbackIsExpired() {
        feedback.setExpiryDate(LocalDate.now().minusDays(1));
        assertTrue(feedback.isExpired());
    }

    @Test
    void testIsExpiredWhenFeedbackIsNotExpired() {
        feedback.setExpiryDate(LocalDate.now().plusDays(1));
        assertFalse(feedback.isExpired());
    }

    @Test void testIsInStockWhenQuantityIsGreaterThanZero() {
        feedback.setQuantity(10);
        assertTrue(feedback.isInStock());
    }

    @Test
    void testIsInStockWhenQuantityIsZero() {
        feedback.setQuantity(0);
        assertFalse(feedback.isInStock());
    }

    @Test
    void testIsInStockWhenQuantityIsNegative() {
        feedback.setQuantity(-5);
        assertFalse(feedback.isInStock());
    }

    @Test
    void testIsCheapFeedbackWhenPriceIsLessThan50() {
        feedback.setPrice(49.99);
        assertTrue(feedback.isCheapFeedback());
    }

    @Test
    void testIsCheapFeedbackWhenPriceIs50() {
        feedback.setPrice(50.0);
        assertFalse(feedback.isCheapFeedback());
    }

    @Test
    void testIsCheapFeedbackWhenPriceIsGreaterThan50() {
        feedback.setPrice(50.01);
        assertFalse(feedback.isCheapFeedback());
    }

    @Test
    void testComparePriceWhenPricesAreEqual() {
        Feedback otherFeedback = new Feedback();
        feedback.setPrice(100.0);
        otherFeedback.setPrice(100.0);
        assertEquals(0, feedback.comparePrice(otherFeedback));
    }

    @Test
    void testComparePriceWhenThisPriceIsLessThanOther() {
        Feedback otherFeedback = new Feedback();
        feedback.setPrice(99.99);
        otherFeedback.setPrice(100.0);
        assertEquals(-1, feedback.comparePrice(otherFeedback));
    }

    @Test
    void testComparePriceWhenThisPriceIsGreaterThanOther() {
        Feedback otherFeedback = new Feedback();
        feedback.setPrice(100.01);
        otherFeedback.setPrice(100.0);
        assertEquals(1, feedback.comparePrice(otherFeedback));
    }

    @Test void testGetShelfLifeInDaysWithValidDates() {
        feedback.setManufactureDate(LocalDate.of(2023, 1, 1));
        feedback.setExpiryDate(LocalDate.of(2023, 1, 10));
        assertEquals(9, feedback.getShelfLifeInDays());
    }

    @Test
    void testGetShelfLifeInDaysWhenManufactureOrExpiryDateIsNull() {
        feedback.setManufactureDate(null);
        feedback.setExpiryDate(LocalDate.of(2023, 1, 10));
        assertEquals(-1, feedback.getShelfLifeInDays());

        feedback.setManufactureDate(LocalDate.of(2023, 1, 1));
        feedback.setExpiryDate(null);
        assertEquals(-1, feedback.getShelfLifeInDays());
    }
    
    @Test void testGetShelfLifeInDaysWhenManufactureDateAfterExpiryDate() {
        feedback.setManufactureDate(LocalDate.of(2023, 1, 11));
        feedback.setExpiryDate(LocalDate.of(2023, 1, 10));
        assertEquals(-1, feedback.getShelfLifeInDays());
    }

    @Test
    void testToString() {
        feedback.setId("P001");
        feedback.setName("Feedback A");
        feedback.setPrice(99.99);
        feedback.setManufactureDate(LocalDate.of(2023, 1, 1));
        feedback.setExpiryDate(LocalDate.of(2023, 12, 31));
        feedback.setQuantity(100);
        String expectedString = "Feedback [id=P001, name=Feedback A, price=99.99, manufactureDate=2023-01-01, expiryDate=2023-12-31, quantity=100]";
        assertEquals(expectedString, feedback.toString());
    }

    @Test
    void testConstructorAndGetters() {
        String expectedId = "P123";
        String expectedName = "Test Feedback";
        double expectedPrice = 199.99;
        LocalDate expectedManufactureDate = LocalDate.of(2023, 6, 1);
        LocalDate expectedExpiryDate = LocalDate.of(2024, 6, 1);
        int expectedQuantity = 50;

        Feedback newFeedback = new Feedback(
            expectedId,
            expectedName,
            expectedPrice,
            expectedManufactureDate,
            expectedExpiryDate,
            expectedQuantity
        );

        assertEquals(expectedId, newFeedback.getId());
        assertEquals(expectedName, newFeedback.getName());
        assertEquals(expectedPrice, newFeedback.getPrice());
        assertEquals(expectedManufactureDate, newFeedback.getManufactureDate());
        assertEquals(expectedExpiryDate, newFeedback.getExpiryDate());
        assertEquals(expectedQuantity, newFeedback.getQuantity());
    }

}

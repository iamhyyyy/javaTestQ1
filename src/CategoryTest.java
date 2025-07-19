
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CategoryTest {
    private Category category;
    private Category category1;
    private Category category2;

    @BeforeEach
    public void setUp() {
        category = new Category();
        category.setStatus(true);
        category.setCreatedDate(LocalDate.of(2021, 1, 1));
        category1 = new Category("1", "Electronics", "Items of electronic nature", true, LocalDate.of(2021, 1, 1));
        category2 = new Category("2", "Furniture", "Household furniture items", false, LocalDate.of(2022, 6, 15));
    }

    @Test
    public void testIsActive() {
        assertTrue(category.isActive(category));
        assertTrue(category1.isActive(category1));
        assertFalse(category2.isActive(category2));
    }

    @Test
    public void testUpdateStatus() {
        category1.updateStatus(category1, false);
        assertFalse(category1.isStatus());
        category2.updateStatus(category2, true);
        assertTrue(category2.isStatus());
    }

    @Test
    public void testGetDaysSinceCreated() {
        LocalDate today = LocalDate.now();
        long expectedDays1 = ChronoUnit.DAYS.between(category1.getCreatedDate(), today);
        long expectedDays2 = ChronoUnit.DAYS.between(category2.getCreatedDate(), today);

        assertEquals(expectedDays1, category1.getDaysSinceCreated(category1));
        assertEquals(expectedDays2, category2.getDaysSinceCreated(category2));
    }

    @Test
    public void testNameContainsKeyword() {
        assertTrue(category1.nameContainsKeyword(category1, "electronic"));
        assertTrue(category1.nameContainsKeyword(category1, "Electronics"));
        assertFalse(category1.nameContainsKeyword(category1, "furniture"));
        assertTrue(category2.nameContainsKeyword(category2, "furn"));
        assertFalse(category2.nameContainsKeyword(category2, "electronics"));
    }

    @Test
    public void testCompareByCreatedDate() {
        assertTrue(category1.compareByCreatedDate(category1, category2) < 0);
        assertTrue(category2.compareByCreatedDate(category2, category1) > 0);
        Category category3 = new Category("3", "Groceries", "Daily food items", true, LocalDate.of(2021, 1, 1));
        assertEquals(0, category1.compareByCreatedDate(category1, category3));
    }

    @Test
    public void testGetSetId() {
        category1.setId("3");
        assertEquals("3", category1.getId());
    }

    @Test
    public void testGetSetName() {
        category1.setName("Appliances");
        assertEquals("Appliances", category1.getName());
    }

    @Test
    public void testGetSetDescription() {
        category1.setDescription("New Description");
        assertEquals("New Description", category1.getDescription());
    }

    @Test
    public void testGetSetStatus() {
        category1.setStatus(false);
        assertFalse(category1.isStatus());
    }

    @Test
    public void testGetSetCreatedDate() {
        LocalDate newDate = LocalDate.of(2023, 1, 1);
        category1.setCreatedDate(newDate);
        assertEquals(newDate, category1.getCreatedDate());
    }
}


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BrandTest {

    private Brand brand;

    // Tạo mới một obj Brand với các giá trị mẫu để dùng cho các test case.
    @BeforeEach
    public void setUp() {
        brand = new Brand("001", "BrandName", "SoundBrand", 1500.00, "USA", 2015, "http://brandwebsite.com", true, "http://logourl.com");
    }

    //Kiểm tra constructor mặc định, Tất cả thuộc tính kiểu String phải là null.
    @Test
    public void testDefaultConstructor() {
        Brand defaultBrand = new Brand();
        assertNull(defaultBrand.getBrandId());
        assertNull(defaultBrand.getBrandName());
        assertNull(defaultBrand.getSoundBrand());
        assertEquals(defaultBrand.getPrice(), 0.0);//price = 0.0
        assertNull(defaultBrand.getCountry());
        assertEquals(defaultBrand.getYearFounded(), 0);//yearFounded = 0
        assertNull(defaultBrand.getWebsite());
        assertFalse(defaultBrand.isActive());//isActive = false
        assertNull(defaultBrand.getLogoUrl());
    }

    //Kiểm tra hàm toString() trả về đúng định dạng mong muốn.
    @Test
    public void testToString() {
        String expected = "Brand [brandId=001, brandName=BrandName, soundBrand=SoundBrand, price=1500.0, country=USA, yearFounded=2015, website=http://brandwebsite.com, isActive=true, logoUrl=http://logourl.com]";
        assertEquals(brand.toString(), expected);
    }

    //Kiểm tra hàm isFromCountry hoạt động đúng (phân biệt đúng sai tên nước, không phân biệt hoa thường).
    @Test
    public void testIsFromCountryPositive() {
        assertTrue(brand.isFromCountry("usa"));
    }

    @Test
    public void testIsFromCountryNegative() {
        assertFalse(brand.isFromCountry("Canada"));
    }

    //Nếu country là null, hàm isFromCountry phải trả về false.
    @Test
    public void testIsFromCountryNullCountry() {
        brand.setCountry(null);
        assertFalse(brand.isFromCountry("USA"));
    }

    //test hàm có phải hãng mắc tiềng khom, dựa vào price
    @Test
    public void testIsPremiumBrandTrue() {
        assertTrue(brand.isPremiumBrand());
    }

    @Test
    public void testIsPremiumBrandFalse() {
        brand.setPrice(500.00);
        assertFalse(brand.isPremiumBrand());
    }

    //test hàm so sánh giá giữa 2 hãng, nếu giá bằng nhau thì trả về 0.
    @Test
    public void testComparePriceEqual() {
        Brand other = new Brand();
        other.setPrice(1500.00);
        assertEquals(brand.comparePrice(other), 0);
    }

    @Test //cái này là test getter với setter
    public void testAllSettersGetters() {
        // Set values
        brand.setBrandId("B001");
        brand.setBrandName("Toyota");
        brand.setSoundBrand("Vroom");
        brand.setPrice(29999.99);
        brand.setCountry("Japan");
        brand.setYearFounded(1937);
        brand.setWebsite("https://www.toyota.com");
        brand.setActive(true);
        brand.setLogoUrl("https://logo.com/toyota.png");

        // check set giá trị rồi get lại phải đúng
        assertEquals(brand.getBrandId(), "B001");
        assertEquals(brand.getBrandName(), "Toyota");
        assertEquals(brand.getSoundBrand(), "Vroom");
        assertEquals(brand.getPrice(), 29999.99);
        assertEquals(brand.getCountry(), "Japan");
        assertEquals(brand.getYearFounded(), 1937);
        assertEquals(brand.getWebsite(), "https://www.toyota.com");
        assertTrue(brand.isActive());
        assertEquals(brand.getLogoUrl(), "https://logo.com/toyota.png");
    }

    //test hàm is new brand 
    //Nếu năm thành lập gần (ví dụ mới 2 năm) thì trả về true.
    @Test
    public void testIsNewBrand_True() {
        int currentYear = java.time.Year.now().getValue();
        Brand brand = new Brand();
        brand.setYearFounded(currentYear - 2); // mới thành lập 2 năm

        assertTrue(brand.isNewBrand(), "Brand should be considered new.");
    }

    //Nếu năm thành lập cũ (ví dụ 2000) thì trả về false.
    @Test
    public void testIsNewBrand_False() {
        Brand brand = new Brand();
        brand.setYearFounded(2000); // cũ rồi

        assertFalse(brand.isNewBrand(), "Brand should NOT be considered new.");
    }
}

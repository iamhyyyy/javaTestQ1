
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrandTest {

    private Brand brand;

    @BeforeMethod
    public void setUp() {
        brand = new Brand("001", "BrandName", "SoundBrand", 1500.00, "USA", 2015, "http://brandwebsite.com", true, "http://logourl.com");
    }

    @Test
    public void testDefaultConstructor() {
        Brand defaultBrand = new Brand();
        Assert.assertNull(defaultBrand.getBrandId());
        Assert.assertNull(defaultBrand.getBrandName());
        Assert.assertNull(defaultBrand.getSoundBrand());
        Assert.assertEquals(defaultBrand.getPrice(), 0.0);
        Assert.assertNull(defaultBrand.getCountry());
        Assert.assertEquals(defaultBrand.getYearFounded(), 0);
        Assert.assertNull(defaultBrand.getWebsite());
        Assert.assertFalse(defaultBrand.isActive());
        Assert.assertNull(defaultBrand.getLogoUrl());
    }

    @Test
    public void testToString() {
        String expected = "Brand [brandId=001, brandName=BrandName, soundBrand=SoundBrand, price=1500.0, country=USA, yearFounded=2015, website=http://brandwebsite.com, isActive=true, logoUrl=http://logourl.com]";
        Assert.assertEquals(brand.toString(), expected);
    }

    //test hàm coi hãng ở nước nào
    @Test
    public void testIsFromCountryPositive() {
        Assert.assertTrue(brand.isFromCountry("usa"));
    }

    @Test
    public void testIsFromCountryNegative() {
        Assert.assertFalse(brand.isFromCountry("Canada"));
    }

    @Test
    public void testIsFromCountryNullCountry() {
        brand.setCountry(null);
        Assert.assertFalse(brand.isFromCountry("USA"));
    }

    //test hàm có phải hãng mắc tiềng khom
    @Test
    public void testIsPremiumBrandTrue() {
        Assert.assertTrue(brand.isPremiumBrand());
    }

    @Test
    public void testIsPremiumBrandFalse() {
        brand.setPrice(500.00);
        Assert.assertFalse(brand.isPremiumBrand());
    }

    //test hàm so sánh giá giữa 2 hãng
    @Test
    public void testComparePriceEqual() {
        Brand other = new Brand();
        other.setPrice(1500.00);
        Assert.assertEquals(brand.comparePrice(other), 0);
    }

    @Test //cái này là test getter với setter
    public void testAllSetters() {
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

        // Verify values via getters
        Assert.assertEquals(brand.getBrandId(), "B001");
        Assert.assertEquals(brand.getBrandName(), "Toyota");
        Assert.assertEquals(brand.getSoundBrand(), "Vroom");
        Assert.assertEquals(brand.getPrice(), 29999.99);
        Assert.assertEquals(brand.getCountry(), "Japan");
        Assert.assertEquals(brand.getYearFounded(), 1937);
        Assert.assertEquals(brand.getWebsite(), "https://www.toyota.com");
        Assert.assertTrue(brand.isActive());
        Assert.assertEquals(brand.getLogoUrl(), "https://logo.com/toyota.png");
    }

    //test hàm is new brand 
    @Test
    public void testIsNewBrand_True() {
        int currentYear = java.time.Year.now().getValue();
        Brand brand = new Brand();
        brand.setYearFounded(currentYear - 2); // mới thành lập 2 năm

        Assert.assertTrue(brand.isNewBrand(), "Brand should be considered new.");
    }

    @Test
    public void testIsNewBrand_False() {
        Brand brand = new Brand();
        brand.setYearFounded(2000); // cũ rồi

        Assert.assertFalse(brand.isNewBrand(), "Brand should NOT be considered new.");
    }
}

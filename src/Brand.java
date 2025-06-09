

//Brand: là các dòng xe mà hãng xe có
public class Brand {
    //props
    private String brandId;
    private String brandName;
    private String soundBrand;
    private double price;
    private String country;
    private int yearFounded;
    private String website;
    private boolean isActive;
    private String logoUrl;


    
    //constructor
    public Brand() {
    }
    
    public Brand(String brandId, String brandName, String soundBrand, double price, String country, int yearFounded,
            String website, boolean isActive, String logoUrl) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
        this.country = country;
        this.yearFounded = yearFounded;
        this.website = website;
        this.isActive = isActive;
        this.logoUrl = logoUrl;
    }


    //getter & setter
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
    
    // method
    @Override
    public String toString() {
        return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", soundBrand=" + soundBrand + ", price="
                + price + ", country=" + country + ", yearFounded=" + yearFounded + ", website=" + website
                + ", isActive=" + isActive + ", logoUrl=" + logoUrl + "]";
    }

    public boolean isFromCountry(String countryName) {
        return this.country != null && this.country.equalsIgnoreCase(countryName);
    }

    public int getBrandAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - this.yearFounded;
    }

    public boolean isPremiumBrand() {
        return this.price > 1000;
    }

    public int comparePrice(Brand other) {
        return Double.compare(this.price, other.price);
    }
    
    public boolean isNewBrand() {
        int age = getBrandAge();
        return age >= 0 && age < 5;
    }
}

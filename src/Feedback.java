import java.time.LocalDate;

public class Feedback {
    // Props
    private String id;
    private String name;
    private double price;
    private LocalDate manufactureDate; // ngày sản xuất
    private LocalDate expiryDate;      // hạn sử dụng
    private int quantity;

    // Constructors
    public Feedback() {
    }

    public Feedback(String id, String name, double price, LocalDate manufactureDate, LocalDate expiryDate, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    // Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Methods

    @Override
    public String toString() {
        return "Feedback [id=" + id + ", name=" + name + ", price=" + price + ", manufactureDate=" + manufactureDate
                + ", expiryDate=" + expiryDate + ", quantity=" + quantity + "]";
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    public boolean isCheapFeedback() {
        return price < 50;
    }

    public int comparePrice(Feedback other) {
        return Double.compare(this.price, other.price);
    }

    public long getShelfLifeInDays() {
        if (manufactureDate != null && expiryDate != null) {
            return java.time.temporal.ChronoUnit.DAYS.between(manufactureDate, expiryDate);
        }
        return -1;
    }
}

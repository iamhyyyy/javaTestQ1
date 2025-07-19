import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Category {
    private String id;
    private String name;
    private String description;
    private boolean status; // true = active, false = inactive
    private LocalDate createdDate;

    public Category() {
    }

    public Category(String id, String name, String description, boolean status, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive(Category category) {
        return category.isStatus();
    }

    // 2. Cập nhật trạng thái category
    public void updateStatus(Category category, boolean newStatus) {
        category.setStatus(newStatus);
    }

    // 3. Tính số ngày kể từ ngày tạo category đến hôm nay
    public long getDaysSinceCreated(Category category) {
        return ChronoUnit.DAYS.between(category.getCreatedDate(), LocalDate.now());
    }

    // 4. Kiểm tra category có tên chứa từ khóa nào đó
    public boolean nameContainsKeyword(Category category, String keyword) {
        return category.getName().toLowerCase().contains(keyword.toLowerCase());
    }

    // 5. So sánh hai category theo ngày tạo
    public int compareByCreatedDate(Category c1, Category c2) {
        return c1.getCreatedDate().compareTo(c2.getCreatedDate());
    }
}
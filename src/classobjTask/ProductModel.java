package classobjTask;

/**
 * Created by Anukul-PC on 06-07-2018.
 */
public class ProductModel {
    private String productName;
    private int productPrice;
    private String discription;
    private int categoryId;

    public ProductModel(String productName, int productPrice, String discription, int categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discription = discription;
        this.categoryId = categoryId;
    }

    public ProductModel() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
package classobjTask;

/**
 * Created by Anukul-PC on 06-07-2018.
 */
public class ProductModel {
    private String productName;
    private int productPrice;
    private String discription;

    public ProductModel(String productName, int productPrice, String discription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discription = discription;
    }
    public ProductModel(){

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
}

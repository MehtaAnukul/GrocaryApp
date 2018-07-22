package classobjTask;

/**
 * Created by Anukul-PC on 21-07-2018.
 */
public class UserOrderModel {

    private int productQuantity;
    private ProductModel productModel;

    public UserOrderModel(int productQuantity, ProductModel productModel) {
        this.productQuantity = productQuantity;
        this.productModel = productModel;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }
}

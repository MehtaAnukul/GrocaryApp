package classobjTask;

import java.util.ArrayList;

/**
 * Created by Anukul-PC on 19-07-2018.
 */
public class OrderModel {
    private String userName;
    private int productQuantity;
    private float total;
    private ArrayList<ProductModel> productModelArrayList;

    public OrderModel(String userName, int productQuantity, float total, ArrayList<ProductModel> productModelArrayList) {
        this.userName = userName;
        this.productQuantity = productQuantity;
        this.total = total;
        this.productModelArrayList = productModelArrayList;
    }

    public OrderModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<ProductModel> getProductModelArrayList() {
        return productModelArrayList;
    }

    public void setProductModelArrayList(ArrayList<ProductModel> productModelArrayList) {
        this.productModelArrayList = productModelArrayList;
    }
}

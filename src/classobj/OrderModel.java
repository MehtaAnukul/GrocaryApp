package classobj;

import java.util.ArrayList;

/**
 * Created by Anukul-PC on 19-07-2018.
 */
public class OrderModel {
    private String userName;
    private float total;
    private ArrayList<UserOrderModel> userOrderModel;

    public OrderModel(String userName, float total, ArrayList<UserOrderModel> userOrderModel) {
        this.userName = userName;
        this.total = total;
        this.userOrderModel = userOrderModel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<UserOrderModel> getUserOrderModel() {
        return userOrderModel;
    }

    public void setUserOrderModel(ArrayList<UserOrderModel> userOrderModel) {
        this.userOrderModel = userOrderModel;
    }
}

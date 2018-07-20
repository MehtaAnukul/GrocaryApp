package classobjTask;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anukul-PC on 06-07-2018.
 */
public class GrocaryArrayList {
    private long subTotal = 0;
    private long orderTotal = 0;
    private int productQuntity = 0;
    private Scanner getInput;
    private ArrayList<AdminLoginModel> adminLoginModelArrayList;
    private ArrayList<CategoryModel> categoryModelArrayList;
    private ArrayList<ProductModel> productModelArrayList;
    private ArrayList<OrderModel> orderModelArrayList;
    private AdminLoginModel adminLoginModel;
    private ArrayList<ProductModel> orderProductModelArrayList;


    GrocaryArrayList() {
        getInput = new Scanner(System.in);
        adminLoginModelArrayList = new ArrayList<>();
        categoryModelArrayList = new ArrayList<>();
        productModelArrayList = new ArrayList<>();
        adminLoginModel = new AdminLoginModel();
        orderModelArrayList = new ArrayList<>();
        orderProductModelArrayList = new ArrayList<>();
        choice();
    }

    private void choice() {
        int choice;
        System.out.println("");
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("3.Exit");
        System.out.println("choose choice:");
        choice = getInput.nextInt();

        switch (choice) {
            case 1:
                login();
                changesInCategoryAndProduct();
                choice();
                break;
            case 2:
                User();
                choice();
                break;

        }

    }


    private void User() {

        int choice;
        System.out.println("");
        System.out.println("1.See the menu");
        System.out.println("2.Apply or Make a order");
        System.out.println("3.See your Order with bill");
        System.out.println("4.Remove your all order");
        System.out.println("5.Exit");
        choice = getInput.nextInt();

        switch (choice) {
            case 1:
                menu();
//                choice();
                break;
            case 2:
                System.out.println("Enter your name:");
                final String userName = getInput.next();
                makeOrder(userName);
//                choice();
                break;

            case 3:
                // seeOrderBill();
                choice();
                break;
            case 4:
                removeOrder();
            case 5:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                choice();
                break;
        }
    }

    private void makeOrder(String userName) {

        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + categoryModelArrayList.get(i).getCategoryName());
        }
        int categoryChoice;
        int productChoice;
        subTotal = 0;

        System.out.println("Enter your chategory");
        categoryChoice = getInput.nextInt();

        System.out.println(categoryModelArrayList.get(categoryChoice).getCategoryName());

        for (int i = 0; i < productModelArrayList.size(); i++) {
            if (categoryChoice == productModelArrayList.get(i).getCategoryId()) {
                System.out.println("Product" + ":" + productModelArrayList.indexOf(productModelArrayList.get(i)) + "." + productModelArrayList.get(i).getProductName() + " | "
                        + productModelArrayList.get(i).getProductPrice() + " | "
                        + productModelArrayList.get(i).getDiscription());
            }
        }

        System.out.println("choose your product for make order");
        productChoice = getInput.nextInt();

        System.out.println("How mach quntity of your product");
        productQuntity = getInput.nextInt();

        orderProductModelArrayList.add(productModelArrayList.get(productChoice));

        subTotal = productQuntity * productModelArrayList.get(productChoice).getProductPrice();
        orderTotal = orderTotal + subTotal;


        chooseMoreProduct(userName, productQuntity, orderTotal, orderProductModelArrayList);

    }


    private void chooseMoreProduct(String userName, int productQuntity, float orderTotal, ArrayList<ProductModel> orderProductModelArrayList) {
        String choice;
        System.out.println("Press Y for choose more and N for No");
        choice = getInput.next();
        if (choice.equals("Y")) {
            makeOrder(userName);
        } else {
            orderModelArrayList.add(new OrderModel(userName, productQuntity, orderTotal, orderProductModelArrayList));
            for (int i = 0; i < orderModelArrayList.size(); i++) {
                System.out.println("--Username--" + orderModelArrayList.get(i).getUserName()
                        + "-- Total -- " + orderModelArrayList.get(i).getTotal()
                        + "--Qunt -- " + orderModelArrayList.get(i).getProductQuantity());

                for (int j = 0; j < orderModelArrayList.get(i).getProductModelArrayList().size(); j++) {
                    System.out.println(orderModelArrayList.get(i).getProductModelArrayList().get(j).getProductName() + "--"
                            + orderModelArrayList.get(i).getProductModelArrayList().get(j).getProductPrice());
                }
            }
        }
        changesInCategoryAndProduct();

        //addtocart();
    }


   /* private void addtocart(String userName) {
        System.out.println("");
        System.out.println("your order is");

        orderModelArrayList.add(new OrderModel())


    }*/

    private void menu() {
        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + categoryModelArrayList.get(i).getCategoryName());

            for (int j = 0; j < productModelArrayList.size(); j++) {
                if (productModelArrayList.get(j).getCategoryId() == categoryModelArrayList.indexOf(categoryModelArrayList.get(i))) {
                    System.out.println("--------Product" + productModelArrayList.get(j).getProductName() + " | "
                            + productModelArrayList.get(j).getProductPrice() + " | "
                            + productModelArrayList.get(j).getDiscription());
                }
            }
        }


    }

    private void removeOrder() {
        int choice;
        System.out.println("");
        System.out.println("1.Remove all Order");
        System.out.println("2.Remove perticular order");
        System.out.println("3.Exit");
        choice = getInput.nextInt();
        switch (choice) {
            case 1:
                removeAllOrder();
                choice();
                break;
            case 2:
                removePerticularOrder();
                choice();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                choice();
                break;
        }
    }

    private void removePerticularOrder() {
        int index;
        System.out.println("");

        for (int i = 0; i < orderModelArrayList.size(); i++) {
            System.out.println(i + "." + orderModelArrayList.get(i).getUserName());
            System.out.println(orderModelArrayList.get(0).getProductModelArrayList().get(0).getProductName() + " | "
                    + orderModelArrayList.get(0).getProductQuantity() + " | "
                    + orderModelArrayList.get(0).getProductModelArrayList().get(0).getProductPrice() + " | "
                    + orderModelArrayList.get(0).getTotal() + "  --"
                    + orderModelArrayList.get(0).getProductModelArrayList().size());

        }
        System.out.println("");
        System.out.println("Enter your index for delete particular Order");
        index = getInput.nextInt();

        orderModelArrayList.remove(index);


    }

    private void removeAllOrder() {
        String choice;
        System.out.println("");
        System.out.println("Are you sure you want to deleteAll Order ");
        System.out.println("Press Y for deleteALL or N for no");
        choice = getInput.next();

        if (choice.equals("Y")) {
            orderModelArrayList.clear();
        } else {
            changesInCategoryAndProduct();
        }
    }

    private void changesInCategoryAndProduct() {
        int choice;
        System.out.println("");
        System.out.println("1.If you want to apply changes in Category");
        System.out.println("2.If you want to apply changes in Product");
        System.out.println("3.Exit");
        System.out.println("choodse your choice:");
        choice = getInput.nextInt();
        switch (choice) {
            case 1:
                changesInCategory();
                choice();
                break;
            case 2:
                changesInProduct();
                choice();
                break;
            case 3:
                choice();

            default:
                System.out.println("Wrong choice");
                choice();
                break;
        }
    }

    private void changesInProduct() {
        int choice;
        System.out.println("");
        System.out.println("Admin");
        System.out.println("1.If you want to Add Product");
        System.out.println("2.If you want to see all Product");
        System.out.println("3.If you want to Update Product");
        System.out.println("4.If you want to Remove Product");
        System.out.println("5.Exit");
        System.out.println("choose your choice:");
        choice = getInput.nextInt();
        switch (choice) {
            case 1:
                addProduct();
                changesInProduct();
                break;
            case 2:
                seeAllProduct();
                changesInProduct();
                break;
            case 3:
                updateProduct();
                choice();
                break;
            case 4:
                removeProduct();
                choice();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                choice();
                break;

        }
    }

    private void removeProduct() {
        int choice;
        System.out.println("");
        System.out.println("1.If you want to remove all Product");
        System.out.println("2.If you want to remove perticular product");
        System.out.println("3.Exit");
        choice = getInput.nextInt();

        switch (choice) {
            case 1:
                removeAllProduct();
                changesInCategoryAndProduct();
                break;
            case 2:
                removeParticularProduct();
                changesInCategoryAndProduct();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                removeProduct();
                break;
        }
    }

    private void removeParticularProduct() {
        System.out.println("");
        int index;

        for (int i = 0; i < productModelArrayList.size(); i++) {
            System.out.println(i + "." + productModelArrayList.get(i).getProductName() + " | "
                    + productModelArrayList.get(i).getProductPrice() + " | "
                    + productModelArrayList.get(i).getDiscription());
        }
        System.out.println("");
        System.out.println("choose your index If you want to delete");
        index = getInput.nextInt();

        productModelArrayList.remove(index);

    }

    private void removeAllProduct() {
        String choice;
        System.out.println("Are you sure you want delete all product");
        System.out.println("Press Y for deleteALL or N for no");
        choice = getInput.next();
        if (choice.equals("Y")) {
            productModelArrayList.clear();
        } else {
            changesInCategoryAndProduct();
        }
    }

    private void updateProduct() {
        int prochoice;
        int categoryId;
        System.out.println("");
        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + categoryModelArrayList.get(i).getCategoryName());
        }
        System.out.println("");
        System.out.println("choose the categoryId");
        categoryId = getInput.nextInt();


        System.out.println("");

        for (int i = 0; i < productModelArrayList.size(); i++) {
            System.out.println(i + "." + productModelArrayList.get(i).getProductName() + "|"
                    + productModelArrayList.get(i).getProductPrice() + "|"
                    + productModelArrayList.get(i).getDiscription());

        }
        System.out.println("");
        System.out.println("choose product index");
        prochoice = getInput.nextInt();
        updateProData(categoryId, prochoice);

    }

    private void updateProData(int categoryId, int prochoice) {
        String choice;
        String productName;
        int productPrice;
        String discription;

        System.out.println("");
        System.out.println("Enter the ProductName:");
        productName = getInput.next();
        System.out.println("Enter the ProductPrice:");
        productPrice = getInput.nextInt();
        System.out.println("Enter the productDiscription:");
        discription = getInput.next();

        productModelArrayList.set(prochoice, new ProductModel(productName, productPrice, discription, categoryId));

        System.out.println("Press Y for add product or N for no");
        choice = getInput.next();
        if (choice.equals("Y")) {

            updateProData(categoryId, prochoice);
        } else {
            changesInCategoryAndProduct();
        }

    }


    private void seeAllProduct() {
        for (int i = 0; i < categoryModelArrayList.size(); i++) {

            System.out.println(i + "." + categoryModelArrayList.get(i).getCategoryName());

            for (int j = 0; j < productModelArrayList.size(); j++) {
                if (productModelArrayList.get(j).getCategoryId() == categoryModelArrayList.indexOf(categoryModelArrayList.get(i))) {
                    System.out.println("----- Product:" + productModelArrayList.get(j).getProductName() + "|"
                            + productModelArrayList.get(j).getProductPrice() + "|"
                            + productModelArrayList.get(j).getDiscription());
                }
            }

        }
    }

    private void addProduct() {
        int categoryId;
//        productModelArrayList = new ArrayList<>();
        System.out.println("");

        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + categoryModelArrayList.get(i).getCategoryName());

        }
        System.out.println("Enter the categoryId or Index");
        categoryId = getInput.nextInt();
        addProductData(categoryId);

    }

    private void addProductData(int categoryId) {

        final String productName;
        final int productPrice;
        final String discription;

        System.out.println("");
        System.out.println("Enter the ProductName:");
        productName = getInput.next();


        System.out.println("Enter the ProductPrice:");
        productPrice = getInput.nextInt();

        System.out.println("Enter the productDiscription:");
        discription = getInput.next();

        productModelArrayList.add(new ProductModel(productName, productPrice, discription, categoryId));

        System.out.println("Press Y for add product or N for no");
        String choice = getInput.next();
        if (choice.equals("Y")) {
            addProductData(categoryId);
        } else {
            changesInCategoryAndProduct();
        }

    }

    private void changesInCategory() {
        int choice;
        System.out.println("");
        System.out.println("Admin");
        System.out.println("1.If you want to Add Grocary Category");
        System.out.println("2.If you want to see all Grocary Category");
        System.out.println("3.If you want to Update Grocary Category");
        System.out.println("4.If you want to Remove Grocary Category");
        System.out.println("5.Exit");
        System.out.println("choose your choice:");
        choice = getInput.nextInt();
        switch (choice) {
            case 1:
                addGrocaryCategory();
                changesInCategoryAndProduct();
                break;
            case 2:
                seeAllGrocaryCategory();
                changesInCategory();
                break;
            case 3:
                updateGrocaryCategory();
                choice();
                break;
            case 4:
                removeGrocaryCategory();
                choice();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                choice();
                break;

        }
    }

    private void removeGrocaryCategory() {
        int choice;
        System.out.println("");
        System.out.println("1.If you want to remove all category");
        System.out.println("2.If you want to remove particular category");
        System.out.println("3.Exit");
        choice = getInput.nextInt();
        switch (choice) {
            case 1:
                removeAllCategory();
                changesInCategory();
                break;
            case 2:
                removeParticularCategory();
                changesInCategory();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                changesInCategory();
                break;

        }
    }

    private void removeParticularCategory() {
        System.out.println("");
        int index;

        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + " " + categoryModelArrayList.get(i).getCategoryName());
        }
        System.out.println("");
        System.out.println("choose your choice index which you want to delete");
        index = getInput.nextInt();

        categoryModelArrayList.remove(index);
    }

    private void removeAllCategory() {

        categoryModelArrayList.clear();
    }

    private void updateGrocaryCategory() {
        System.out.println("");
        int index;
        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + " " + categoryModelArrayList.get(i).getCategoryName());
        }
        System.out.println("");
        System.out.println("choose your choice index which you want to update");
        index = getInput.nextInt();

        update(index);

    }

    private void update(int i) {
        String choice;
        String categoryName;
        System.out.println("Enter the category");

        categoryName = getInput.next();
        categoryModelArrayList.set(i, new CategoryModel(categoryName));

        changesInCategory();
    }

    private void seeAllGrocaryCategory() {
        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println(i + "." + categoryModelArrayList.get(i).getCategoryName());
        }


    }


//      for(int i=0;i<productModelArrayList.size();i++){
//          System.out.println(categoryModelArrayList.get(productModelArrayList.get(i).getCategoryId()).getCategoryName());
//          System.out.println(i +"."+productModelArrayList.get(i).getProductName() + "|"
//          +productModelArrayList.get(i).getProductPrice() + "|"
//          +productModelArrayList.get(i).getDiscription());
//      }


    private void addGrocaryCategory() {
        String categoryName;
       /*final int categorySize;
        System.out.println("");
        System.out.println("Enter no how many category you want to make");
        categorySize = getInput.nextInt();
        String a[] = new String[categorySize];
        System.out.println("Enter Category");
        for (int i = 0; i < categorySize; i++) {
            a[i] = getInput.next();
        }*/
        System.out.println("Enter Category");
        categoryName = getInput.next();
        categoryModelArrayList.add(new CategoryModel(categoryName));

        addcategory();


    }

    private void addcategory() {
        String choice;
        String categoryName;
        System.out.println("Press Y for add category or N for no");
        choice = getInput.next();
        if (choice.equals("Y")) {
            System.out.println("Enter category");
            categoryName = getInput.next();
            categoryModelArrayList.add(new CategoryModel(categoryName));
            addcategory();
        } else {
            changesInCategoryAndProduct();
        }
    }

    private void login() {
        final String userName;
        final String password;
        // Console console = System.console();
        final String systemUserName = adminLoginModel.getUserName();
        final String systemPassword = adminLoginModel.getPassword();
        System.out.println("Enter user Name");
        userName = getInput.next();
        System.out.println("Enter your password");
        password = getInput.next();

        adminLoginModelArrayList.add(new AdminLoginModel(userName, password));

        if (userName.equals(systemUserName) && password.equals(systemPassword)) {
            System.out.println("Welcome" + " " + userName);
        } else {
            System.out.println("something wrong..!!");
            choice();
        }


    }
}

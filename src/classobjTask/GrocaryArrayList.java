package classobjTask;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anukul-PC on 06-07-2018.
 */
public class GrocaryArrayList {
    private Scanner getInput;
    private ArrayList<AdminLoginModel> adminLoginModelArrayList;
    private ArrayList<CategoryModel> categoryModelArrayList;
    private ArrayList<ProductModel> productModelArrayList;
    private AdminLoginModel adminLoginModel;


    GrocaryArrayList() {
        getInput = new Scanner(System.in);
        adminLoginModelArrayList = new ArrayList<>();
        categoryModelArrayList = new ArrayList<>();
        productModelArrayList = new ArrayList<>();
        adminLoginModel = new AdminLoginModel();

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
        System.out.println("1.Apply or Make a order");
        System.out.println("2.See your Order");
        System.out.println("3.Remove your all order");
        System.out.println("4.Exit");
        choice = getInput.nextInt();
        switch (choice) {
            case 1:
                //makeOrder();
                choice();
                break;
            case 2:
                //seeOrder();
                choice();
                break;
            case 3:
                removeOrder();
                choice();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Wrong choice");
                choice();
                break;
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
                //removeAllOrder();
                choice();
                break;
            case 2:
                // removePerticularOrder();
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
                System.exit(0);
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
                //addProduct();
                choice();
                break;
            case 2:
                //  seeAllProduct();
                choice();
                break;
            case 3:
                //updateProduct();
                choice();
                break;
            case 4:
                // removeProduct();
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
                choice();
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
        switch (choice){
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
                removeGrocaryCategory();
                break;

        }
    }

    private void removeParticularCategory() {
        System.out.println("");
        int index;

        for(int i=0;i<categoryModelArrayList.size();i++){
            System.out.println(i+"."+" "+categoryModelArrayList.get(i).getCategoryName());
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
        for(int i = 0; i<categoryModelArrayList.size();i++){
            System.out.println(i+"."+" " + categoryModelArrayList.get(i).getCategoryName());
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
        categoryModelArrayList.set(i,new CategoryModel(categoryName));

        changesInCategory();
    }

    private void seeAllGrocaryCategory() {
        for (int i = 0; i < categoryModelArrayList.size(); i++) {
            System.out.println("The category is :"+" "+ categoryModelArrayList.get(i).getCategoryName());
        }
    }

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
            changesInCategory();
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

        adminLoginModelArrayList.add(new AdminLoginModel(userName,password));

        if(userName.equals(systemUserName) && password.equals(systemPassword)){
            System.out.println("Welcome"+" " +userName);
        }
        else {
            System.out.println("something wrong..!!");
            choice();
        }



    }
}

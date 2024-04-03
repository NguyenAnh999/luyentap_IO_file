package ra.implement;
import ra.support.InputMethods;
import ra.entity.Categories;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriesImplement {

    public static List<Categories> categoriesList;
    public CategoriesImplement(){
        categoriesList = getFileCategories();
    }
//    static {
//        categoriesList.add(new Categories(0,"cà phê1","cà phê chồn",true));
//        categoriesList.add(new Categories(1,"cà phê2","cà phê mèo",true));
//        categoriesList.add(new Categories(2,"cà phê3","cà phê chó",true));
//        categoriesList.add(new Categories(3,"cà phê4","cà phê voi",true));
//        categoriesList.add(new Categories(4,"cà phê5","cà phê gà",true));
//        categoriesList.add(new Categories(5,"cà phê6","cà phê chim",true));
//        categoriesList.add(new Categories(6,"cà phê7","cà phê chuột",true));
//        categoriesList.add(new Categories(7,"cà phê8","cà phê cú",true));
//        categoriesList.add(new Categories(8,"cà phê9","cà phê cá",true));
//        categoriesList.add(new Categories(9,"cà phê10","cà phê sai",false));
//    }

    public void addElement() {
        System.out.println("Mời bạn nhập vào số danh mục muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Categories categories = new Categories();
            categories.inputData();
            categoriesList.add(categories);
        }
        upDateFileCategories();
    }

    public Categories finByID(Integer ID) {
        for (Categories categories : categoriesList) {
            if (categories.getCatalogId() == ID) {
                return categories;
            }
        }
        return null;
    }

    public void deleteElement() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID danh mục muốn xóa");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.err.println("id bạn nhập vào chưa đúng mời nhập lại");
            } else {
                categoriesList.remove(finByID(IDDelete));
                upDateFileCategories();
                isExit = false;

            }
        }
    }

    public void updateElement() {
        displayData();
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID danh mục muốn sửa");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                while (isExit) {
                    System.out.println("chọn trường bạn cần sửa \n" +
                            "1: Tên\n" +
                            "2: Mô tả\n" +
                            "3: trạng thái\n" +
                            "0: Thoát");
                    System.out.println("mời bạn chọn");
                    byte choice = InputMethods.getByte();
                    switch (choice) {
                        case 1:
                            finByID(IDDelete).setCatalogName(finByID(IDDelete).getNameInput());
                            break;
                        case 2:
                            System.out.println("Mời nhập mô tả mới");
                            finByID(IDDelete).setDescriptions(InputMethods.getString());
                            break;
                        case 3:
                            finByID(IDDelete).setCatalogStatus(finByID(IDDelete).getInputCatalogStatus());
                            break;
                        case 0:
                            System.out.println("cập nhật thành công");
                            isExit = false;
                            break;
                        default:
                            System.err.println("Trường bạn chọn sửa không có");

                    }
                }
            }
        }
        upDateFileCategories();
    }
    public void updateStatus(Scanner sc) {
        displayData();
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn nhập vào ID danh mục muốn cập nhật trạng thái");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.err.println("id bạn nhập vào chưa đúng mời nhập lại");
            } else {
                finByID(IDDelete).displayData();
                finByID(IDDelete).setCatalogStatus(finByID(IDDelete).getInputCatalogStatus());
                System.out.println("cập nhật thành công");
                isExit = false;
            }
        }
        upDateFileCategories();
    }
    public void displayData() {
        if (categoriesList.isEmpty()){
            System.err.println("bạn chưa có danh mục nào");
        }
        categoriesList.stream().filter(Categories::isCatalogStatus).forEach(Categories::displayData);
    }
    public static void upDateFileCategories() {

        try {
            FileOutputStream fos = new FileOutputStream("C:\\JavaCodeOff\\ontaptonghop\\src\\Category.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(categoriesList);
            fos.close();
        } catch (Exception e) {
            System.out.println("loi");
        }
    }

    public static List<Categories> getFileCategories() {
        List<Categories> list = new ArrayList<>();
        try {
            FileInputStream fos = new FileInputStream("C:\\JavaCodeOff\\ontaptonghop\\src\\Category.txt");
            ObjectInputStream oos = new ObjectInputStream(fos);
            list = (List<Categories>) oos.readObject();
            oos.close();
            return list;
        } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
        }
        return list;
    }

}
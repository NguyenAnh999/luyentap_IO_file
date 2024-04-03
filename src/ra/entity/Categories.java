package ra.entity;

import ra.support.InputMethods;

import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;

import static ra.implement.CategoriesImplement.categoriesList;
public class Categories implements Serializable {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    // Constructor
    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // Getter and Setter methods
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // Method to input data
    public void inputData() {
        this.catalogId = getIdInput();
        this.catalogName = getNameInput();
        this.descriptions = getInputDescriptions();
        this.catalogStatus = getInputCatalogStatus();
    }

    public boolean getInputCatalogStatus() {
        System.out.println("moi ban nhap trang thai");
        return InputMethods.getBoolean();
    }

    public String getInputDescriptions() {
        System.out.println("mowif banj nhaapj mo ta");
        return InputMethods.getString();
    }

    public String getNameInput() {
        System.out.println("mòi ban nhập tên");
        while (true) {
            String name = InputMethods.getString();
            if (name.isBlank()) {
                System.out.println("tên không được để trống");
            } else {
                if (categoriesList.stream().anyMatch(categories -> categories.getCatalogName().equals(name))) {
                    System.out.println("tên đã tồn tại");
                } else {
                    return name;
                }
            }
        }
    }


    public int getIdInput() {
        if (categoriesList.isEmpty()) {
            return 1000;
        } else {
            int max = categoriesList.get(0).getCatalogId();
            for (Categories category : categoriesList) {
                if (category.getCatalogId() > max) {
                    max = category.getCatalogId();
                }
            }
            return max + 1;
        }
    }

    // Method to display data
    public void displayData(){
        System.out.printf("ID danh mục: %-2d | Tên danh mục: %-5s | " +
                        "Mô tả danh mục: %-9s | Trạng thái danh mục: %-5s | \n",
                this.catalogId,this.catalogName,this.descriptions,this.catalogStatus?"hoạt dộng":"không hoạt động");
    }
}

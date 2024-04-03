package ra.entity;

import ra.support.InputMethods;

import java.io.*;
import java.util.Date;
import java.util.List;

import static ra.implement.ProductImplement.productList;
import static ra.implement.CategoriesImplement.categoriesList;

public class Product implements Serializable{
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
        // Khởi tạo mặc định
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    // Các phương thức getter và setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    // Phương thức nhập dữ liệu sản phẩm
    public void inputData() {
        this.productId = getInputProductId();
        this.productName = getInputName();
        this.created = getInputDate();
        this.description = getInputDescriptions();
        this.price = getInputPrice();
        this.catalogId = getCategoryId();
        this.productStatus = getInputProductStatus();

    }

    public int getInputProductStatus() {
        System.out.println("mời bạn chọn trạng thái");
        System.out.println("0: Đang bán – 1: Hết hàng – 2: Không bán");
        return InputMethods.getInteger();
    }

    private String getInputProductId() {
        final String regex = "^[C|A|S]\\w{3}$";
        while (true) {
            System.out.println("Nhập vào mã sản phẩm");
            String productIdInput = InputMethods.getString();
            if (productIdInput.matches(regex)) {
                boolean flag = true;
                for (Product product : productList) {
                    if (product != null && product.getProductId().equals(productIdInput)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return productIdInput;
                } else {
                    System.err.println("Id đã tồn tại, vui long nhập giá trị khác");
                }
            } else {
                System.err.println("Không đúng định dạng (C___)|(S___)|(A___)");
            }
        }
    }

    private int getCategoryId() {
        if (categoriesList.isEmpty()) {
            return -1;
        }
        while (true) {
            int count = 1;
            for (Categories arrCategory : categoriesList) {
                if (arrCategory.isCatalogStatus()) {
                    System.out.println("danh mục thứ : " + count);
                    arrCategory.displayData();
                    count++;
                }
            }
            System.out.println("mời bạn nhập vào số thứ tự của danh mục muốn chọn");
            int choice = InputMethods.getInteger();
            if (choice > count) {
                System.out.println("bạn chọn chưa đúng mời chọn lại");
            } else {
                return categoriesList.get(choice - 1).getCatalogId();
            }
        }
    }


    public Date getInputDate() {
        System.out.println("mời bạn nhập ngày nhập sản phẩm");
        return InputMethods.getDate();
    }

    public String getInputDescriptions() {
        System.out.println("Mời bạn nhập mô tả cho sản phẩm");
        return InputMethods.getString();
    }

    public float getInputPrice() {
        while (true) {
            System.out.println("Mời bạn nhập giá");
            float price = InputMethods.getFloat();
            if (price > 0) {
                return price;
            } else {
                System.err.println("Giá cần phải lớn hơn 0");
            }
        }
    }

    public String getInputName() {
        while (true) {
            System.out.println("Mời bạn nhập vào tên sản phẩm");
            String nameCheck = InputMethods.getString();
            if (nameCheck.length() > 50 || nameCheck.length() < 10) {
                System.err.println("Tên không vượt quá 50 kí tự và nhỏ hơn 10 kí tự");
            } else {
                if (productList.stream().anyMatch(product -> product.getProductName().equals(nameCheck))) {
                    System.err.println("Tên đã được sử dụng");

                } else {
                    return nameCheck;
                }
            }
        }
    }

    public void displayData() {
        String CategoryName = "Chưa chọn";
        if (this.catalogId != -1) {
            for (Categories categories : categoriesList) {
                if (categories.getCatalogId() == this.catalogId) {
                    CategoryName = categories.getCatalogName();
                }
            }
        }

        System.out.printf("Mã sản phẩm: %-5s | Tên sản phẩm: %-5s | giá sản phẩm: %-5f | " +
                        "Mô tả: %-5s | Ngày nhập: %-5s | Tên danh mục: %-5s | " +
                        "trạng thái sản phẩm: %-5s\n", this.productId, this.productName, this.price, this.description,
                this.created.toString(), CategoryName, CategoryName);
    }


    // Chuyển đổi trạng thái sản phẩm thành chuỗi
    private String getProductStatusAsString() {
        switch (productStatus) {
            case 0:
                return "Đang bán";
            case 1:
                return "Hết hàng";
            case 2:
                return "Không bán";
            default:
                return "Unknown";
        }
    }

}

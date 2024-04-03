package ra.run;
import ra.implement.CategoriesImplement;
import ra.implement.ProductImplement;
import java.util.Scanner;


public class ShopManagement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***************SHOP MENU****************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    categoryManagementMenu();
                    break;
                case 2:
                    productManagementMenu();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    public static void categoryManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        CategoriesImplement cal = new CategoriesImplement();
        int choice;

        do {
            System.out.println("************CATEGORIES MENU************");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Gọi phương thức để nhập thông tin danh mục
                    cal.addElement();
                    break;
                case 2:
                    // Gọi phương thức để hiển thị thông tin danh mục
                    cal.displayData();
                    break;
                case 3:
                    // Gọi phương thức để cập nhật thông tin danh mục
                    cal.updateElement();
                    break;
                case 4:
                    // Gọi phương thức để xóa danh mục
                    cal.deleteElement();
                    break;
                case 5:
                    // Gọi phương thức để cập nhật trạng thái danh mục
                    cal.updateStatus(scanner);
                    break;
                case 6:
                    System.out.println("Quay lại menu SHOP MANAGEMENT.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);

    }

    public static void productManagementMenu() {
        ProductImplement cal = new ProductImplement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Gọi phương thức để nhập thông tin sản phẩm
                    cal.addElement();
                    break;
                case 2:
                    // Gọi phương thức để hiển thị thông tin sản phẩm
                    cal.displayData();
                    break;
                case 3:
                    // Gọi phương thức để sắp xếp sản phẩm theo giá
                    cal.sortElementByPrice();
                    break;
                case 4:
                    // Gọi phương thức để cập nhật thông tin sản phẩm
                    cal.updateElement(scanner);
                    break;
                case 5:
                    // Gọi phương thức để xóa sản phẩm
                    cal.deleteElement();
                    break;
                case 6:
                    // Gọi phương thức để tìm kiếm sản phẩm theo tên
                    cal.searchByName();
                    break;
                case 7:
                    // Gọi phương thức để tìm kiếm sản phẩm trong khoảng giá
                    cal.searchByPrice();
                    break;
                case 8:
                    System.out.println("Quay lại menu SHOP MANAGEMENT.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (true);
    }
}

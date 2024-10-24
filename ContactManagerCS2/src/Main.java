
import java.util.Scanner;

public class Main {
    private static ContactService contactService = new ContactService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DBHelper.createTable();

        while (true) {
            System.out.println("1. 添加联系人");
            System.out.println("2. 修改联系人");
            System.out.println("3. 删除联系人");
            System.out.println("4. 查看所有联系人");
            System.out.println("5. 退出");

            int choice = scanner.nextInt();
            scanner.nextLine();  // 清除输入换行

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    viewContacts();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void addContact() {
        System.out.println("输入姓名:");
        String name = scanner.nextLine();
        System.out.println("输入地址:");
        String address = scanner.nextLine();
        System.out.println("输入电话:");
        String phone = scanner.nextLine();
        contactService.addContact(new Contact(name, address, phone));
    }

    private static void updateContact() {
        System.out.println("输入要修改的联系人ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除输入换行
        System.out.println("输入新姓名:");
        String name = scanner.nextLine();
        System.out.println("输入新地址:");
        String address = scanner.nextLine();
        System.out.println("输入新电话:");
        String phone = scanner.nextLine();
        contactService.updateContact(new Contact(id, name, address, phone));
    }

    private static void deleteContact() {
        System.out.println("输入要删除的联系人ID:");
        int id = scanner.nextInt();
        contactService.deleteContact(id);
    }

    private static void viewContacts() {
        contactService.getAllContacts().forEach(contact -> {
            System.out.println(contact);
        });
    }
}

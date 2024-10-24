public class Contact {
    private int id;
    private String name;
    private String address;
    private String phone;

    // 构造函数：不需要 ID（用于添加新联系人时）
    public Contact(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // 构造函数：需要 ID（用于更新联系人时）
    public Contact(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // 生成 Getters 和 Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", 姓名: " + name + ", 地址: " + address + ", 电话号码: " + phone;
    }
}

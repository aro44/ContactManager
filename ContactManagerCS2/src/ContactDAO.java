import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public void addContact(Contact contact) {
        String sql = "INSERT INTO contacts(name, address, phone) VALUES(?, ?, ?)";
        try (Connection conn = DBHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getAddress());
            pstmt.setString(3, contact.getPhone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateContact(Contact contact) {
        String sql = "UPDATE contacts SET name = ?, address = ?, phone = ? WHERE id = ?";
        try (Connection conn = DBHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getAddress());
            pstmt.setString(3, contact.getPhone());
            pstmt.setInt(4, contact.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteContact(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = DBHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Contact> getAllContacts() {
        String sql = "SELECT * FROM contacts";
        List<Contact> contacts = new ArrayList<>();
        try (Connection conn = DBHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contact contact = new Contact(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contacts;
    }
}
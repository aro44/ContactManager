
import java.util.List;

public class ContactService {
    private ContactDAO contactDAO = new ContactDAO();

    public void addContact(Contact contact) {
        if (isValid(contact)) {
            contactDAO.addContact(contact);
        } else {
            System.out.println("Invalid contact data.");
        }
    }

    public void updateContact(Contact contact) {
        if (isValid(contact)) {
            contactDAO.updateContact(contact);
        } else {
            System.out.println("Invalid contact data.");
        }
    }

    public void deleteContact(int id) {
        contactDAO.deleteContact(id);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    private boolean isValid(Contact contact) {
        return contact.getName() != null && !contact.getName().isEmpty()
                && contact.getAddress() != null && !contact.getAddress().isEmpty()
                && contact.getPhone() != null && !contact.getPhone().isEmpty();
    }
}

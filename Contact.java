import java.util.ArrayList;

public class Contact {
    private ArrayList<ContactInfo> contacts;

    public Contact() {
        contacts = new ArrayList<>();
    }

    public void add(String firstName, String lastName, String email, String phoneNumber) {
        String id = IdSpawner.generateID();
        ContactInfo contactInfo = new ContactInfo(id,firstName,lastName,email,phoneNumber);
        contacts.add(contactInfo);
        System.out.println("Generated ID: " + id);
    }

    public boolean remove(String id) {
        for (int i = 0; i<contacts.size(); i++) {
            if (contacts.get(i).getId().equals(id)) {
                contacts.remove(i);
                return true;
            }
        }

        return false;
    }

    public ContactInfo search(String id) {
        for (ContactInfo contactInfo : contacts) {
            if (contactInfo.getId().equals(id)) {
                return contactInfo;
            }
        }
        return null;
    }

    public void display() {
        for (ContactInfo contactInfo : contacts) {
            System.out.println(
                    contactInfo.getId() +
                            " " +
                            contactInfo.getFirstName() +
                            " " +
                            contactInfo.getLastName() +
                            " " +
                            contactInfo.getEmail() +
                            " " +
                            contactInfo.getPhoneNumber());
        }
    }

    public void addLoadedContact(ContactInfo contactInfo) {
        contacts.add(contactInfo);
    }

    public ArrayList<ContactInfo> getContacts() {
        return contacts;
    }

    public int getMaxID() {
        int maxID = 0;

        for (ContactInfo contactInfo : contacts) {
            try {
                int ID = Integer.parseInt(contactInfo.getId());
                if (ID > maxID) {
                    maxID = ID;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid ID");
            }
        }
        return maxID;
    }
}

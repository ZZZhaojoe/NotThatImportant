public class ContactInfo {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    public ContactInfo(String id,String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void firstNameSetter() {
        System.out.println("First Name to change: ");
        String firstName = Edit.sc.next();
        if (!firstName.isEmpty()) {
            this.firstName = firstName;
        }
        else  {
            System.out.println("First Name cannot be empty");
        }
    }
    public void lastNameSetter() {
        System.out.println("Last Name to change: ");
        String lastName = Edit.sc.next();
        if (!lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }
    public void emailSetter() {
        System.out.println("Email to change: ");
        String email = Edit.sc.next();
        if (!email.isEmpty()) {
            this.email = email;
        }
    }
    public void phoneNumberSetter() {
        System.out.println("Phone Number to change: ");
        String phoneNumber = Edit.sc.next();
        if (!phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
    }
}

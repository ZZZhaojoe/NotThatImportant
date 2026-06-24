import java.util.Scanner;

public class Edit {
    private Contact contact;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    boolean validity = false;
    public static final Scanner sc = new Scanner(System.in);
    StatusSetting status = new StatusSetting();

    public Edit(Contact contact) {
        this.contact = contact;
    }

    public void digitalEdit() {
        System.out.println("""
                
                Choose your choice:
                1.Add new contact
                2.Remove one existing contact
                3.search contact
                4.edit one existing contact
                5.view all contacts
                6.Exit
                """);
        validity = false;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                while (!validity) {
                    System.out.print("Enter First Name: (Must be filled)");
                    String firstName = sc.next();

                    if (!firstName.isEmpty()) {
                        System.out.print("Enter Last Name: (Must be filled)");
                        String lastName = sc.next();

                        if (!lastName.isEmpty()) {
                            System.out.print("Enter Phone Number: (Must be filled)");
                            String phoneNumber = sc.next();

                            if (!phoneNumber.isEmpty()) {
                                System.out.print("Enter Email Address: (Must be filled)");
                                String email = sc.next();

                                if (!email.isEmpty()) {
                                    contact.add(firstName, lastName, email, phoneNumber);
                                    System.out.println("Your Contact has been added.");
                                    validity = true;

                                } else  {
                                    System.out.println("Please enter a valid Email Address.");
                                }
                            } else  {
                                System.out.println("Please enter a valid Phone Number.");
                            }
                        } else   {
                            System.out.println("Please enter a valid Last Name.");
                        }
                    } else {
                        System.out.println("Please enter a valid Phone Number.");
                    }
                }
                break;

            case 2:
                while (!validity) {
                    System.out.print("Enter the id of the contact you want to delete: ");
                    String id = sc.next();
                    boolean result = contact.remove(id);

                    if (result) {
                        System.out.println("Contact has been deleted.");
                        validity = true;
                    }
                    else {
                        System.out.println("Please enter a valid contact ID.");
                    }
                }
                break;

            case 3:
                while (!validity) {
                    System.out.print("Enter your contact id: ");
                    String id = sc.next();
                    ContactInfo result = contact.search(id);

                    if (result != null) {
                        System.out.println(
                                "Your Contact has been found: " +
                                        result.getId() +
                                        " " +
                                        result.getFirstName() +
                                        " " +
                                        result.getLastName() +
                                        " " +
                                        result.getPhoneNumber() +
                                        " " +
                                        result.getEmail());

                        validity = true;

                    }
                    else {

                        System.out.println("Contact not found.");
                    }
                }
                break;

            case 4:
                while (!validity) {
                    System.out.print("Enter your expect id to change");
                    String id = sc.next();

                    if (!id.isEmpty()) {
                        ContactInfo result = contact.search(id);
                        if (result != null) {
                            System.out.println("""
                                            
                                            "Choose your expect option: "
                                            "1.Edit First Name "
                                            "2.Edit Last Name "
                                            "3.Edit Phone Number "
                                            "4.Edit Email Address"
                                            """);

                            String option = sc.next();

                            switch (option) {
                                case "1":
                                    result.firstNameSetter();
                                    validity = true;
                                    break;

                                case "2":
                                    result.lastNameSetter();
                                    validity = true;
                                    break;

                                case "3":
                                    result.phoneNumberSetter();
                                    validity = true;
                                    break;

                                case "4":
                                    result.emailSetter();
                                    validity = true;
                                    break;

                            }
                        } else   {
                            System.out.println("Please enter a valid id.");
                        }
                    } else   {
                        System.out.println("Please enter a valid id.");
                    }
                }
                break;

            case 5:
                try {
                    contact.display();
                } catch (Exception e) {
                    System.out.println("Error in displaying.");
                }
                break;

            case 6:
                try {
                    status.exit();
                } catch (Exception e) {
                    System.out.println("Error in exiting.");
                }
                break;
        }
    }

    public boolean isValidity() {
        return validity;
    }

}

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InputOutput {
    private String fileName = "Contacts.txt";

    public void loadContact(Contact contactBook) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                return;
            }

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();
                String[] data = line.split(",");

                ContactInfo contact = new ContactInfo(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4]
                );
                contactBook.addLoadedContact(contact);
            }
            input.close();

        } catch (Exception e) {
            System.out.println("Error in loading contact.");
        }
    }

    public void saveContact(Contact contactBook) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Do you want to save your contacts? (y/n)");
            String choice = keyboard.next();

            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {

                FileWriter fileWriter = new FileWriter(fileName);

                for (ContactInfo contact : contactBook.getContacts()) {
                    fileWriter.write(String.valueOf(contact.getId()));
                    fileWriter.write(",");
                    fileWriter.write(String.valueOf(contact.getFirstName()));
                    fileWriter.write(",");
                    fileWriter.write(String.valueOf(contact.getLastName()));
                    fileWriter.write(",");
                    fileWriter.write(String.valueOf(contact.getEmail()));
                    fileWriter.write(",");
                    fileWriter.write(String.valueOf(contact.getPhoneNumber()));
                    fileWriter.write("\n");
                }
                fileWriter.close();
            }
            else  {
                System.out.println("Saving canceled");
            }
        } catch (Exception e) {
            System.out.println("Error writing contact into file");
        }
    }
}

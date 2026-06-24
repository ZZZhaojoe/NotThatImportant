public class Main {
    private static StatusSetting statusSetting = new StatusSetting();

    public static void main(String[] args) {
        statusSetting.setStart();
        Contact contact = new Contact();
        Edit edit = new Edit(contact);

        InputOutput io = new InputOutput();

        io.loadContact(contact);

        int maxID = contact.getMaxID();
        IdSpawner.setNextId(maxID + 1);

        while (StatusSetting.start) {

            edit.digitalEdit();

        }

        io.saveContact(contact);
    }
}

public class IdSpawner {
    private static int nextId = 1;

    public static void setNextId(int id) {
        nextId = id;
    }

    public static String generateID() {
        return String.format("%03d",nextId++);
    }
}

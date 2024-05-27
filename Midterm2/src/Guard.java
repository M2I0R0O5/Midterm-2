public class Guard {
    private String name;
    private int id;

    // Constructor
    public Guard(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Guard{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    // Method to return a CSV representation of the Guard
    public String toCSV() {
        return id + "," + name;
    }

    // Static method to create a Guard from a CSV line
    public static Guard fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        return new Guard(name, id);
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecurityCompany {
    private List<Guard> guards;

    // Constructor
    public SecurityCompany() {
        this.guards = new ArrayList<>();
    }

    // Method to add a guard
    public void addGuard(Guard guard) {
        guards.add(guard);
        System.out.println("Guard added: " + guard);
    }

    // Method to remove a guard by id
    public void removeGuard(int id) {
        guards.removeIf(guard -> guard.getId() == id);
        System.out.println("Guard with id " + id + " removed.");
    }

    // Method to list all guards
    public void listGuards() {
        if (guards.isEmpty()) {
            System.out.println("No guards in the company.");
        } else {
            for (Guard guard : guards) {
                System.out.println(guard);
            }
        }
    }

    // Method to update a guard's name by id
    public void updateGuardName(int id, String newName) {
        for (Guard guard : guards) {
            if (guard.getId() == id) {
                guard.setName(newName);
                System.out.println("Guard's name updated to: " + newName);
                return;
            }
        }
        System.out.println("Guard with id " + id + " not found.");
    }

    // Method to find a guard by name
    public Guard findGuardByName(String name) {
        for (Guard guard : guards) {
            if (guard.getName().equals(name)) {
                return guard;
            }
        }
        System.out.println("Guard with name " + name + " not found.");
        return null;
    }

    // Method to save the state to a CSV file
    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Guard guard : guards) {
                writer.write(guard.toCSV());
                writer.newLine();
            }
            System.out.println("State saved to state.csv.");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    // Method to restore the state from a CSV file
    public void restoreState() {
        guards.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                guards.add(Guard.fromCSV(line));
            }
            System.out.println("State restored from state.csv.");
        } catch (IOException e) {
            System.err.println("Error restoring state: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "SecurityCompany{" +
                "guards=" + guards +
                '}';
    }
}

public class Tester {
    public static void main(String[] args) {
        SecurityCompany securityCompany = new SecurityCompany();

        // Creating guard instances
        Guard guard1 = new Guard("Batman", 7);
        Guard guard2 = new Guard("Spider-Man", 1121);
        Guard guard3 = new Guard("X-man", 1941 );

        // Adding guards to the company
        securityCompany.addGuard(guard1);
        securityCompany.addGuard(guard2);
        securityCompany.addGuard(guard3);

        // Saving state
        securityCompany.saveState();

        // Removing a guard by id
        securityCompany.removeGuard(1121);

        // Listing all guards after removal
        System.out.println("Listing all guards after removal:");
        securityCompany.listGuards();

        // Restoring state
        securityCompany.restoreState();

        // Listing all guards after restoring
        System.out.println("Listing all guards after restoring:");
        securityCompany.listGuards();
    }
}


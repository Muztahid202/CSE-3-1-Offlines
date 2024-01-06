import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Passenger crewmate1 = new Crewmate("Crew1");
        Passenger crewmate2 = new Crewmate("Crew2");
        Passenger crewmate3 = new Crewmate("Crew3");
        Passenger imposter1 = new ImposterDecorator(new Crewmate("Imp1"));
        Passenger imposter2 = new ImposterDecorator(new Crewmate("Imp2"));
        Passenger imposter3 = new ImposterDecorator(new Crewmate("Imp3"));

        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        passengers.add(crewmate1);
        passengers.add(crewmate2);
        passengers.add(crewmate3);
        passengers.add(imposter1);
        passengers.add(imposter2);
        passengers.add(imposter3);
    

        SpaceShipDatabase spaceShipDatabase = new SpaceShipDatabase(passengers);

        String command;
        String[] commandParts;
        String currentUser = null;
        boolean canExit = false;

        try {
            do {
                // Prompt for user input
                System.out.print("Enter command: ");
                command = scanner.nextLine();
                commandParts = command.split(" ");

                // Process the user input
                try {
                    switch (commandParts[0]) {
                        case "login":
                            if (currentUser != null) {
                                System.out.println("Another user is already logged in. Please logout first.");
                            } else if (commandParts.length == 2) {

                                if(spaceShipDatabase.login(commandParts[1]))
                                    currentUser = commandParts[1];

                            } else {
                                throw new IllegalArgumentException("Invalid login command. Please use 'login <name>'.");
                            }
                            break;
                        case "repair":
                            if (commandParts.length != 1) {
                                throw new IllegalArgumentException("Invalid repair command. Please use 'repair' only.");
                            }
                            spaceShipDatabase.repair();
                            break;
                        case "work":
                            if (commandParts.length != 1) {
                                throw new IllegalArgumentException("Invalid work command. Please use 'work' only.");
                            }
                            spaceShipDatabase.work();
                            break;
                        case "logout":
                            if (commandParts.length != 1) {
                                throw new IllegalArgumentException("Invalid logout command. Please use 'logout' only.");
                            }
                            spaceShipDatabase.logout();
                            currentUser = null; // Reset currentUser after logout
                            break;
                        case "exit":
                            if (commandParts.length != 1) {
                                throw new IllegalArgumentException("Invalid exit command. Please use 'exit' only.");
                            }
                            if (currentUser != null) {
                                System.out.println("Please logout before exiting.");
                            } else {
                                System.out.println("Exiting the program.");
                                canExit = true;
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid command. Please enter login, repair, work, logout, or exit.");
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } while (!canExit);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}

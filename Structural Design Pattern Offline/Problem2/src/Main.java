import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terminal terminal = new Terminal();

        try {
            while (true) {
                System.out.print("Enter command: ");
                String input = scanner.nextLine();

                // Splitting the input into command and arguments
                String[] commandAndArgs = input.split(" ", 2);
                String command = commandAndArgs[0].toLowerCase();
                String arguments = commandAndArgs.length > 1 ? commandAndArgs[1] : "";

                try {
                    switch (command) {
                        case "mkdrive":
                            terminal.makeDrive(arguments);
                            break;
                        case "cd":
                            if (arguments.equals("~")) {
                                terminal.jumpToRoot();
                            } else {
                                // Trim leading and trailing colons and backslashes
                                String trimmedArguments = arguments.replaceAll("^[:\\\\]+|[:\\\\]+$", "");
                                terminal.changeDirectory(trimmedArguments);
                            }
                            break;
                        case "mkdir":
                            terminal.makeDirectory(arguments);
                            break;
                        case "touch":
                            // Assuming the file size is always provided as an integer in this example
                            String[] touchArgs = arguments.split(" ");
                            if (touchArgs.length >= 2) {
                                String fileName = touchArgs[0];
                                int size = Integer.parseInt(touchArgs[1]);
                                terminal.touch(fileName, size);
                            } else {
                                System.out.println("Error: Missing size argument for 'touch' command.");
                            }
                            break;
                        case "list":
                            terminal.list();
                            break;
                        case "ls":
                            // Trim leading and trailing colons
                            String trimmedArgumentsLs = arguments.replaceAll("^[:]+|[:]+$", "");
                            terminal.details(trimmedArgumentsLs);
                            break;

                        case "delete":
                            if (commandAndArgs.length > 1 && commandAndArgs[1].startsWith("-r")) {
                                terminal.deleteRecursively(commandAndArgs[1].substring(3).trim());
                            } else {
                                terminal.delete(arguments);

                            }
                            break;
                        case "exit":
                            System.out.println("Exiting the terminal.");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Invalid command. Please try again.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number format. Please enter a valid number.");
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
            }
        } finally {
            scanner.close();
        }
    }
}

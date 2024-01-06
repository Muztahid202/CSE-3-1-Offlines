import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Terminal {
    public Directory currentDirectory;
    public RootClass root;
    public Terminal()
    {
        //intialize the root directory
        root = new RootClass("rootSystem", "root", "rootDirectory", "0", null);
        currentDirectory = root;//when the terminal is created the current directory is the root
    }

    public void changeDirectory(String name)
    {
        
        if(currentDirectory.find(name) != null)
        {
            currentDirectory = currentDirectory.findDirectory(name);
            System.out.println("Directory changed to " + name);
        }
        else 
        {
            System.out.println("Error: " + name + " could not be found in the current");
        }
    }

    public void details(String name)
    {
        if(currentDirectory.find(name) != null)
       {
           BasicFileSystemComponent temp = currentDirectory.find(name);
           temp.printDetails();
       }
       else
       {
           System.out.println("Error: " + name + " could not be found");
       }
    }

    public void list()
    {
        currentDirectory.listPrint();
    }

    public void delete(String name)
    {
        if(currentDirectory.find(name) != null)
        {
            BasicFileSystemComponent temp = currentDirectory.find(name);
            temp.delete();
        }
        else 
        {
            System.out.println("Error: " + name + " could not be found");
        }
    }

    public void deleteRecursively(String name)
    {
        if(currentDirectory.find(name) != null)
        {
            BasicFileSystemComponent temp = currentDirectory.find(name);
            temp.deleteRecursively();
            if(currentDirectory.getType().equals("file"))
            {
                System.out.println("Warning: It is not not recommended to delete the file recursively");
            }
        }
        else 
        {
            System.out.println("Error: " + name + " could not be found");
        }
    }

    public void jumpToRoot()
    {
        currentDirectory = root;
        System.out.println("Directory changed to root");
    }

    public void makeDirectory(String name)
    {
        if(!currentDirectory.getType().equals("root"))
        {
            // Get the current system time
            LocalDateTime currentTime = LocalDateTime.now();

            // Create a formatter for the desired output format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy h:mm a");

            // Format the current time using the formatter
            String formattedTime = currentTime.format(formatter);
            currentDirectory.add(new Folder( name, "folder", currentDirectory.getDirectory(), formattedTime, currentDirectory));
            System.out.println("Folder " + name + " has been created");
        }
        else 
        {
            System.out.println("Error: Cannot create a folder in the root directory");
        }
       
    }

    public void touch(String name, int size)
    {
        if(!currentDirectory.getType().equals("root"))
        {
            // Get the current system time
            LocalDateTime currentTime = LocalDateTime.now();

            // Create a formatter for the desired output format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy h:mm a");

            // Format the current time using the formatter
            String formattedTime = currentTime.format(formatter);
            currentDirectory.add(new File(name, size, "file", currentDirectory.getDirectory(), formattedTime));
            System.out.println("File " + name + " has been created");
        }
        else 
        {
            System.out.println("Error: Cannot create a file in the root directory");
        }
    }

    public void makeDrive(String name)
    {
        if(currentDirectory.getType().equals("root"))
        {
            // Get the current system time
            LocalDateTime currentTime = LocalDateTime.now();

            // Create a formatter for the desired output format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy h:mm a");

            // Format the current time using the formatter
            String formattedTime = currentTime.format(formatter);
            currentDirectory.add(new Drive(name , "drive", name , formattedTime, currentDirectory));
            System.out.println("Drive " + name + " has been created");
        }
        else 
        {
            System.out.println("Error: Cannot create a drive in the current directory");
        }
    }
    
}

public class Crewmate implements Passenger{
    
    private String name;

    public Crewmate(String name) {
        this.name = name;
    }
    
    public void login() {
        System.out.println("Welcome Crewmate!");
    }
    public void logout() {
        System.out.println("Bye Bye crewmate");
    }
    public void repair() {
        System.out.println("Repairing the spaceship");
    }
    public void work() {
        System.out.println("Doing research");
    }

    public String getName() {
        return name;
    }
    
}

public class ImposterDecorator extends BaseDecorator {
    
    public ImposterDecorator(Passenger passenger) {
        super(passenger);
    }
    
    public void login() {
        super.login();
        System.out.println("We won`t tell anyone; you are an imposter");
    }
    public void logout() {
        super.logout();
        System.out.println("See you again Comrade Imposter.");
    }
    public void repair() {
        super.repair();
        System.out.println("Damaging the spaceship.");
    }
    public void work() {
        super.work();
        System.out.println("Trying to kill a crewmate.");
        System.out.println("Successfully killed a crewmate.");
    }
    
}

public class BaseDecorator implements Passenger{
    private Passenger passenger;
    
    public BaseDecorator(Passenger passenger) {
        this.passenger = passenger;
    }
    
    public void login() {
        passenger.login();
    }
    public void logout() {
        passenger.logout();
    }
    public void repair() {
        passenger.repair();
    }
    public void work() {
        passenger.work();
    }
    public String getName() {
        return passenger.getName();
    }
    
}

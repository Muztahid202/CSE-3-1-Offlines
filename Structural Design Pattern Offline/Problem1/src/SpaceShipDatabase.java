import java.util.ArrayList;

public class SpaceShipDatabase {
    private ArrayList<Passenger> passengers;
    private Passenger passenger = null;
   
    public SpaceShipDatabase(ArrayList<Passenger> spacepassengers)
    {
        passengers = spacepassengers;
        
    }

    private Passenger getPassenger(String name)
    {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                return passenger;
            }
        }
        return null;
    }

    public boolean login(String name)
    {
        passenger = getPassenger(name);
        if (passenger != null) {
            passenger.login();
            return true;
        }
        else{
            System.out.println("Id not found");
            return false;
        }
    }

    public void logout()
    {
        if(passenger == null){
            System.out.println("None is logged in");
        }
        else{
            passenger.logout();
            passenger = null;
        }
    }

    public void repair()
    {
        if(passenger == null){
            System.out.println("None is logged in");
        }
        else{
            passenger.repair();
        }
    }

    public void work()
    {
        if(passenger == null){
            System.out.println("None is logged in");
        }
        else{
            passenger.work();
        }
    }

    
}

import java.util.ArrayList;

public class WalkingTour extends Activity{
    private String distance;

    public WalkingTour(String name, String description, int cost, int capacity, ArrayList<PremiumPassenger> guestList, Destination location, String distance) {
        super(name, description, cost, capacity,guestList,location);
        this.distance = distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    @Override
    public void printActivity(){
        System.out.println("Name: "+ getName());
        System.out.println("Cost: "+ getCost());
        System.out.println("Capacity: "+ getCapacity() +" guests");
        System.out.println("Distance: "+distance);
        System.out.println("Available slots: "+(this.getCapacity()-this.getGuestList().size())+" guests");
    }
    //needs to be overridden in order to print distance
}

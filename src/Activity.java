import java.util.ArrayList;

public class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private ArrayList<PremiumPassenger> guestList;
    private Destination location;

    public Activity(String name, String description, int cost, int capacity, ArrayList<PremiumPassenger> guestList, Destination location){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.guestList = guestList;
        this.location = location;
    }

    public void setLocation(Destination location) {
        this.location = location;
    }

    public Destination getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setGuestList(ArrayList<PremiumPassenger> guestList) {
        this.guestList = guestList;
    }

    public ArrayList<PremiumPassenger> getGuestList() {
        return guestList;
    }

    public void addGuest(PremiumPassenger passenger){
        guestList.add(passenger);
    }
    //allows guests to be added without creating a new guest list with setGuestList


    public boolean checkPassenger(PremiumPassenger passenger){
        for (PremiumPassenger premiumPassenger : guestList) {
            if (premiumPassenger.equals(passenger)) return true;
            //checks if the passenger is the same passenger as required
        }
        return false;
    }
    public void printActivity(){
        System.out.println("Name: "+name);
        System.out.println("Cost: "+cost);
        System.out.println("Capacity: "+capacity+" guests");
        System.out.println("Available slots: "+(capacity-guestList.size())+" guests");
        //math is here in order to create availabilities
    }
}

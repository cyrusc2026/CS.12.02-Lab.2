import java.util.ArrayList;

public class TheaterShow extends Activity{
    private ArrayList<Actor> stars;

    public TheaterShow(String name, String description, int cost, int capacity, ArrayList<PremiumPassenger> guestList, Destination location,ArrayList<Actor>stars) {
        super(name, description, cost, capacity,guestList,location);
        this.stars = stars;
    }

    public void setStars(ArrayList<Actor> stars) {
        this.stars = stars;
    }

    public void addStars (Actor star){
        this.stars.add(star);
    }
    //addStars lets user to add star without creating a new ArrayList (with setStars)

    public ArrayList<Actor> getStars() {
        return stars;
    }
    @Override
    public void printActivity(){
        System.out.println("Name: "+ getName());
        System.out.println("Cost: "+ getCost());
        System.out.println("Capacity: "+ getCapacity() +" guests");
        for (Actor star : stars) {
            star.printActor();
        }
        System.out.println("Available slots: "+(this.getCapacity()-this.getGuestList().size())+" guests");
    }
    //needs to be overridden in order to print out stars
}

import java.util.ArrayList;

public class CruiseShip {
    private String name;
    private int passengerCapacity;
    private ArrayList<Destination> itinerary;
    private ArrayList<PremiumPassenger> passengerList;
    private ArrayList<Cabin> cabinList;


    public CruiseShip(String name, int passengerCapacity, ArrayList<Destination> itinerary, ArrayList<PremiumPassenger> passengerList,ArrayList<Cabin> cabinList){
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengerList = passengerList;
        this.cabinList = cabinList;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerList(ArrayList<PremiumPassenger> passengerList) {
        this.passengerList = passengerList;
    }

    public ArrayList<PremiumPassenger> getPassengerList() {
        return passengerList;
    }

    public void setItinerary(ArrayList<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public void addPassenger(PremiumPassenger passenger){
        this.passengerList.add(passenger);
    }
    //allows Passenger to be added without creating new ArrayList with setPassengerList

    public void addDestination(Destination destination){
        this.itinerary.add(destination);
    }
    //allows Destination to be added without creating new ArrayList with setItinerary

    public ArrayList<Destination> getItinerary() {
        return itinerary;
    }

    public void addCabin(Cabin cabin){this.cabinList.add(cabin);}

    public void printItinerary(){
        System.out.println(name+"'s Itinerary\n\n");
        for (int i = 0; i < itinerary.size();i++){
            System.out.println("Destination "+(i+1)+": "+itinerary.get(i).getName());
            itinerary.get(i).printActivityList();
        }
    }

    public void printPassengerList(){
        System.out.println(name+"'s Passenger List \n");
        for (int i = 0; i < passengerList.size(); i++){
            System.out.println("Passenger "+(i+1)+":");
            passengerList.get(i).printPassenger(this);
            System.out.println("\n");
        }
    }

    public void printCabinList(){
        System.out.println(name+"'s Cabin List");
        for (Cabin cabin : cabinList) {
            cabin.printCabin(this);
        }
    }

    public ArrayList<Cabin> getCabinList() {
        return cabinList;
    }

    public void setCabinList(ArrayList<Cabin> cabinList) {
        this.cabinList = cabinList;
    }
}

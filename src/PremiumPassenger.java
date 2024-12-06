public class PremiumPassenger {
    private String name;
    private String passengerNumber;

    public PremiumPassenger(String name, String passengerNumber){
        this.name = name;
        this.passengerNumber = passengerNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }


    public void printPassenger(CruiseShip ship){
        System.out.println("Passenger Name: "+ name);
        System.out.println("Passenger Number: "+passengerNumber);
        System.out.println("Activities chosen by "+name+":");
        for (int i =0; i <ship.getItinerary().size(); i++){
            Activity activityHere = ship.getItinerary().get(i).checkPassenger(this);
            if (activityHere == null) System.out.println("This guest has not signed up for an activity at "+ship.getItinerary().get(i).getName());
            else System.out.println("Activity at "+ship.getItinerary().get(i).getName()+": "+activityHere.getName());
        }
    }


    public void signUp(PremiumPassenger passenger, Activity activity){
        boolean hasActivity = false;
        for (int i = 0; i<activity.getLocation().getActivityList().size(); i++) {
            Activity currentActivity = activity.getLocation().getActivityList().get(i);
            for (int j = 0; j<currentActivity.getGuestList().size(); j++){
                if (currentActivity.getGuestList().get(j).equals(passenger)) {
                    hasActivity = true;
                    break;
                }
            }
        }
        boolean isFull = (activity.getGuestList().size()== activity.getCapacity());
        if (isFull) System.out.println("The activity being selected is full!");
        if (hasActivity) System.out.println("The passenger has already signed up for another activity at this destination!");
        if (!hasActivity && !isFull) {
            activity.addGuest(passenger);
            System.out.println(name+" has successfully signed up for "+activity.getName());
        }
    }
}
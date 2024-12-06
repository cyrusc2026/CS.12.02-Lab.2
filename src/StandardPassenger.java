public class StandardPassenger extends PremiumPassenger{
    private int balance;

    public StandardPassenger(String name, String passengerNumber,int balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
@Override
    public void printPassenger(CruiseShip ship){
        System.out.println("Passenger Name: "+ this.getName());
        System.out.println("Passenger Number: "+this.getPassengerNumber());
        System.out.println("Balance: "+balance);
        //overridden to print balance
        System.out.println("Activities chosen by "+this.getName()+":");
        for (int i =0; i <ship.getItinerary().size(); i++){
            Activity activityHere = ship.getItinerary().get(i).checkPassenger(this);
            //checks the passenger's activity at index (i) of the ship's itinerary
            if (activityHere == null) System.out.println("This guest has not signed up for an activity at "+ship.getItinerary().get(i).getName());
            else System.out.println("Activity at "+ship.getItinerary().get(i).getName()+": "+activityHere.getName()+"\nCost paid for this activity: "+activityHere.getCost());
        }
    }


    @Override
    public void signUp(PremiumPassenger passenger, Activity activity){
        boolean hasActivity = false;
        for (int i = 0; i<activity.getLocation().getActivityList().size(); i++) {
            Activity currentActivity = activity.getLocation().getActivityList().get(i);
            for (int j = 0; j<currentActivity.getGuestList().size(); j++){
                if (currentActivity.getGuestList().get(j).equals(passenger)) hasActivity=true;
            }
            //checks if the user has already signed up for an activity
        }
        boolean isFull = (activity.getGuestList().size()== activity.getCapacity());
        //checks if there is an availability in the activity
        if (isFull) System.out.println("The activity being selected is full!");
        if (hasActivity) System.out.println("The passenger has already signed up for another activity at this destination!");
        if (balance < activity.getCost()) System.out.println("The passenger doesn't have enough funds to sign up for this activity!"); //checks if the passenger has enough money to sign up
        if (!hasActivity && !isFull && balance >= activity.getCost()) {
            activity.addGuest(passenger);
            System.out.println(this.getName()+" has successfully signed up for "+activity.getName());
            balance = balance - activity.getCost();
        }
    }
}

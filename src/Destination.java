import java.util.ArrayList;

public class Destination {
    private String name;
    private ArrayList<Activity> activityList;

    public Destination(String name, ArrayList<Activity> activityList){
        this.name = name;
        this.activityList = activityList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setActivityList(ArrayList<Activity> activityList) {
        this.activityList = activityList;
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

    public void addActivity(Activity activity) {activityList.add(activity);}
    //allows activity to be added without creating new ArrayList with setActivityList
    public Activity checkPassenger(PremiumPassenger passenger){
        for (Activity activity : activityList) {
            if (activity.checkPassenger(passenger)) return activity;
            //returns the Activity so that it can be used in other methods (instead of the specific index because it doesn't really help the user)
        }
        return null; //no Activity
    }

    public void printActivityList(){
        System.out.println("Activities offered at "+name+":\n");
        for (int i = 0; i<activityList.size();i++){
            System.out.println("Activity "+(i+1)+":");
            activityList.get(i).printActivity();
        }
    }

    public void printAvailableActivity(){
        System.out.println("Activities that still have open slots at "+name+":\n");
        for (Activity activity : activityList) {
            if (activity.getGuestList().size() < activity.getCapacity()) {//checks if the activity still has available slots
                activity.printActivity();
                System.out.println("\n");
            }
        }
    }
}

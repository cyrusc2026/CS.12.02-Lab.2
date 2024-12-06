import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static CruiseShip destiny = new CruiseShip("Disney Destiny",3466,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    static CruiseShip adventure = new CruiseShip("Disney Adventure",6000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    static StandardPassenger mickeyMouse = new StandardPassenger("Mickey Mouse","101010",100);
    static StandardPassenger minnieMouse = new StandardPassenger("Minnie Mouse", "101011",100);
    static SeniorPassenger donaldDuck = new SeniorPassenger("Donald Duck","111110",250);
    static SeniorPassenger daisyDuck = new SeniorPassenger("Daisy Duck","111111",250);
    static PremiumPassenger elsa = new PremiumPassenger("Elsa","221010");
    static PremiumPassenger anna = new PremiumPassenger("Anna","221011");
    static Destination singapore = new Destination("Singapore",new ArrayList<>());
   static Destination hongKong = new Destination("Hong Kong",new ArrayList<>());
    static Actor cynthiaErivo = new Actor("Cynthia Erivo", "Elphaba");
    static Actor arianaGrande = new Actor("Ariana Grande","Galinda");
    static TheaterShow wicked = new TheaterShow("Wicked", "The hit backstory behind the beloved tale of the Wizard of Oz", 20, 5,new ArrayList<>(),singapore,new ArrayList<>());
    static Actor sierraBoggess = new Actor("Sierra Boggess", "Christine");
    static Actor michaelCrawford = new Actor("Michael Crawford","the Phantom");
    static TheaterShow phantomOfTheOpera = new TheaterShow("The Phantom of the Opera", "A retelling of the classic novel",15,10,new ArrayList<>(),hongKong,new ArrayList<>());
    static Activity hongKongDisneyland = new Activity("Hong Kong Disneyland Excursion", "A trip to the most magical place on Earth",50,15,new ArrayList<>(),hongKong);
    static Activity marinaBaySands = new Activity("Marina Bay Sands Excursion","A glamorous mall excursion with luxury brands",10,10,new ArrayList<>(),singapore);
    static WalkingTour streetFoodWalk = new WalkingTour("Street Food Walking Tour","Try the varying different street foods in Singapore, including Michelin-Star winning noodles",30,10,new ArrayList<>(),singapore,"5 km");
    static WalkingTour kowloonWalk = new WalkingTour("Walk Kowloon Tour","Explore the hidden back roads of Kowloon, including sights such as the Kowloon Walled City Park",15,10,new ArrayList<>(),hongKong,"10 km");
    public static void main(String[] args) {
        String[] testCases = {"Passenger not enough funds","Passenger signing up for a full activity","Print itinerary","Print Passenger List","Print Available Activities","Print Cabins"};
        System.out.println("Welcome to my Cruise Ship simulator");
        System.out.println("See below the following test cases:");
        for (int i = 0; i < testCases.length; i++){
            System.out.println("Test Case "+(i+1)+": "+testCases[i]);
        }
        wicked.addStars(cynthiaErivo);
        wicked.addStars(arianaGrande);
        phantomOfTheOpera.addStars(sierraBoggess);
        phantomOfTheOpera.addStars(michaelCrawford);
        destiny.addDestination(singapore);
        destiny.addDestination(hongKong);
        adventure.addDestination(singapore);
        adventure.addDestination(hongKong);
        singapore.addActivity(streetFoodWalk);
        singapore.addActivity(marinaBaySands);
        singapore.addActivity(wicked);
        hongKong.addActivity(kowloonWalk);
        hongKong.addActivity(hongKongDisneyland);
        hongKong.addActivity(phantomOfTheOpera);
        Scanner scanner = new Scanner(System.in);
        testCaseTriage(scanner.nextInt());
    }

    public static void testCaseTriage(int mode){
        if (mode == 1) notEnoughFunds();
        if (mode == 2) fullActivity();
        if (mode == 3) printItinerary();
        if (mode == 4) printPassengerList();
        if (mode == 5) printAvailableActivities();
        if (mode == 6) printCabins();
    }

    public static void notEnoughFunds(){
        System.out.println("Mode chosen: Passenger not enough funds");
        System.out.println("Creating test case");
        System.out.println("Current cruise ship: "+destiny.getName());
        System.out.println("Test case: Passenger "+ mickeyMouse.getName());
        streetFoodWalk.addGuest(mickeyMouse);
        mickeyMouse.printPassenger(destiny);
        mickeyMouse.setBalance(0);
        System.out.println(mickeyMouse.getName()+"'s current balance: "+ mickeyMouse.getBalance());
        System.out.println("Trying to sign up for "+phantomOfTheOpera.getName());
        mickeyMouse.signUp(mickeyMouse,phantomOfTheOpera);
    }

    public static void fullActivity(){
        System.out.println("Mode chosen: Activity is full");
        System.out.println("Creating test case");
        System.out.println("Current cruise ship: "+adventure.getName());
        System.out.println("Test case: Activity "+hongKongDisneyland.getName());
        hongKongDisneyland.addGuest(minnieMouse);
        hongKongDisneyland.printActivity();
        hongKongDisneyland.setCapacity(1);
        System.out.println(hongKongDisneyland.getName()+"'s current capacity: "+hongKongDisneyland.getCapacity());
        System.out.println(elsa.getName()+" trying to sign up for the activity");
        elsa.signUp(elsa,hongKongDisneyland);
    }

    public static void printItinerary(){
        System.out.println("Mode chosen: Print itinerary");
        adventure.printItinerary();
    }
    public static void printPassengerList(){
        System.out.println("Mode chosen: Print passenger list");
        destiny.addPassenger(elsa);
        destiny.addPassenger(anna);
        destiny.addPassenger(mickeyMouse);
        destiny.addPassenger(minnieMouse);
        destiny.addPassenger(donaldDuck);
        destiny.addPassenger(daisyDuck);
        wicked.addGuest(elsa);
        wicked.addGuest(anna);
        wicked.addGuest(mickeyMouse);
        streetFoodWalk.addGuest(daisyDuck);
        streetFoodWalk.addGuest(donaldDuck);
        marinaBaySands.addGuest(minnieMouse);
        phantomOfTheOpera.addGuest(daisyDuck);
        phantomOfTheOpera.addGuest(donaldDuck);
        kowloonWalk.addGuest(elsa);
        kowloonWalk.addGuest(anna);
        hongKongDisneyland.addGuest(minnieMouse);
        hongKongDisneyland.addGuest(mickeyMouse);
        destiny.printPassengerList();
    }
    public static void printAvailableActivities(){
        System.out.println("Mode chosen: print availabilities");
        wicked.addGuest(elsa);
        wicked.addGuest(anna);
        wicked.addGuest(mickeyMouse);
        streetFoodWalk.addGuest(daisyDuck);
        streetFoodWalk.addGuest(donaldDuck);
        marinaBaySands.addGuest(minnieMouse);
        phantomOfTheOpera.addGuest(daisyDuck);
        phantomOfTheOpera.addGuest(donaldDuck);
        kowloonWalk.addGuest(elsa);
        kowloonWalk.addGuest(anna);
        hongKongDisneyland.addGuest(minnieMouse);
        hongKongDisneyland.addGuest(mickeyMouse);
        wicked.setCapacity(3);
        marinaBaySands.setCapacity(1);
        kowloonWalk.setCapacity(2);
        hongKong.printAvailableActivity();
        singapore.printAvailableActivity();
    }
    public static void printCabins(){
        Cabin oneA = new Cabin("1A",mickeyMouse,"standard");
        Cabin oneB = new Cabin("1B",minnieMouse,"standard");
        Cabin oneC = new Cabin("1C",null,"premium");
        Cabin oneD = new Cabin("1D",elsa,"standard");
        Cabin oneE = new Cabin("1E",anna,"premium");
        Cabin twoA = new Cabin("2A",donaldDuck,"standard");
        Cabin twoB = new Cabin("2B",daisyDuck,"standard");
        adventure.addCabin(oneA);
        adventure.addCabin(oneB);
        adventure.addCabin(oneC);
        adventure.addCabin(oneD);
        adventure.addCabin(oneE);
        adventure.addCabin(twoA);
        adventure.addCabin(twoB);
        adventure.printCabinList();
    }
}
public class Cabin {
    private String name;
    private PremiumPassenger passenger;
    private String status;
    public Cabin(String name, PremiumPassenger passenger, String status){
        this.name = name;
        this.passenger = passenger;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PremiumPassenger getPassenger() {
        return passenger;
    }

    public void setPassenger(PremiumPassenger passenger) {
        if (status.equals("premium")&&(passenger.getClass().getSimpleName().equals("SeniorPassenger")||passenger.getClass().getSimpleName().equals("StandardPassenger")))
            System.out.println("This passenger cannot be added to this cabin because they are not a premium passenger");
        else this.passenger = passenger;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printCabin(CruiseShip ship){
        System.out.println("Cabin "+name);
        System.out.println("Cabin type: "+status);
        if (passenger!=null){
            passenger.printPassenger(ship);
        }
        else System.out.println("Unoccupied");
    }
}

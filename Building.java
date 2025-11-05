public class Building implements BuildingRequirements {
    // Attributes of building:
    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    // Constructor for building
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    // Returns the building's name
    public String getName() {
        return this.name;
    }

    // Returns the building's address
    public String getAddress() {
        return this.address;
    }

    // Returns the number of floors in a building
    public int getFloors() {
        return this.nFloors;
    }

    // Returns string saying "<Building name> is a <# floors>-story building located at <address>"
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    public static void main(String[] args) {
        // creates building fordHall
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}

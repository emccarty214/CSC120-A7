/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    // Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    

    public Cafe(String name, String address, int nFloors, int startOz, int startSugar, int startCream, int startCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = startOz;
        this.nSugarPackets = startSugar;
        this.nCreams = startCream;
        this.nCups = startCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a cup of coffee and subtracts the proper amounts from the inventory
     * @param size the amount of oz you want the coffee to be
     * @param nSugarPackets the amount of sugar in the coffee
     * @param nCreams the amount of creams in the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // if there is not enough coffee...
        if (this.nCoffeeOunces < size) {
            // then add some more 
            this.restock(size, 0, 0, 0);
        }
        // subract size from the total number of coffee ounces
        this.nCoffeeOunces -= size;

        // if there is not enough sugar
        if (this.nSugarPackets < nSugarPackets) {
            // add some more
            this.restock(0, nSugarPackets, 0, 0);
        }
        // subract sugars from total number of sugars
        this.nSugarPackets -= nSugarPackets;

        // if there is not enough cream
        if (this.nCreams < nCreams) {
            // add some more
            this.restock(0, 0, nCreams, 0);
        }
        // subtract creams from total number of creams
        this.nCreams -= nCreams;

        // if there is not enough sugar
        if (this.nCups < 1) {
            // add some more
            this.restock(0, 0, 0, 10);
        }
        //subtract 1 from total cups
        this.nCups -= 1;
    }

    /**
     * Restocks items by the inputted amount
     * @param nCoffeeOunces The amount of oz you want to add
     * @param nSugarPackets the amount of sugar you want to add
     * @param nCreams the amount of cream you want to add
     * @param nCups the amount of cups you want to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        // add stock to each item based on information in the call
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }


    
    public static void main(String[] args) {
        // check that we can make a new cafe
        Cafe CC = new Cafe("CC", "100 Elm Street, Northampton, MA 01063", 1, 64, 20, 20, 10);
        
        // check that sell coffee works when we have all the ingredients
        CC.sellCoffee(8, 2, 1);
        System.out.println("Coffee oz: " + CC.nCoffeeOunces);
        System.out.println("Sugar: " + CC.nSugarPackets);
        System.out.println("Cream: " + CC.nCreams);
        System.out.println("Cups: " + CC.nCups);

        System.out.println("----------------------");

        // check that restock works 
        CC.sellCoffee(60, 20, 20);
        System.out.println("Coffee oz: " + CC.nCoffeeOunces);
        System.out.println("Sugar: " + CC.nSugarPackets);
        System.out.println("Cream: " + CC.nCreams);
        System.out.println("Cups: " + CC.nCups);

    }
    
}

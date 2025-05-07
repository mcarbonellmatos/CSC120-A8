/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    
    /**
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address,int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(nCoffeeOunces >= size &&  this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups >= 1){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Sold coffee! Size " + size + " oz with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
        System.out.println("Updated inventory: " + this.nCoffeeOunces + " oz of coffee left, " + this.nSugarPackets + " sugar packets left, " + this.nCreams + " creams left," + this.nCups + " cups left.");
        }
        else {
            System.out.println("There is not enough ingridients to complete this order.");
        }
    }

    public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked inventory: " + this.nCoffeeOunces + " onces of coffe, " + this.nSugarPackets + " packets of sugar, " + this.nCreams + " creams, " + this.nCups + " cups.");
    }



    public static void main(String[] args) {
        Cafe neilsonCafe = new Cafe("Compass Cafe", "7 Elm St", 1, 26, 40, 20, 30);
        neilsonCafe.sellCoffee(10, 2, 1);
        neilsonCafe.sellCoffee(16, 3, 2);
        neilsonCafe.restock(200, 30, 20, 10);
    }
    
}

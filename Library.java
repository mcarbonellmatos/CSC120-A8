import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /**
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors, Boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    public void addTitle(String title){
      this.collection.put(title,true);
    }

    public String removeTitle(String title) { // return the title that we removed 
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
    }
    else {
      System.out.println("This book is not in this collection, unable to remove.");
    }
    return title;
  }

    public void checkOut(String title){
      if (!isAvailable(title)) {
        System.out.println("Book " + title + " has been already checked out.");
      }
      else {
        this.collection.put(title, false);
        System.out.println("This book has been checked out.");
      }
    }

    public void returnBook(String title){
      if(!containsTitle(title)){
        throw new RuntimeException(title + " can't be returned as is not part of this collection.");
      }
      if(isAvailable(title)){
        throw new RuntimeException("The book " + title + " hasn't been chehcked out, therefore it cannot be returned.");
      }
      collection.put(title, true);
      System.out.println("Book " + title + " has been returned.");
    }

    public boolean containsTitle(String title) // returns true if the title appears as a key in the Libary's collection, false otherwise
    {
      return this.collection.containsKey(title);
    }
    public boolean isAvailable(String title) // returns true if the title is currently available, false otherwise
    {
      return this.collection.get(title);
    }
    
    public void printCollection() // prints out the entire collection in an easy-to-read way (including checkout status)
    {
      System.out.println(this.collection.toString());
    }

    @Override
    public void showOptions(){
      if (hasElevator) {
        super.showOptions();
      }
      else {
        System.out.println("Available options " + this.name + ":\n + enter() \n + goUp() \n goDown()");
      }
    }

    @Override
    public void goToFloor(int floorNum){
      if (hasElevator ){
        super.goToFloor(floorNum);
      }
      else {
        System.out.println("Library doesn't have an elevator.");
      }  
    }

    @Override
    public void goUp(){
      if (this.activeFloor == -1){
        throw new RuntimeException("You are outside of the building. Call enter() first");
      }
      if (this.activeFloor < 3){
        this.activeFloor++;
      }
      else {
        throw new RuntimeException("You are in the 3rd floor.");
      }
    }

    // @Override
    // public void enter(){
    //   if(this.activeFloor == -1) {
    //     this.activeFloor = 0;
    //     System.out.println("You have enetered the library");
    //   }
    // }

    @Override
    public void goDown(){
      if (this.activeFloor == -1){
        throw new RuntimeException("You are outside of the building. Call enter() first");
      }
      if (this.activeFloor > -1){
        this.activeFloor--;
      }
      else {
        throw new RuntimeException("You are in the 1st floor.");
      }
    }
  
    public static void main(String[] args) {
      Library hillyer = new Library("Hillyer Art Library", "22 Elm St", 3, true);
      
      hillyer.addTitle("The Great Gatsby");
      hillyer.addTitle("The Count of Monte Cristo");

      System.out.println("Collection:");
      hillyer.printCollection();

      hillyer.checkOut("The Great Gatsby");
      System.out.println("Updated collection:");
      hillyer.printCollection();

      //Intentional error message
      hillyer.checkOut("The Great Gatsby");

      hillyer.returnBook("The Great Gatsby");
      System.out.println("Final collection inventory:");
      hillyer.printCollection();

      hillyer.showOptions();
      hillyer.enter();
      hillyer.goToFloor(2);
    }
}
  
  
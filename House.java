/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   * 
   */
  public House(String name, String address, int nFloors, Boolean hasDiningRoom, Boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();

  }

  public void moveIn(Student s){
    this.residents.add(s);
    System.out.println(s.toString() + " has moved in.");
  }

  public Student moveOut(Student s) // return the Student who moved out
  {
    if (this.residents.contains(s)){
      this.residents.remove(s);
      System.out.println(s.toString() + " has moved out.");
      return s;
    }
    else {
      String alert = s.getName() + " does not live in this house.";
      throw new RuntimeException(alert);
    }
  }

  public boolean isResident(Student s){
    return this.residents.contains(s);
  }

  public boolean hasElevator(){
    return this.hasElevator;
  }

  @Override
  public void showOptions(){
    if (hasElevator) {
      super.showOptions();
    } else {
      System.out.println("Available options " + this.name + ":\n + enter() \n + goUp() \n goDown()");
    }
  }

  @Override
  public void goToFloor(int floorNum){
    if (hasElevator){
      super.goToFloor(floorNum);
    } else {
      System.out.println("House doesn't have an elevator.");
    }
  }


  public static void main(String[] args) {
    House Chapin = new House("Chapin", "3 Chapin way", 4, true, false);
    Student Milka = new Student("Milka", "9902838", 2028);
    Chapin.moveIn(Milka);
    System.out.println("Is Milka a Chapin resident?" + Chapin.isResident(Milka));
    Chapin.moveOut(Milka);
    System.out.println("Is Milka a Chapin resident?" + Chapin.isResident(Milka));
    Chapin.showOptions();
    Chapin.goToFloor(3);
  }
}
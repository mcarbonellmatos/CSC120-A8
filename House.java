/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   */
  public House(String name, String address, int nFloors, Boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
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


  public static void main(String[] args) {
    House Chapin = new House("Chapin", "3 Chapin way", 3, true);
    Student Milka = new Student("Milka", "9902838", 2028);
    Chapin.moveIn(Milka);
    System.out.println("Is Milka a Chapin resident?" + Chapin.isResident(Milka));
    Chapin.moveOut(Milka);
    System.out.println("Is Milka a Chapin resident?" + Chapin.isResident(Milka));
  }
}
import java.util.ArrayList;


public class House extends Building implements HouseRequirements{
  // House unique attributes
  private ArrayList<Student> residents; // list of students
  private boolean hasDiningRoom; // T/F whether house has dining room


  /**
   * Constructs a new instance of House
   * @param name name of House
   * @param address address of House
   * @param nFloors number of floors in House
   * @param dining whether or not House has a dining room
   */
  public House(String name, String address, int nFloors, boolean dining) {
    super(name, address, nFloors); // use constructor from building to get name, address, floors
    this.residents = new ArrayList<Student>(); // creating new ArrayList for residents
    this.hasDiningRoom = dining; // setting hasDiningRoom to true/false

    System.out.println("You have built a house: 🏠");
  }


  /**
   * Getter for hasDiningRoom; will give you true or false depending on whether or not the House has a dining room
   * @return true/false if House has dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Gets the number of residents in a House
   * @return number of residents in house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * If a student does not already live in the House, this method adds them to the residents of the house
   * @param s The student you want to add
   */
  public void moveIn(Student s) {
    // check if Student s is already in the House
    if (this.residents.contains(s)) {
      // throw exception if the student is already in house
      throw new RuntimeException(s + " already lives in " + this.getName() + " House");
    } 
    // if student is not already in the House
    this.residents.add(s);
  }

  /**
   * Removes a student from the House if they are  currently living in the House
   * @param s the Student you want to remove
   * @return returns the student if they have been successfully removed
   */
  public Student moveOut(Student s) {
    // check if the student is in the house
    if (this.residents.contains(s)) { 
      // remove them from house if they are
      this.residents.remove(s);
      return s;
    }
    // throw exception if they are not 
    throw new RuntimeException(s + " does not live in " + this.getName() + " House" );
  }

  /**
   * Returns true if the student is in the House, false if not
   * @param s the Student you want to investigate
   * @return whether or not that student is in the House
   */
  public boolean isResident(Student s) {
      // if the student is in the House return true. If not, return false
      return this.residents.contains(s);
  }


  public static void main(String[] args) {
    // create Lamont House
    House Lamont = new House("Lamont", "17 Prospect St, Northampton, MA 01063", 4, true);

    // see if hasDiningRoom returns True
    System.out.println(Lamont.hasDiningRoom());

    // see if nResidents prints 0
    System.out.println(Lamont.nResidents());

    // create Students
    Student elaine = new Student("Elaine", "991234567", 2027);
    Student gwyn = new Student("Gwyn", "997654321", 2027);
    Student niveen = new Student("Niveen", "993217654", 2027);

    // see if moveIn will add Elaine & Gwyn to Lamont House
    Lamont.moveIn(elaine);
    Lamont.moveIn(gwyn);
    System.out.println(Lamont.nResidents());

    // see if move in will throw exception when we try to add Elaine again
    //Lamont.moveIn(elaine);

    // see if moveOut will remove Gwyn from the House
    System.out.println(Lamont.moveOut(gwyn));
    System.out.println(Lamont.nResidents());
  

    // see if moveOut will throw an exception if we try to remove niveen from the house
    //Lamont.moveOut(niveen);

    // see if isResident can tell that Elaine is in Lamont
    System.out.println(Lamont.isResident(elaine));

    //see if isResident can tell that Niveen is not in Lamont
    System.out.println(Lamont.isResident(niveen));

  }

}
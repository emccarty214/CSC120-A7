import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {
    // Attributes
    private final Hashtable<String, Boolean> collection;

    /**
     * Constructor for a new instance of library
     * @param name The library's name
     * @param address The library's address
     * @param nFloors The number of floors in the library
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); // get name, address, and floors from building
      this.collection = new Hashtable<String, Boolean>(); // initialize collection
      System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a title to the Library's collection if the title is not already in the collection
     * @param title the title you want to add
     */
    public void addTitle(String title) {
      // check if the book is already in collection
      if (this.collection.containsKey(title)) {
        // throws exception if the book is already in the Library's collection
        throw new RuntimeException(title + " is already in " + this.getName() + " Library's collection");
      }
      // adds book to collection if the library doesn't already have it and sets check out status to true (availiable)
      this.collection.put(title, true);
    }

    /**
     * Removes title from Library's collection if the title is in the collection. Returns removed title
     * @param title The title you want to remove
     * @return the removed title
    */
    public String removeTitle(String title) {
      // check if the title is in the Library's collection
      if (this.collection.containsKey(title)) {
        // if it is in the collection remove it and return the title
        this.collection.remove(title);
        return title;
      } else {
        // if title is not in collection throw exception
        throw new RuntimeException(title + " is not in " + this.getName() + " Library's collection");
      }
    }

    /**
     * If the title is avaliable, allows you to check it out of the Library
     * @param title the title you want to check out
     */
    public void checkOut(String title) {
      // check if title is in the Library's collection
      if (this.collection.containsKey(title)) {
        // if the Library has the title, we want to check if it has already been checked out
        if (this.collection.get(title).equals(false)) {
          // if the title has been checked out, throw exception
          throw new RuntimeException(title + " has already been checked out. Try again later.");
        } else {
          // if title is not checked out, change availability status to false
          this.collection.put(title, false); 
        }
      } else {
        // if the title is not in the Library's collection
        throw new RuntimeException(title + " is not in " + this.getName() + " Library's collection. You cannot check it out");
      }
    }

    /**
     * Returns a checked out title to the Library
     * @param title the title you want to check out
     */
    public void returnBook(String title) {
      // check if title is in the Library's collection
      if (this.collection.containsKey(title)) {
        // if the Library has the title, we want to check if it is available
        if (this.collection.get(title).equals(true)) {
          // if the title has is available, throw exception
          throw new RuntimeException(title + " has not been checked out.");
        } else {
          // if title has been checked out, change check out status to true
          this.collection.put(title, true); 
        }
      } else {
        // if the title is not in the Library's collection
        throw new RuntimeException(title + " is not in " + this.getName() + " Library's collection. You cannot check it out");
      }
    }

    /**
     * Returns true if the title in in the Library's collection
     * @param title the title you want to check
     * @return true/false whether or not the title is in the Library's collection
     */
    public boolean containsTitle(String title) {
      // returns true if the Library's collection has the key title
      return this.collection.containsKey(title);
    }

    /**
     * Returns true if the title is available, false otherwise
     * @param title the title you want to examine
     * @return true for available; false for not available
     */
    public boolean isAvailable(String title) {
      // check if title is in collection
      if (this.collection.containsKey(title)) {
        // if title in collection --> returns true if the title is available
        return this.collection.get(title);
      } else {
        // if title not in collection --> throws exception
        throw new RuntimeException(title + " is not in " + this.getName() + " Library's collection");
      }
      
    }

    /**
     * Prints a nicely formatted list of all titles in collection and whether or not they are available
     */
    public void printCollection() {
      // for every element in the collection
      for (int i = 0; i < this.collection.size(); i++) {
        // create string of each title in collection
        String title = this.collection.keySet().toArray()[i].toString();
        // if the title is available:
        if (this.collection.get(title).equals(true)) {
          // print title and is available
          System.out.println(title + " -- Available");
        } else { // if the title is not available
          // print title and is not available'
          System.out.println(title + " -- Not Available");
        }
        
          
      }
    }
  
    public static void main(String[] args) {
      // creating Hillyer Library
      Library Hillyer = new Library("Hillyer", "22 Elm St, Northampton, MA 01063", 2);

      // make sure the constructer works
      System.out.println(Hillyer);

      // check that addTitle adds a book to our collection
      Hillyer.addTitle("The Princess Bride");
      Hillyer.addTitle("The Night Gardener");
      Hillyer.addTitle("The Little Prince");
      Hillyer.addTitle("Small Spaces");
      System.out.println(Hillyer.collection.size());

      // check that addTitle thows an exception when you try to add a book that's already in the collection
      //Hillyer.addTitle("The Princess Bride");

      // see if removeTitle will take Princess Bride out of the collection
      System.out.println(Hillyer.removeTitle("The Princess Bride"));
      System.out.println(Hillyer.collection.size());
    

      // see if removeTitle will throw exception if we try to remove Sawkill Girls from collection
      //Hillyer.removeTitle("Sawkill Girls");

      // check that we can check out The Night Gardener
      Hillyer.checkOut("The Night Gardener");
      System.out.println(Hillyer.collection.get("The Night Gardener"));

      // check that we get exception when we try to check out the Night Gardener again
      //Hillyer.checkOut("The Night Gardener");

      // see if we get exception when we try to check out a book that is not in the Library's collection
      //Hillyer.checkOut("Sawkill Girls");

      // check that we can return The Night Gardener
      Hillyer.returnBook("The Night Gardener");
      System.out.println(Hillyer.collection.get("The Night Gardener"));

      // check that we get exception when we try to return the Night Garderner when it is available
      //Hillyer.returnBook("The Night Gardener");

      // see if we get exception when we try to check out a book that is not in the Library's collection
      //Hillyer.checkOut("Sawkill Girls");

      // check that containsTitle says the Little Prince is in our Library
      System.out.println(Hillyer.containsTitle("The Little Prince"));

      // check that containsTitle says Sawkill Girls is not in our Library
      System.out.println(Hillyer.containsTitle("Sawkill Girls"));

      // check that isAvailiable returns true for The Little Prince
      System.out.println(Hillyer.isAvailable("The Little Prince"));

      // check that isAvailiable returns false for Small Spaces after we check it out
      Hillyer.checkOut("Small Spaces");
      System.out.println(Hillyer.isAvailable("Small Spaces"));

      // check that isAvailiable throws exception when we try to check the availiability of Sawkill Girls
      //Hillyer.isAvailable("Sawkill Girls");

      // check that printCollection prints what we expect
      Hillyer.printCollection();

    
    }
  
  }
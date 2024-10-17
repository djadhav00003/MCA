import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstraction: Abstract class for educational institutions
abstract class EducationalInstitution {
    protected String administrativeMinistryDepartment; // Encapsulation (protected for subclasses)
    
    // Constructor with default ministry
    public EducationalInstitution() {
        this.administrativeMinistryDepartment = "Ministry of Education";
    }

    // Abstract method for displaying details (Abstraction and Polymorphism)
    public abstract void displayDetails();

    // Getter for encapsulated field
    public String getAdministrativeMinistryDepartment() {
        return administrativeMinistryDepartment;
    }
}

// Inheritance and Encapsulation
class Institution extends EducationalInstitution {
    private String name;
    private String city;
    private String stateUT;
    private String nameOfAct;

    // Constructor with parameters
    public Institution(String name, String city, String stateUT, String nameOfAct) {
        super(); // Call to the parent constructor
        this.name = name;
        this.city = city;
        this.stateUT = stateUT;
        this.nameOfAct = nameOfAct;
    }

    // Getters for Encapsulation
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStateUT() {
        return stateUT;
    }

    public String getNameOfAct() {
        return nameOfAct;
    }

    // Method overriding for Polymorphism (run-time)
    @Override
    public void displayDetails() {
        System.out.printf("Name of Institute: %-60s\nCity: %-60s\nState/UT: %-20s\nName of Act: %-20s\nAdministrative Ministry/Department: %-50s%n%n%n",
                name, city, stateUT, nameOfAct, administrativeMinistryDepartment);
    }
}

// Class Main demonstrating usage of encapsulation, inheritance, polymorphism, and abstraction
public class Main {
    public static void main(String[] args) {

        List<EducationalInstitution> institutions = new ArrayList<>();

        // Adding institutions to the list (Polymorphism: Storing Institution objects in an EducationalInstitution list)
        institutions.add(new Institution("Aligarh Muslim University", "Aligarh", "Uttar Pradesh", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"));
        institutions.add(new Institution("Banaras Hindu University", "Varanasi", "Uttar Pradesh", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"));
        institutions.add(new Institution("University of Delhi", "Delhi", "Delhi", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"));
        institutions.add(new Institution("Atal Bihari Vajpayee Indian Institute of Information Technology and Management, Gwalior", "Gwalior", "Madhya Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"));
        institutions.add(new Institution("Indian Institute of Information Technology, Allahabad", "Allahabad", "Uttar Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"));
        institutions.add(new Institution("Pandit Dwarka Prasad Mishra Indian Institute of Information Technology, Design and Manufacturing, Jabalpur", "Jabalpur", "Madhya Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"));
        institutions.add(new Institution("Indian Institute of Information Technology, Design and Manufacturing, Kancheepuram", "Kancheepuram", "Tamil Nadu", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"));
        institutions.add(new Institution("Indian Institute of Information Technology, Design and Manufacturing, Kurnool", "Kurnool", "Andhra Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"));
        institutions.add(new Institution("Indian Institute of Information Technology, Dharwad", "Dharwad", "Karnataka", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Guwahati", "Guwahati", "Assam", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Kalyani", "Kalyani", "West Bengal", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Kota", "Kota", "Rajasthan", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Kottayam", "Kottayam", "Kerala", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Lucknow", "Lucknow", "Uttar Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Senapati", "Senapati", "Manipur", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Nagpur", "Nagpur", "Maharashtra", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Pune", "Pune", "Maharashtra", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Ranchi", "Ranchi", "Jharkhand", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Sonepat", "Sonepat", "Haryana", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Sri City", "Sri City", "Andhra Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Tiruchirappalli", "Tiruchirappalli", "Tamil Nadu", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));
        institutions.add(new Institution("Indian Institute of Information Technology, Una", "Una", "Himachal Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"));

        // Display all institutions using polymorphism (method overriding)
        for (EducationalInstitution institution : institutions) {
            System.out.println("XXXXXXXXXXXXXXXXXX " + ((Institution) institution).getName() + " XXXXXXXXXXXXXXXXXX");
            institution.displayDetails();  // Polymorphic behavior (runtime method binding)
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. View institutions by State");
            System.out.println("2. View institutions by City");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter the state/UT:");
                    String state = scanner.nextLine();
                    System.out.println("\n");

                    boolean stateFound = false;
                    for (EducationalInstitution institution : institutions) {
                        Institution inst = (Institution) institution; // Downcasting to access Institution-specific fields
                        if (inst.getStateUT().equalsIgnoreCase(state)) {
                            inst.displayDetails();
                            stateFound = true;
                        }
                    }
                    if (!stateFound) {
                        System.out.println("No institutions found for the state/UT: " + state);
                    }
                    break;

                case 2:
                    System.out.println("Enter the city:");
                    String city = scanner.nextLine();
                    System.out.println("\n");

                    boolean cityFound = false;
                    for (EducationalInstitution institution : institutions) {
                        Institution inst = (Institution) institution; // Downcasting to access Institution-specific fields
                        if (inst.getCity().equalsIgnoreCase(city)) {
                            inst.displayDetails();
                            cityFound = true;
                        }
                    }
                    if (!cityFound) {
                        System.out.println("No institutions found in the city: " + city);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please select 1, 2, or 3.");
                    break;
            }
        }
    }
}

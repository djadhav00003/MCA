import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Main class to run the program for displaying and filtering institutions of national importance.
 * <p>
 * Allows users to view institutions by state/UT or city.
 * </p>
 * @author Dipankar Jadhav
 * @version 1.0
 */
public class javadocs {
    /**
     * Main method to run the program.
     * <p>
     * Initializes a list of institutions, displays all institutions, and provides an interactive menu
     * for users to filter and view institutions based on their state/UT or city.
     * </p>
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        List<Institution> institutions = new ArrayList<>();

        // Adding institutions to the list
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

        // Displaying all institutions
        for (Institution institution : institutions) {
            System.out.println("XXXXXXXXXXXXXXXXXX" + institution.getName() + "XXXXXXXXXXXXXXXXXX");
            institution.display();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        // Interactive menu for users
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. View institutions by State");
            System.out.println("2. View institutions by City");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the state/UT:");
                    String state = scanner.nextLine();
                    System.out.println("\n");
                    boolean stateFound = false;
                    for (Institution institution : institutions) {
                        if (institution.getStateUT().equalsIgnoreCase(state)) {
                            institution.display();
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
                    for (Institution institution : institutions) {
                        if (institution.getCity().equalsIgnoreCase(city)) {
                            institution.display();
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

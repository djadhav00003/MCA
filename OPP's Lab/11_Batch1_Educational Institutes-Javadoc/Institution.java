/**
 * Represents a specific institution with additional details such as name, city, state/UT, and the act under which it was established.
 * <p>
 * Inherits from {@link EducationalInstitution}.
 * </p>
 * @author Dipankar Jadhav
 * @version 1.0
 */
public class Institution extends EducationalInstitution{
    private String name;
    private String city;
    private String stateUT;
    private String nameOfAct;

    /**
     * Constructs an Institution with the specified details.
     *
     * @param name The name of the institution.
     * @param city The city where the institution is located.
     * @param stateUT The state or union territory where the institution is located.
     * @param nameOfAct The act under which the institution was established.
     */
    public Institution(String name, String city, String stateUT, String nameOfAct) {
        super();
        this.name = name;
        this.city = city;
        this.stateUT = stateUT;
        this.nameOfAct = nameOfAct;
    }

    /**
     * Gets the name of the institution.
     *
     * @return The name of the institution.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the city where the institution is located.
     *
     * @return The city of the institution.
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the state or union territory where the institution is located.
     *
     * @return The state/UT of the institution.
     */
    public String getStateUT() {
        return stateUT;
    }

    /**
     * Gets the act under which the institution was established.
     *
     * @return The name of the act.
     */
    public String getNameOfAct() {
        return nameOfAct;
    }

    /**
     * Displays the details of the institution, including name, city, state/UT, name of the act, and the administrative ministry/department.
     */
    public void display() {
        System.out.printf("Name of Institute: %-60s\nCity: %-60s\nState/UT: %-20s\nName of Act: %-20s\nAdministrative Ministry/Department: %-50s%n%n%n",
                name, city, stateUT, nameOfAct, administrativeMinistryDepartment);
    }
}

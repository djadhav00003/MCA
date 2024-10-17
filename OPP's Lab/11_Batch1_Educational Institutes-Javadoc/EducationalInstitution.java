/**
 * Represents an educational institution.
 * Provides basic information about the institution, including its administrative ministry or department.
 * <p>
 * Concepts used: class, inheritance.
 * </p>
 * @author Dipankar Jadhav
 * @version 1.0
 */
class EducationalInstitution {
    /** The administrative ministry or department responsible for the institution. */
    protected String administrativeMinistryDepartment;

    /**
     * Constructs an EducationalInstitution with the default administrative ministry/department.
     * Sets the administrative ministry/department to "Ministry of Education".
     */
    public EducationalInstitution() {
        this.administrativeMinistryDepartment = "Ministry of Education";
    }

    /**
     * Gets the administrative ministry or department for this institution.
     *
     * @return The administrative ministry/department.
     */
    public String getAdministrativeMinistryDepartment() {
        return administrativeMinistryDepartment;
    }
}
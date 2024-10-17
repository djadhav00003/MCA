//Author :Dipankar Jadhav
//Roll No: 11
//Title : Displaying Institutions of National Importance
//Start date:17/7/24
//Modified date:24/7/24
//Description :It firstly display all the Institutions of National Importance.
// User can filter out institutions based on state/city and Concepts like class , object , inheritence has been used

using System;
using System.Collections.Generic;

class EducationalInstitution {
    protected string administrativeMinistryDepartment;

    public EducationalInstitution() {
        administrativeMinistryDepartment = "Ministry of Education";
    }

    public string GetAdministrativeMinistryDepartment() {
        return administrativeMinistryDepartment;
    }
}

class Institution : EducationalInstitution {
    private string name;
    private string city;
    private string stateUT;
    private string nameOfAct;

    public Institution(string name, string city, string stateUT, string nameOfAct) {
        this.name = name;
        this.city = city;
        this.stateUT = stateUT;
        this.nameOfAct = nameOfAct;
    }

    public string GetName() {
        return name;
    }

    public string GetCity() {
        return city;
    }

    public string GetStateUT() {
        return stateUT;
    }

    public string GetNameOfAct() {
        return nameOfAct;
    }

    public void Display() {
        Console.WriteLine($"Name of Institute: {name,-60}\nCity: {city,-60}\nState/UT: {stateUT,-20}\nName of Act: {nameOfAct,-20}\nAdministrative Ministry/Department: {administrativeMinistryDepartment,-50}\n\n\n");
    }
}

class Program {
    static void Main(string[] args) {
        List<Institution> institutions = new List<Institution> {
            new Institution("Aligarh Muslim University", "Aligarh", "Uttar Pradesh", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"),
            new Institution("Banaras Hindu University", "Varanasi", "Uttar Pradesh", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"),
            new Institution("University of Delhi", "Delhi", "Delhi", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"),
            new Institution("Atal Bihari Vajpayee Indian Institute of Information Technology and Management, Gwalior", "Gwalior", "Madhya Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
            new Institution("Indian Institute of Information Technology, Allahabad", "Allahabad", "Uttar Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
            new Institution("Pandit Dwarka Prasad Mishra Indian Institute of Information Technology, Design and Manufacturing, Jabalpur", "Jabalpur", "Madhya Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
            new Institution("Indian Institute of Information Technology, Design and Manufacturing, Kancheepuram", "Kancheepuram", "Tamil Nadu", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
            new Institution("Indian Institute of Information Technology, Design and Manufacturing, Kurnool", "Kurnool", "Andhra Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
            new Institution("Indian Institute of Information Technology, Dharwad", "Dharwad", "Karnataka", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Guwahati", "Guwahati", "Assam", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Kalyani", "Kalyani", "West Bengal", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Kota", "Kota", "Rajasthan", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Kottayam", "Kottayam", "Kerala", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Lucknow", "Lucknow", "Uttar Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Senapati", "Senapati", "Manipur", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Nagpur", "Nagpur", "Maharashtra", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Pune", "Pune", "Maharashtra", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Ranchi", "Ranchi", "Jharkhand", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Sonepat", "Sonepat", "Haryana", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Sri City", "Sri City", "Andhra Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Tiruchirappalli", "Tiruchirappalli", "Tamil Nadu", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
            new Institution("Indian Institute of Information Technology, Una", "Una", "Himachal Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        };

        foreach (var institution in institutions) {
            Console.WriteLine("XXXXXXXXXXXXXXXXXX" + institution.GetName() + "XXXXXXXXXXXXXXXXXX");
            institution.Display();
            Console.WriteLine();
        }

        while (true) {
            Console.WriteLine("Choose an option:");
            Console.WriteLine("1. View institutions by State");
            Console.WriteLine("2. View institutions by City");
            Console.WriteLine("3. Exit");

            int choice = int.Parse(Console.ReadLine());

            switch (choice) {
                case 1:
                    Console.WriteLine("Enter the state/UT:");
                    string state = Console.ReadLine();
                    Console.WriteLine("\n");
                    bool stateFound = false;
                    foreach (var institution in institutions) {
                        if (institution.GetStateUT().Equals(state, StringComparison.OrdinalIgnoreCase)) {
                            institution.Display();
                            stateFound = true;
                        }
                    }
                    if (!stateFound) {
                        Console.WriteLine("No institutions found for the state/UT: " + state);
                    }
                    break;

                case 2:
                    Console.WriteLine("Enter the city:");
                    string city = Console.ReadLine();
                    Console.WriteLine("\n");
                    bool cityFound = false;
                    foreach (var institution in institutions) {
                        if (institution.GetCity().Equals(city, StringComparison.OrdinalIgnoreCase)) {
                            institution.Display();
                            cityFound = true;
                        }
                    }
                    if (!cityFound) {
                        Console.WriteLine("No institutions found in the city: " + city);
                    }
                    break;

                case 3:
                    Console.WriteLine("Exiting...");
                    return;

                default:
                    Console.WriteLine("Invalid choice, please select 1, 2, or 3.");
                    break;
            }
        }
    }
}
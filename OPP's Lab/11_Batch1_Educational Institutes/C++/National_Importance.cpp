//Author :Dipankar Jadhav
//Roll No: 11
//Title : Displaying Institutions of National Importance
//Start date:17/7/24
//Modified date:24/7/24
//Description :It firstly display all the Institutions of National Importance.
// User can filter out institutions based on state/city and Concepts like class , object , inheritence has been used

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

class EducationalInstitution {
protected:
    std::string administrativeMinistryDepartment;

public:
    EducationalInstitution() {
        administrativeMinistryDepartment = "Ministry of Education";
    }

    std::string getAdministrativeMinistryDepartment() const {
        return administrativeMinistryDepartment;
    }
};

class Institution : public EducationalInstitution {
private:
    std::string name;
    std::string city;
    std::string stateUT;
    std::string nameOfAct;

public:
    Institution(std::string name, std::string city, std::string stateUT, std::string nameOfAct)
        : name(name), city(city), stateUT(stateUT), nameOfAct(nameOfAct) {}

    std::string getName() const {
        return name;
    }

    std::string getCity() const {
        return city;
    }

    std::string getStateUT() const {
        return stateUT;
    }

    std::string getNameOfAct() const {
        return nameOfAct;
    }

    void display() const {
        printf("Name of Institute: %-60s\nCity: %-60s\nState/UT: %-20s\nName of Act: %-20s\nAdministrative Ministry/Department: %-50s\n\n\n",
               name.c_str(), city.c_str(), stateUT.c_str(), nameOfAct.c_str(), administrativeMinistryDepartment.c_str());
    }
};

int main() {
    std::vector<Institution> institutions = {
        Institution("Aligarh Muslim University", "Aligarh", "Uttar Pradesh", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"),
        Institution("Banaras Hindu University", "Varanasi", "Uttar Pradesh", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"),
        Institution("University of Delhi", "Delhi", "Delhi", "Entry No. 63, Union list - The 7th schedule under Article 246 of the Constitution of India"),
        Institution("Atal Bihari Vajpayee Indian Institute of Information Technology and Management, Gwalior", "Gwalior", "Madhya Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
        Institution("Indian Institute of Information Technology, Allahabad", "Allahabad", "Uttar Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
        Institution("Pandit Dwarka Prasad Mishra Indian Institute of Information Technology, Design and Manufacturing, Jabalpur", "Jabalpur", "Madhya Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
        Institution("Indian Institute of Information Technology, Design and Manufacturing, Kancheepuram", "Kancheepuram", "Tamil Nadu", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
        Institution("Indian Institute of Information Technology, Design and Manufacturing, Kurnool", "Kurnool", "Andhra Pradesh", "The Indian Institutes of Information Technology Act, 2014 and their subsequent amendments"),
        Institution("Indian Institute of Information Technology, Dharwad", "Dharwad", "Karnataka", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Guwahati", "Guwahati", "Assam", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Kalyani", "Kalyani", "West Bengal", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Kota", "Kota", "Rajasthan", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Kottayam", "Kottayam", "Kerala", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Lucknow", "Lucknow", "Uttar Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Senapati", "Senapati", "Manipur", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Nagpur", "Nagpur", "Maharashtra", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Pune", "Pune", "Maharashtra", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Ranchi", "Ranchi", "Jharkhand", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Sonepat", "Sonepat", "Haryana", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Sri City", "Sri City", "Andhra Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Tiruchirappalli", "Tiruchirappalli", "Tamil Nadu", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
        Institution("Indian Institute of Information Technology, Una", "Una", "Himachal Pradesh", "The Indian Institutes of Information Technology (Public-Private Partnership) Act, 2017"),
    };

    for (const auto& institution : institutions) {
        std::cout << "XXXXXXXXXXXXXXXXXX" << institution.getName() << "XXXXXXXXXXXXXXXXXX" << std::endl;
        institution.display();
        std::cout << std::endl;
    }

    while (true) {
        std::cout << "Choose an option:" << std::endl;
        std::cout << "1. View institutions by State" << std::endl;
        std::cout << "2. View institutions by City" << std::endl;
        std::cout << "3. Exit" << std::endl;

        int choice;
        std::cin >> choice;
        std::cin.ignore();

        switch (choice) {
        case 1: {
            std::cout << "Enter the state/UT:" << std::endl;
            std::string state;
            std::getline(std::cin, state);
            std::cout << std::endl;
            bool stateFound = false;
            for (const auto& institution : institutions) {
                if (std::equal(state.begin(), state.end(), institution.getStateUT().begin(), institution.getStateUT().end(), [](char a, char b) { return tolower(a) == tolower(b); })) {
                    institution.display();
                    stateFound = true;
                }
            }
            if (!stateFound) {
                std::cout << "No institutions found for the state/UT: " << state << std::endl;
            }
            break;
        }
        case 2: {
            std::cout << "Enter the city:" << std::endl;
            std::string city;
            std::getline(std::cin, city);
            std::cout << std::endl;
            bool cityFound = false;
            for (const auto& institution : institutions) {
                if (std::equal(city.begin(), city.end(), institution.getCity().begin(), institution.getCity().end(), [](char a, char b) { return tolower(a) == tolower(b); })) {
                    institution.display();
                    cityFound = true;
                }
            }
            if (!cityFound) {
                std::cout << "No institutions found in the city: " << city << std::endl;
            }
            break;
        }
        case 3:
            std::cout << "Exiting..." << std::endl;
            return 0;

        default:
            std::cout << "Invalid choice, please select 1, 2, or 3." << std::endl;
            break;
        }
    }
}
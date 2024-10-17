#Author :Dipankar Jadhav
#Roll No: 11
#Title : Displaying Institutions of National Importance
#Start date:17/7/24
#Modified date:24/7/24
#Description :It firstly display all the Institutions of National Importance.
# User can filter out institutions based on state/city and Concepts like class , object , inheritence has been used

class EducationalInstitution:
    def __init__(self):
        self.administrative_ministry_department = "Ministry of Education"

    def get_administrative_ministry_department(self):
        return self.administrative_ministry_department


class Institution(EducationalInstitution):
    def __init__(self, name, city, state_ut, name_of_act):
        super().__init__()
        self.name = name
        self.city = city
        self.state_ut = state_ut
        self.name_of_act = name_of_act

    def get_name(self):
        return self.name

    def get_city(self):
        return self.city

    def get_state_ut(self):
        return self.state_ut

    def get_name_of_act(self):
        return self.name_of_act

    def display(self):
        print(f"Name of Institute: {self.name:<60}\nCity: {self.city:<60}\nState/UT: {self.state_ut:<20}\nName of Act: {self.name_of_act:<20}\nAdministrative Ministry/Department: {self.administrative_ministry_department:<50}\n\n\n")


def main():
    institutions = [
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
    ]

    for institution in institutions:
        print("XXXXXXXXXXXXXXXXXX" + institution.get_name() + "XXXXXXXXXXXXXXXXXX")
        institution.display()
        print()

    while True:
        print("Choose an option:")
        print("1. View institutions by State")
        print("2. View institutions by City")
        print("3. Exit")

        choice = int(input())

        if choice == 1:
            print("Enter the state/UT:")
            state = input()
            print("\n")
            state_found = False
            for institution in institutions:
                if institution.get_state_ut().lower() == state.lower():
                    institution.display()
                    state_found = True
            if not state_found:
                print("No institutions found for the state/UT: " + state)

        elif choice == 2:
            print("Enter the city:")
            city = input()
            print("\n")
            city_found = False
            for institution in institutions:
                if institution.get_city().lower() == city.lower():
                    institution.display()
                    city_found = True
            if not city_found:
                print("No institutions found in the city: " + city)

        elif choice == 3:
            print("Exiting...")
            break

        else:
            print("Invalid choice, please select 1, 2, or 3.")


if __name__ == "__main__":
    main()

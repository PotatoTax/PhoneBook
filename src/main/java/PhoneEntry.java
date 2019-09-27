class PhoneEntry
{
    private String firstName;
    private String lastName;
    private String phone;

    PhoneEntry(String FirstName, String LastName, String PhoneNumber)
    {
        firstName = FirstName;
        lastName = LastName;
        phone = PhoneNumber;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getPhone() {
        return phone;
    }
}

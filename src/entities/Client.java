package entities;

public class Client {
    private final String name;
    private final String surname;
    private final String address;
    private final String passportNumber;

    public Client(String name, String surname, String address, String passportNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
}

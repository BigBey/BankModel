package builders;

import entities.Client;

public class ClientBuilder implements IBuilder {

    private String name;
    private String surname;
    private String address;
    private String passportNumber;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public void reset() {
        this.name = null;
        this.surname = null;
        this.address = null;
        this.passportNumber = null;
    }

    public Client getResult(){
        if(name != null && surname != null)
            return new Client(name, surname, address, passportNumber);
        else
            return null;
    }

}

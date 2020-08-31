package addressbook;

import java.util.Collections;
import java.util.Comparator;

public class Person implements Comparable<Person> {

    public Person(String firstname, String lastname, String address,
            String city, String state, int zip) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s, %s  %05d",
                firstname, lastname, address, city, state, zip);
    }

    @Override
    public int compareTo(Person o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class NameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int x = o1.getLastName().compareTo(o2.getLastName());
            if (x == 0){
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return x;
        }
    }

    public static class AddressComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAddress().compareTo(o2.getAddress());
        }
    }

    public static class CityComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getCity().compareTo(o2.getCity());
        }
    }

    public static class StateComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getState().compareTo(o2.getState());
        }
    }

    public static class ZipComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return (o1.getZip() - o2.getZip());
        }
    }

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private int zip;
}

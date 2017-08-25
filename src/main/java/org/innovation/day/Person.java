package org.innovation.day;

/**
 * Created by kondrak on 8/25/17.
 */
public class Person {
    private String personToken;
    private String firstName;
    private String lastName;

    public String getPersonToken() {
        return personToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPersonToken(String personToken) {
        this.personToken = personToken;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

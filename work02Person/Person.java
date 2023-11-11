package int101s2023h02.src.work02Person;

import int101s2023h02.src.work01Utilitor.Utilitor;

import java.util.Objects;

public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        Utilitor utilitor = new Utilitor();
        this.firstname = utilitor.testString(firstname);
        this.lastname = utilitor.testString(lastname);
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void incrementNextId() {
        nextId += 10;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        Utilitor utilitor = new Utilitor();
        this.firstname = utilitor.testString(firstname);
    }

    public void setLastname(String lastname) {
        Utilitor utilitor = new Utilitor();
        this.lastname = utilitor.testString(lastname);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname);
    }
}

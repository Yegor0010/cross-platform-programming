package com.y0010;

import java.util.Comparator;

public class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " -> " + age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj instanceof Human) == false)
            return false;

        Human human = (Human) obj;
        return getFirstName().equalsIgnoreCase(human.getFirstName())
                && getLastName().equalsIgnoreCase(human.getLastName()) && getAge() == human.getAge();

    }

    @Override
    public int compareTo(Human human) {
        Comparator<Human> comparator = Comparator.comparing(Human::getFirstName).thenComparing(Human::getLastName)
                .thenComparing(Human::getAge);

        return comparator.compare(this, human);
    }
}

package org.example;

import java.util.Objects;

public abstract class Person {
    private String name;

    public abstract String getDescription();

    // constructors
    public Person() {
        name = null;
    }
    public Person(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }
}

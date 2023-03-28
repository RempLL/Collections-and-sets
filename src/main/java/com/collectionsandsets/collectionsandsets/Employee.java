package com.collectionsandsets.collectionsandsets;

import java.util.Objects;

public class Employee {
    private final String name;

    private final String surname;


    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public String toString() {
        return "Имя:" + name + " Фамилия: " + surname;
    }
}

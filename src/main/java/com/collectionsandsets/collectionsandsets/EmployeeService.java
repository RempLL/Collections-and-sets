package com.collectionsandsets.collectionsandsets;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employee = new ArrayList<>(List.of(
            new Employee("Альберт", "Миронов"),
            new Employee("Виктор", "Меньшиков"),
            new Employee("Андрей", "Абавикян"),
            new Employee("Петр", "Первый"),
            new Employee("Мария", "Воронова"),
            new Employee("Федор", "Кислинкин"),
            new Employee("Ренат", "Хабибулин"),
            new Employee("Дмитрий", "Рогозов"),
            new Employee("Роберт", "Иванов"),
            new Employee("Павел", "Кучин")
    ));


    public Employee addEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        for (Employee value : employee) {
            if (value.equals(newEmployee)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        employee.add(newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).equals(newEmployee)) {
                return employee.remove(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        for (Employee value : employee) {
            if (value.equals(newEmployee)) {
                return newEmployee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String print() {
        return employee.toString();
    }
}

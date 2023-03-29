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


    public void addEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        boolean flag = false;
        for (Employee value : employee) {
            if (value.equals(newEmployee)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employee.add(newEmployee);
        }
    }

    public void removeEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        boolean flag = false;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).equals(newEmployee)) {
                employee.remove(i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new EmployeeNotFoundException();
        }
    }

    public boolean findEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        for (Employee value : employee) {
            if (value.equals(newEmployee)) {
                return true;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String print() {
        return employee.toString();
    }
}

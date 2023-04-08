package com.collectionsandsets.collectionsandsets;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    Map<String,Employee> employee = new HashMap<>(Map.of(
            "1", new Employee("Альберт", "Миронов"),
            "2",new Employee("Виктор", "Меньшиков"),
            "3",new Employee("Андрей", "Абавикян"),
            "4",new Employee("Петр", "Первый"),
            "5",new Employee("Мария", "Воронова"),
            "6",new Employee("Федор", "Кислинкин"),
            "7",new Employee("Ренат", "Хабибулин"),
            "8",new Employee("Дмитрий", "Рогозов"),
            "9",new Employee("Роберт", "Иванов"),
            "10",new Employee("Павел", "Кучин")));

    public Employee addEmployee(String name,String surname){
        Employee newEmployee = new Employee(name,surname);
        if(employee.containsValue(newEmployee)){
            throw new EmployeeAlreadyAddedException();
        }
        employee.put(String.valueOf(employee.size()+1),newEmployee);
        System.out.println(employee);
        return newEmployee;
    }

    public Employee removeEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        if (employee.values().remove(newEmployee)) {
            return newEmployee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);
        if (employee.containsValue(newEmployee)) {
            return newEmployee;
        }
        throw new EmployeeNotFoundException();
    }

    public String print() {
        return employee.values().toString();
    }
}

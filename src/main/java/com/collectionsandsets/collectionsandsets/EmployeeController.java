package com.collectionsandsets.collectionsandsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String print() {
        return employeeService.print();
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        try {
            employeeService.addEmployee(name, surname);
            return "Сотрудник " + name + " " + surname + " добавлен";
        } catch (EmployeeAlreadyAddedException e) {
            return "Сотрудник " + name + " " + surname + " уже есть";
        }
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        try {
            employeeService.removeEmployee(name, surname);
            return "Сотрудник " + name + " " + surname + " удален";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник " + name + " " + surname + " отсутствует";
        }
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        try {
            employeeService.findEmployee(name, surname);
            return "Сотрудник " + name + " " + surname + " найден";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник " + name + " " + surname + " отсутствует";
        }
    }
}

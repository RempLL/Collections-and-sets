package com.collectionsandsets.collectionsandsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public Employee add(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String name, @RequestParam("lastName") String surname) {
        return employeeService.findEmployee(name, surname);
    }
}

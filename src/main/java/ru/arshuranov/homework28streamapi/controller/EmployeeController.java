package ru.arshuranov.homework28streamapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.arshuranov.homework28streamapi.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.arshuranov.homework28streamapi.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequestMapping(path = "/employees")


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Это просто для теста как печатается мапа
    @GetMapping()
    public Map printAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("salary") int salary,
            @RequestParam("department") int department

    ) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public String removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

    //тест для вывода листа без ключей
    @GetMapping("/list")
    public List<Employee> hashMapToList() {
        return employeeService.getListOfEmployees();
    }


    @GetMapping("/departments/max-salary")
    public Optional<Employee> maxSalaryDepartment(
            @RequestParam("departmentId") int department
    ) {
        return employeeService.maxSalaryDepartment(department);
    }

    @GetMapping("/departments/min-salary")
    public Optional<Employee> minSalaryDepartment(
            @RequestParam("departmentId") int department
    ) {
        return employeeService.minSalaryDepartment(department);
    }

    //здесь допер сделать перегрузку, надеюсь, что правильно
    @GetMapping("/departments/all")
    public List<Employee> allEmployeesSortedByDepartment(
            @RequestParam(value = "departmentId", required = false) Integer department
    ) {
        if (department == null) {
            return employeeService.allEmployeesSortedByDepartment();
        }
        return employeeService.allEmployeesSortedByDepartment(department);
    }


}

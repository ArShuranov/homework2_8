package ru.arshuranov.homework28streamapi.service;

import ru.arshuranov.homework28streamapi.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    String removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> getAllEmployees();


}

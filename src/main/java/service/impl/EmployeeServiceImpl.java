package service.impl;

import model.Employee;
import org.springframework.stereotype.Service;
import service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    @Override
    public String print() {
        return "Hello";
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = getEmployeeKey(firstName, lastName);

        if (employees.containsKey(key)) {
            throw new RuntimeException("Такой сотрудник уже есть в базе");
        } else {
            employees.put(key, employee);
        } return employees.get(key);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String key = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new RuntimeException("Такого сотрудника нет в базе");
        } else {
            employees.remove(key);
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new RuntimeException("Такого сотрудника нет в базе");
        } else {
            return employees.get(key);
        }
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

}

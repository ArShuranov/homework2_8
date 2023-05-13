package ru.arshuranov.homework28streamapi.service.impl;

import org.springframework.stereotype.Service;
import ru.arshuranov.homework28streamapi.model.Employee;
import ru.arshuranov.homework28streamapi.service.DepartmentService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer department) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer department) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer department) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> department==null || employee.getDepartment().equals(department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

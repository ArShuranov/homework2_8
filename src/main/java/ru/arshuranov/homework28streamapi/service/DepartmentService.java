package ru.arshuranov.homework28streamapi.service;

import ru.arshuranov.homework28streamapi.model.Employee;

import java.util.List;
import java.util.Map;


public interface DepartmentService {

    Employee getEmployeeWithMaxSalary(Integer department);

    Employee getEmployeeWithMinSalary(Integer department);

    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees(Integer department);

}

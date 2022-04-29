package pro.sky.course_2_spring_all.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.course_2_spring_all.data.Employee;
import pro.sky.course_2_spring_all.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course_2_spring_all.exceptions.EmployeeNotFoundException;
import pro.sky.course_2_spring_all.exceptions.InvalidNameException;
import pro.sky.course_2_spring_all.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String lastName, String firstName, int department, int salary) {
        validateName(firstName, lastName);
        Employee newEmployee = new Employee(capitalize(lastName), capitalize(firstName), department, salary);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public void validateName(String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new InvalidNameException(name);
            }
        }
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName, int department, int salary) {
        Employee removeEmployee = new Employee(lastName, firstName, department, salary);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(removeEmployee)) {
                employees.remove(removeEmployee);
                return removeEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String lastName, String firstName, int department, int salary) {
        Employee findEmployee = new Employee(lastName, firstName, department, salary);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(findEmployee)) {
                return findEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public List<Employee> printListOfEmployee() {
        return employees;
    }

    @Override
    public Map<String, Employee> printAllEmployee() {
        return null;
    }

    @Override
    public Employee findEmployee2(String lastName, String firstName) {
        return null;
    }
}


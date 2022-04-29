package pro.sky.course_2_spring_all.service;

import pro.sky.course_2_spring_all.data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    public Employee addEmployee(String lastName, String firstName, int department, int salary);

    public Employee removeEmployee(String lastName, String firstName, int department, int salary);

    public Employee findEmployee(String lastName, String firstName, int department, int salary);

    public Employee findEmployee2(String lastName, String firstName);

    public List<Employee> printListOfEmployee();

    public Map<String, Employee> printAllEmployee();
}

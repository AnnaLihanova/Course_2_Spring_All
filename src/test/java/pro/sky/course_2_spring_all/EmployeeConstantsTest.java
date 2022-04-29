package pro.sky.course_2_spring_all;

import pro.sky.course_2_spring_all.data.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeConstantsTest {
    public static final String LAST_NAME = "Bunin";
    public static final String LAST_NAME2 = "Muchin";
    public static final String FIRST_NAME = "Ivav";
    public static final String FIRST_NAME2 = "Timur";
    public static final String INCORRECT_FIRST_NAME = "Timur87";
    public static final int DEPARTMENT = 1;
    public static final int INCORRECT_DEPARTMENT = 6;
    public static final int SALARY = 200;
    public static final int MIN_SALARY = 100;
    public static final int MAX_SALARY = 300;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(LAST_NAME, FIRST_NAME,  DEPARTMENT, MAX_SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(LAST_NAME2, FIRST_NAME2, DEPARTMENT, MIN_SALARY);
    public static final Employee INCORRECT_DEPARTMENT_EMPLOYEE = new Employee(LAST_NAME, FIRST_NAME, INCORRECT_DEPARTMENT, SALARY);
    public static final List<Employee> EMPLOYEES = List.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE);
    public static final List<Employee> EMPLOYEES2 = List.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE,INCORRECT_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer, List<Employee>> EMPLOYEE_MAP = EMPLOYEES2.stream()
            .collect(groupingBy(Employee::getDepartment));
}

package pro.sky.course_2_spring_all.service;


import pro.sky.course_2_spring_all.data.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public Employee printDepartmentMaxSalary(int department);

    public Employee printDepartmentMinSalary(int department);

    public List<Employee> printAllEmployeesDepartment(int department);

    public Map<Integer, List<Employee>> printListByDepartment();
}

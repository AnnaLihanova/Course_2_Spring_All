package pro.sky.course_2_spring_all.service.impl;//package pro.sky.coursetwo.services;
//
//import org.springframework.stereotype.Service;
//import pro.sky.coursetwo.data.Employee;
//import pro.sky.coursetwo.exceptions.EmployeeAlreadyAddedException;
//import pro.sky.coursetwo.exceptions.EmployeeNotFoundException;
//import pro.sky.coursetwo.interfaces.EmployeeService;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class EmployeeServiceMapImpl implements EmployeeService {
//    private final Map<String, Employee> employeesMap;
//
//    public EmployeeServiceMapImpl() {
//        employeesMap = new HashMap<>();
//    }
//
//    private String getKey(String lastName, String firstName) {
//        return firstName + " " + lastName;
//    }
//
//    @Override
//    public Employee addEmployee(String lastName, String firstName) {
//        String key = getKey(lastName, firstName);
//        if (employeesMap.containsKey(key)) {
//            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
//        }
//        Employee newEmployeeMap = new Employee(lastName, firstName);
//        employeesMap.put(key, newEmployeeMap);
//        return newEmployeeMap;
//    }
//
//    @Override
//    public Employee removeEmployee(String lastName, String firstName) {
//        String key = getKey(lastName, firstName);
//        if (employeesMap.remove(key) == null) {
//            throw new EmployeeNotFoundException("Employee not found");
//        }
//        Employee removedEmployee = new Employee(lastName, firstName);
//        return removedEmployee;
//            }
//
//    @Override
//    public Employee findEmployee2(String lastName, String firstName) {
//        String key = getKey(lastName, firstName);
//        Employee findEmployee = employeesMap.get(key);
//        if (employeesMap.get(key) == null) {
//            throw new EmployeeNotFoundException("Employee not found");
//        }
//        return findEmployee;
//    }
//
//    @Override
//    public Map<String, Employee> printAllEmployee() {
//        return employeesMap;
//    }
//
//    @Override
//    public List<Employee> printListOfEmployee() {
//        return null;
//    }
//
//    @Override
//    public boolean findEmployee(String lastName, String firstName) {
//        return false;
//    }
//}

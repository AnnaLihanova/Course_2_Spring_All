package pro.sky.course_2_spring_all.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_2_spring_all.data.Employee;
import pro.sky.course_2_spring_all.service.impl.EmployeeServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") int salary) {
        return employeeService.addEmployee(lastName, firstName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("department") int department,
                                   @RequestParam("salary") int salary) {
        return employeeService.removeEmployee(lastName, firstName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeService.findEmployee2(lastName, firstName);
    }

    @GetMapping(path = "/print")
    public Map<String, Employee> printAllEmployee() {
        return employeeService.printAllEmployee();
    }
}

package pro.sky.course_2_spring_all;

import org.junit.jupiter.api.Test;
import pro.sky.course_2_spring_all.data.Employee;
import pro.sky.course_2_spring_all.exceptions.EmployeeAlreadyAddedException;
import pro.sky.course_2_spring_all.exceptions.EmployeeNotFoundException;
import pro.sky.course_2_spring_all.exceptions.InvalidNameException;
import pro.sky.course_2_spring_all.service.impl.EmployeeServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course_2_spring_all.EmployeeConstantsTest.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    void shouldAddEmployee() {
        Employee newEmployee = new Employee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY);
        assertEquals(0, employeeService.printListOfEmployee().size());
        assertEquals(employeeService.addEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY), newEmployee);
        assertEquals(1, employeeService.printListOfEmployee().size());
    }

    @Test
    void shouldExceptionWhenEmployeeAlreadyAdded() {
        Employee existed = employeeService.addEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY);
        assertTrue(employeeService.printListOfEmployee().contains(existed));
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldExceptionWhenInvalidName() {
        assertThrows(InvalidNameException.class, () -> employeeService.validateName(INCORRECT_FIRST_NAME));
    }

    @Test
    void shouldRemoveEmployee() {
        Employee newEmployee = employeeService.addEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY);
        assertEquals(1, employeeService.printListOfEmployee().size());
        Employee removedEmployee = employeeService.removeEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY);
        assertEquals(newEmployee, removedEmployee);
        assertTrue(employeeService.printListOfEmployee().isEmpty());
    }

    @Test
    void shouldExceptionWhenRemoveEmployee() {
        assertTrue(employeeService.printListOfEmployee().isEmpty());
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldFindEmployee() {
        Employee existed = employeeService.addEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY);
        assertEquals(existed, employeeService.findEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldExceptionWhenEmployeeNotFind() {
        assertEquals(0, employeeService.printListOfEmployee().size());
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY));

    }

    @Test
    void shouldPrintListOfEmployee() {
        Employee newEmployee = employeeService.addEmployee(LAST_NAME, FIRST_NAME, DEPARTMENT, SALARY);
        Employee newEmployee2 = employeeService.addEmployee(LAST_NAME2, FIRST_NAME2, DEPARTMENT, SALARY);
        List<Employee> newListOfEmployee = List.of(newEmployee, newEmployee2);
        assertEquals(newListOfEmployee, employeeService.printListOfEmployee());
    }
}
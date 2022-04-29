package pro.sky.course_2_spring_all;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_2_spring_all.exceptions.EmployeeNotFoundException;
import pro.sky.course_2_spring_all.service.impl.DepartmentServiceImpl;
import pro.sky.course_2_spring_all.service.impl.EmployeeServiceImpl;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.course_2_spring_all.EmployeeConstantsTest.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void shouldPrintDepartmentMaxSalary() {
        when(employeeService.printListOfEmployee()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.printDepartmentMaxSalary(DEPARTMENT));
    }

    @Test
    void shouldExceptionWhenEmployeeWithMaxSalaryNotFound() {
        when(employeeService.printListOfEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.printDepartmentMaxSalary(DEPARTMENT));
    }

    @Test
    void shouldPrintDepartmentMinSalary() {
        when(employeeService.printListOfEmployee()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.printDepartmentMinSalary(DEPARTMENT));
    }

    @Test
    void shouldExceptionWhenEmployeeWithMinSalaryNotFound() {
        when(employeeService.printListOfEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.printDepartmentMinSalary(DEPARTMENT));
    }

    @Test
    void shouldExceptionWhenDepartmentIsIncorrect() {
        when(employeeService.printListOfEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.printDepartmentMinSalary(INCORRECT_DEPARTMENT));
    }

    @Test
    void shouldPrintAllEmployeesDepartment() {
        when(employeeService.printListOfEmployee()).thenReturn(EMPLOYEES2);
        assertEquals(EMPLOYEES, departmentService.printAllEmployeesDepartment(DEPARTMENT));
    }

    @Test
    void shouldPrintListByDepartment() {
        when(employeeService.printListOfEmployee()).thenReturn(EMPLOYEES2);
        assertEquals(EMPLOYEE_MAP, departmentService.printListByDepartment());
    }
}
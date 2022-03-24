package pro.sky.coursetwo.services;

import org.springframework.stereotype.Service;
import pro.sky.coursetwo.data.Employee;
import pro.sky.coursetwo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.coursetwo.exceptions.EmployeeNotFoundException;
import pro.sky.coursetwo.interfaces.EmployeeService;
import pro.sky.coursetwo.interfaces.DepartmentService;

import java.util.ArrayList;
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
    public Employee printDepartmentMaxSalary(int department) {
        return employeeService.printListOfEmployee().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee printDepartmentMinSalary(int department) {
        return employeeService.printListOfEmployee().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public List<Employee> printAllEmployeesDepartment(int department) {
        return employeeService.printListOfEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> printListByDepartment() {
        return employeeService.printListOfEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }
}

package pro.sky.coursetwo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursetwo.data.Employee;
import pro.sky.coursetwo.services.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl employeeService;

    public DepartmentController(DepartmentServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/max-salary")
    public Employee printDepartmentMaxSalary(@RequestParam("department") int department) {
        return employeeService.printDepartmentMaxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee printDepartmentMinSalary(@RequestParam("department") int department) {
        return employeeService.printDepartmentMinSalary(department);
    }

    @GetMapping(path = "/all", params = "department")
    public List<Employee> printAllEmployeesDepartment(@RequestParam("department") int department) {
        return employeeService.printAllEmployeesDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printListByDepartment() {
        return employeeService.printListByDepartment();
    }
}


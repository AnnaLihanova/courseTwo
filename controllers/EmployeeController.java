package pro.sky.coursetwo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursetwo.data.Employee;
import pro.sky.coursetwo.services.EmployeeServiceImpl;
import pro.sky.coursetwo.services.EmployeeServiceMapImpl;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final EmployeeServiceMapImpl employeeServiceMap;

    public EmployeeController(EmployeeServiceImpl employeeService, EmployeeServiceMapImpl employeeServiceMap) {
        this.employeeService = employeeService;
        this.employeeServiceMap = employeeServiceMap;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeServiceMap.addEmployee(lastName, firstName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeServiceMap.removeEmployee(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName) {
        return employeeServiceMap.findEmployee2(lastName, firstName);
    }

    @GetMapping(path = "/print")
    public Map<String, Employee> printAllEmployee() {
        return employeeServiceMap.printAllEmployee();
    }
}

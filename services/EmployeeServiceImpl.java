package pro.sky.coursetwo.services;

import org.springframework.stereotype.Service;

import pro.sky.coursetwo.data.Employee;
import pro.sky.coursetwo.exceptions.EmployeeAlreadyAddedException;
import pro.sky.coursetwo.exceptions.EmployeeNotFoundException;
import pro.sky.coursetwo.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivanov", "Ivan"),
            new Employee("Шариков", "Роман"),
            new Employee("Дудник", "Петр"),
            new Employee("Кромкина", "Мария"),
            new Employee("Тарасова", "Татьяна")
    ));

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        Employee newEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(newEmployee)) {
                throw new EmployeeAlreadyAddedException("Employee already added");
            }
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        Employee removeEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(removeEmployee)) {
                employees.remove(removeEmployee);
                return removeEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public boolean findEmployee(String lastName, String firstName) {
        Employee findEmployee = new Employee(lastName, firstName);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(findEmployee)) {
                return true;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public List<Employee> printListOfEmployee() {
        return employees;
    }

    @Override
    public Map<String, Employee> printAllEmployee() {
        return null;
    }

    @Override
    public Employee findEmployee2(String lastName, String firstName) {
        return null;
    }
}


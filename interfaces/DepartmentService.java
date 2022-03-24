package pro.sky.coursetwo.interfaces;


import pro.sky.coursetwo.data.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public Employee printDepartmentMaxSalary(int department);

    public Employee printDepartmentMinSalary(int department);

    public List<Employee> printAllEmployeesDepartment(int department);

    public Map<Integer, List<Employee>> printListByDepartment();
}

package com.bakuvi.spring.rest.controller;

import com.bakuvi.spring.rest.exception_handling.NoSuchEmployeeException;
import com.bakuvi.spring.rest.entity.Employee;
import com.bakuvi.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("there is no employee with ID=" + id + "in DB");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee=employeeService.getEmployee(id);
        if(employee==null){
            throw new NoSuchEmployeeException("there is no employee with ID=" + id +"in DB");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id="+id+"was deleted";
    }

}

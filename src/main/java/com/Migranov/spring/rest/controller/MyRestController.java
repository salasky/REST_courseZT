package com.Migranov.spring.rest.controller;

import com.Migranov.spring.rest.entity.Employee;
import com.Migranov.spring.rest.exeption_handler.EmployeeInCorrectData;
import com.Migranov.spring.rest.exeption_handler.NoSuchEmployeeExeption;
import com.Migranov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final EmployeeService employeeService;

    @Autowired
    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allemployees=employeeService.getAllEmployees();
        return allemployees;

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee=employeeService.getEmployee(id);

        if(employee==null){
            throw new NoSuchEmployeeExeption("There is no employee with ID: "+id);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
       employeeService.saveEmployee(employee);
       return  employee;
    }
    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
        Employee employee=employeeService.getEmployee(id);
        if(employee==null){
            throw new NoSuchEmployeeExeption("There is no employee with ID="+id);
        }
        employeeService.deleteEmployee(id);
        return "Employee with id: "+id+" was deleted";

    }


}

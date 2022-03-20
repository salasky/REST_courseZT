package com.Migranov.spring.rest.dao;

import com.Migranov.spring.rest.entity.Employee;
import com.Migranov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    public void deleteEmploye(int id);
}

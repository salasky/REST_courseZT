package com.Migranov.spring.rest.dao;

import com.Migranov.spring.rest.entity.Employee;
import com.Migranov.spring.rest.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session=sessionFactory.getCurrentSession();
       /* List<Employee> allEmployee=session.createQuery("from Employee ",Employee.class).getResultList();*/
        Query<Employee> query=session.createQuery("from Employee ",Employee.class);
        List<Employee> allEmploye=query.getResultList();
        return allEmploye;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        Employee employee=session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmploye(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Employee> query=session.createQuery("delete from Employee "+
                "where id=:emloyeeId");
        query.setParameter("emloyeeId",id);
        query.executeUpdate();

    }
}

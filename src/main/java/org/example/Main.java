package org.example;

import org.example.entities.Employee;
import org.example.utils.EmployeeEntityManagerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EmployeeEntityManagerFactory.getEntityManager();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();

        System.out.println("All employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
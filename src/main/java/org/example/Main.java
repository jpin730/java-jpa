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
        System.out.println();

        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Michael");
        newEmployee.setLastName("Scott");
        newEmployee.setEmail("some@email.com");
        newEmployee.setSalary(2000.0f);

        entityManager.getTransaction().begin();
        entityManager.persist(newEmployee);
        entityManager.getTransaction().commit();

        System.out.println("New employee created:");
        System.out.println(newEmployee);
        System.out.println();

        int employeeId = newEmployee.getId();
        Employee foundEmployee = entityManager.find(Employee.class, employeeId);
        System.out.println("Employee with id " + employeeId);
        System.out.println(foundEmployee);
        System.out.println();

        foundEmployee.setSalary(3000.0f);
        entityManager.getTransaction().begin();
        entityManager.merge(foundEmployee);
        entityManager.getTransaction().commit();
        System.out.println("Salary updated:");
        System.out.println(foundEmployee);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.eclipselink;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.badr.eclipselink.model.Departement;
import org.badr.eclipselink.model.Employee;
import org.junit.Ignore;

/**
 *
 * @author oussama
 */
public class testEclipseLinkApp {

    private EntityManagerFactory entityManagerFactory;

    private String persistenceUnitName = "default";

    public testEclipseLinkApp() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    @After
    public void tearDown() {
        entityManagerFactory.close();
    }

    @Test @Ignore
    public void testShouldCreateDB(){
    }

    @Test
    public void testShouldReturnCustomResult(){
        EntityManager  entityManager = entityManagerFactory.createEntityManager();

        Employee employee1, employee2;

        employee1 = new Employee("Oussma", "BADR");
        employee2 = new Employee("Aniss", "NAIM");

        Departement departement = new Departement();
        departement.setLocation("Morocco");

        departement.setEmployees(Arrays.asList(new Employee[]{employee1, employee2}));

        entityManager.getTransaction().begin();
        entityManager.persist(departement);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
//        List list = entityManager.
//                            createNativeQuery("SELECT d.Location as departementLocation "
//                                            + "FROM Departement d", "DepEmpMapping").getResultList();
        List list = entityManager.
                            createNativeQuery("SELECT d.Location as departementLocation, " +
                                                    " e.firstName || ' ' || e.lastName as employeesFullName "
                                            + "FROM Departement d JOIN Employee e "
                                            + "ON d.id = e.departement_ID", "DepEmpMapping").getResultList();

        entityManager.getTransaction().commit();

        System.out.println(list.toString());
    }


}

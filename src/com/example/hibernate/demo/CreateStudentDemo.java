package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        try (factory) {
            Session session = factory.getCurrentSession();

            Student student = new Student("Paul", "Wall", "paulwall@gmail.com");
            Student student2 = new Student("Alex", "Johnson", "alexjohnson@gmail.com");
            Student student3 = new Student("Loren", "Ipsum", "loreipsum@gmail.com");

            session.beginTransaction();

            session.save(student);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Finally done!!");

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student st = session.get(Student.class, student.getId());
            System.out.println(st);

            session.getTransaction().commit();

            System.out.println("Reading done");

        }

    }


}

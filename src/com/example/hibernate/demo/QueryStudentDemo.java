package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        try (factory) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student").list();

            for(Student tempStudent: theStudents){
                System.out.println(tempStudent);
            }

            theStudents = session.createQuery("from Student as s where s.firstName = 'Paul' ").list();

            for(Student student:theStudents){
                System.out.println(student);
            }
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }

    }


}

package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Student st = session.get(Student.class, 1);
            session.delete(st);
            session.createQuery("delete from Student where id = 2 ").executeUpdate();


            session.getTransaction().commit();


        }

    }


}

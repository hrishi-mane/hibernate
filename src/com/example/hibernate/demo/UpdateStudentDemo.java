package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        try (factory) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            Student st = session.get(Student.class, 1);
            st.email = "paulwall2@gmail.com";
            session.getTransaction().commit();

            session = factory .getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email = 'abc@gmail.com' ").executeUpdate();
            session.getTransaction().commit();


        }

    }


}

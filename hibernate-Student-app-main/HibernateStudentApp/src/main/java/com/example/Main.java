
        package com.example;

        import java.util.Properties;

        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;

        public class Main {

            public static void main(String[] args) {

                Configuration configuration = new Configuration();

                Properties properties = new Properties();

                properties.setProperty(
                        "hibernate.connection.driver_class",
                        "com.mysql.cj.jdbc.Driver");

                properties.setProperty(
                        "hibernate.connection.url",
                        "jdbc:mysql://db01.dbhost.dev:5051/db_4559gfb4z");

                properties.setProperty(
                        "hibernate.connection.username",
                        "user_4559gfb4z");

                properties.setProperty(
                        "hibernate.connection.password",
                        "p4559gfb4z");

                properties.setProperty(
                        "hibernate.hbm2ddl.auto",
                        "update");

                properties.setProperty(
                        "hibernate.show_sql",
                        "true");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Student.class);

                SessionFactory factory =
                        configuration.buildSessionFactory();

                Session session = factory.openSession();

                session.beginTransaction();

                Student student = new Student(
                        101,
                        "Hrithika",
                        "hrithika@gmail.com",
                        "B.Tech IT");

                session.persist(student);

                session.getTransaction().commit();

                System.out.println("Student inserted successfully!");

                session.close();
                factory.close();
            }
        }
package com.mavenP.firstMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started" );
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        

        //create table
        Student st = new Student();
        st.setId(103);
        st.setName("minakshi");
        st.setCity("indore");
        System.out.println(st);
        
        //creating object of address classs
        Address ad= new Address();
        
      ad.setStreet("street1");
        ad.setCity("khargone");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(234.765);
        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/monikapic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        //session open and start
        Session session = factory.openSession();
        
       Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done");
    }
}

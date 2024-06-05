package com.mavenP.firstMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo 
{
       public static void main(String[] args)
       {
    	   //get and load method
    	   Configuration cfg = new Configuration();
    	   cfg.configure("hibernate.cfg.xml");
    	   SessionFactory factory = cfg.buildSessionFactory();
    	   Session session = factory.openSession();
    	   //getMethod
    	   Student student = (Student)session.get(Student.class, 103);
    	   System.out.println(student);
    	   
    	   Student student1 = (Student)session.load(Student.class, 103);
    	   System.out.println(student1);
    	   
    	   Address ad = (Address)session.get(Address.class, 1);
    	   System.out.println(ad.getStreet()+" : "+ad.getCity());
    	   
    	   session.close();
    	   
    	   
    	   factory.close();
    	   
       }
}

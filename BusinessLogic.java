package com.prodapt.week4code;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BusinessLogic {
	Session session=ElectonicDBconnect.setUp();
	public void createRecord() {
		 
		
		ElectronicShop e1=new ElectronicShop(54,"LG TV",50000);
		ElectronicShop e2=new ElectronicShop(55,"Samsung S21 Pro",75000);
		ElectronicShop e3=new ElectronicShop(56,"Sony Refrigerator",100000);
		ElectronicShop e4=new ElectronicShop(57,"Apple Phone",85000);
		ElectronicShop e5=new ElectronicShop(58,"MI Phone",35000);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
}
	public void read() {
        //Read operation
    	//Session session=ElectonicDBconnect.setUp();
    	 
    List libs = session.createQuery("from ElectronicShop").list();
    for (Iterator iterator = libs.iterator(); iterator.hasNext();) {
  	  ElectronicShop lib = (ElectronicShop) iterator.next();
    System.out.println(lib.getId() + " " + lib.getName());
    }//easy approach
    Query query=session.createQuery("from ElectronicShop");//here persistent class name is Customer
    ArrayList<ElectronicShop> list=(ArrayList<ElectronicShop>) query.list();
    for (ElectronicShop elec: list) {
        System.out.println(elec);
    }
    
    }
	  public void update() {
      	//Session session=ElectonicDBconnect.setUp();
      	 
      Transaction tx=session.beginTransaction();
      Query q=session.createQuery("update ElectronicShop set Name=:p1 where id=:p2");
      q.setParameter("p1","Apple IPhone");     //record 10
      q.setParameter("p2",57);

      int status=q.executeUpdate();
      System.out.println(status);
      System.out.println("Recordes are Sucessfully Updated");
      tx.commit();
      
      
      }
	  public void delete() {
      	
      	//Session session=ElectonicDBconnect.setUp();
      Transaction tx2=session.beginTransaction();
      Query q1=session.createQuery("delete ElectronicShop  where id=:p2");
    
      q1.setParameter("p2",58);

      int status1=q1.executeUpdate();
      System.out.println(status1);
      System.out.println("Recorde are Sucessfully deleted");
     tx2.commit();

      
     // t.commit();
      session.close();
      }
	  
	
	
	
}


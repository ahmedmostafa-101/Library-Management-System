/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import static lms.LMS.library;

/**
 *
 * @author Electronica
 */

public abstract class Person {
    protected int  id;
    protected String name;
    protected String Address;
    protected String Phonenum;
    
    public Person () {}

    public Person(int id, String name, String Address, String Phonenum) {
        this.id = id;
        this.name = name;
        this.Address = Address;
        this.Phonenum = Phonenum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public void setPhonenum(String Phonenum) {
        this.Phonenum = Phonenum;
    }

   public  abstract void search (String bookname);
   
    public void printInfo()
    {
        System.out.println("-----------------------------------------");
        System.out.println("\nThe details are: \n");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + Address);
        System.out.println("Phone No: " + Phonenum + "\n");
    }
    
      
        
        
    
}

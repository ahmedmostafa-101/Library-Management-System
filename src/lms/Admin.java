/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.text.ParseException;
import java.util.Scanner;
import static lms.LMS.library;
import static lms.LMS.over_period;

/**
 *
 * @author Electronica
 */
public class Admin extends Person {
    
    
    protected String password;

    public Admin () {}

    public Admin(String password, int id, String name, String Address, String Phonenum) {
        super(id, name, Address, Phonenum);
        this.password = password;
    }

    



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void search(String bookname) {
        boolean search=false;
       String dialog="";
        for(int i=0;i< library.size();i++){
            if(library.get(i).Bname.equals(bookname)){
                search=true;
                
                dialog+="Title : "+library.get(i).Bname+"\n"+"ID : "+library.get(i).Bid+"\n"+"Aouther: "+library.get(i).Bauthor+"\n"+"Version: "+library.get(i).Bversion+"\n"+
                       "Price: "+library.get(i).Bprice+"\n" +"Stock : "+library.get(i).Stock+"\n";
                break;
            }
        }
            if(search)
                System.out.println(dialog);
            else
                System.out.println("Publication not exist");
        
    }
    public void delet (String bookname){
        boolean delet=true;
        for(int i=0;i< library.size();i++){
            if(library.get(i).Bname.equals(bookname)){
                
                library.remove(i);
                delet=false;
                break;
            }       
    }
        if(delet)
            System.out.println("This publication not exist...");
        else
            System.out.println("This publication deleted...");
}
    public void modify (String bookname,String pname, String pauthor, String pversion, int pStock, int pid, double pprice){
        boolean availabilty=false;
       
        for(int i=0;i< library.size();i++){
            if(library.get(i).Bname.equals(bookname)){
                availabilty=true;
                
                library.get(i).setBname(pname);
                library.get(i).setBauthor(pauthor);
                library.get(i).setBversion(pversion);
                library.get(i).setBid(pid);
                library.get(i).setStock(pStock);
                break;
        
    }
            else{
                System.out.println("This Publication not exist");
                break;}
            
} 

    }
    public void add (String pname, String pauthor, String pversion, int pStock, int pid, double pprice, int typenum) {
        
        switch (typenum) {
            case 1:
                library.add(new BOOKS (pname, pauthor, pversion, pStock, pid, pprice));
                showlist();
                break;
                
            case 2:
                library.add(new BOOKLET (pname, pauthor, pversion, pStock, pid, pprice));
                showlist();
                break;
               
            case 3:
                library.add(new MAGAZINE (pname, pauthor, pversion, pStock, pid, pprice));
                
                showlist();
                break;
        }
        
    }
  

   

   
    
    
     public static void fine_pay (int catnum,int i,float days) {
         
         
         switch (catnum) {
             case 1://book
         try{
             if(days>20)
                 
                 throw new Exception();
         }
         catch (Exception e){
             System.out.println("Maximum borrow-period is 20 days, you must pay fine....");
             
             System.out.println("The fine is : "+Math.ceil(library.get(i).Bprice*.1)+" pounds");
         }
         break;
             case 2://booklet
                 try{
             if(days>20)
                 throw new Exception();
         }
         catch (Exception e){
             System.out.println("Maximum borrow-period is 20 days, you must pay fine....");
             
             System.out.println("The fine is : "+Math.ceil(library.get(i).Bprice*.25)+" pounds");
         }
          break;       
             case 3 ://magazine
                 try{
             if(days>12)
                 throw new Exception();
         }
         catch (Exception e){
             System.out.println("Maximum borrow-period is 12 days, you must pay fine....");
             
             System.out.println("The fine is : "+Math.ceil(library.get(i).Bprice*.2)+" pounds");
         }
         break;
             default:
                 System.out.println("you must choose a category....");
                 break;
     }        
}

    
    @Override
    public void printInfo() {
        super.printInfo();
    }

    public void showlist() {
        for(int i=0;i<library.size();i++){
            
            System.out.println((i+1)+"-"+"ID: "+library.get(i).Bid+"   "+"Title: " +library.get(i).Bname+"\n"+"Author: "+library.get(i).Bauthor+"   "+
                    "Version: "+library.get(i).Bversion+"\n"+"Price: "+library.get(i).Bprice+" pounds"+"   "+"Stock: "+library.get(i).Stock+"\n");
        }
    }
    
    

    
}


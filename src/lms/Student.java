/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static lms.LMS.library;
import java.util.Date;
import java.util.Scanner;
import static lms.LMS.borrowed;

        
/**
 *
 * @author Electronica
 */
public class Student extends Person {

     protected String stage;
   

   public Student() {}

    public Student(String stage, int id, String name, String Address, String Phonenum) {
        super(id, name, Address, Phonenum);
        this.stage = stage;
    }

    

    @Override
     public void search(String bookname) {
        boolean search=false;
       String dialog="";
        for(int i=0;i< library.size();i++){
            if(library.get(i).Bname.equals(bookname)){
                search=true;
                
                dialog+="Title : "+library.get(i).Bname+"\n"+"Aouther: "+library.get(i).Bauthor+"\n"+"Version: "+library.get(i).Bversion+"\n"+
                       "Price: "+library.get(i).Bprice+"\n";
                break;
            }
        }
            if(search)
                System.out.println(dialog);
            else
                System.out.println("Publication not exist");
        
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Stage: "+ stage);
    }
    
    public static float period (String dateBeforeString, String dateAfterString ) throws ParseException {
      
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
         
	       Date dateBefore = myFormat.parse(dateBeforeString);
	       Date dateAfter = myFormat.parse(dateAfterString);
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       float daysBetween = (difference / (1000*60*60*24));
              
	       return (daysBetween);
	
    }
    public static void borrow (String bookname){
        
        boolean avail=false;
        for(int i=0;i<library.size();i++){
            if(library.get(i).Bname.equals(bookname) && library.get(i).Stock>1){
                avail=true;
                
                --library.get(i).Stock;
                borrowed.add(i, bookname);
                System.out.println(bookname+" borrowed successfully");
                break;
            
            }
            
            else{
                System.out.println("Publication not Available");
                break;}
        }
        
    }
    
    public void return_book (String bookname){
        boolean avail=false;
        for(int i=0;i<library.size();i++){
            if(library.get(i).Bname.equals(bookname)){
                avail=true;
                
                ++library.get(i).Stock;
                System.out.println(bookname+" returned successfully");
                break;}
                
            else{
                System.out.println("Publication not exist");
                break;}
            
    }

     
}

    
    public void showlist() {
        for(int i=0;i<library.size();i++){
            
            System.out.println((i+1)+"-"+"ID: "+library.get(i).Bid+"   "+"Title: " +library.get(i).Bname+"\n"+"Author: "+library.get(i).Bauthor+"   "+
                    "Version: "+library.get(i).Bversion+"\n"+"Price: "+library.get(i).Bprice+" pounds"+"\n");
        }
    }

    

    
}

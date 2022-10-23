
package lms;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static lms.LMS.library;


public class LMS {

   public static ArrayList<Publication> library = new ArrayList<Publication>();
   public static ArrayList<String> borrowed = new ArrayList<String>();
   public static ArrayList<Student> students =new ArrayList<Student> ();
   public static ArrayList<Admin> admins =new ArrayList<Admin> ();
   public static ArrayList<String> over_period =new ArrayList<String> ();

   public static Admin admin =new Admin();
   public static Student student =new Student();
   public static String issuedate,redate;
   
      public static void main(String[] args) throws ParseException  {
      
        Scanner sc=new Scanner(System.in);
        String bookname;
        boolean system=true;
        boolean adminloop=true;
        boolean studentloop=true;
        int choise;
        int person_num,admin_num,student_num; 
        
        library.add(0,new BOOKS("java", "author", "1st", 50, 101, 12));
        library.add(1,new BOOKS("c++", "author", "2nd", 53, 151, 19));
        library.add(2,new BOOKLET("python", "author", "1st", 100, 4040, 80));
        library.add(3,new MAGAZINE("Magazine", "author", "1st", 30, 10001, 41.5));
        admins.add(0,new Admin("1234", 1000001, "Admin", "Assiut", "01142202567"));
       
        //---------------------------------------------------------------------------------//
        
        boolean person;
        LMS.Person_menu();
        
        while (system==true){
            do{
         person=false;
        
        try{
            person_num=sc.nextInt();
            person=true;
        }
        catch (InputMismatchException e){
            person=false;
            System.out.println("invalid input");
            person_num=sc.nextInt();
        }
        
        }while(!person);
        switch (person_num){
            
            case 1:{
                 boolean admiin=false;
                String pass="";
                System.out.println("Enter your password : ");
                
              do{  pass=sc.next();
                
                for(int i=0;i<admins.size();i++){
                    if(admins.get(i).password.equals(pass)){
                    LMS.Admin_menu();
                    admiin=true;
                    }
                else
                        System.out.println("you must enter valid password");}
                
                  }
              while(!admiin);
               
        do{       
        try{
              admin_num=sc.nextInt();
              admiin=true;
        }
        catch (InputMismatchException e){
            admiin=false;
            System.out.println("invalid input");
            admin_num=sc.nextInt();
        }
        }while(!admiin);
        boolean f2=true;
         while(f2){ switch (admin_num){
               case 1://search
                System.out.println("Enter the publication title :");
                bookname=sc.next();
                admin.search(bookname);
                
                System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                
					
                                                
                break;
            case 2://add
                System.out.println("Choose a Category :");
                System.out.println("1-Book\n"+"2-Booklet\n"+"3-Magazine\n");
                int typenum=sc.nextInt();
                String title,aother,version;
                int id,stock;
                double price;
                System.out.println("Enter Publication ID: ");
                id=sc.nextInt();
                System.out.println("Enter Publication Title: ");
                title=sc.next();
                System.out.println("Enter Publication Aouther: ");
                aother=sc.next();
                System.out.println("Enter Publication Version: ");
                version=sc.next();
                System.out.println("Enter Publication Price: ");
                price=sc.nextDouble();
                System.out.println("Enter Publication Stock: ");
                stock=sc.nextInt();
                admin.add(title, aother, version, stock, id,price , typenum);
                System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
             
            case 3://delete
                System.out.println("Enter the publication title :");
                bookname=sc.next();
                admin.delet(bookname);
                admin.showlist();
                System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
                
            case 4://modify
                String mtitle,maother,mversion;
                int mid,mstock;
                double mprice;
                System.out.println("Enter publication-title you want to modify : ");
                bookname=sc.next();
                admin.search(bookname);
                System.out.println("Please enter the new detailes :");
                System.out.println("Enter Publication Title: ");
                mtitle=sc.next();
                System.out.println("Enter Publication ID: ");
                mid=sc.nextInt();
                System.out.println("Enter Publication Aouther: ");
                maother=sc.next();
                System.out.println("Enter Publication Version: ");
                mversion=sc.next();
                System.out.println("Enter Publication Price: ");
                mprice=sc.nextDouble();
                System.out.println("Enter Publication Stock: ");
                mstock=sc.nextInt();
               admin.modify(bookname, mtitle, maother, mversion, mstock, mid, mprice);
               admin.showlist();
               System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
               break;
               
            case 5://list
                admin.showlist();
               System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
                
            case 6://list of borrowed
                System.out.println("List of Borrowed-Publications :");
                for(int i=0;i<borrowed.size()&&i<students.size();i++)
                    System.out.println((i+1)+"-"+"Title: "+borrowed.get(i)+"\tStudent Name: "+students.get(i).name);
                System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break; 
                
            case 7://list of over period 
                System.out.println("List of Over-Period borrowed publications :");
                for(int i=0;i<over_period.size();i++)
                    System.out.println("Title :"+over_period.get(i));
               System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
            
                
//            case 8:
//                
//                LMS.Person_menu();
//                 person=false;
//        do{
//        try{
//            person_num=sc.nextInt();
//            person=true;
//        }
//        catch (InputMismatchException e){
//            person=false;
//            System.out.println("invalid input");
//            person_num=sc.nextInt();
//        }
//        }while(!person);
//        break;
                case 8:
                f2=true;
               
                break;
            case 9:
                System.out.println("System Closed....");
                system=false;
                System.exit(0);
                break;
                
            default:
                System.out.println("You must enter a number (1 : 9)");
                break;
        }  
                break;}}
            case 2:{
                LMS.Student_menu();
                boolean stu=false;
           do{       
        try{
              student_num=sc.nextInt();
              stu=true;
        }
        catch (InputMismatchException e){
            stu=false;
            System.out.println("invalid input");
            student_num=sc.nextInt();
        }
        }while(!stu);
       
        switch (student_num){
            case 1://search
                System.out.println("Enter the publication title :");
                bookname=sc.next();
                student.search(bookname);
              System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
                
            case 2://listing
                student.showlist();
              System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
                
            case 3://borrow
                int sid;
                String sname,saddress,sphone,sstage;
                System.out.println("Please enter your personal info: ");
                System.out.println("ID: ");  sid=sc.nextInt();
                System.out.println("Nmae: ");  sname=sc.next();
                System.out.println("Stage: ");  sstage=sc.next();
                System.out.println("Address: ");  saddress=sc.nextLine();
                System.out.println("Phone Number: ");  sphone=sc.next();
                students.add(new Student(sstage, sid, sname, saddress, sphone));
                System.out.println("Enter the title of publication you want to borrow :");
                bookname=sc.next();
                Student.borrow(bookname);
                System.out.println("Enter the Issue-Date (dd-MM-yyyy) : ");
                issuedate=sc.next();
              System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
                
            case 4://return
                System.out.println("Choose a Category: \n"+"1-Book\n"+"2-Booklet\n"+"3-Magazine\n");
                int catnum=sc.nextInt();
                System.out.println("Enter the title of publication you want to return :");
                bookname=sc.next();
                student.return_book(bookname);
                int indx=library.indexOf(bookname)+1;
                System.out.println("Enter Return-Date (dd-MM-yyyy) : ");
                redate=sc.next();
                float days=Student.period(issuedate,redate);
                System.out.println("You borrowed this publication for "+days+" days");
                if(days>20 || days>12)
                    over_period.add(bookname);
                Admin.fine_pay(catnum, indx, days);
               System.out.println("1-Exit || 2-Menu ");
                choise=sc.nextInt();
                
			while (choise != 1 && choise != 2) 
			    {
					System.out.println("You must enter number |(1) to exit or (2) for show menu|");
					choise=sc.nextInt();
				}
				if (choise == 1) {
					System.out.println("Thank you for using our service...");
					system=false;
                                        System.exit(0);
                                        
				}
				else if (choise == 2){
                                    System.out.println("Continue as | 1-Admin | 2-Student or || 3-Close Program");
                                    system=true;
                                }
                break;
                
//            case 5:
//                
//                 LMS.Person_menu();
//                 person=false;
//        do{
//        try{
//            person_num=sc.nextInt();
//            person=true;
//        }
//        catch (InputMismatchException e){
//            person=false;
//            System.out.println("invalid input");
//            person_num=sc.nextInt();
//        }
//        }while(!person);
//        break;
                
            case 5:
                System.out.println("Thank you....");
                system=false;
                System.exit(0);
                break;
                        
            default:
                System.out.println("You must enter a number (1 : 6)");
                break;
        }
        break;}
           case 3:{
                System.out.println("System Closed");
                system=false;
                System.exit(0);
                break;}
        
        default:{
            System.out.println("You must enter a number (1 : 3)");
           }
    }
    }            
            
        }
    
    
    public static void Person_menu () 
    {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t         Library Management System");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1-Admin (**you must enter your password before every operation**)");
        System.out.println("2-Student");
        System.out.println("3-Exit\n");
        
    }
    public static void Admin_menu ()
    {
         System.out.println("---------------------------------------------------");
        System.out.println("\t    Library Management System");
        System.out.println("---------------------------------------------------");
        System.out.println("\t       Admin's Functions");
        System.out.println("---------------------------------------------------");
        System.out.println("1-Search\n"+"2-Add Publication\n"+"3-Delete Publication\n"+"4-Modify Publication\n"+"5-Show List of Publications\n"+
                           "6-Display list of borrowed Publications\n"+"7-Display list of over period Publications\n"+"8-Exit\n");
    }
    
    public static void Student_menu ()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("\t    Library Management System");
        System.out.println("---------------------------------------------------");
        System.out.println("\t       Student's Functions");
        System.out.println("---------------------------------------------------");
        System.out.println("1-Search\n"+"2-Show List of Publications\n"+"3-Borrow\n"+"4-Return a Publication\n"+"5-Exit\n");
                         
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

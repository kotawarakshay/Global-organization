package com.capgemini.contactbook.ui;

import java.util.Scanner;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;

import com.igate.contactbook.bean.EnquiryBean;

public class Client 
{
	static ContactBookService contactBook=null;
	static ContactBookServiceImpl contactBookImpl=null;
	static Scanner sc=new Scanner(System.in);
	static EnquiryBean enqry=null;
	public static void main(String[] args) 
	{
		EnquiryBean enqry=null;
		int enqryId=0;
		
		int option=0;
		while(true)
		{

			System.out.println("*************Global Recruitments***************");
			System.out.println("Choose an operation");
			System.out.println("1.Enter Enquiry Details:");
			System.out.println("2.View Enquiry Details on Id");
			System.out.println("0.Exit");
			System.out.println("*************************************************");
			
		
		try 
		{
			option=sc.nextInt();
			switch(option)
			{
			case 1:
				while(enqry==null)
				{
					enqry=populateEnquiryBean();
				}
				try
				{
				    contactBook=new ContactBookServiceImpl();
				    enqry=new EnquiryBean();
				    int enqyId=contactBook.addEnquiry(enqry);
					System.out.println("Entered Details has been successfully registered");
					System.out.println("Enquiry ID is:"+enqryId);
				}
				
		
		        catch(Exception e)
		        {
			    System.out.println(e);	
		        }
	            finally 
	            {
		        enqryId=0;
		        contactBook=null;
		        enqry=null;
	            }
	             break;
			
			case 2:
				
				
					
			default:
				
			}
			}
			catch(Exception f)
			{
			System.out.println(f);
			}
		}
		
	}	
		
	

	private static EnquiryBean populateEnquiryBean() 
	{
		EnquiryBean enqry=new EnquiryBean();
		System.out.println("Enter First Name");
		enqry.setfName(sc.next());
	    System.out.println("Enter the Last Name");
	    enqry.setlName(sc.next());
	    System.out.println("Enter Contact Number");
	    enqry.setContactNo(sc.next());
	    System.out.println("Enter preferred Domain");
	    enqry.setpDomain(sc.next());
	    System.out.println("Enter preferred Location");
	    enqry.setpLocation(sc.next());
	    
	
	
	contactBookImpl=new ContactBookServiceImpl();
	try
	 {
		 contactBookImpl.validateCustomer(enqry);
		 return enqry;
	 }
	catch(Exception messege)
	{
		System.out.println("Invalid data:");
		System.out.println(messege);
		System.exit(0);
		}
	return null;
}
}
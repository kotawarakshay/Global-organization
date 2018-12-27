package com.capgemini.contactbook.service;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exception.ContactBookException;

import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookServiceImpl  implements ContactBookService
{

	ContactBookDao contactDao=new ContactBookDaoImpl();
	static EnquiryBean enqry=new EnquiryBean();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException 
	{
		int enqryId=0;
		enqryId=ContactBookDao.addCustomer(enqry);
		return enqryId;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException {
		// TODO Auto-generated method stub
		return false;
	}

	public void validateCustomer(EnquiryBean enqry) throws ContactBookException 
	{
		List<String> validationErrors =new ArrayList<String>();
		if(!(isValidfName(enqry.getfName())))
		{
			validationErrors.add("\n customer name should be in alphatical and min 3 char long!");
		}
		if(!(isValidlName(enqry.getlName())))
		{
			validationErrors.add("\n customer name should be in alphatical and min 3 char long!");
		}
		if(!(isValidPhoneNumber(enqry.getContactNo())))
		{
			validationErrors.add("\n phone number should be in 10 digit \n");
		}
		if(!(isValidPDomain(enqry.getpDomain())))
		{
			validationErrors.add("\nPlease enter valid Domain \n");
		}
		if(!validationErrors.isEmpty())
		{
			throw new ContactBookException(validationErrors+ "");
		}
		
	}

	   private boolean isValidPDomain(String pDomain)
	   {
		   Pattern domainPattern=Pattern.compile("^[A-Za-z]{3,}$");
			Matcher domainmatcher=domainPattern.matcher(pDomain);
			return domainmatcher.matches();
	}

	private boolean isValidPhoneNumber(String contactNo) 
	   {
		Pattern phonePattern=Pattern.compile("^[6-9][0-9]{9}$");
		Matcher phonematcher=phonePattern.matcher(contactNo);
		return phonematcher.matches();
		
	 }

	private boolean isValidlName(String lName) 
	{
		   Pattern lnamePattern=Pattern.compile("^[A-Za-z]{3,}$");
			Matcher lnamematcher=lnamePattern.matcher(lName);
			return lnamematcher.matches();
	}

	private boolean isValidfName(String fName) 
	   { 
		Pattern fnamePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher fnamematcher=fnamePattern.matcher(fName);
		return fnamematcher.matches();
	   }

	public boolean validateEnquiryId(CharSequence enquiryId)
	{
		Pattern idPattern=Pattern.compile("[1-9][0-9]{2}");
		Matcher idmatcher=idPattern.matcher(enquiryId);
		if(idmatcher.matches())
			return true;
		else
			return false;
	}
	}



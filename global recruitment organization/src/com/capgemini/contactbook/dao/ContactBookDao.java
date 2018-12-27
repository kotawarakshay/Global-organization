package com.capgemini.contactbook.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.contactbook.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookDao
{
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, ClassNotFoundException, IOException, SQLException;
	public EnquiryBean getEnquiryDetails(int EnquiryID)throws ContactBookException;
	public static int addCustomer(EnquiryBean enqry) {
		// TODO Auto-generated method stub
		return 0;
	}
}

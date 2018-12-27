package com.capgemini.contactbook.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.util.DBConnection;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoImpl implements ContactBookDao
{

	static Logger logger=Logger.getLogger(ContactBookDaoImpl.class);
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, ClassNotFoundException, IOException, SQLException 
	{

		logger.info("In Add Enquiry");
		Connection connection = DBConnection.getConnection();
		Statement st=null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int enqryId=0;
		try 
		{
			preparedStatement=connection.prepareStatement(QueryMapper.ADD_DETAILS);
			preparedStatement.setInt(1,enqryId);
			rs = preparedStatement.executeQuery();
			
			preparedStatement.setString(1, enqry.getfName());
			preparedStatement.setString(2, enqry.getlName());
			preparedStatement.setString(3, enqry.getContactNo());
			preparedStatement.setString(4, enqry.getpDomain());
			preparedStatement.setString(5,enqry.getpLocation());
			preparedStatement.executeUpdate();
			
			 rs=st.executeQuery(QueryMapper.ALL_DETAILS);
			    while(rs.next())
			    {
			    	enqryId=rs.getInt(1);
		
			    }
		}
		catch(Exception messege)
		{
			System.out.println(messege);
		}
		return 0;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException {
		// TODO Auto-generated method stub
		return null;
	}

}

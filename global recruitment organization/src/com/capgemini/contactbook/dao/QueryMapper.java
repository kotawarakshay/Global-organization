package com.capgemini.contactbook.dao;

public interface QueryMapper 
{
	public static final String ADD_DETAILS="INSERT INTO  enquiry values(enqry_Id_Sequence.nextVal,?,?,?,?)";
	public static final String ALL_DETAILS="Select * from enquiry";
}

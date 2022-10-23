package com.test.helpers;

import org.testng.annotations.BeforeMethod;

import com.test.utils.Utils;

public class ServiceHelpers {
	@BeforeMethod
	public static String  baseuri() {
		String uri=("https://dummy.restapiexample.com/api/v1/employees");
		System.out.println("base uri entered");
		return uri;
	
	}
	
/*	public static String  baseurii() {
		Utils ut=new Utils();
		String baseuri=ut.getconfigproperty("baseurl");
		System.out.println("uri enetered : "+baseuri );
		return baseuri;	
	}*/

}

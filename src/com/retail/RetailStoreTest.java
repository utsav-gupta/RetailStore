package com.retail;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import objects.Bill;
import objects.User;
import objects.Bill.BillCategory;
import objects.User.UserType;

public class RetailStoreTest {
	
	static RetailStore store ;
	
	@BeforeClass
	public static void setup(){
		store = new RetailStore();
	}
	

	//1. If	the	user is	an	employee of	the	store,	
	//he	gets	a	30%	discount
	
	@Test
	public void testUserAsEmployee() {
		
		User user = new User();
		user.setUserType(UserType.EMPLOYEE);
		user.setTimeInYrs(1);
		
		Bill bill = new Bill();
		bill.setAmt(1023.4);
		bill.setUser(user);
		
		double netPayable = store.calculateAmt(bill);
		double expectedValue=1023.4 - 1023.4*0.3f-35;
		
		assertEquals(expectedValue, netPayable, 0.00001);
		
	}
	
	
	
	//2. If	the	user	is	an	affiliate	of	the	store,	
	//he	gets	a	10%	discount
	
	@Test
	public void testUserAsAffiliate() {
		
		User user = new User();
		user.setUserType(UserType.AFFILIATE);
		user.setTimeInYrs(1);
		
		Bill bill = new Bill();
		bill.setAmt(1023.4);
		bill.setUser(user);
		
		double netPayable = store.calculateAmt(bill);
		double expectedValue=1023.4 - 1023.4*0.1f - 45;
		
		assertEquals(expectedValue, netPayable, 0.00001);
	}
	
	
	
	//3. If	the	user	has	been	a	customer	for	over	2	years,	
	//he	gets	a	5%	discount.

	@Test
	public void testUserAsOldCustomer() {

		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setTimeInYrs(3);
		
		Bill bill = new Bill();
		bill.setAmt(1023.4);
		bill.setUser(user);
		
		double netPayable = store.calculateAmt(bill);
		double expectedValue=1023.4 - 1023.4*0.05f - 45;
		
		assertEquals(expectedValue, netPayable, 0.00001);
	}
	
	//4. For	every	$100	on	the	bill,	
	//there	would	be	a	$	5	discount	
	
	@Test
	public void testNetDiscount() {
		
		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setTimeInYrs(1);
		
		Bill bill = new Bill();
		bill.setAmt(1023.4);
		bill.setUser(user);
		
		double netPayable = store.calculateAmt(bill);
		double expectedValue=1023.4 - 50;
		
		assertEquals(expectedValue, netPayable, 0.00001);
	}
	
	//5. The	percentage	based	discounts	do	not	apply	
	//on	groceries

	@Test
	public void testDiscountOnGroceries() {
		
		User user = new User();
		user.setUserType(UserType.CUSTOMER);
		user.setTimeInYrs(1);
		
		Bill bill = new Bill();
		bill.setAmt(1023.4);
		bill.setUser(user);
		bill.setCategory(BillCategory.GROCERIES);
		
		double netPayable = store.calculateAmt(bill);
		double expectedValue=1023.4 - 50;
		
		assertEquals(expectedValue, netPayable, 0.00001);
	}

	//6. A	user	can	get	only	one	of	the	percentage	
	//based	discounts	on	a	bill.
	
	@Test
	public void testNoMultipleDiscounts() {
		
		User user = new User();
		user.setUserType(UserType.AFFILIATE);
		user.setTimeInYrs(3);
		
		Bill bill = new Bill();
		bill.setAmt(1023.4);
		bill.setUser(user);
		
		double netPayable = store.calculateAmt(bill);
		double expectedValue=1023.4 - 1023.4*0.1f-45;
		
		assertEquals(expectedValue, netPayable, 0.00001);
		
	}

	@AfterClass
	public static void stripDown() {
		store=null;
	}

}

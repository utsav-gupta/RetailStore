package com.retail;

import java.util.Locale.Category;

import objects.Bill;
import objects.Bill.BillCategory;
import objects.User.UserType;

public class RetailStore {

	public double calculateAmt(Bill bill) {
		
		float discountFactor =0.0f;
		double discountedAmt = 0.0;
		
		if(bill.getCategory()!=BillCategory.GROCERIES) {

			// Designed to give max percentage discount possible.

			if(bill.getUser().getTimeInYrs()>=2) {
				discountFactor=0.05f;
			}
			if(bill.getUser().getUserType() == UserType.AFFILIATE) {
				discountFactor=0.1f;
			}
			if(bill.getUser().getUserType() == UserType.EMPLOYEE) {
				discountFactor=0.3f;
			}
			if(bill.getUser().getUserType() == (UserType.AFFILIATE)) {
				discountFactor=0.1f;
			}

		}
		
	    discountedAmt = bill.getAmt()-bill.getAmt()*discountFactor;
		int additionalDiscount = (int)discountedAmt/100*5;
		double netPayable=discountedAmt-additionalDiscount;

		return netPayable;
	}
	
}

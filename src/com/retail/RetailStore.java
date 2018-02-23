package com.retail;

import objects.Bill;
import objects.Bill.BillCategory;


public class RetailStore {

	public double calculateAmt(Bill bill) {
		
		float discountFactor =0.0f;
		double discountedAmt = 0.0;
		
		if(bill.getCategory()!=BillCategory.GROCERIES) {

			// If user is neither Employee nor Affiliate but is more than 2 years old

			if(bill.getUser().getDiscountFactor() == 0 && bill.getUser().getTimeInYrs()>=2) {
				discountFactor=0.05f;
			}
			else {
				discountFactor = bill.getUser().getDiscountFactor();
			}

		}
		
	    discountedAmt = bill.getAmt()-bill.getAmt()*discountFactor;
		int additionalDiscount = (int)discountedAmt/100*5;
		double netPayable=discountedAmt-additionalDiscount;

		return netPayable;
	}
	
}

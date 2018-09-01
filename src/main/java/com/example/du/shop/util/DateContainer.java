package com.example.du.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateContainer {

	Date date;

	public DateContainer(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdFormat.format(date);
		
	}
	
}

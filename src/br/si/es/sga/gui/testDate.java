package br.si.es.sga.gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDate {

	public static void main(String[] args) {
		DateFormat dateFormt = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println( dateFormt.format(new Date()));

	}

}

package br.com.sambatech.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Teste {

	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		SimpleDateFormat simpleDateFormat = 
		       new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		simpleDateFormat.setTimeZone(timeZone);

		System.out.println("Time zone: " + timeZone.getID());
		System.out.println("default time zone: " + TimeZone.getDefault().getID());
		System.out.println();

		System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
		System.out.println("Default: " + calendar.getTime());
		
		calendar = Calendar.getInstance();
		long timeInMil = calendar.getTimeInMillis();
		long time = calendar.getTimeZone().getOffset(System.currentTimeMillis());
		System.out.println("Time: " + time);
		System.out.println("TimeInMili: " + timeInMil);
	}
}

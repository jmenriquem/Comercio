/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author alumno
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat spanishDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public static String dateToString(Date date) {
		try {
			return dateFormat.format(date);
		} catch (NullPointerException ex) {
			return null;
		}
	}

	public static String spanishDateToString(Date date) {
		try {
			return spanishDateFormat.format(date);
		} catch (NullPointerException ex) {
			return null;
		}
	}

	public static String timeToString(Date date) {
		try {
			return timeFormat.format(date);
		} catch (NullPointerException ex) {
			return null;
		}
	}

	public static Date parseDate(String string) {
		try {
			return dateFormat.parse(string);
		} catch (java.text.ParseException ex) {
			return null;
		}
	}

	public static Date parseSpanishDate(String string) {
		try {
			return spanishDateFormat.parse(string);
		} catch (java.text.ParseException ex) {
			return null;
		}
	}

	public static Date parseTime(String string) {
		try {
			return timeFormat.parse(string);
		} catch (java.text.ParseException ex) {
			return null;
		}
	}

	public static long getDifferenceMinutesBetweenDates(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long differenceTime = endTime - startTime;
		long differenceMinutes = differenceTime / (1000 * 60);
		return differenceMinutes;
	}

	public static long getDifferenceDaysBetweenDates(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long differenceTime = endTime - startTime;
		long differenceDays = differenceTime / (1000 * 60 * 60 * 24);
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.setTime(startDate);
		end.setTime(endDate);

		/*
		 * int startDateYear = start.get(Calendar.YEAR); int startDateMonth =
		 * start.get(Calendar.MONTH); int startDateDay =
		 * start.get(Calendar.DAY_OF_MONTH); int endDateYear =
		 * end.get(Calendar.YEAR); int endDateMonth = end.get(Calendar.MONTH);
		 * int endDateDay = end.get(Calendar.DAY_OF_MONTH);
		 * 
		 * start.set(startDateYear, startDateMonth, startDateDay);
		 * end.set(endDateYear, endDateMonth, endDateDay);
		 */

		start.add(Calendar.DAY_OF_MONTH, (int) differenceDays);
		while (start.before(end)) {
			start.add(Calendar.DAY_OF_MONTH, 1);
			differenceDays++;
		}
		while (start.after(end)) {
			start.add(Calendar.DAY_OF_MONTH, -1);
			differenceDays--;
		}

		/*
		 * DateFormat dateFormat = DateFormat.getDateInstance();
		 * System.out.println("The difference between " +
		 * dateFormat.format(startDate) + " and " + dateFormat.format(endDate) +
		 * " is " + differenceDays + " days.");
		 */

		return differenceDays;
	}

	public static Date addMonthsToDate(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	public static Date getMinimumDateBetweenMonths(Date date, int differenceMonths) {
		String[] dateString = DateUtil.dateToString(date).split("-");
		int year = Integer.parseInt(dateString[0]);
		int month = Integer.parseInt(dateString[1]);
		int day = Integer.parseInt(dateString[2]);

		month += differenceMonths;

		if (month > 24) {
			month -= 24;
			year = year + 2;
		} else if (month > 12 && month <= 24) {
			month -= 12;
			year++;
		}

		String yearString = String.valueOf(year);
		String monthString = String.valueOf(month);
		String dayString = String.valueOf(day);

		if (monthString.length() == 1)
			monthString = new String("0" + monthString);
		if (dayString.length() == 1)
			dayString = new String("0" + dayString);

		return parseDate(yearString + "-" + monthString + "-" + dayString);
	}

	public static Date getLastYearDate() {
		// Obtenemos el año actual como java.util.GregorianCalendar
		GregorianCalendar calendar = new GregorianCalendar();
		/*
		 * System.out.println("Dia actual:" +
		 * calendar.get(Calendar.DAY_OF_MONTH) + "/" +
		 * (calendar.get(Calendar.MONTH) + 1) + "/" +
		 * calendar.get(Calendar.YEAR));
		 */
		// Obtenemos el año actual
		int currentYear = calendar.get(Calendar.YEAR);
		int daysToSubstract = -365;
		// Si este año es bisiesto y ya superamos el 29 de febrero, tenemos que
		// restar 366
		// Si el año pasado fue bisiesto y en el año actual aún estamos en enero
		// o febrero, tenemos que restar 366
		if ((calendar.isLeapYear(currentYear) && calendar.get(Calendar.MONTH) > 1)
				|| (calendar.isLeapYear(currentYear - 1) && calendar.get(Calendar.MONTH) < 2))
			daysToSubstract = -366;
		// Restamos (Sumamos el número negativo de días)
		calendar.add(GregorianCalendar.DAY_OF_YEAR, daysToSubstract);
		/*
		 * System.out.println("Dia hace un año:" +
		 * calendar.get(Calendar.DAY_OF_MONTH) + "/" +
		 * (calendar.get(Calendar.MONTH) + 1) + "/" +
		 * calendar.get(Calendar.YEAR));
		 */
		return calendar.getTime();
	}
}
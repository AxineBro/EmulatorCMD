package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeUtils {
	
	public static String getNowDate() {
		StringBuilder resulDate = new StringBuilder();
		resulDate.append(formatterTime(new GregorianCalendar().get(Calendar.DAY_OF_MONTH)) + ".");
		resulDate.append(formatterTime(new GregorianCalendar().get(Calendar.MONTH) + 1) + ".");
		resulDate.append(new GregorianCalendar().get(Calendar.YEAR));
		return resulDate.toString();
	}
	public static String getNowTime() {
		StringBuilder resulTime = new StringBuilder();
		resulTime.append(formatterTime(new GregorianCalendar().get(Calendar.HOUR_OF_DAY)) + ":");
		resulTime.append(formatterTime(new GregorianCalendar().get(Calendar.MINUTE)));
		return resulTime.toString();
	}
	private static String formatterTime(int Time) {
		return Time > 9? "" + Time: "0" + Time;
	}
}

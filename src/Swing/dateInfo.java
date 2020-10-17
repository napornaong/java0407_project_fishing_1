package Swing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dateInfo {

	public dateInfo() {
		Calendar cal = Calendar.getInstance();
		String format = "MM.dd";
		String[] week = { "일", "월", "화", "수 ", "목", "금", "토" };

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dTime = formatter.format(cal.getTime());
		String w = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter1 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime1 = formatter1.format(cal.getTime());
		String w1 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];


		SimpleDateFormat formatter2 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime2 = formatter2.format(cal.getTime());
		String w2 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter3 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime3 = formatter3.format(cal.getTime());
		String w3 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter4 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime4 = formatter4.format(cal.getTime());
		String w4 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter5 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime5 = formatter5.format(cal.getTime());
		String w5 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter6 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime6 = formatter6.format(cal.getTime());
		String w6 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter7 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime7 = formatter7.format(cal.getTime());
		String w7 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat formatter8 = new SimpleDateFormat(format);
		cal.add(cal.DATE, +1);
		String dTime8 = formatter8.format(cal.getTime());
		String w8 = week[cal.get(Calendar.DAY_OF_WEEK) - 1];
	}
	
}

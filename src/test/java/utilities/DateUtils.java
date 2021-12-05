package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returnNextMonth(){
        //creating date object
        Date date = new Date();
        //creating calendar object
        Calendar calendar = new GregorianCalendar();
        //set calendar date to current date
        calendar.setTime(date);
        //creating object of SimpleDateFormat
        //Defining/formatting date MMM-yyyy
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-yyyy");
        //incrementing current month to next month
        calendar.add(Calendar.MONTH,1);
        //generating now this calendar date to simDateFormat pattern
        String newDate = simpleDateFormat.format(calendar.getTime());
        return newDate;



    }
}

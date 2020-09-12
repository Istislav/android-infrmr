package ru.istislav.infrmr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Util {

    public static String dateFormatted(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");

        return dateFormat.format(date);
    }

    public static String getCurrentDateLine() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // modern method (API 26)
            date = Date.from(ZonedDateTime.now().minusDays(7).toInstant());
        } else { // old method
            Calendar calendar = Calendar.getInstance();
            // calendar.add(Calendar.HOUR_OF_DAY, 24*7);
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            date = calendar.getTime();
        }
        return formatter.format(date);
    }


}

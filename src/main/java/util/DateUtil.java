package util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @date 2020/07/04
 * @time 13:31
 */
public class DateUtil {

    /**
     * @param date      Date
     * @param zone      Africa/Nairobi
     * @param dayOffset 天偏移
     * @return 当地时间0时
     */
    public static Date getDayBegin(Date date, String zone, int dayOffset) {
        TimeZone timeZone = TimeZone.getTimeZone(zone);
        TimeZone.setDefault(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, dayOffset);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param date      Date
     * @param timeZone  Africa/Nairobi
     * @param dayOffset 天偏移
     * @return 当地时间结束时
     */
    public static Date getDayEnd(Date date, String timeZone, int dayOffset) {
        TimeZone zone = TimeZone.getTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance(zone);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, dayOffset);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

}

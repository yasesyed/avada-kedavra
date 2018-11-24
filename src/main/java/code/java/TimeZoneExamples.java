package code.java;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by syed.yaser on 27/07/17.
 */
public class TimeZoneExamples {

    public static void main(String[] args) throws ParseException {
        Date today = new Date();
        /*System.out.println(today);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println(today);
        today = new Date();
        System.out.println(today);
        System.out.println(TimeZone.getDefault());
*/

        //Thu 2017-07-27'T'02:31:36+0530
        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        String dateStr = "2017-08-03T00:00:00+0000";
        String fmtIn = "yyyy-MM-dd'T'hh:mm:ssZ";
        SimpleDateFormat sdfIn = new SimpleDateFormat(fmtIn);
        System.out.println(sdfIn.parse(dateStr));
        System.out.println(sdfIn.parse(dateStr).getTime());

        //System.out.println(new Timestamp(sdfIn.parse(dateStr).getTime()));

    }
}

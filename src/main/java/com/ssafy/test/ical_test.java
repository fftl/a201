
package com.ssafy.test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.Summary;

import static java.lang.ClassLoader.getSystemResource;

/**
 * requirements
 *  ical4j-1.0-rc3.jar
 *  backport-util-concurrent-3.1.jar
 *
 * @author pluto
 */
public class ical_test {

    public static void main(String[] args) throws Exception {
        Calendar calendar = getCalendar();

        List<CalendarComponent> list = calendar.getComponents(Component.VEVENT);
        for (int i=0; i<list.size(); i++) {
            VEvent vEvent = (VEvent)list.get(i);
            Summary summary = vEvent.getSummary().get();
            DtStart dtStart = vEvent.getStartDate().get();
            DtEnd dtEnd = vEvent.getEndDate(true).get();
            Location location = vEvent.getLocation().get();

            String summaryString = summary.getValue();
//            System.out.println("LEE => "+summaryString);

//            Date dtStart1 = (Date) dtStart.getDate();
//            Date dtEnd1 = (Date) dtEnd.getDate();


            String[] params = new String[2];
            params[0] = summaryString;
//            params[1] = getDateString(dtStart1);
//            params[2] = getDateString(dtEnd1);
            params[1] = location.getValue();
//            MessageFormat formatter = new MessageFormat("{0}\t{1}\t{2}\t{3}");
            MessageFormat formatter = new MessageFormat("{0}\t{1}");
            String message = formatter.format(params);
            System.out.println(message);
        }

    }
    /*
    public static Calendar getCalendar0() throws Exception {
     FileInputStream fin = new FileInputStream("C:\\java\\workspace\\javaya-java-test\\src\\org\\javaya\\test\\ical\\basic.ics");
     CalendarBuilder builder = new CalendarBuilder();
     Calendar calendar = builder.build(fin);

     return calendar;
    }

    public static Calendar getCalendar1() throws Exception {
     Resource r = new ClassPathResource("org/javaya/test/ical/basic.ics");
     File f = r.getFile();
     String filename = f.getAbsolutePath();

     FileInputStream fin = new FileInputStream(filename);
     CalendarBuilder builder = new CalendarBuilder();
     Calendar calendar = builder.build(fin);

     return calendar;
    }

    public static Calendar getCalendar2() throws Exception {
     java.net.URL dbURL = ClassLoader.getSystemResource("org/javaya/test/ical/basic.ics");
     File filename = new File(dbURL.getFile());

     FileInputStream fin = new FileInputStream(filename);
     CalendarBuilder builder = new CalendarBuilder();
     Calendar calendar = builder.build(fin);

     return calendar;
    }
    */
    public static Calendar getCalendar() throws Exception {
        File filename = new File("src/main/java/com/ssafy/test/basic.ics");

        FileInputStream fin = new FileInputStream(filename);
        CalendarBuilder builder = new CalendarBuilder();
        Calendar calendar = builder.build(fin);

        return calendar;
    }

    public static String getDateString(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return sdf.format(date);
    }

}
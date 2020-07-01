

import java.util.Date;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class DateTest {

    public static void main(String[] args) {
       Date d = new Date();
       System.out.println(d.toString());
       
       
       ///////////
          
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Calendar c = Calendar.getInstance();
       System.out.println(dateFormat.format(c.getTime()));
	       
    

    }
}

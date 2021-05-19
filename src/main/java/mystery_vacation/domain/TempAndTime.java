package mystery_vacation.domain;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TempAndTime {
   public double temp;
   public long time;
   public int timezone;
   
   public TempAndTime(double temp, long time, int timezone){
           this.temp = temp;
           this.time = time;
           this.timezone = timezone;
   }

    public double getTemp() {
      return temp;
    }

    public void setTemp(double temp) {
      this.temp = temp;
    }

    public void setTime(long time) {
      this.time = time;
    }

    public int getTimezone() {
      return timezone;
    }

    public void setTimezone(int timezone) {
      this.timezone = timezone;
    }

    public long getTime() {
      return time;
    }

    public String convertTime() {
      time = time * 1000;
      Date date = new Date(time);
      DateFormat dateFormat = new SimpleDateFormat("h:mm a");
      TimeZone timeZone = TimeZone.getTimeZone("UTC");
      timeZone.setRawOffset(timezone * 1000);
      dateFormat.setTimeZone(timeZone);
      return dateFormat.format(date);
    }
    
    public String convertTemp() {
       double convertedTemp = (temp - 273.15) * 9.0 / 5.0 + 32.0;
       DecimalFormat decimalFormat = new DecimalFormat("#.##");
       String tempToString = decimalFormat.format(convertedTemp) + " F";
       return tempToString;
     }
}

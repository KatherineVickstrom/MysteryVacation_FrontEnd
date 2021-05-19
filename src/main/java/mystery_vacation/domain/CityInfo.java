package mystery_vacation.domain;

import mystery_vacation.domain.City;
import mystery_vacation.domain.CityInfo;
import mystery_vacation.domain.Country;
import mystery_vacation.domain.TempAndTime;

public class CityInfo {
   
   private String time, temp;
   private Country country;
   private City city;
   
   public CityInfo() { }
   
   public CityInfo(City city, Country country, TempAndTime tempAndTime) {
      this.temp = tempAndTime.convertTemp();
      this.time = tempAndTime.convertTime();
      this.city = city;
      this.country = country;
    }

 @Override
 public int hashCode()
 {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((temp == null) ? 0 : temp.hashCode());
    result = prime * result + ((time == null) ? 0 : time.hashCode());
    return result;
 }

 @Override
 public boolean equals(Object obj)
 {
    if (this == obj)
       return true;
    if (obj == null)
       return false;
    if (getClass() != obj.getClass())
       return false;
    CityInfo other = (CityInfo) obj;
    if (city == null)
    {
       if (other.city != null)
          return false;
    } else if (!city.equals(other.city))
       return false;
    if (country == null)
    {
       if (other.country != null)
          return false;
    } else if (!country.equals(other.country))
       return false;
    if (temp == null)
    {
       if (other.temp != null)
          return false;
    } else if (!temp.equals(other.temp))
       return false;
    if (time == null)
    {
       if (other.time != null)
          return false;
    } else if (!time.equals(other.time))
       return false;
    return true;
 }

 public String getTime()
 {
    return time;
 }

 public void setTime(String time)
 {
    this.time = time;
 }

 public String getTemp()
 {
    return temp;
 }

 public void setTemp(String temp)
 {
    this.temp = temp;
 }

 public Country getCountry()
 {
    return country;
 }

 public void setCountry(Country country)
 {
    this.country = country;
 }

 public City getCity()
 {
    return city;
 }

 public void setCity(City city)
 {
    this.city = city;
 }

}
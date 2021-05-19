package mystery_vacation.service;

import java.util.List;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mystery_vacation.domain.*;
 
@Service
public class CityService {
        @Autowired
        private CityRepository cityRepository;
        @Autowired
        private CountryRepository countryRepository;
        @Autowired
        private WeatherService weatherService;
        
        @Autowired
        private RabbitTemplate rabbitTemplate;
        
        public CityInfo getCityInfo(String cityName) {
           
           List<City> cities = cityRepository.findByName(cityName);
           if (cities.size() > 0) {
              // in case of multiple cities, take the first one.
              City city = cities.get(0);
              Country country = countryRepository.findByCode(city.getCountryCode());
              TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);
              CityInfo cityInfo = new CityInfo(city, country, tempAndTime);
              return cityInfo;
           }
           
           else {
              return null;
           }
     }
        
            
    @Autowired
    private FanoutExchange fanout;
     
        public void requestReservation( 
                       String cityName, 
                       String level, 
                       String email) {
                    String msg  = "{\"cityName\": \""+ cityName + 
                   "\" \"level\": \""+level+
                   "\" \"email\": \""+email+"\"}" ;
                    System.out.println("Sending message:"+msg);
                    rabbitTemplate.convertSendAndReceive(
                    fanout.getName(), 
                    "",   // routing key none.
                    msg);
            }

}

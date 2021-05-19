package mystery_vacation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mystery_vacation.domain.CityInfo;
import mystery_vacation.service.CityService;
 
@Controller
public class CityController {
   @Autowired
   private CityService cityService;             
   @GetMapping("/cities/{city}")
   public String getCityInfo(@PathVariable("city") String cityName,Model model) {
      CityInfo cityInfo = cityService.getCityInfo(cityName);
      if (cityInfo == null) {
              // error.  city not found
              model.addAttribute("error", "City not found. "+cityName);
              return "cityerror";
      } else {
              model.addAttribute("cityInfo", cityInfo);
              return "cityshow";
      }

   }
   

   @PostMapping("/cities/reservation")
   public String createReservation(
                   @RequestParam("city") String cityName, 
                   @RequestParam("level") String level, 
                   @RequestParam("email") String email, 
                   Model model) {
           
           model.addAttribute("city", cityName);
           model.addAttribute("level", level);
           model.addAttribute("email", email);
           cityService.requestReservation(cityName, level, email);
           return "request_reservation";
   }

}


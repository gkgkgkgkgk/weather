package com.climate.site.controller;

import com.climate.site.service.WeatherData;
import com.climate.site.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gouri on 15/04/2016.
 */
@Controller
public class WeatherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/getforcity", method = RequestMethod.POST)
    public String getWeatherForCity(@RequestParam(value="city", required=true) int city, ModelMap model){
        LOGGER.debug("getWeatherForCity called for " + city);
        String cityString = getCity(city);

        if (cityString != null) {

            WeatherData data = weatherService.currentWeatherForCity(cityString);

            model.addAttribute("data", data);

        }

        return "index";
    }

    private String getCity(int city) {
        switch(city) {
            case 1 : return "London";
            case 2 : return "HongKong";
            default: return null;
        }
    }

}

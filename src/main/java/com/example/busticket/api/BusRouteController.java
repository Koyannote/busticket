package com.example.busticket.api;


import com.example.busticket.model.BusRoute;
import com.example.busticket.persistence.BusRouteRespository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/busroutes")
public class BusRouteController {

    private MongoTemplate mongoTemplate;
    private BusRouteRespository busRouteRespository;


    public BusRouteController(MongoTemplate mongoTemplate, BusRouteRespository busRouteRespository) {
        this.mongoTemplate = mongoTemplate;
        this.busRouteRespository = busRouteRespository;
    }

    @GetMapping("/all")
    public Collection<BusRoute> showAllRoute(){
        Collection<BusRoute> routes =        this.mongoTemplate.findAll(BusRoute.class);
       return routes ;
    }

    @GetMapping("/{busName}")
    public Collection<BusRoute> byBusName(@PathVariable String busName){
          return this.busRouteRespository.findByBusContains(busName);
    }

    @GetMapping("/name/{toCity}")
    public Collection<BusRoute> byToCity(@PathVariable("toCity") String toCity){

        return this.busRouteRespository.findByRoutesToCity(toCity);



    }
}

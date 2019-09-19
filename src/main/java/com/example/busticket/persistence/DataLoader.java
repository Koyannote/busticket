package com.example.busticket.persistence;

import com.example.busticket.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;


@Service
public class DataLoader implements CommandLineRunner {

    private final MongoTemplate mongoTemplate ;

    public DataLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override @Profile("dev")
    public void run(String... args) throws Exception {
       BusRoute mandalayYangon = new BusRoute(

               new Bus("ShweMan", BusStatus.ECONOMIC,
                       Arrays.asList(
                       new Seats("A1", SeatStatus.VACANT),
                       new Seats("A2",SeatStatus.VACANT),
                       new Seats("A3",SeatStatus.VACANT),
                       new Seats("A4",SeatStatus.VACANT),
                       new Seats("A5",SeatStatus.VACANT)
                       )),new Routes("Mandalay","Yangon"),
               LocalDateTime.now().plusDays(1),
               LocalDateTime.now().plusDays(2),
               Arrays.asList("Pegu","Pyinmana"));


        BusRoute yangonTaunggyi = new BusRoute(

                new Bus("AungMyanmar",BusStatus.ECONOMIC,
                        Arrays.asList(
                                new Seats("A1",SeatStatus.VACANT),
                                new Seats("A2",SeatStatus.VACANT),
                                new Seats("A3",SeatStatus.VACANT),
                                new Seats("A4",SeatStatus.VACANT),
                                new Seats("A5",SeatStatus.VACANT)
                        )),new Routes("Yangon","Taunggyi"),
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2),
                Arrays.asList("TharSyi","Pyinmana","Kalaw"));
        Collection<BusRoute> busroute =Arrays.asList(mandalayYangon,yangonTaunggyi);
     //   this.mongoTemplate.insertAll(busroute);

    }


}

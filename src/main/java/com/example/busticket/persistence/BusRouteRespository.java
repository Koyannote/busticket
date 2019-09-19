package com.example.busticket.persistence;

import com.example.busticket.model.BusRoute;
import com.mongodb.internal.connection.MongoWriteConcernWithResponseException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface BusRouteRespository extends MongoRepository<BusRoute,String> {

    List<BusRoute> findByBusContains(String busName);

    List<BusRoute> findByRoutesToCity(String toCity);


}

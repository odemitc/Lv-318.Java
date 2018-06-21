package org.uatransport.service.ewayutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.uatransport.entity.Stop;
import org.uatransport.entity.Transit;
import org.uatransport.exception.ResourceNotFoundException;
import org.uatransport.repository.StopRepository;
import org.uatransport.repository.TransitRepository;
import org.uatransport.service.ewayutil.ewayentity.EwayResponseObject;
import org.uatransport.service.ewayutil.ewayentity.EwayRoute;
import org.uatransport.service.ewayutil.ewayentity.EwayRouteList;
import org.uatransport.service.ewayutil.ewaystopentity.EwayPoint;
import org.uatransport.service.ewayutil.ewaystopentity.EwayPoints;
import org.uatransport.service.ewayutil.ewaystopentity.EwayRouteWithPoints;
import org.uatransport.service.ewayutil.ewaystopentity.EwayStopResponse;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EwayStopListSaver {
    private final TransitRepository transitRepository;
    private final StopRepository stopRepository;

    public String getUrlByID(String transitId) {
        URIBuilder uri = new URIBuilder()
                .setScheme(EwayConfig.getProperty("scheme"))
                .setHost(EwayConfig.getProperty("host"))
                .addParameter("login", EwayConfig.getProperty("login"))
                .addParameter("password", EwayConfig.getProperty("password"))
                .addParameter("function", EwayConfig.getProperty("function-stops"))
                .addParameter("city", EwayConfig.getProperty("city"))
                .addParameter("id", transitId)
                .addParameter("start_position", EwayConfig.getProperty("start_position"))
                .addParameter("stop_position", EwayConfig.getProperty("stop_position"));
        return uri.toString();
    }

    private ResponseEntity<String> getResponse(String transitId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(getUrlByID(transitId), String.class);
    }

    private EwayStopResponse getObjectFromJson(String transitId) {
        Gson gson = new Gson();
        return gson.fromJson(getResponse(transitId).getBody(), EwayStopResponse.class);
    }

    public void convertAndSaveStops(String transitId) {
        EwayStopResponse ewayStopResponse = getObjectFromJson(transitId);
        Transit transit = transitRepository.findById(Integer.parseInt(transitId))
                .orElseThrow(() -> new ResourceNotFoundException("Impossible to save transit. There is no such transit for assignment."));
        EwayRouteWithPoints route = ewayStopResponse.getRoute();
        EwayPoints ewayPoints = route.getPoints();
        EwayPoint[] arrayOfPoints = ewayPoints.getPoint();
        List<Stop> stops = new ArrayList<>();
        for (EwayPoint point : arrayOfPoints) {
            System.out.println(point.getTitle());
            Stop stop = new Stop();
            stop.setLat(point.getLat());
            stop.setLng(point.getLng());
            stop.setDirection(point.getDirection());
            if (point.getTitle() != null) {
                stop.setStreet(point.getTitle());
            }
            stopRepository.save(stop);
            stops.add(stop);
        }
        transit.setStops(stops);
        transitRepository.save(transit);
    }
}

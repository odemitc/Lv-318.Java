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
import org.uatransport.entity.Transit;
import org.uatransport.repository.CategoryRepository;
import org.uatransport.repository.TransitRepository;
import org.uatransport.service.ewayutil.ewayentity.EwayResponseObject;
import org.uatransport.service.ewayutil.ewayentity.EwayRoute;
import org.uatransport.service.ewayutil.ewayentity.EwayRouteList;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class EwayRoutesListSaver {
    private final TransitRepository transitRepository;
    private final CategoryRepository categoryRepository;

    private String login = "vladlenonopko";
    private String password = "3knKuw8BvsqwP2n";
    private String function = "cities.GetRoutesList";
    private String city = "lviv";

    public String getUrl() {
        URIBuilder uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.eway.in.ua/")
                .addParameter("login", login)
                .addParameter("password", password)
                .addParameter("function", function)
                .addParameter("city", city);
        return uri.toString();
    }

    private ResponseEntity<String> getResponse(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(getUrl(), String.class);
    }

    private EwayResponseObject getObjectFromJson(){
        Gson gson = new Gson();
        return gson.fromJson(getResponse().getBody(), EwayResponseObject.class);
    }

    public void convertAndSaveEwayRoutes() {
        EwayResponseObject object  = getObjectFromJson();
        EwayRouteList ewayRouteList = object.getRoutesList();
        for (EwayRoute route : ewayRouteList.getRoute()) {
            Transit transit = new Transit();
            transit.setId(route.getId());
            Integer categoryId = 6;
            switch (route.getTransport()) {
                case "bus":
                    categoryId = 7;
                    break;
                case "trol":
                    categoryId = 5;
                    break;
                case "tram":
                    categoryId = 4;
                    break;
            }
            transit.setCategory(categoryRepository.findById(categoryId).get());
            transit.setName(route.getTitle());
            transitRepository.save(transit);
        }
    }
}

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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.uatransport.entity.Transit;
import org.uatransport.repository.CategoryRepository;
import org.uatransport.repository.TransitRepository;
import org.uatransport.service.ewayutil.ewayentity.EwayResponseObject;
import org.uatransport.service.ewayutil.ewayentity.EwayRoute;
import org.uatransport.service.ewayutil.ewayentity.EwayRouteList;

import java.io.*;
import java.nio.charset.Charset;

@RequiredArgsConstructor
@Service
public class EwayRoutesListSaver {
    private final TransitRepository transitRepository;
    private final CategoryRepository categoryRepository;

    private String apiUrl = "https://api.eway.in.ua/";
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

    private EwayResponseObject getResponse() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(this.getUrl());
        ResponseHandler<EwayResponseObject> ewayRouteResponseHandler = new ResponseHandler<EwayResponseObject>() {
            @Override
            public EwayResponseObject handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                HttpEntity entity = httpResponse.getEntity();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                Reader reader = new InputStreamReader(entity.getContent(), charset);
                return gson.fromJson(reader, EwayResponseObject.class);
            }
        };
        return httpClient.execute(getRequest, ewayRouteResponseHandler);
    }

    private void testJsonRoutesList() throws FileNotFoundException {
        Gson gson = new Gson();
        EwayResponseObject object = gson.fromJson(new FileReader("D:\\SoftServeClient\\Lv-318.Java\\src\\main\\java\\org\\uatransport\\service\\ewayutil\\GetRoutesList.json"), EwayResponseObject.class);
        EwayRouteList ewayRouteList = object.getRoutesList();
        for (EwayRoute ewayRoute : ewayRouteList.getRoute()) {
            System.out.println(ewayRoute);
        }
    }

    private void testJsonResp() {
        EwayRoute first = new EwayRoute();
        first.setId(1);
        first.setTitle("28");
        first.setStart_position(0);
        first.setStop_position(28);
        first.setTransport("bus");

        EwayRoute second = new EwayRoute();
        second.setId(2);
        second.setTitle("35");
        second.setStart_position(1);
        second.setStop_position(35);
        second.setTransport("bus2");

        EwayRoute[] array = {first, second};
        EwayRouteList list = new EwayRouteList();
        list.setRoute(array);
        EwayResponseObject object = new EwayResponseObject();
        object.setRoutesList(list);

        Gson gson = new Gson();
        System.out.println(gson.toJson(object));
    }

    public void convertAndSaveEwayRoutes() {
        EwayResponseObject object = null;
        try {
            object = getResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {

    }


}

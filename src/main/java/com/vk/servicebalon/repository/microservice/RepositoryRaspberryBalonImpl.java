package com.vk.servicebalon.repository.microservice;

import com.vk.servicebalon.device.DeviceModelRaspberry;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Repository
@ComponentScan(basePackages = {"com.vk.servicebalon.device","com.vk.servicebalon.configuration"})
public class RepositoryRaspberryBalonImpl implements RepositoryRaspberryBalon{

    private final DeviceModelRaspberry deviceModelRaspberry;

    private final RestTemplate restTemplate;

    @Autowired
    public RepositoryRaspberryBalonImpl(final DeviceModelRaspberry deviceModelRaspberry, final RestTemplate restTemplate) {
        this.deviceModelRaspberry = deviceModelRaspberry;
        this.restTemplate = restTemplate;
    }

    @Override
    public JsonBodyListForTableModelTRM202 readJsonTableModelTRM202BetweenDate(final LocalDateTime start, final LocalDateTime end) {
        return restTemplate.postForObject(createUrlAdress()+"/database/range", createHttpEntity(start, end), JsonBodyListForTableModelTRM202.class);
    }

    @Override
    public TableModelTRM202 readJsonTableModelTRM202Last() {
        return restTemplate.getForObject(createUrlAdress()+"/database/get-last-row", TableModelTRM202.class);
    }

    @Override
    public DeviceModelTRM202 readJsonDeviceModelTRM202allRegisters(){
        return restTemplate.getForObject(createUrlAdress()+"/modbus/read-all", DeviceModelTRM202.class);
    }

    private HttpHeaders createHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    private String createJSONObject(LocalDateTime from, LocalDateTime to) {
        JSONObject jsonpObject = new JSONObject();
        try {
            jsonpObject.put("from", from);
            jsonpObject.put("to", to);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonpObject.toString();
    }

    private String createUrlAdress(){
        return "http://"+deviceModelRaspberry.getIp()+":"+deviceModelRaspberry.getTomcatPort();
    }

    private HttpEntity<String> createHttpEntity(LocalDateTime from, LocalDateTime to){
        return new HttpEntity<String>(createJSONObject(from, to), createHttpHeaders());
    }
}

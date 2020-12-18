package com.vk.servicebalon.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.serotonin.json.JsonObject;
import com.vk.servicebalon.chain.Chain1;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.DateFromChart;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.modbus.entity.ModbusBodyDateRange;
import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.service.ServiceTRM202Impl;
import com.vk.servicebalon.table.TableModelTRM202;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@RestController
@EnableScheduling
@ComponentScan(basePackages = {"com.vk.servicebalon.chain"})
@RequestMapping(value = "/chain1")
public class ControllerChain1 {

    private Chain1 chain1;

    private final TaskTRM202 taskTRM202;

    private final ServiceTRM202 serviceTRM202;

    @Autowired
    public ControllerChain1(final Chain1 chain1, final TaskTRM202 taskTRM202, final ServiceTRM202 serviceTRM202){
        this.chain1 = chain1;
        this.taskTRM202 = taskTRM202;
        this.serviceTRM202 = serviceTRM202;
    }

    @Scheduled(fixedRate = 1000)
    private void loop(){
//
//        RestTemplate restTemplate = new RestTemplate();
//        DeviceModelTRM202 deviceModelTRM202 = restTemplate.getForObject("http://192.168.8.149:8080/modbus/read-all", DeviceModelTRM202.class);
//        assert deviceModelTRM202 != null;
//        System.out.println(deviceModelTRM202.getHoldingRegister0());

//        JsonBodyListForTableModelTRM202 cvb = restTemplate.postForObject(createUrlAdress(), createHttpEntity(), JsonBodyListForTableModelTRM202.class);
//        cvb.getTableModelTRM202List().forEach(System.out::println);
//        System.out.println(cvb.getFrom()+"     "+cvb.getTo());

        System.out.println(serviceTRM202.findLastValueByDate().toString());

//        if (!chain1.isAlive()){
//            chain1 = new Chain1(taskTRM202);
//        }
    }

//    private HttpHeaders createHttpHeaders(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        return httpHeaders;
//    }
//
//    private String createJSONObject() {
//        JSONObject jsonpObject = new JSONObject();
//        try {
//
//            jsonpObject.put("from", LocalDateTime.now().minusDays(1));
//            jsonpObject.put("to", LocalDateTime.now());
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//        return jsonpObject.toString();
//    }
//
//    private String createUrlAdress(){
//        return "http://192.168.8.149:8080/database/range";
//    }
//
//    private HttpEntity<String> createHttpEntity(){
//        return new HttpEntity<String>(createJSONObject(), createHttpHeaders());
//    }

    private void randomParserLocalDateTime(){
        String timeInterval = "2018-05-03T08:00Z/2018-05-04T04:00Z";
        String[] allTime = timeInterval.split("/");
        if (allTime.length != 2) {
            throw new IllegalStateException("Wrong number of datetimes, should be 2");
        }
        OffsetDateTime dateTimeStart = OffsetDateTime.parse(allTime[0]);
        OffsetDateTime dateTimeEnd = OffsetDateTime.parse(allTime[1]);
        OffsetDateTime current = dateTimeStart;
        while (current.isBefore(dateTimeEnd)) {
            OffsetDateTime next = current.plusHours(1);
            System.out.println("" + current + '/' + next);
            current = next;
        }
        System.out.println("Time End: " + dateTimeEnd);
    }
}
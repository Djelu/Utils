package com.fantasy.Utils.controller;

import com.fantasy.Utils.model.LightCounter;
import com.fantasy.Utils.model.WaterCounter;
import com.fantasy.Utils.model.request.CalculateRequest;
import com.fantasy.Utils.model.response.CalculateResponse;
import com.fantasy.Utils.service.CountersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/counters")
public class CountersController {

    @Autowired
    CountersService countersService;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

//    @PostMapping("/calculate")
//    public Mono<ServerResponse> calculate(CalculateRequest requestBody) {
//        try {
//            final var calculatedData = countersService.calculateAndGetCountersData(
//                new LightCounter(requestBody.getDay(), requestBody.getNight()),
//                new WaterCounter(requestBody.getCold(), requestBody.getHot())
//            );
//            final String jsonResult = new ObjectMapper().writeValueAsString(calculatedData);
//            return ServerResponse.ok()
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(BodyInserters.fromValue(jsonResult));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ServerResponse.badRequest()
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(BodyInserters.fromValue(e.getMessage()));
//        }
//    }

    @PostMapping("/calculate")
    public Mono<CalculateResponse> calculate(CalculateRequest requestBody) {
        final var calculatedData = countersService.calculateAndGetCountersData(
                new LightCounter(requestBody.getDay(), requestBody.getNight()),
                new WaterCounter(requestBody.getCold(), requestBody.getHot())
        );
        return Mono.just(calculatedData);
    }
}

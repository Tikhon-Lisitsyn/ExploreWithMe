package ru.practicum.controller;

import org.springframework.web.bind.annotation.*;
import ru.practicum.EndpointHit;
import ru.practicum.client.StatsServiceClient;

import java.util.List;

@RestController
public class StatsClientController {
    private final StatsServiceClient statsServiceClient;

    public StatsClientController(StatsServiceClient statsServiceClient) {
        this.statsServiceClient = statsServiceClient;
    }

    @PostMapping("/hit")
    public void saveHit(@RequestBody EndpointHit endpointHit) {
        statsServiceClient.sendHitInfo(endpointHit.getApp(), endpointHit.getUri(), endpointHit.getIp());
    }

    @GetMapping("/stats")
    public String getStats(@RequestParam String start,
                           @RequestParam String end,
                           @RequestParam(required = false) List<String> uris) {
        return statsServiceClient.getStats(start, end, uris);
    }
}

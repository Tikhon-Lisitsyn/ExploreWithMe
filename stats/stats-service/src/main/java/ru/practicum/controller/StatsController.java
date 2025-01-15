package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.EndpointHit;
import ru.practicum.ViewStats;
import ru.practicum.service.StatsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StatsController {

    private StatsService statsService;

    @PostMapping("/hit")
    public void saveHit(@RequestBody EndpointHit endpointHit) {
        statsService.saveHit(endpointHit);
    }

    @GetMapping("/stats")
    public List<ViewStats> getStats(@RequestParam String start,
                                    @RequestParam String end,
                                    @RequestParam(required = false) List<String> uris) {
        return statsService.getStats(start, end, uris);
    }
}


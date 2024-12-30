package ru.practicum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.EndpointHit;
import ru.practicum.ViewStats;
import ru.practicum.repository.EndpointHitRepository;
import ru.practicum.repository.ViewStatsRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatsService {

    @Autowired
    private EndpointHitRepository endpointHitRepository;

    @Autowired
    private ViewStatsRepository viewStatsRepository;

    public void saveHit(EndpointHit endpointHit) {
        endpointHit.setTimestamp(LocalDateTime.now());
        endpointHitRepository.save(endpointHit);
    }

    public List<ViewStats> getStats(String start, String end, List<String> uris) {
        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);
        List<Object[]> results = viewStatsRepository.findStats(startDateTime, endDateTime, uris);

        List<ViewStats> statsList = new ArrayList<>();
        for (Object[] result : results) {
            ViewStats viewStats = new ViewStats();
            viewStats.setApp((String) result[0]);
            viewStats.setUri((String) result[1]);
            viewStats.setHits(((Number) result[2]).longValue());
            statsList.add(viewStats);
        }
        return statsList;
    }
}



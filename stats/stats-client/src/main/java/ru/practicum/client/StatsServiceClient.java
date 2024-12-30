package ru.practicum.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.practicum.HitRequest;

import java.util.List;

@Service
@AllArgsConstructor
public class StatsServiceClient {

    private final RestTemplate restTemplate;

    public void sendHitInfo(String serviceName, String uri, String ip) {
        String url = "http://localhost:9090/hit";
        HitRequest hitRequest = new HitRequest(serviceName, uri, ip);

        restTemplate.postForObject(url, hitRequest, Void.class);
    }

    public String getStats(String startDate, String endDate, List<String> uris) {
        String url = "http://localhost:9090/stats";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("start", startDate)
                .queryParam("end", endDate)
                .queryParam("uris", String.join(",", uris));

        return restTemplate.getForObject(builder.toUriString(), String.class);
    }
}

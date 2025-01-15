package ru.practicum;

import lombok.Data;

@Data
public class HitRequest {
    private String serviceName;
    private String uri;
    private String ip;

    public HitRequest(String serviceName, String uri, String ip) {
        this.serviceName = serviceName;
        this.uri = uri;
        this.ip = ip;
    }
}

package ru.practicum;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "endpoint_hit")
public class EndpointHit {
    @Id
    private Long id;
    private String app;
    private String uri;
    private String ip;
    private LocalDateTime timestamp;
}
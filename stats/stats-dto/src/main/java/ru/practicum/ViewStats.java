package ru.practicum;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "view_stats")
public class ViewStats {
    @Id
    private Long id;
    private String app;
    private String uri;
    private Long hits;
    private LocalDateTime timestamp;
}

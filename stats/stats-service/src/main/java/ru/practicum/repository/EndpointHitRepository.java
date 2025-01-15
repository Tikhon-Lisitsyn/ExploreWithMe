package ru.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.EndpointHit;

public interface EndpointHitRepository extends JpaRepository<EndpointHit, Long> {
}


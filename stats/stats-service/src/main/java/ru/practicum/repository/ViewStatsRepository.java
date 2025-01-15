package ru.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface ViewStatsRepository extends JpaRepository<ViewStats, String> {
    @Query("SELECT v.app AS app, v.uri AS uri, COUNT(v) AS hits " +
            "FROM EndpointHit v " +
            "WHERE v.timestamp BETWEEN :start AND :end " +
            "AND v.uri IN :uris " +
            "GROUP BY v.app, v.uri " +
            "ORDER BY COUNT(v) DESC")
    List<Object[]> findStats(@Param("start") LocalDateTime start,
                             @Param("end") LocalDateTime end,
                             @Param("uris") List<String> uris);
}



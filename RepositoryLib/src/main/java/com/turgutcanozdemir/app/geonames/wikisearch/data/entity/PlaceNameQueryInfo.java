package com.turgutcanozdemir.app.geonames.wikisearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "place_name_query_info")
public class PlaceNameQueryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_name_query_info_id")
    public long id;

    @Column(name = "query_date_time", nullable = false)
    public LocalDateTime queryDateTime = LocalDateTime.now();

    @Column(name = "query_value", nullable = false)
    public int queryValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place", nullable = false)
    public PlaceNameInfo placeNameInfo;
}
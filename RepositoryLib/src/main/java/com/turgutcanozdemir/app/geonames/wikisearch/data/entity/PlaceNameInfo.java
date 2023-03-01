package com.turgutcanozdemir.app.geonames.wikisearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "place_name_info")
public class PlaceNameInfo {
    @Id
    public String place;

    @Column(name = "query_datetime", nullable = false)
    public LocalDateTime queryDateTime = LocalDateTime.now();

    @Column(name = "save_datetime", nullable = false)
    public LocalDateTime saveDateTime = LocalDateTime.now();

    @Column(name = "query_count", nullable = false)
    public int queryCount = 1;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "placeNameInfo", cascade = CascadeType.ALL)
    public List<PlaceName> placeNames;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "placeNameInfo", cascade = CascadeType.ALL)
    public Set<PlaceNameQueryInfo> placeNamesQueryInfo;

    @Override
    public int hashCode()
    {
        return place.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceNameInfo placeNameInfo && placeNameInfo.place.equals(place);
    }
}

package com.turgutcanozdemir.app.geonames.wikisearch.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "place_names")
public class PlaceName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_name_id")
    public long id;

    @Column(name = "summary", length = 500)
    public String summary;

    @Column(name = "country_code")
    public String countryCode;

    @Column(name = "title")
    public String title;

    @Column(nullable = false)
    public double longitude;

    @Column(nullable = false)
    public double latitude;

    @Column(name = "wikipedia_url")
    public String wikipediaUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place", nullable = false)
    public PlaceNameInfo placeNameInfo;

    @Override
    public int hashCode()
    {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceName placeName && placeName.id == id;
    }
}

package com.turgutcanozdemir.app.geonames.wikisearch.api.geonames.entity;

import com.fasterxml.jackson.annotation.JsonInclude;


public class PlaceName {
    public String summary;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int elevation;

    public int geoNameId;

    public String feature;

    public double lng;

    public String countryCode;

    public int rank;

    public String thumbnailImg;

    public String lang;

    public String title;

    public double lat;

    public String wikipediaUrl;
}

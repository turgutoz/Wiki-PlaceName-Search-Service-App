package com.turgutcanozdemir.app.geonames.wikisearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PlaceNameDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String summary;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int geoNameId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String feature;

    public double lng;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int rank;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String longitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String title;

    public double latitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String wikipediaUrl;
}

package com.turgutcanozdemir.app.geonames.wikisearch.api.geonames.service;

import com.turgutcanozdemir.app.geonames.wikisearch.api.geonames.entity.PlaceNames;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Scope("prototype")
public class PlaceNameSearchService {
    private final RestTemplate m_restTemplate;

    @Value("${app.geonames.url}")
    private String m_url;

    public PlaceNameSearchService(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }

    public PlaceNames findPlaceNames(String city)
    {
        return m_restTemplate.getForObject(String.format(m_url, city), PlaceNames.class);
    }
}

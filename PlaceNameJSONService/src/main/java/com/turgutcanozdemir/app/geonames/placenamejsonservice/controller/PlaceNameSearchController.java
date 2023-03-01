package com.turgutcanozdemir.app.geonames.placenamejsonservice.controller;


import com.turgutcanozdemir.app.geonames.wikisearch.dto.PlaceNamesDTO;
import com.turgutcanozdemir.app.geonames.wikisearch.service.PlaceNameService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("api/from/geonames/placeNameSearchJSON")
public class PlaceNameSearchController {
    private final PlaceNameService m_placeNameService;

    public PlaceNameSearchController(PlaceNameService placeNameService)
    {
        m_placeNameService = placeNameService;
    }

    @GetMapping("places")
    public PlaceNamesDTO findPlaceNames(String place)
    {
        return m_placeNameService.findPlaceNames(place);
    }
}

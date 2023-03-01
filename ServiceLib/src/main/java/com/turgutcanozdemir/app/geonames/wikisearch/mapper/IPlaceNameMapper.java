package com.turgutcanozdemir.app.geonames.wikisearch.mapper;

import com.turgutcanozdemir.app.geonames.wikisearch.api.geonames.entity.PlaceName;
import com.turgutcanozdemir.app.geonames.wikisearch.api.geonames.entity.PlaceNames;
import com.turgutcanozdemir.app.geonames.wikisearch.dto.PlaceNameDTO;
import com.turgutcanozdemir.app.geonames.wikisearch.dto.PlaceNamesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(implementationName = "PlaceNameMapperImpl", componentModel = "spring")
public interface IPlaceNameMapper {
    @Mappings({
            @Mapping(source = "lng", target = "longitude"),
            @Mapping(source = "lat", target = "latitude"),
    })
    PlaceNameDTO toPlaceNameDTO(PlaceName placeName);
    PlaceNamesDTO toPlaceNamesDTO(PlaceNames placeNames);

    PlaceNameDTO toPlaceNameDTO(com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceName placeName);

    default PlaceNamesDTO toPlaceNamesDTO(List<PlaceNameDTO> placeNames)
    {
        var dto = new PlaceNamesDTO();

        dto.geonames = placeNames;

        return dto;
    }

    com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceName toPlaceName(PlaceNameDTO placeNameDTO);
}

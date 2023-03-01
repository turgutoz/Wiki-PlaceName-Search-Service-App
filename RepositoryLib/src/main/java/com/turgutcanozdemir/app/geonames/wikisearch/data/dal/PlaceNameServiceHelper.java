package com.turgutcanozdemir.app.geonames.wikisearch.data.dal;

import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceName;
import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceNameInfo;
import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceNameQueryInfo;
import com.turgutcanozdemir.app.geonames.wikisearch.data.repository.IPlaceNameInfoRepository;
import com.turgutcanozdemir.app.geonames.wikisearch.data.repository.IPlaceNameQueryInfoRepository;
import com.turgutcanozdemir.app.geonames.wikisearch.data.repository.IPlaceNameRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlaceNameServiceHelper {
    private final IPlaceNameRepository m_placeNameRepository;
    private final IPlaceNameInfoRepository m_placeNameInfoRepository;

    private final IPlaceNameQueryInfoRepository m_placeNameQueryInfoRepository;

    public PlaceNameServiceHelper(IPlaceNameRepository placeNameRepository, IPlaceNameInfoRepository placeNameInfoRepository, IPlaceNameQueryInfoRepository placeNameQueryInfoRepository)
    {
        m_placeNameRepository = placeNameRepository;
        m_placeNameInfoRepository = placeNameInfoRepository;
        m_placeNameQueryInfoRepository = placeNameQueryInfoRepository;
    }

    public boolean existPlaceNameInfoByPlace(String place)
    {
        return m_placeNameInfoRepository.existsById(place);
    }

    public Iterable<PlaceName> findPlaceNamesByPlace(String place)
    {
        return m_placeNameRepository.findByPlace(place);
    }

    public Optional<PlaceNameInfo> findPlaceNameInfoByPlace(String place)
    {
        return m_placeNameInfoRepository.findById(place);
    }

    public int updatePlaceNameInfoQueryCount(String place)
    {
        return m_placeNameInfoRepository.updateQueryCount(place);
    }

    public PlaceNameInfo savePlaceNameInfo(PlaceNameInfo placeNameInfo)
    {
        return m_placeNameInfoRepository.save(placeNameInfo);
    }

    public PlaceNameQueryInfo savePlaceNameQueryInfo(PlaceNameQueryInfo placeNameQueryInfo)
    {
        return m_placeNameQueryInfoRepository.save(placeNameQueryInfo);
    }

}

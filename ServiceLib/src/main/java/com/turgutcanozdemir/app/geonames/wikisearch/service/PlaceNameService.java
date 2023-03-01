package com.turgutcanozdemir.app.geonames.wikisearch.service;

import com.karandev.util.data.service.DataServiceException;
import com.turgutcanozdemir.app.geonames.wikisearch.api.geonames.service.PlaceNameSearchService;
import com.turgutcanozdemir.app.geonames.wikisearch.data.dal.PlaceNameServiceHelper;
import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceNameInfo;
import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceNameQueryInfo;
import com.turgutcanozdemir.app.geonames.wikisearch.dto.PlaceNamesDTO;
import com.turgutcanozdemir.app.geonames.wikisearch.mapper.IPlaceNameMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.csystem.util.collection.CollectionUtil.toList;

@Service
@Scope("prototype")
public class PlaceNameService {
    private final PlaceNameSearchService m_placeNameSearchService;

    private final IPlaceNameMapper m_placeNameMapper;

    private final PlaceNameServiceHelper m_placeNameServiceHelper;

    private PlaceNameQueryInfo createPlaceNameQueryInfo(PlaceNameInfo pni, int queryCount)
    {
        var pnqi = new PlaceNameQueryInfo();

        pnqi.placeNameInfo = pni;
        pnqi.queryDateTime = LocalDateTime.now();
        pnqi.queryValue = queryCount;

        return pnqi;
    }

    private void savePlaceNameQueryInfo(String place)
    {
        var optPni = m_placeNameServiceHelper.findPlaceNameInfoByPlace(place);

        if(optPni.isEmpty())
            throw new DataServiceException("findPlaceNames");

        var pni = optPni.get();

        var pnqi = createPlaceNameQueryInfo(pni, pni.queryCount);

        pnqi.queryValue = pni.queryCount;

        m_placeNameServiceHelper.savePlaceNameQueryInfo(pnqi);
    }

    public PlaceNamesDTO getPlaceNameFromGeonames(String place)
    {
        var placeNamesDTO = m_placeNameMapper.toPlaceNamesDTO(m_placeNameSearchService.findPlaceNames(place));

        if (placeNamesDTO.geonames.isEmpty())
            return placeNamesDTO;

        var pni = new PlaceNameInfo();
        var pnqi = createPlaceNameQueryInfo(pni, 1);

        pni.place = place;

        var list = placeNamesDTO.geonames.stream().map(m_placeNameMapper::toPlaceName).toList();

        list.forEach(pn -> pn.placeNameInfo = pni);

        pni.placeNames = new ArrayList<>(list);

        m_placeNameServiceHelper.savePlaceNameInfo(pni);
        m_placeNameServiceHelper.savePlaceNameQueryInfo(pnqi);

        return placeNamesDTO;
    }

    private PlaceNamesDTO getPlaceNamesFromDB(String place)
    {
        m_placeNameServiceHelper.updatePlaceNameInfoQueryCount(place);
        savePlaceNameQueryInfo(place);

        return m_placeNameMapper.toPlaceNamesDTO(toList(m_placeNameServiceHelper.findPlaceNamesByPlace(place), m_placeNameMapper::toPlaceNameDTO));
    }

    public PlaceNameService(PlaceNameSearchService placeNameSearchService, IPlaceNameMapper placeNameMapper, PlaceNameServiceHelper placeNameServiceHelper)
    {
        m_placeNameSearchService = placeNameSearchService;
        m_placeNameMapper = placeNameMapper;
        m_placeNameServiceHelper = placeNameServiceHelper;
    }

    @Transactional
    public PlaceNamesDTO findPlaceNames(String place)
    {
        return m_placeNameServiceHelper.existPlaceNameInfoByPlace(place) ? getPlaceNamesFromDB(place) : getPlaceNameFromGeonames(place);
    }

}

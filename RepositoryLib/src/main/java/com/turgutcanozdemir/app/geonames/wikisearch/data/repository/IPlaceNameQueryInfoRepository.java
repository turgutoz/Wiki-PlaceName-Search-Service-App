package com.turgutcanozdemir.app.geonames.wikisearch.data.repository;

import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceNameQueryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceNameQueryInfoRepository extends CrudRepository<PlaceNameQueryInfo, Long> {

}



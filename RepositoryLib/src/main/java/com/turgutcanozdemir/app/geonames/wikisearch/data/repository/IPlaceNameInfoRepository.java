package com.turgutcanozdemir.app.geonames.wikisearch.data.repository;

import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceNameInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceNameInfoRepository extends CrudRepository<PlaceNameInfo, String> {
    @Query("update PlaceNameInfo pni set pni.queryCount = pni.queryCount + 1 where pni.place = :place")
    @Modifying
    int updateQueryCount(@Param("place") String place);
}

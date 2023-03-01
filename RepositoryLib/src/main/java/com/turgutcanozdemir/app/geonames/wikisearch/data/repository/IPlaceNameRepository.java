package com.turgutcanozdemir.app.geonames.wikisearch.data.repository;

import com.turgutcanozdemir.app.geonames.wikisearch.data.entity.PlaceName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceNameRepository extends CrudRepository<PlaceName, Long> {
    @Query("select pn from PlaceName pn join pn.placeNameInfo where pn.placeNameInfo.place = :place")
    Iterable<PlaceName> findByPlace(@Param("place") String place);
}

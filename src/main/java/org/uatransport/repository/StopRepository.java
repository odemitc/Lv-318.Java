package org.uatransport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.uatransport.entity.Point;
import org.uatransport.entity.Stop;

import java.util.List;

public interface StopRepository extends CrudRepository<Stop, Integer> {

    List<Stop> findByStreet(String name);

    @Query("SELECT s FROM Transit t JOIN t.points s WHERE t.id = :id ORDER BY INDEX(s)")
    List<Stop> findByTransitId(@Param("id") Integer id);

    @Query("SELECT s FROM Transit t JOIN t.points s WHERE t.id = :id AND s.street = :street")
    Stop findByTransitIdAndStopName(@Param("id") Integer transitId, @Param("street") String street);

    @Query("SELECT INDEX(s) FROM Transit t JOIN t.points s WHERE t.id = :id AND s.street = :street")
    Integer findIndexByTransitIdAndStopName(@Param("id") Integer transitId, @Param("street") String street);
}
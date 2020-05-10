package com.example.demo3;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

interface PlayersRepository extends JpaRepository<Players, Long> {
    List<Players> findByName(@Param("name") String name);
}
/*
public interface PlayersRepository extends PagingAndSortingRepository<Players, Integer> {

    List<Players> findByName(@Param("name") String name);

}
 */

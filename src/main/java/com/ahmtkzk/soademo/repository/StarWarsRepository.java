package com.ahmtkzk.soademo.repository;

import com.ahmtkzk.soademo.model.starwars.StarWarsPeopleResponseEntity;
import org.springframework.data.repository.CrudRepository;

public interface StarWarsRepository extends CrudRepository<StarWarsPeopleResponseEntity, Integer> {
}

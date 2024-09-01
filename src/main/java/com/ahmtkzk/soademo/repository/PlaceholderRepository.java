package com.ahmtkzk.soademo.repository;

import com.ahmtkzk.soademo.model.placeholder.PlaceholderPostResponseEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlaceholderRepository extends CrudRepository<PlaceholderPostResponseEntity, Integer> {
}

package org.uatransport.repository;

import org.springframework.data.repository.CrudRepository;

public interface GenericPointRepository<T extends Point> extends CrudRepository<T, Integer> {
}

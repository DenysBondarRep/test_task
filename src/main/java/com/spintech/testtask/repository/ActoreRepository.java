package com.spintech.testtask.repository;

import com.spintech.testtask.entity.Actor;
import com.spintech.testtask.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ActoreRepository extends CrudRepository<Actor, Long> {
}

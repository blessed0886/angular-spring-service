package com.zipcodewilmington.angularservice.repository;

import com.zipcodewilmington.angularservice.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by leon on 12/21/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}

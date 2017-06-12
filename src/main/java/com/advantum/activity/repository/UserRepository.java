package com.advantum.activity.repository;

import com.advantum.activity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for User business object.
 *
 * @author José Sevila <josevilah@gmail.com>
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}

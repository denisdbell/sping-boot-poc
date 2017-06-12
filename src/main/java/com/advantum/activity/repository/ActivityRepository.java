package com.advantum.activity.repository;

import com.advantum.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for Activity business object.
 *
 * @author José Sevila <josevilah@gmail.com>
 */
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}

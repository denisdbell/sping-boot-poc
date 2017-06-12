package com.advantum.activity.repository;

import com.advantum.activity.model.ActivityDelay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for the ActivityDelay business object
 *
 * @author José Sevila <josevilah@gmail.com>
 */
public interface ActivityDelayRepository extends JpaRepository<ActivityDelay, Integer> {
}

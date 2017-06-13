package com.advantum.activity.repository;

import com.advantum.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for Activity business object.
 *
 * @author Denis Bell
 */
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}

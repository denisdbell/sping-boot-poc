package com.advantum.activity.repository;

import com.advantum.activity.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for the ActivityType business object
 *
 * @author Denis Bell
 */
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {
}

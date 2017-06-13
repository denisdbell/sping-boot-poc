package com.advantum.activity.repository;

import com.advantum.activity.model.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for the ActivityCategory business object
 *
 * @author Denis Bell
 */
public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Integer> {
}

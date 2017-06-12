package com.advantum.activity.repository;

import com.advantum.activity.model.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for the ActivityCategory business object
 *
 * @author José Sevila <josevilah@gmail.com>
 */
public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Integer> {
}

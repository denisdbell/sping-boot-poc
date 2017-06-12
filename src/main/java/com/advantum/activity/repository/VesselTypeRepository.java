package com.advantum.activity.repository;

import com.advantum.activity.model.VesselType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides CRUD operations for the VesselType business object
 *
 * @author José Sevila <josevilah@gmail.com>
 */
public interface VesselTypeRepository extends JpaRepository<VesselType, Integer> {
}

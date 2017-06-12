package com.advantum.activity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stores information about Vessel Types.
 *
 * Created by Sevila <josevilah@gmail.com> on 14/12/2016.
 */
@Entity
@Table(name = "vessel_type")
public class VesselType {

    /**
     * Identifier of the Vessel Type
     */
    @Id
    @Column(name = "id")
    private Integer vesselTypeId;

    /**
     * Name of the Vessel Type
     */
    private String name;

    public VesselType() {
    }

    public VesselType(Integer vesselTypeId, String name) {
        this.vesselTypeId = vesselTypeId;
        this.name = name;
    }

    public Integer getVesselTypeId() {
        return vesselTypeId;
    }

    public void setVesselTypeId(Integer vesselTypeId) {
        this.vesselTypeId = vesselTypeId;
    }
}

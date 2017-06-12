package com.advantum.activity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Describes the categories for the activities.
 *
 * Created by Sevila <josevilah@gmail.com> on 14/12/2016.
 */
@Entity
@Table(name = "activity_category")
public class ActivityCategory {

    /**
     * Identifier of the Activity Category
     */
    @Id
    @Column(name = "id")
    private Integer activityCategoryId;

    /**
     * Name of the Activity Category
     */
    private String name;

    public ActivityCategory() {

    }

    public ActivityCategory(Integer activityCategoryId, String name) {
        this.activityCategoryId = activityCategoryId;
        this.name = name;
    }

    public Integer getActivityCategoryId() {
        return activityCategoryId;
    }

    public void setActivityCategoryId(Integer activityCategoryId) {
        this.activityCategoryId = activityCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

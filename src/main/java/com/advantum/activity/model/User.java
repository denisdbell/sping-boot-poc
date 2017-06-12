package com.advantum.activity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stores information about an User
 *
 * Created by Sevila <josevilah@gmail.com> on 14/12/2016.
 */
@Entity
@Table(name = "_user")
public class User {

    /**
     * Identifier of the User
     */
    @Id
    @Column(name = "id")
    private Integer userId;

    /**
     * User's username
     */
    private String username;

    public User() {
    }

    public User(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

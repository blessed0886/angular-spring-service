package com.zipcodewilmington.angularservice.model;

import java.io.Serializable;

public class User implements Serializable {

	private Long id;
    private String firstName;

	public User() {}

    public User(Long id, String fname) {
        this.id = id;
        this.firstName = fname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

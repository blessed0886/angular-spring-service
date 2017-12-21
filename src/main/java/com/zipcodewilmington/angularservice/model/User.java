package com.zipcodewilmington.angularservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @Column(name = "id")
	private Long id;
    @Column(name = "firstName")
    private String firstName;

	public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.firstName = name;
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

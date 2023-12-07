package com.site.news.model;

import com.site.news.enums.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends BaseEntity{
    public Admin(Long id, @Email(message = "Email should be valid") String mail, String password, UserType type) {
        super(id, mail, password, type);
    }
}

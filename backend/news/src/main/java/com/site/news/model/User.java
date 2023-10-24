package com.site.news.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("User")
public class User extends BaseEntity {
}

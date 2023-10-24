package com.site.news.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Visitor")
public class Visitor extends BaseEntity{
}

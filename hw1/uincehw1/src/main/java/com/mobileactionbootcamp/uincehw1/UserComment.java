package com.mobileactionbootcamp.uincehw1;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USERCOMMENTS")
public class UserComment {
    @Id
    private long id;

    @Column(name = "COMMENT", length = 500)
    private String comment;

    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @Column(name = "PRODUCTID")
    private long productId;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "FK_ID")
    private User user;
}

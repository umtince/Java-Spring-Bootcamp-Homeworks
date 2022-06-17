package com.mobileactionbootcamp.uincehw1;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "USERS_ID_SEQ")
    @GeneratedValue(generator = "userSeq")
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRSTNAME", length = 50)
    private String firstName;

    @Column(name = "LASTNAME", length = 50)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PHONENUMBER", length = 15)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private boolean isActive;
}

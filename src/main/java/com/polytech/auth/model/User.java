package com.polytech.auth.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 50)
    private String password;

}

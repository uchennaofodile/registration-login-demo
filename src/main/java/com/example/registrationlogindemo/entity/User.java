package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable=false)
    String name;

    @Column(nullable=false, unique=true)
    String email;

    @Column(nullable=false)
    String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="user_roles",
            joinColumns={@JoinColumn(name="USER_ID",referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
     List<Role> roles = new ArrayList<>(); //Stores all role entities associated with a user


}

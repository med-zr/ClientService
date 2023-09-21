package org.operationsix.ClientService.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserTable",uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "email" }) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String username;
    @Column(length = 80,nullable = false)
    private String email;
    @Column(length = 14,nullable = false)
    private String password;
    @Column(nullable = false)
    private int isAdmin;
    @Column(nullable = false)
    private int isActive;

}

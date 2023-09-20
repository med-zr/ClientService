package org.operationsix.ClientService.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User",uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "email" }) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20,nullable = false)
    private String username;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 14,nullable = false)
    private String password;
    @Column(nullable = false)
    private int isAdmin;
    @Column(nullable = false)
    private int isActive;

}

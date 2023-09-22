package org.operationsix.ClientService.models;

import java.time.LocalDateTime;
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
    @Column(nullable = false,columnDefinition = "integer default 1")
    private int isActive;
    @Column(length = 30,nullable = true)
    private LocalDateTime editDate;
    @Column(length = 30,nullable = true)
    private LocalDateTime createDate;
}

package edu.miu.cs425.gameshackhutapp.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name="users")
@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    @NotEmpty(message = "First name is required")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Column(name="last_name")
    private String lastName;

    @NotEmpty(message = "Password is required")
    @JsonIgnore
    private String password;

    private boolean active;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

package fr.piroxxi.ruel_li_2.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.piroxxi.ruel_li_2.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(NON_DEFAULT)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    private String phone;
    private String lang;
    private boolean enabled;
    private boolean isNotLocked;
    private boolean isUsingMFA;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JoinTable
    @ManyToMany
    private Set<Role> roles;

    public void addRole(Role role) {
        if(roles == null){
            roles = new HashSet<>();
        }
        roles.add(role);
    }
}

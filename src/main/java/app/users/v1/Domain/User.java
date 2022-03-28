package app.users.v1.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "phone"),
                @UniqueConstraint(columnNames = "email")
        })
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @Column(name = "uuid")
    private String userId;

    @Column(name = "phone")
    @NotEmpty
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    private String password;

    @Column(name = "role")
    private String role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}

    @Column(name = "authority")
    private String[] authorities;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_not_locked")
    private boolean isNotLocked;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "last_login_date_display")
    private Date lastLoginDateDisplay;
}

package com.educate.skinsnake.domain.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@Setter(AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
public class User {
    @Id
    @GeneratedValue(generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    private Long userId;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;
}

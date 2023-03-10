package com.educate.skinsnake.domain.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TOKENS")
@Setter(AccessLevel.PACKAGE)
//@Builder(access = AccessLevel.PACKAGE)
@Builder
public class Token {
    @Id
    @GeneratedValue(generator = "TOKENS_SEQ")
    @SequenceGenerator(name = "TOKENS_SEQ", sequenceName = "TOKENS_SEQ", allocationSize = 1)
    private Long tokenId;
    @Column(name = "ACCESS_TOKEN", nullable = false)
    private String accessToken;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}

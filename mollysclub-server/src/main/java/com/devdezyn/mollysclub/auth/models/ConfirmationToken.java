package com.devdezyn.mollysclub.auth.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.devdezyn.mollysclub.user.User;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="confirmation_tokens")
public class ConfirmationToken {
  @Id
  @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "confirmation_token_sequence"
  )
  private Long id;

  @Column(nullable = false)
  private String token;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime expiresAt;

  private LocalDateTime confirmedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "user_id")
  private User user;

  public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, User user) {
    this.token = token;
    this.createdAt = createdAt;
    this.expiresAt = expiresAt;
    this.user = user;
  }

}

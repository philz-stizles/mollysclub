package com.devdezyn.mollysclub.auth.token;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.devdezyn.mollysclub.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
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

  @ManyToOne
  @JoinColumn(nullable = false, name = "app_user_id")
  private User appUser;

  public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, User appUser) {
    this.token = token;
    this.createdAt = createdAt;
    this.expiresAt = expiresAt;
    this.appUser = appUser;
  }

}

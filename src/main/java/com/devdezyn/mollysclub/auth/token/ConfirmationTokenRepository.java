package com.devdezyn.mollysclub.auth.token;

import java.time.LocalDateTime;
import java.util.Optional;

import com.devdezyn.mollysclub.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
  Optional<ConfirmationToken> findByToken(String token);

  Optional<ConfirmationToken> findByAppUser(User user);

  @Transactional
  @Modifying
  @Query("UPDATE ConfirmationToken ct " +
          "SET ct.confirmedAt = ?2 " +
          "WHERE ct.token = ?1")
  int updateConfirmedAt(String token, LocalDateTime confirmedAt);
}

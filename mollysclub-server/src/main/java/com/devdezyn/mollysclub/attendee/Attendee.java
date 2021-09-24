package com.devdezyn.mollysclub.attendee;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.devdezyn.mollysclub.shared.models.BaseEntity;
import com.devdezyn.mollysclub.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Attendee extends BaseEntity {
  private User user;
  private String comment;
  private AttendeeStatus status;

  @Builder
  public Attendee(Long id, User user, String comment, AttendeeStatus status) {
    super(id);
    this.user = user;
    this.comment = comment;
    this.status = status;
  }
}

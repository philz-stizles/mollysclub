package com.devdezyn.mollysclub.appointment;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devdezyn.mollysclub.attendee.Attendee;
import com.devdezyn.mollysclub.shared.models.BaseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {
  private Date when;
  private String mandate;
  private Date createdAt;
  private Date updatedAt;
  private AppointmentStatus status;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Attendee> attendees;


  // @OneToOne
  // private Doctor doctor;

  // @OneToOne
  // private Patient patient;


  @Builder
  public Appointment(Long id, Date when, String mandate, Date createdAt, Date updatedAt, AppointmentStatus status,
      List<Attendee> attendees) {
    super(id);
    
    this.when = when;
    this.mandate = mandate;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.attendees = attendees;
  }
}

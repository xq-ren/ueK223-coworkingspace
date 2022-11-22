package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Entity
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  private LocalDateTime bookingTime;

  private String bookingText;

  public enum bookingStatus{
    CONFIRMED(1), PROCESSING(2), DENIED(3);

    private int value;

    private bookingStatus (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getBookingTime() {
    return this.bookingTime;
  }

  public void setBookingTime(LocalDateTime bookingTime) {
    this.bookingTime = bookingTime;
  }

  public String getBookingText() {
    return this.bookingText;
  }

  public void setBookingText(String bookingText) {
    this.bookingText = bookingText;
  }
  
}
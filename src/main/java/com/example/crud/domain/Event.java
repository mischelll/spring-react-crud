package com.example.crud.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event extends BaseEntity{
    @Column(name = "date")
    private Instant date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "events_users",
            joinColumns = {@JoinColumn(name = "event_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> attendees;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(date, event.date) && Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(attendees, event.attendees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, title, description, attendees);
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", attendees=" + attendees +
                '}';
    }
}

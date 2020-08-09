package fr.miage.orleans.modele;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany @JoinColumn(name = "id")
    private User user;
    private String eventName;
    private Date dateStart;
    private Date dateEnd;
    private String eventAddress;
    

    public Event() {
    }

    public Event(Long id, User user, String eventName, Date dateStart, Date dateEnd, String eventAddress) {
        this.id = id;
        this.user = user;
        this.eventName = eventName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.eventAddress = eventAddress;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getEventAddress() {
        return this.eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public Event id(Long id) {
        this.id = id;
        return this;
    }

    public Event user(User user) {
        this.user = user;
        return this;
    }

    public Event eventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Event dateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Event dateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public Event eventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
        return this;
    }

}
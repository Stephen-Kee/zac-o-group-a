package org.launchcode.outdoorEvents.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;


@Entity
public class User extends AbstractEntity{

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @NotNull
    private String username;
    @NotNull
    private String pwHash;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;


//    @OneToMany
//    private List<Event> events;
//
//    @OneToMany
//    private List<Location> locations;

    public User(){};

    public User(String username, String password, String firstName, String lastName, String email /*, List<Event>
    events,
                List<Location> locations*/) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.events = events;
//        this.locations = locations;
    }


//    public List<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<Event> events) {
//        this.events = events;
//    }
//
//        public List<Location> getLocations() {return locations;}
//
//    public void setLocations(List<Location> locations) {this.locations = locations;}

    public String getUsername() {return username; }

    public void setUsername(String username) { this.username = username;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public boolean isMatchingPassword(String password) {return encoder.matches(password, pwHash);}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


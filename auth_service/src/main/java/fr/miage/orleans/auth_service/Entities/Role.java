package fr.miage.orleans.auth_service.Entities;

import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    @ManyToMany(fetch= FetchType.EAGER,mappedBy = "roles")
    @JsonIgnore
    private List < User > users;

    public Role(){

    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List < User > getUsers() {
        return users;
    }

    public void setUsers(List < User > users) {
        this.users = users;
    }
}
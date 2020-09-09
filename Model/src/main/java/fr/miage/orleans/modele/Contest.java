package fr.miage.orleans.modele;

import java.util.Collection;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "userContests")
    private Collection<User> participants;
    private String contestName;
    private Date dateStart;
    private Date dateEnd;
    private Prize prize;
}

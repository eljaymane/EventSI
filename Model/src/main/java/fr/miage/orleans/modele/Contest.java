package fr.miage.orleans.modele;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity()
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "contests")
    private Set<User> users;
    private String contestName;
    private Date dateStart;
    private Date dateEnd;
    @ManyToOne @JoinColumn(name="prize_id" )
    @ElementCollection(targetClass=Prize.class)
    private Prize prize;
    
    public Contest() {
    	
    }
    
	public Contest(Long id, Set<User> participants, String contestName, Date dateStart, Date dateEnd, Prize prize) {
		super();
		this.id = id;
		this.users = participants;
		this.contestName = contestName;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.prize = prize;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<User> getParticipants() {
		return users;
	}
	public void setParticipants(Set<User> participants) {
		this.users = participants;
	}
	public String getContestName() {
		return contestName;
	}
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Prize getPrize() {
		return prize;
	}
	public void setPrize(Prize prize) {
		this.prize = prize;
	}
    
    
}

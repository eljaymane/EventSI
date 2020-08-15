package fr.miage.orleans.modele;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rank {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rankName;
    private Integer rankPoints;


    public Rank() {
    }

    public Rank(Long id, String rankName, Integer rankPoints) {
        this.id = id;
        this.rankName = rankName;
        this.rankPoints = rankPoints;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRankName() {
        return this.rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getRankPoints() {
        return this.rankPoints;
    }

    public void setRankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
    }

    public Rank id(Long id) {
        this.id = id;
        return this;
    }

    public Rank rankName(String rankName) {
        this.rankName = rankName;
        return this;
    }

    public Rank rankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
        return this;
    }


    
}
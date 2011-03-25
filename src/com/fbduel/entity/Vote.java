package com.fbduel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
 
@Entity
@Table(name = "Votes")
public class Vote implements Serializable
{
	private static final long serialVersionUID = -7687166987315313802L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id = null;
 
    @Version
    @Column(name = "version")
    private int version = 0;
    
    @Column(name = "voter_id")
    private String voter;
    
    @Column(name = "candidate1_id")
    private String candidate1;
    
    @Column(name = "candidate2_id")
    private String candidate2;
    
    @Column(name = "winner_id")
    private String winner;
    
    @Column(name = "creation_date", insertable = false, updatable = false)
    private Date creationDate;
 
    public Date getCreationDate() {
		return creationDate;
	}

	public Long getId()
    {
        return id;
    }
 
    public int getVersion()
    {
        return version;
    }

	public String getVoter() {
		return voter;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}

	public String getCandidate1() {
		return candidate1;
	}

	public void setCandidate1(String candidate1) {
		this.candidate1 = candidate1;
	}

	public String getCandidate2() {
		return candidate2;
	}

	public void setCandidate2(String candidate2) {
		this.candidate2 = candidate2;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}
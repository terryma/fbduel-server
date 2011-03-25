package com.fbduel.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.fbduel.entity.Vote;
import com.fbduel.sample.SessionFactoryHelper;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/vote/{voter}/{candidate1}/{candidate2}/{winner}/")
public class VoteResource {

	@GET 
	@Produces("text/plain")
	public String simple(@PathParam("voter") String voter,
			@PathParam("candidate1") String candidate1,
			@PathParam("candidate2") String candidate2,
			@PathParam("winner") String winner
				) {
		Session session = SessionFactoryHelper.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
 
        Vote v = new Vote();
        v.setVoter(voter);
        v.setCandidate1(candidate1);
        v.setCandidate2(candidate2);
        v.setWinner(winner);

        session.save(v);
 
        transaction.commit();
        
		String ret = "";
		ret += "Voter: " + voter + "\n";
		ret += "Candidate1: " + candidate1 + "\n";
		ret += "Candidate2: " + candidate2 + "\n";
		ret += "Winner: " + winner + "\n";
		ret += "ID: " + v.getId() + "\n";
		ret += "Version: " + v.getVersion() + "\n";
		System.out.println(ret);
		return ret;
	}
}
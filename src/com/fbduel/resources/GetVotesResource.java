package com.fbduel.resources;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.fbduel.entity.Vote;
import com.fbduel.sample.SessionFactoryHelper;

@Path("/get-votes")
public class GetVotesResource {

	@GET 
	@Produces("text/html")
	public String simple() {
		Session session = SessionFactoryHelper.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
 
        List<Vote> votes = session.createQuery("from Vote").list();
        String ret = "<table><thead><tr><th>Voter</th><th>Candidate 1</th><th>Candidate 2</th><th>Winnder</th><th>Creation Date</th></tr></thead><tbody>";
        for (Vote v : votes) {
        	ret += "<tr><td>" + v.getVoter() + "</td><td>" + v.getCandidate1() + "</td><td>" + v.getCandidate2() + "</td><td>" + v.getWinner() + "</td><td>" + v.getCreationDate() + "</td></tr>";
        }
        ret += "</tbody></table>";
 
        transaction.commit();

 
		return ret;
	}
}
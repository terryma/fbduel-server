package com.fbduel.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.fbduel.sample.SessionFactoryHelper;

@Path("/remove-votes")
public class RemoveVotesResource {

	@GET 
	@Produces("text/html")
	public String simple() {
		Session session = SessionFactoryHelper.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
 
        int n = session.createQuery("delete from Vote").executeUpdate();
 
        transaction.commit();
        
        return ""+n;
	}
}
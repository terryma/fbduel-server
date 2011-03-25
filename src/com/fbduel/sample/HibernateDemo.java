package com.fbduel.sample;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.fbduel.entity.Vote;
 
public class HibernateDemo
{
    public static void main(String[] args)
    {
        Session session = SessionFactoryHelper.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
 
        Vote v = new Vote();
        v.setVoter("voter");
        v.setCandidate1("candidate1");
        v.setCandidate2("candidate2");
        v.setWinner("winner");

        session.save(v);
 
        transaction.commit();
 
        System.out.println("vote");
        System.out.println("Generated ID is: " + v.getId());
        System.out.println("Generated Version is: " + v.getVersion());
    }
}
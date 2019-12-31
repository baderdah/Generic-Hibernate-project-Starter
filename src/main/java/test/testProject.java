package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import beans.Maladie;
import beans.Patient;
import dao.GenericEntityOperations;

public class testProject {
	
	public static void main(String[] args) {
		GenericEntityOperations entityOp = new GenericEntityOperations();
		Set<Maladie> liste = new HashSet<Maladie>() ;
		Set<Maladie> liste2 = new HashSet<Maladie>() ;
		
		Maladie m1 = new Maladie();
		m1.setName("M1");
		Maladie m2 = new Maladie();
		m2.setName("M2");
		Maladie m3 = new Maladie();
		m3.setName("M3");
		
		liste.add(m1);
		liste.add(m2);
		liste.add(m3);
		
		liste2.add(m1);
		liste2.add(m2);

		Patient p1 = new Patient("p1");
		Patient p2 = new Patient("p2");
		
		p1.setMaladieListe(liste);
		p2.setMaladieListe(liste2);
		System.out.println("here1");
		entityOp.save(p1);
		System.out.println("here2");		
		entityOp.save(p2);
		System.out.println("here3");
		
	}
}

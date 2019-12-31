package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String Name;
	
	@ManyToMany(cascade = {
			CascadeType.MERGE, CascadeType.PERSIST
	})
	@JoinTable(name = "patientMaladies", joinColumns = @JoinColumn(name= "patient_id"),
	inverseJoinColumns = @JoinColumn(name = "maladie_id") )
	Set<Maladie> MaladieListe;
	
	
	public Patient() {
		super();
		MaladieListe = new HashSet<Maladie>();
	}
	public Patient(String name) {
		super();
		MaladieListe = new HashSet<Maladie>();
		Name = name;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Set<Maladie> getMaladieListe() {
		return MaladieListe;
	}
	public void setMaladieListe(Set<Maladie> maladieListe) {
		MaladieListe = maladieListe;
	}
	
	public void addMaladie(Maladie maladie) {
		MaladieListe.add(maladie);
	}
	public void removeMaladie(Maladie maladie) {
		MaladieListe.remove(maladie);
	}
	
	
}

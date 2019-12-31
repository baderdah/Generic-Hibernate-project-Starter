package beans;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Doctor extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;
}

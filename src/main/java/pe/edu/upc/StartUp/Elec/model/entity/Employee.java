package pe.edu.upc.StartUp.Elec.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = " employees",indexes= {@Index(columnList="name",name="employee_index_name")})
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

@Column(name= "name", length = 50,nullable = false)
	private String name;

@Column(name= "dni", length = 8,nullable = false)
	private String dni;

@Column(name= "last_name", length = 50,nullable = false)
	private String lastname;

@Column(name= "email", length = 50,nullable = false)
	private String email;

@Column(name= "image", length = 500)
	private String image;

@OneToMany(mappedBy = "employee")
	private List<Publication> publications;

public Employee() {
	publications =new ArrayList<>();
	
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public List<Publication> getPublications() {
	return publications;
}

public void setPublications(List<Publication> publications) {
	this.publications = publications;
}

}

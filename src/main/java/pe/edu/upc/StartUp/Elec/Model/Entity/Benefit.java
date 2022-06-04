package pe.edu.upc.StartUp.Elec.Model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Benefits")
public class Benefit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "benefits_id", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre no debe estar en blanco")
    @NotNull(message = "El nombre debe contener valor")
    @Size(max = 50, message = "El tamaño no debe ser mayor a 50")
    @Column(name = "benefits_name", length = 50, nullable = false)
    private String name;

    @NotBlank(message = "La descripción no debe estar en blanco")
    @NotNull(message="La descripción debe contener valor")
    @Size(max=200,message="El tamaño no debe ser mayor a 200")
    @Column(name = "benefits_description", length = 200, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}

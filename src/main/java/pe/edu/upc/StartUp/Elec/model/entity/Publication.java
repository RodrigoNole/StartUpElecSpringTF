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
@Table(name = "Publications")
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publication_id", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre no debe estar en blanco")
    @NotNull(message="El nombre debe contener valor")
    @Size(max=100,message="El tamaño no debe ser mayor a 100")
    @Column(name = "publication_name", length = 100, nullable = false)
    private String name;

    @NotBlank(message = "La descripción no debe estar en blanco")
    @NotNull(message="La descripción debe contener valor")
    @Size(max=500,message="El tamaño no debe ser mayor a 500")
    @Column(name = "publication_description", length = 500, nullable = false)
    private String description;

    @Size(max = 500, message = "El tamaño no debe ser mayor a 500")
    @Column(name= "publication_image", length = 500,nullable = false)
    private String image;

    @Size(max=500,message="El tamaño no debe ser mayor a 500")
    @Column(name= "publication_url", length = 500,nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, updatable = false)
    private Employee employee;
}

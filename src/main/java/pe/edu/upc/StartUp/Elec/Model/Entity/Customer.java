package pe.edu.upc.StartUp.Elec.Model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @NotBlank(message = "El DNI no debe estar en blanco")
    @NotNull(message = "El DNI debe contener valor")
    @Size(max = 8, message = "El tamaño no debe ser mayor a 8")
    @Column(name = "customer_dni", length = 8, nullable = false)
    private Integer dni;

    @NotBlank(message = "El nombre no debe estar en blanco")
    @NotNull(message = "El nombre debe contener valor")
    @Size(max = 50, message = "El tamaño no debe ser mayor a 50")
    @Column(name = "customer_first_name", length = 50, nullable = false)
    private String firstName;

    @NotBlank(message = "El apellido no debe estar en blanco")
    @NotNull(message = "El apellido debe contener valor")
    @Size(max = 50, message = "El tamaño no debe ser mayor a 50")
    @Column(name = "customer_last_name", length = 50, nullable = false)
    private String lastName;

    @NotBlank(message = "El email no debe estar en blanco")
    @NotNull(message = "El email debe contener valor")
    @Size(max = 50, message = "El tamaño no debe ser mayor a 50")
    @Column(name = "customer_email", length = 50, nullable = false)
    private String email;

    @Size(max = 500, message = "El tamaño no debe ser mayor a 500")
    @Column(name = "customer_image", length = 500, nullable = false)
    private String image;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Home> homes;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Publication> publications;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TypeCard> typeCards;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Benefit> benefits;

}


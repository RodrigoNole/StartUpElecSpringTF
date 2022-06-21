package pe.edu.upc.StartUp.Elec.Model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TypeCards",indexes = {@Index(columnList = "type_card_number",name="typeCard_index_name")})
public class TypeCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "type_card_id",nullable = false)
    private Integer id;

    @NotBlank(message = "El número de la tarjeta no debe estar en blanco")
    @NotNull(message = "El número de la tarjeta debe contener valor")
    @Size(max = 16, message = "El tamaño no debe ser mayor a 16")
    @Column(name= "type_card_number", length = 16,nullable = false)
    private String number;

    @NotBlank(message = "El CVV de la tarjeta no debe estar en blanco")
    @NotNull(message = "El CVV de la tarjeta debe contener valor")
    @Size(max = 3, message = "El tamaño no debe ser mayor a 3")
    @Column(name= "type_card_cvv", length = 3,nullable = false)
    private String cvv;

    @NotBlank(message = "La fecha de expiración de la tarjeta no debe estar en blanco")
    @NotNull(message = "La fecha de expiración debe contener valor")
    @Size(max = 6, message = "El tamaño no debe ser mayor a 6")
    @Column(name = "type_card_expiration_date", length = 6, nullable = false)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;
}

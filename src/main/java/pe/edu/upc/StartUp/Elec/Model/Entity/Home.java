package pe.edu.upc.StartUp.Elec.Model.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Homes")
public class Home implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "home_id", nullable = false)
    private Integer id;


    @Column(name = "home_address", length = 50, nullable = false)
    private String address;

    @Column(name = "home_description", length = 200, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;

    @OneToOne(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Receipt receipt;
}

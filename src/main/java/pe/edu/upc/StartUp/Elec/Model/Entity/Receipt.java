package pe.edu.upc.StartUp.Elec.Model.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Receipts",indexes = {@Index(columnList = "month",name="receipt_index_name")})
public class Receipt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "receipts_id", nullable = false)
    private Integer id;

    @Column(name = "receipts_month", length = 50, nullable = false)
    private String month;

    @Min(0)
    @Column(name = "receipts_amount", length = 7, nullable = false)
    private Double amount;

    @Column(name = "receipts_description", length = 50, nullable = false)
    private String description;

    @Column(name = "receipts_creation_date", length = 50, nullable = false)
    private Date creationDate;

    @Column(name = "receipts_expiration_date", length = 50, nullable = false)
    private Date expirationDate;

    @JoinColumn(name = "home_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Home home;

}

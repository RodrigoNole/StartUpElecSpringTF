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
@Table(name = "Receipts",indexes = {@Index(columnList = "receipts_month",name="receipt_index_name")})
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

}

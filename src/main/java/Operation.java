import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OPERATION")
public class Operation {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Date */
	@Column(name = "DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	/** Montant */
	@Column(name = "MONTANT", nullable = false)
	private double montant;

	/** Motif */
	@Column(name = "MOTIF", length = 255, nullable = true)
	private String motif;

	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;

	public Operation() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param solde Solde
	 * @param compte Compte
	 */
	public Operation(double montant, Compte compte) {
		super();
		this.date = new Date();
		this.montant = montant;
		this.compte = compte;
	}

	/**
	 * Getter pour l'attribut id
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut date
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter pour l'attribut date
	 *
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Getter pour l'attribut montant
	 *
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter pour l'attribut montant
	 *
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Getter pour l'attribut motif
	 *
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * Setter pour l'attribut motif
	 *
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * Getter pour l'attribut compte
	 *
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * Setter pour l'attribut compte
	 *
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}

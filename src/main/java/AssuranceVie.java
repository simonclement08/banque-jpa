import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Modélise une Assurance vie
 */
@Entity
public class AssuranceVie extends Compte {

	/** Date de fin */
	@Column(name = "DATE_FIN", nullable = false)
	private LocalDate dateFin;
	
	/** Taux */
	@Column(name = "TAUX", nullable = false)
	private double taux;

	/** Constructeur */
	public AssuranceVie() {
		super();
	}
	
	/**
	 * Constructeur
	 *
	 * @param numero Numéro
	 * @param solde Solde
	 * @param dateFin Dete de fin
	 * @param taux Taux
	 */
	public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	/**
	 * Getter pour l'attribut dateFin
	 *
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter pour l'attribut dateFin
	 *
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter pour l'attribut taux
	 *
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * Setter pour l'attribut taux
	 *
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}

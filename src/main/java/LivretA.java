import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Modélise un Livret A
 */
@Entity
public class LivretA extends Compte {
	
	/** Taux */
	@Column(name = "TAUX", nullable = false)
	private double taux;

	/** Constructeur */
	public LivretA() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param numero Numéro
	 * @param solde Solde
	 * @param taux
	 */
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
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

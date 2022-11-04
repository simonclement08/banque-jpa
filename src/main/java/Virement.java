import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Modélise un virement
 */
@Entity
public class Virement extends Operation {

	/** Bénéficiare */
	@Column(name = "BENEFICIAIRE", nullable = false)
	private String beneficiare;

	public Virement() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param solde       Solde
	 * @param compte      Compte
	 * @param beneficiare
	 */
	public Virement(double montant, Compte compte, String beneficiare) {
		super(montant, compte);
		this.beneficiare = beneficiare;
	}

	/**
	 * Getter pour l'attribut beneficiare
	 *
	 * @return the beneficiare
	 */
	public String getBeneficiare() {
		return beneficiare;
	}

	/**
	 * Setter pour l'attribut beneficiare
	 *
	 * @param beneficiare the beneficiare to set
	 */
	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}

}

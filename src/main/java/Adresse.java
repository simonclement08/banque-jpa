import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	/** Numéro */
	@Column(name = "NUMERO", nullable = false)
	private int numero;

	/** Rue */
	@Column(name = "RUE", length = 250, nullable = false)
	private String rue;

	/** Code postal */
	@Column(name = "CODE_POSTAL", length = 5, nullable = false)
	private String codePostal;

	/** Ville */
	@Column(name = "VILLE", length = 50, nullable = false)
	private String ville;

	/** Constructeur */
	public Adresse() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param numero Numéro de ville
	 * @param rue Rue
	 * @param codePostal Code postal
	 * @param ville Ville
	 */
	public Adresse(int numero, String rue, String codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * Getter pour l'attribut numero
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Setter pour l'attribut numero
	 *
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Getter pour l'attribut rue
	 *
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter pour l'attribut rue
	 *
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter pour l'attribut codePostal
	 *
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter pour l'attribut codePostal
	 *
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter pour l'attribut ville
	 *
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour l'attribut ville
	 *
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}

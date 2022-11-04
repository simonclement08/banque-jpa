import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe Compte qui peut être un LivretA ou une AssuranceVie
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "COMPTE")
public class Compte {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Numéro */
	@Column(name = "NUMERO", length = 25, nullable = false)
	private String numero;

	/** Solde */
	@Column(name = "SOLDE", nullable = false)
	private double solde;

	/** Liste des opérations */
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations = new ArrayList<Operation>();

	/** Liste des clients */
	@ManyToMany
	@JoinTable(name = "CLIENT_COMPTE",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_CLIENT", "ID_COMPTE" })},
		joinColumns = { @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID")},
		inverseJoinColumns = { @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")}
	)
	private List<Compte> comptes = new ArrayList<Compte>();

	/** Constructeur */
	public Compte() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param numero Numéro
	 * @param solde Solde
	 */
	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
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
	 * Getter pour l'attribut numero
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Setter pour l'attribut numero
	 *
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Getter pour l'attribut solde
	 *
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * Setter pour l'attribut solde
	 *
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * Getter pour l'attribut operations
	 *
	 * @return the operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * Getter pour l'attribut comptes
	 *
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return comptes;
	}

}

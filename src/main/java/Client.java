import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLIENT")
public class Client {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Nom */
	@Column(name = "NOM", length = 20, nullable = false)
	private String nom;

	/** Prénom */
	@Column(name = "PRENOM", length = 20, nullable = false)
	private String prenom;

	/** Date de naissance */
	@Column(name = "DATE_NAISSANCE", nullable = false)
	private LocalDate dateNaissance;
	
	/** Adresse */
	@Embedded
	private Adresse adresse;

	/** Banque */
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	private Banque banque;

	/** Liste des comptes */
	@ManyToMany
	@JoinTable(name = "CLIENT_COMPTE",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_CLIENT", "ID_COMPTE" })},
		joinColumns = { @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")},
		inverseJoinColumns = { @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID")}
	)
	private List<Compte> comptes = new ArrayList<Compte>();

	public Client() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param nom Nom
	 * @param prenom Prénom
	 * @param dateNaissance Date de naissance
	 * @param adresse Adresse
	 * @param banque Banque
	 */
	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
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
	 * Getter pour l'attribut nom
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour l'attribut nom
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour l'attribut prenom
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour l'attribut prenom
	 *
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour l'attribut dateNaissance
	 *
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour l'attribut dateNaissance
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour l'attribut adresse
	 *
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter pour l'attribut adresse
	 *
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter pour l'attribut banque
	 *
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * Setter pour l'attribut banque
	 * 
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class Banque {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Nom */
	@Column(name = "NOM", length = 25, nullable = false)
	private String nom;

	/** Liste des clients */
	@OneToMany(mappedBy = "banque")
	List<Client> clients = new ArrayList<Client>();

	/** Constructeur */
	public Banque() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param nom Nom
	 */
	public Banque(String nom) {
		super();
		this.nom = nom;
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
	 * Getter pour l'attribut clients
	 *
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

}

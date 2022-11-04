import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertionBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		
		Banque creditMutuel = new Banque("Crédit Mutuel");
		em.persist(creditMutuel);
		
		Banque creditAgricole = new Banque("Crédit Agricole");
		em.persist(creditAgricole);
		
		Compte compte1 = new Compte("FR784546886", 1578.54);
		em.persist(compte1);
		Operation op1 = new Operation(20, compte1);
		em.persist(op1);
		
		Compte compte2 = new Compte("FR725474133", 1378.74);
		em.persist(compte2);
		Operation op2 = new Operation(100, compte2);
		em.persist(op2);
		Operation op3 = new Operation(50, compte2);
		em.persist(op3);
		
		Compte compte3 = new Compte("FR754546784", 10578.89);
		em.persist(compte3);
		Operation op4 = new Operation(30, compte3);
		em.persist(op4);
		
		Client clementSimon = new Client("SIMON", "Clément", LocalDate.of(2000, 8, 2), creditMutuel);
		clementSimon.getComptes().add(compte1);
		clementSimon.getComptes().add(compte3);
		Adresse adresse1 = new Adresse(130, "route nationale", "08160", "Dom le Mesnil");
		clementSimon.setAdresse(adresse1);
		em.persist(clementSimon);
		
		Client pascalFerat = new Client("Ferat", "Pascal", LocalDate.of(1975, 12, 1), creditAgricole);
		pascalFerat.getComptes().add(compte2);
		Adresse adresse2 = new Adresse(5, "rue du Moulin", "51100", "Reims");
		pascalFerat.setAdresse(adresse2);
		em.persist(pascalFerat);
		
		transaction.commit();

	}

}

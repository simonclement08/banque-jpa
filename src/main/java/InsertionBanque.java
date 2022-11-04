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


		Adresse adresse1 = new Adresse(130, "route nationale", "08160", "Dom le Mesnil");
		Client clementSimon = new Client("SIMON", "Clément", LocalDate.of(2000, 8, 2), adresse1, creditMutuel);
		em.persist(clementSimon);

		Adresse adresse2 = new Adresse(5, "rue du Moulin", "51100", "Reims");
		Client pascalFerat = new Client("Ferat", "Pascal", LocalDate.of(1975, 12, 1), adresse2, creditAgricole);
		em.persist(pascalFerat);
		
		Compte compte1 = new Compte("FR784546886", 1578.54);
		em.persist(compte1);
		Operation op1 = new Operation(20, compte1);
		em.persist(op1);
		
		clementSimon.getComptes().add(compte1);
		pascalFerat.getComptes().add(compte1);

		Compte compte2 = new LivretA("FR725474133", 1378.74, 0.1);
		em.persist(compte2);
		
		clementSimon.getComptes().add(compte2);

		Compte compte3 = new AssuranceVie("FR754546784", 10578.89, LocalDate.of(2024, 10, 31), 0.1);
		em.persist(compte3);
		
		clementSimon.getComptes().add(compte3);
		
		Operation op4 = new Operation(30, compte3);
		em.persist(op4);
		Operation vir = new Virement(30, compte3, "Gauthier");
		em.persist(vir);

		transaction.commit();

	}

}

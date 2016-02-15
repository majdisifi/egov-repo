package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.GreyCard;



@Stateless
public class GreyCardManagement implements IGreyCardManagementRemote {
	@PersistenceContext
	EntityManager Us;

	public void addGreyCard(GreyCard gc) {
		Us.persist(gc);
	}

	public void flush() {
		Us.flush();
	}

	public void update(GreyCard gc) {
		Us.merge(gc);

	}

	public void remove(GreyCard gc) {

		Us.remove(Us.merge(gc));

	}

	@Override
	public GreyCard findByidGreyCard(int idGreyCard) {
		Us.find(GreyCard.class, idGreyCard);
		return null;
	}
	
	@Override
	public GreyCard findByid (int id) {
		Us.find(GreyCard.class, id);
		return null;
	}

	@Override
	public List<GreyCard> findAll() {
		List<GreyCard> cards = new ArrayList<>();
		cards= (List<GreyCard>) Us.createQuery("select gc from GreyCard gc").getResultList();
		return cards;
	}
	
}

package sessionbeans;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.GreyCard;

@Remote
public interface IGreyCardManagementRemote {

	void addGreyCard(GreyCard gc );

	GreyCard findByidGreyCard(int idGreyCard);
	GreyCard findByid(int id);
	

	void update(GreyCard gc);

	void flush();

	void remove(GreyCard gc);

	List<GreyCard> findAll();

	

}

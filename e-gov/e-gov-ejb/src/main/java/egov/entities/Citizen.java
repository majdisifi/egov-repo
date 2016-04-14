package egov.entities;

import egov.entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Citizen
 *
 */
@Entity

public class Citizen extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Citizen() {
		super();
	}
   
}

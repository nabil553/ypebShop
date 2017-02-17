package come.ypeb.model.manager.role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import come.ypeb.model.manager.Manager;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "ypeb")
public class Role extends AbstractRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String name, Boolean super_, Boolean shopWeb, Boolean points,
			Boolean member, Boolean order, Boolean message, Boolean seeting,
			Integer trade) {
		super(name, super_, shopWeb, points, member, order, message, seeting,
				trade);
	}

	/** full constructor */
	public Role(String name, Boolean super_, Boolean shopWeb, Boolean points,
			Boolean member, Boolean order, Boolean message, Boolean seeting,
			Integer trade, Boolean isDelete, Set<Manager> managers) {
		super(name, super_, shopWeb, points, member, order, message, seeting,
				trade, isDelete, managers);
	}

}

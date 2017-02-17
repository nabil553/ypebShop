package come.ypeb.model.manager;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import come.ypeb.model.manager.role.Role;

/**
 * AbstractManager entity provides the base persistence definition of the
 * Manager entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractManager implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private String name;
	private String realName;
	private String telephone;
	private Boolean isDelete;
	private String password;

	// Constructors

	/** default constructor */
	public AbstractManager() {
	}

	/** minimal constructor */
	public AbstractManager(Role role, String name, String realName,
			String telephone, String password) {
		this.role = role;
		this.name = name;
		this.realName = realName;
		this.telephone = telephone;
		this.password = password;
	}

	/** full constructor */
	public AbstractManager(Role role, String name, String realName,
			String telephone, Boolean isDelete, String password) {
		this.role = role;
		this.name = name;
		this.realName = realName;
		this.telephone = telephone;
		this.isDelete = isDelete;
		this.password = password;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "realName", nullable = false, length = 45)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "telephone", nullable = false, length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "isDelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
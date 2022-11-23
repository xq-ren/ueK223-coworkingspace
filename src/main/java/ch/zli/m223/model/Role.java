package ch.zli.m223.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    private String roleName;

    @OneToMany 
    private List<AppUser> auser;

	public List<AppUser> getUsers() {
		return this.auser;
	}

	public void setUsers(List<AppUser> auser) {
		this.auser = auser;
	}


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

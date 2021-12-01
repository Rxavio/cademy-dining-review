package net.dining.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "username")
    private String userName;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "post_code")
    private String postCode;
    
    @Column(name = "peanut_allergy")
    private boolean isPeanutAllergy;
    
    @Column(name = "egg_allergy")
    private boolean isEggAllergy;
    
    @Column(name = "dairy_allergy")
    private boolean isDairyAllergy;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public boolean isPeanutAllergy() {
		return isPeanutAllergy;
	}

	public void setPeanutAllergy(boolean isPeanutAllergy) {
		this.isPeanutAllergy = isPeanutAllergy;
	}

	public boolean isEggAllergy() {
		return isEggAllergy;
	}

	public void setEggAllergy(boolean isEggAllergy) {
		this.isEggAllergy = isEggAllergy;
	}

	public boolean isDairyAllergy() {
		return isDairyAllergy;
	}

	public void setDairyAllergy(boolean isDairyAllergy) {
		this.isDairyAllergy = isDairyAllergy;
	}
    

  }

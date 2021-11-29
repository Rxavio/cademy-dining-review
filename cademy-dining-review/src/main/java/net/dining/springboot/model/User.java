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
    private Long id;
    
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

  }

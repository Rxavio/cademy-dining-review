package net.dining.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurent")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "post_code")
    private String postcode;
    
    @Column(name = "zip_code")
    private String zipCode;
    
    @Column(name = "cuisine")
    private String cuisine;
}

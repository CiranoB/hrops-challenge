package cirano.hrops.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String streetLine;

    @NotNull
    private int postCode;


    private int number;

    @NotNull
    private String city;

    @NotNull
    private boolean isMain;

//    @ManyToOne
//    @JsonIgnoreProperties("user")
//    private User user;

}

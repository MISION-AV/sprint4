package edu.udea.sprint4.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "enterprise")
public class Enterprise {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 70, unique = true)
    private  String name;

    @Column(name = "document", nullable = false, length = 15, unique = true)
    private String document;

    @Column(name = "phone", nullable = true, length = 10)
    private String phone;

    @Column(name = "address", nullable = true, length = 70)
    private String address;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "update_at")
    private LocalDate updateAt;

}

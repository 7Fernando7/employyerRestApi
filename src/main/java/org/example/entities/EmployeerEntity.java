package org.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEER")
public class EmployeerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEER_ID")
    private int id;

    @Column(name = "EMPLOYEER_NAME")
    private String name;

    @Column(name = "EMPLOYEER_AGE")
    private int age;

    @Column(name = "EMPLOYEER_SALARY")
    private Double salary;

    @Column(name = "EMPLOYEER_POSITION")
    private String position;
}

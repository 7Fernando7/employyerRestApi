package org.example.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeerDTO implements Serializable {

    private int id;

    private String name;

    private int age;

    private Double salary;

    private String position;

}

package com.srs.REST.API.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity // specifies that class is jpa entity
@Table(name = "employee") // to set table name other than EmployeeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id // to generate Id automatically
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;
}

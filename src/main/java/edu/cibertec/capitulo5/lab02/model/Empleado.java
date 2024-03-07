package edu.cibertec.capitulo5.lab02.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@ToString
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "salario", precision = 10, scale = 2)
    private BigDecimal salario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaIngreso")
    private LocalDate fechaIngreso;

    @ManyToOne
    private Departamento departamento;

}

package com.augusto.beltexam.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="boards")
@NoArgsConstructor
@Getter
@Setter
public class Board extends BaseModel{

    @NotNull
    @NotBlank(message = "No puede estar vacio.")
    @Size(min=2, message = "El nombre del invitado debe tener minimo 2 caracteres.")
    private String guestName;

    @Range(min = 1, max = 10, message = "El número de invitados debe estar entre 1 y 10.")
    private int numberOfGuests;
    
    private String note;

    @ManyToOne
    @JoinColumn(name = "waitstaff_id")
    private Waitstaff waitstaff;
}

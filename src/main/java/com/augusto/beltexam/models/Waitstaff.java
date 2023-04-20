package com.augusto.beltexam.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="waitstaffs")
@NoArgsConstructor
@Getter
@Setter
public class Waitstaff extends BaseModel{

    @NotNull
    @NotBlank(message = "No puede estar vacio.")
    private String name;

    @NotNull(message = "No puede estar vacio.")
    @Email(message = "El email no tiene el formato correcto.")
    private String email;

    @NotNull
    @Size(min=8,max=200,message = "La contraseña dene tener entre 8 y 20 caracteres")
    private String password;

    @Transient
    private String passwordConfirmation;

    @OneToMany(mappedBy = "waitstaff", fetch = FetchType.LAZY)
    private List<Board> boards;
}

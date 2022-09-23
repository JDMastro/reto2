package com.reto.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


/**
 * Esta clase Representa la entidad users
 *
 * @version 1.0.0 2022-09-23
 * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
 * @since 1.0.0
 */
@Data
@Document("users")
public class Users {

    /**
     * Identificador del usuario
     */
    @Id
    private String id;

    /**
     * nombre del usuario
     */
    @NotNull(message = "El nombre del usuario es requerido")
    private String name;

    /**
     * apellidos del usuario
     */
    @NotNull(message = "los apellidos del usuario es requerido")
    private String surName;

    /**
     * tipo de documento del usuario
     */
    @NotNull(message = "El tipo de documento del usuario es requerido")
    private String documentType;

    /**
     * documento del usuario
     */
    @Indexed(unique = true)
    @NotNull(message = "El documento del usuario es requerido")
    private String document;

    /**
     * correo del usuario
     */
    @Indexed(unique = true, sparse=true)
    @NotNull(message = "El email del usuario es requerido")
    @Email(message = "Coloque un correo valido")
    private String email;

    /**
     * ciudad del usuario
     */
    @NotNull(message = "la ciudad del usuario es requerido")
    private String city;

    /**
     * nivel del usuario
     */
    @NotNull(message = "El nivel del usuario es requerido")
    private String level;

    /**
     * estado del usuario
     */
    @NotNull(message = "El estado del usuario es requerido")
    private boolean state;
}

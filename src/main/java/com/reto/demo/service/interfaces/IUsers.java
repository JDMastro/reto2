package com.reto.demo.service.interfaces;


import com.reto.demo.domain.Users;

import java.util.List;
import java.util.Optional;

/**
 * Interface para el servicio de UsersService
 *
 * @version 1.0.0 2022-09-23
 * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
 * @since 1.0.0
 */
public interface IUsers {
    /**
     * Es para obtener todos los usuarios
     * @return Un listado de usuarios del sistema
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    List<Users> getAllUsers();

    /**
     * Es para obtener un usuario en especifico
     * @param id Representa el identificador del usuario
     * @return Un usuarios del sistema
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    Optional<Users> getUser(String id);

    /**
     * Es para guarda o actualiza a un usuario en el sistema
     * @param users Representa el usuario que se va a guardar
     * @return El contacto que se guardó en el sistema
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    Users saveOrUpdateUser(Users users);

    /**
     * Es para borrar al usuario del sistema, borrado fisico
     * @param id Representa el identificador del usuario
     */
    void deleteUser(String id);
}

package com.reto.demo.controller;


import com.reto.demo.domain.Users;
import com.reto.demo.service.UsersService;
import com.reto.demo.utility.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Controlador para los usuarios
 *
 * @version 1.0.0 2022-09-23
 * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
 * @since 1.0.0
 */
@Slf4j
@RestController
public class UsersController {
    /**
     * Servicio para el manejo de los usuarios
     */
    @Autowired
    private UsersService usersService;

    /**
     * Variable para el manejo de las respuestas de las API
     */
    private Response response = new Response();

    /**
     * Manejo del código HTTP que se responde en las API
     */
    private HttpStatus httpStatus = HttpStatus.OK;

    /**
     * Index del sistema, responde con el listado de usuarios
     * @return Objeto Response en formato JSON
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    @GetMapping(path = "/api/v1/getall")
    public ResponseEntity<Response> index() {
        response.restart();
        try {
            response.data = usersService.getAllUsers();
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * getall del sistema, responde con un usuario especifico
     * @return Objeto Response en formato JSON
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    @GetMapping(path = "/api/v1/get/{id}")
    public ResponseEntity<Response> getAll(@PathVariable(value="id") String id) {
        response.restart();
        try {
            response.data = usersService.getAllUsers();
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Crea un usuario en el sistema
     * @param users Objeto Contacto a crear o actualizar
     * @return Objeto Response en formato JSON
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    @PostMapping(path = "/api/v1/create")
    public ResponseEntity<Response> createUsers(@RequestBody Users users) {
        response.restart();
        try {
            log.info("Usuario a crear: {}", users);
            response.data = usersService.saveOrUpdateUser(users);
            httpStatus = HttpStatus.CREATED;
        } catch (DuplicateKeyException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Actualiza un usuario en el sistema
     * @param users Objeto Contacto a crear o actualizar
     * @return Objeto Response en formato JSON
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    @PutMapping(path = "/api/v1/update")
    public ResponseEntity<Response> updateUsers(@RequestBody Users users) {
        response.restart();
        try {
            log.info("Usuario a update: {}", users);
            response.data = usersService.saveOrUpdateUser(users);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Borra un usuario del sistema
     * @param id Identificador del usuario a borrar
     * @return Objeto Response en formato JSON
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * since 1.0.0
     */
    @DeleteMapping(path = "/api/v1/delete/{id}")
    public ResponseEntity<Response> deleteUsers(@PathVariable(value="id") String id) {
        response.restart();
        try {
            usersService.deleteUser(id);
            response.data = id;
            if (response.data == null) {
                response.message = "El usuario no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El usuario fue removido exitosamente";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity(response, httpStatus);
    }

    /**
     * Administrador para las excepciones del sistema
     * @param exception Objeto Exception
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Administrador para las excepciones a nivel de SQL con respecto al manejo del acceso a los datos
     * @param exception Objeto DataAccessException
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        response.message = exception.getLocalizedMessage();

    }

}

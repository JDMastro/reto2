package com.reto.demo.utility;


/**
 * Clase para el manejo de las respuestas de las API
 *
 * @version 1.0.0 2022-09-23
 * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
 * @since 1.0.0
 */
public class Response {
    /**
     * Indica de si existe un error o no en la respuesta del API
     */
    public Boolean error;

    /**
     * Mensaje del API cuando es utilizada
     */
    public String message;

    /**
     * Información del API cuando es necesario
     */
    public Object data;

    /**
     * Constructor de la clase
     *
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    public Response() {
        error = false;
        message = "";
        data = null;
    }

    /**
     * Restaura a ceros la respuesta del API
     *
     * @author Jaime David Mastrodomenico Lopez <jdmlmastro9506@gmail.com>
     * @since 1.0.0
     */
    public void restart() {
        error = false;
        message = "";
        data = null;
    }
}

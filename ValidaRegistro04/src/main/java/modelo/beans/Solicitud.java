package modelo.beans;

import java.io.Serializable;

public class Solicitud implements Serializable {
    private String login;
    private String clave;
    private String email;
    private String nombreApellidos;

    public Solicitud( String login, String clave, String email, String nombreApellidos) {
        this.login=login;
        this.clave = clave;
        this.email = email;
        this.nombreApellidos = nombreApellidos;
    }

    public String getClave() {
        return clave;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return login+":"+clave+":"+email+":"+nombreApellidos;
    }
}

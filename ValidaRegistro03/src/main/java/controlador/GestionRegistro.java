package controlador;

import modelo.beans.ListaSolicitudes;
import modelo.beans.Solicitud;
import modelo.procesos.VerificacionSolicitud;
import vista.UtilidadesES;

import java.io.*;

import static controlador.ColorTexto.RESET;
import static controlador.ColorTexto.ROJO;
import static controlador.ColorTexto.VERDE;

public class GestionRegistro {
    private final VerificacionSolicitud verificacionSolicitud;
    private final UtilidadesES utilES;
    private final ListaSolicitudes solicitudesValidas;

    public GestionRegistro(UtilidadesES utilES, VerificacionSolicitud verificacionSolicitud) {
        this.utilES = utilES;
        solicitudesValidas = new ListaSolicitudes();
        this.verificacionSolicitud= verificacionSolicitud;
    }

    public void leerarchivo(File archivo)throws IOException {
        String[] campos;
        String lineaArchivo;

        if (archivo.exists()) {
            if (archivo.canRead()) {
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                    while ((lineaArchivo = br.readLine()) != null) {
                        campos = lineaArchivo.split(":", -1);

                        if (campos.length == 4) {

                            Solicitud solicitud = new Solicitud(campos[0], campos[1], campos[2], campos[3]);
                            validarRegistro(solicitud);

                        }else{
                            utilES.mostrarMensajeln(ROJO + "Solicitud inválida: " + RESET + "Número inválidos de campos en la solicitud");
                        }
                    }
                } catch (IOException IOE) {
                    throw new IOException("Fallo en la lectura del archivo");
                }
            } else {
                utilES.mostrarMensajeln("El archivo no se puede leer");
            }
        } else {
            utilES.mostrarMensajeln("El archivo no existe");
        }
    }


    public String nombrarArchivo() throws IOException {
        String nombreArchivo;
        try {
            do {
                nombreArchivo = utilES.pedirCadena("Introduce el nombre del archivo: ");

                if (!nombreArchivo.endsWith(".txt")) {
                    nombreArchivo = nombreArchivo + ".txt";
                }
                if (verificacionSolicitud.contarCaracter(nombreArchivo, '.') != 1) {
                    utilES.mostrarMensajeln("El archivo solo puede llevar una extensión: .txt");
                }
            } while (verificacionSolicitud.contarCaracter(nombreArchivo, '.') != 1);

        } catch (IOException IOE) {
            throw new IOException();
        }
        return nombreArchivo;
    }


    public void validarRegistro(Solicitud solicitud) {

        if (verificacionSolicitud.verificarSolicitud(solicitud)&&!solicitudesValidas.loginDuplicado(solicitud)) {
            solicitudesValidas.putSolicitud(solicitud);
            utilES.mostrarMensajeln(VERDE + "Solicitud válida: " + RESET + solicitud);
        } else {
            utilES.mostrarMensajeln(ROJO + "Solicitud inválida: " + RESET + solicitud);
            utilES.mostrarMensajeln("   (Hay campos con menos de "
                    + verificacionSolicitud.getCaracteresMinimos() + " caracteres, " +
                    "el correo no contiene un único @ o el login está duplicado)");
        }
    }


    public void serializarRegistro(File nuevoArchivo) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nuevoArchivo))) {
            oos.writeObject(solicitudesValidas);
            utilES.mostrarMensajeln(VERDE + "Solicitudes serializadas correctamente en: " + RESET + nuevoArchivo.getName());

        } catch (IOException ioe) {
            throw new IOException("Error en la grabación serializada del archivo", ioe);
        }
    }

    public ListaSolicitudes getSolicitudesValidas() {
        return solicitudesValidas;
    }
}

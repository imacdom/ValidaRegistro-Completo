package controlador;

import modelo.beans.ListaSolicitudes;
import modelo.beans.Solicitud;
import modelo.procesos.VerificacionSolicitud;
import vista.UtilidadesES;

import java.io.*;

import static controlador.ColorTexto.*;

public class Programa {
    private ListaSolicitudes listaSolicitudes;
    private VerificacionSolicitud verificacionSolicitud;
    UtilidadesES utilES;

    public void ejecutar()throws IOException {
        utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        File archivo;
        String nombreArchivo;
        listaSolicitudes = new ListaSolicitudes();
        verificacionSolicitud = new VerificacionSolicitud();
        String[] campos;
        String lineaArchivo;

        nombreArchivo = nombrarArchivo();
        archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            if (archivo.canRead()) {
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                    while ((lineaArchivo = br.readLine()) != null) {
                        campos = lineaArchivo.split(":", -1);
                        if (campos.length == 4) {

                            Solicitud solicitud = new Solicitud(campos[0], campos[1], campos[2], campos[3]);

                            if (verificacionSolicitud.verificarSolicitud(solicitud)) {
                                listaSolicitudes.putSolicitud(solicitud);
                                utilES.mostrarMensajeln(VERDE+"Solicitud añadidia: "+RESET+solicitud);
                            }else{
                                utilES.mostrarMensajeln(ROJO+"Solicitud inválida: "+RESET+ solicitud);
                                utilES.mostrarMensajeln("   (Hay campos con menos de "
                                        + verificacionSolicitud.getCaracteresMinimos()+ " caracteres " +
                                        "o el correo no contiene un único @)" );
                            }
                        }else{
                            utilES.mostrarMensajeln(ROJO+"Solicitud inválida: "+RESET+"Faltan campos en la solicitud");
                        }
                    }

                } catch (IOException IOE) {
                    throw new IOException("Fallo en la lectura del archivo");
                }
            }else{
                utilES.mostrarMensajeln("El archivo no se puede leer");
            }
        }else{
            utilES.mostrarMensajeln("El archivo no existe");
        }
    }

    private String nombrarArchivo()throws IOException{
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

        }catch (IOException IOE){
            throw new IOException();
        }
        return nombreArchivo;
    }
}

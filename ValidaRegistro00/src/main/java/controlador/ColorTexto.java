package controlador;

// He decidido añadir color a las solicitudes válidas e inválidas para practicar con los enums.

public enum ColorTexto {
    ROJO ("\u001B[31m"),
    VERDE ("\u001B[32m"),
    RESET ("\u001B[0m");

    private String color;

    ColorTexto(String color) {
        this.color=color;
    }

    @Override
    public String toString() {
        return color;
    }
}

public class Contacto {

    private String Nombre;
    private String Apellidos;
    private String Numero;
    private String Correo;

    public Contacto(String nombre, String apellidos, String numero, String correo) {
        Nombre = nombre;
        Apellidos = apellidos;
        Numero = numero;
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public void validarNombre(){
        if (Nombre.isBlank())
            throw new RuntimeException("El nombre no puede estar en blanco");
    }

    public void validarApellidos(){
        if (Apellidos.isBlank())
            throw new RuntimeException("El apellido no puede estar en blanco");
    }

    public void validarNumero(){
        if (Numero.isBlank())
            throw new RuntimeException("El numero no puede estar en blanco");
        if (Numero.length() != 8)
            throw new RuntimeException("El numero debe ser de 8 digitos");
        if (!Numero.matches("\\d+"))
            throw new RuntimeException("El numero no puede contener letras");

    }

    public void validarCorreo(){
        if (Correo.isBlank())
            throw new RuntimeException("El correo no puede estar en blanco");
        if (!Correo.matches(".*[@].*"))
            throw new RuntimeException("Esta no parece ser una direccion de correo");

    }
}

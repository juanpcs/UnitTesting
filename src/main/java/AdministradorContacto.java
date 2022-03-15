import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdministradorContacto {
    Map<String, Contacto> ListaContactos = new ConcurrentHashMap<String, Contacto>();

    public void agregarContacto(String nombre, String apellido, String numero, String correo){
        Contacto contacto = new Contacto(nombre, apellido, numero, correo);
        validarContacto(contacto);
        validarExistenciaContacto(contacto);
        ListaContactos.put(generarClave(contacto), contacto);
    }

    public Collection<Contacto> obtenerContactos(){
        return ListaContactos.values();
    }

    private void validarExistenciaContacto(Contacto contacto){
        if (ListaContactos.containsKey(generarClave(contacto)))
            throw new RuntimeException("El contacto ya existe");
    }

    private void validarContacto(Contacto contacto) {
        contacto.validarNombre();
        contacto.validarApellidos();
        contacto.validarNumero();
        contacto.validarCorreo();
    }

    private String generarClave(Contacto contacto) {
        return String.format("%s-%s", contacto.getNombre(), contacto.getApellidos());
    }
}

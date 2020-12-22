package com.tareas.model;
import com.tareas.excepciones.DBEException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DB {

    private static Set<Tarea> tareas;
    private static Set<Usuario> usuarios;
    private static int ultimoKey = 0;

    static {

        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("martinlopez@hotmail.com", "martin0lopez", "", "Lopez"));
        usuarios.add(new Usuario("miriamhernandez@hotmail.com", "miriam0hernandez", "Miriam", "Hernandez"));
        usuarios.add(new Usuario("lucreciagonzales@hotmail.com", "lucrecia0gonzalez", "Lucrecia", "Gonzalez"));
        usuarios.add(new Usuario("isabelahecheverria@hotmail.com", "isabela0hecheverria", "Isabela", "Hecheverria"));
        usuarios.add(new Usuario("gonzalocampeador@hotmail.com", "gonzalo0campeador", "Gonzalo", "Campeador"));

        tareas = new HashSet<Tarea>();
        tareas.add(new Tarea("Reunión ejecutiva", "Reunión en la sala de juntas 1", "martinlopez@hotmail.com"));
        tareas.add(new Tarea("Reunión ejecutiva", "Reunión en la sala de juntas 1", "miriamhernandez@hotmail.com"));
        tareas.add(new Tarea("Reunión ejecutiva", "Reunión en la sala de juntas 1", "lucreciagonzales@hotmail.com"));
        tareas.add(new Tarea("Reunión ejecutiva", "Reunión en la sala de juntas 1", "isabela0hecheverria"));
        tareas.add(new Tarea("Reunión ejecutiva", "Reunión en la sala de juntas 1", "gonzalocampeador@hotmail.com"));
        tareas.add(new Tarea("Entrega Facturas Enero", "Entrega de facturas a administración", "martinlopez@hotmail.com"));
        tareas.add(new Tarea("Organizació productiva mensual Enero", "Organización temporal de recursos de producción", "miriamhernandez@hotmail.com"));
        tareas.add(new Tarea("Despacho aduanas", "Envío de documentación para el despacho de aduanas", "lucreciagonzales@hotmail.com"));
        tareas.add(new Tarea("Solicitud pagos", "Solicitud pagos fin de año 2020", "isabela0hecheverria"));
        tareas.add(new Tarea("Compra material", "Compra material para producción trimestral", "gonzalocampeador@hotmail.com"));
    }

    private DB() {
    }

    //METODOS TAREAS
    
    /**
     * get
     * @return 
     */
    public static synchronized Collection<Tarea> getTareas() {
        return tareas;
    }

    /**
     * add
     * @param tarea
     * @throws DBEException 
     */
    public static void addTarea(Tarea tarea) throws DBEException {
        if (!tareas.add(tarea)) {
            throw new DBEException("La tarea " + tarea.getTitulo()+ " ya exiate paraa usted");
        }
    }
    
    //METODOS USUARIOS
    
    /**
     * get
     * @return 
     */
    public static synchronized Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * add
     * @param usuario
     * @throws DBEException 
     */
    public static void addUsuario(Usuario usuario) throws DBEException {
        if (!usuarios.add(usuario)) {
            throw new DBEException("El usuario " + usuario.getEmail() + " ya está en uso");
        }
    }
}

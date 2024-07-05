package mx.edu.utez.pruebagit.model;
import java.io.Serializable;

//Bean es una estructura de datos que modela
//un objeto de la vida real, es util en diversos escenarios
public class User implements Serializable {
    private int id;
    private String user_name;
    private String email;
    private String pass;
    private String cody;
    private boolean estado;

    //Siempre deben contener los metodos de
    //Constructores (al menos el vacio)
    //Y los getters y setters

    //Constructor vacio:
    public User(){

    }

    public User(int id, String user_name, String email, String pass, String cody, boolean estado) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.pass = pass;
        this.cody = cody;
        this.estado = estado;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCody() {
        return cody;
    }

    public void setCody(String cody) {
        this.cody = cody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

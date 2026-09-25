package vallegrande.edu.pe.formulario.model;

public class UsuarioModel {

    // Atributos en lowerCamelCase
    private String nombresCompleto;
    private String apellidosCompleto;
    private String correoElectronico;
    private String contrasena;
    private boolean reciOfertasEspeciales;

    public UsuarioModel() {
    }

    public UsuarioModel(String nombresCompleto, String apellidosCompleto, String correoElectronico, String contrasena, boolean reciOfertasEspeciales) {
        this.nombresCompleto = nombresCompleto;
        this.apellidosCompleto = apellidosCompleto;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.reciOfertasEspeciales = reciOfertasEspeciales;
    }

    public String getNombresCompleto() {
        return nombresCompleto;
    }

    public void setNombresCompleto(String nombresCompleto) {
        this.nombresCompleto = nombresCompleto;
    }

    public String getApellidosCompleto() {
        return apellidosCompleto;
    }

    public void setApellidosCompleto(String apellidosCompleto) {
        this.apellidosCompleto = apellidosCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isReciOfertasEspeciales() {
        return reciOfertasEspeciales;
    }

    public void setReciOfertasEspeciales(boolean reciOfertasEspeciales) {
        this.reciOfertasEspeciales = reciOfertasEspeciales;
    }
}
package vallegrande.edu.pe.formulario;

import javax.swing.SwingUtilities;

import vallegrande.edu.pe.formulario.controller.RegistroController;
import vallegrande.edu.pe.formulario.model.UsuarioModel;
import vallegrande.edu.pe.formulario.view.RegistroView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsuarioModel usuarioModel = new UsuarioModel();
            RegistroView registroView = new RegistroView();
            new RegistroController(usuarioModel, registroView);

            registroView.setVisible(true);
        });
    }
}
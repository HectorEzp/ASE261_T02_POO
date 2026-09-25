package vallegrande.edu.pe.formulario.controller;

import vallegrande.edu.pe.formulario.model.UsuarioModel;
import vallegrande.edu.pe.formulario.view.RegistroView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroController {

    private final RegistroView registroView;
    private final UsuarioModel usuarioModel;

    public RegistroController(UsuarioModel usuarioModel, RegistroView registroView) {
        this.usuarioModel = usuarioModel;
        this.registroView = registroView;

        // Listener del botón registrarse
        this.registroView.getBtnRegistrarse().addActionListener(e -> registrarUsuario());

        // Listener para el enlace de Inicio de Sesión
        this.registroView.getLblIniciarSesion().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registroView.mostrarMensajeExito("Redirigiendo a Inicio de Sesión...");
                // Aquí abrirás la ventana de Login cuando la implementemos
            }
        });
    }

    private void registrarUsuario() {
        String nombresCompleto = registroView.getTxtNombresCompleto().getText().trim();
        String apellidosCompleto = registroView.getTxtApellidosCompleto().getText().trim();
        String correoElectronico = registroView.getTxtCorreoElectronico().getText().trim();
        String contrasena = new String(registroView.getTxtContrasena().getPassword());
        String confirmarContrasena = new String(registroView.getTxtConfirmarContrasena().getPassword());

        // Validaciones
        if (nombresCompleto.isEmpty() || apellidosCompleto.isEmpty() || correoElectronico.isEmpty() || contrasena.isEmpty()) {
            registroView.mostrarMensajeError("Por favor, complete todos los campos obligatorios.");
            return;
        }

        if (!correoElectronico.contains("@") || !correoElectronico.contains(".")) {
            registroView.mostrarMensajeError("Ingrese un correo electrónico válido.");
            return;
        }

        if (contrasena.length() < 8) {
            registroView.mostrarMensajeError("La contraseña debe tener al menos 8 caracteres.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            registroView.mostrarMensajeError("Las contraseñas no coinciden.");
            return;
        }

        // Asignación de datos al modelo
        usuarioModel.setNombresCompleto(nombresCompleto);
        usuarioModel.setApellidosCompleto(apellidosCompleto);
        usuarioModel.setCorreoElectronico(correoElectronico);
        usuarioModel.setContrasena(contrasena);

        registroView.mostrarMensajeExito("¡Registro exitoso! Bienvenido, " + nombresCompleto);
    }
}
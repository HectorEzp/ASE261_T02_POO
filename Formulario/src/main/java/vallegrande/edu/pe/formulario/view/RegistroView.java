package vallegrande.edu.pe.formulario.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Path2D;

public class RegistroView extends JFrame {

    // Paleta de colores
    private static final Color COLOR_FONDO_IZQ = new Color(27, 67, 50);       // Verde Bosque Profundo (#1B4332)
    private static final Color COLOR_ACCENTO_VERDE = new Color(82, 183, 136);  // Verde Esmeralda (#52B788)
    private static final Color COLOR_SUBTEXTO_IZQ = new Color(216, 243, 220);  // Verde Menta Claro (#D8F3DC)
    private static final Color COLOR_BOTON = new Color(27, 67, 50);          // Verde Corporativo
    private static final Color COLOR_TEXTO_DER = new Color(33, 37, 41);        // Gris Oscuro Lectura

    // Componentes del Panel Izquierdo
    private JPanel panelIzquierdo;
    private JLabel lblLogoEmpresa;
    private JLabel lblTituloComunidad;
    private JLabel lblSubtituloComunidad;

    // Componentes del Panel Derecho (Formulario)
    private JPanel panelDerecho;
    private JLabel lblTituloCrearCuenta;

    private JLabel lblNombresCompleto;
    private JTextField txtNombresCompleto;

    private JLabel lblApellidosCompleto;
    private JTextField txtApellidosCompleto;

    private JLabel lblCorreoElectronico;
    private JTextField txtCorreoElectronico;

    private JLabel lblContrasena;
    private JPasswordField txtContrasena;

    private JLabel lblConfirmarContrasena;
    private JPasswordField txtConfirmarContrasena;

    private JButton btnRegistrarse;
    private JLabel lblIniciarSesion;

    public RegistroView() {
        setTitle("Cooperativa Agraria Yalpa Limitada - Registro");
        setSize(880, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        inicializarPanelIzquierdo();
        inicializarPanelDerecho();

        add(panelIzquierdo);
        add(panelDerecho);
    }

    private void inicializarPanelIzquierdo() {
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(COLOR_FONDO_IZQ);
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBorder(new EmptyBorder(40, 35, 40, 35));

        // LOGO VECTORIAL DE SEMILLA
        lblLogoEmpresa = new JLabel(" YALPA LTDA.");
        lblLogoEmpresa.setIcon(crearIconoSemilla(36));
        lblLogoEmpresa.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblLogoEmpresa.setForeground(Color.WHITE);
        lblLogoEmpresa.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTituloComunidad = new JLabel("Únete a nuestra comunidad");
        lblTituloComunidad.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTituloComunidad.setForeground(COLOR_ACCENTO_VERDE);
        lblTituloComunidad.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblSubtituloComunidad = new JLabel("<html><center>Regístrate y disfruta todos los beneficios de nuestra cooperativa</center></html>");
        lblSubtituloComunidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSubtituloComunidad.setForeground(COLOR_SUBTEXTO_IZQ);
        lblSubtituloComunidad.setAlignmentX(Component.CENTER_ALIGNMENT);

        // CONTENEDOR CENTRADO PARA LOS BENEFICIOS
        JPanel panelBeneficios = new JPanel();
        panelBeneficios.setOpaque(false);
        panelBeneficios.setLayout(new BoxLayout(panelBeneficios, BoxLayout.Y_AXIS));
        panelBeneficios.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelBeneficios.add(crearItemBeneficio("Compra más rápida"));
        panelBeneficios.add(Box.createRigidArea(new Dimension(0, 14)));
        panelBeneficios.add(crearItemBeneficio("Recibe ofertas especiales"));
        panelBeneficios.add(Box.createRigidArea(new Dimension(0, 14)));
        panelBeneficios.add(crearItemBeneficio("Seguimiento de pedidos"));
        panelBeneficios.add(Box.createRigidArea(new Dimension(0, 14)));
        panelBeneficios.add(crearItemBeneficio("Gestiona tus datos"));

        // Ensamble
        panelIzquierdo.add(Box.createVerticalGlue());
        panelIzquierdo.add(lblLogoEmpresa);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 15)));
        panelIzquierdo.add(lblTituloComunidad);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10)));
        panelIzquierdo.add(lblSubtituloComunidad);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 35)));
        panelIzquierdo.add(panelBeneficios);
        panelIzquierdo.add(Box.createVerticalGlue());
    }

    private JLabel crearItemBeneficio(String texto) {
        JLabel label = new JLabel(" " + texto);
        label.setIcon(crearIconoCheckMark(18)); // Ícono de check vectorial
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private void inicializarPanelDerecho() {
        panelDerecho = new JPanel();
        panelDerecho.setBackground(Color.WHITE);
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBorder(new EmptyBorder(25, 35, 25, 35));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 5, 4, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        lblTituloCrearCuenta = new JLabel("Crear cuenta");
        lblTituloCrearCuenta.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTituloCrearCuenta.setForeground(COLOR_TEXTO_DER);
        gbc.gridy = 0;
        panelDerecho.add(lblTituloCrearCuenta, gbc);

        lblNombresCompleto = new JLabel("Nombres Completos");
        txtNombresCompleto = crearCampoTexto();
        agregarCampo(lblNombresCompleto, txtNombresCompleto, gbc, 1);

        lblApellidosCompleto = new JLabel("Apellidos Completos");
        txtApellidosCompleto = crearCampoTexto();
        agregarCampo(lblApellidosCompleto, txtApellidosCompleto, gbc, 3);

        lblCorreoElectronico = new JLabel("Correo Electrónico");
        txtCorreoElectronico = crearCampoTexto();
        agregarCampo(lblCorreoElectronico, txtCorreoElectronico, gbc, 5);

        lblContrasena = new JLabel("Contraseña");
        txtContrasena = new JPasswordField(20);
        estilarCampo(txtContrasena);
        agregarCampo(lblContrasena, txtContrasena, gbc, 7);

        lblConfirmarContrasena = new JLabel("Confirmar Contraseña");
        txtConfirmarContrasena = new JPasswordField(20);
        estilarCampo(txtConfirmarContrasena);
        agregarCampo(lblConfirmarContrasena, txtConfirmarContrasena, gbc, 9);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBackground(COLOR_BOTON);
        btnRegistrarse.setForeground(Color.WHITE);
        btnRegistrarse.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrarse.setFocusPainted(false);
        btnRegistrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegistrarse.setPreferredSize(new Dimension(0, 38));

        gbc.gridy = 11;
        gbc.insets = new Insets(18, 5, 5, 5);
        panelDerecho.add(btnRegistrarse, gbc);

        lblIniciarSesion = new JLabel("<html><u>¿Ya tienes cuenta? Inicia sesión</u></html>", SwingConstants.CENTER);
        lblIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblIniciarSesion.setForeground(COLOR_BOTON);
        lblIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridy = 12;
        gbc.insets = new Insets(8, 5, 5, 5);
        panelDerecho.add(lblIniciarSesion, gbc);
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField(20);
        estilarCampo(campo);
        return campo;
    }

    private void estilarCampo(JComponent campo) {
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
    }

    private void agregarCampo(JLabel label, JComponent input, GridBagConstraints gbc, int gridy) {
        label.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label.setForeground(COLOR_TEXTO_DER);
        gbc.gridy = gridy;
        panelDerecho.add(label, gbc);

        gbc.gridy = gridy + 1;
        panelDerecho.add(input, gbc);
    }

    // DIBUJA EL ÍCONO DE CHECK VECTORIAL (Imposible de romperse por caracteres)
    private Icon crearIconoCheckMark(int tamano) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Círculo esmeralda
                g2.setColor(COLOR_ACCENTO_VERDE);
                g2.fillOval(x, y, tamano, tamano);

                // Check dibujado dentro
                g2.setColor(COLOR_FONDO_IZQ);
                g2.setStroke(new BasicStroke(2.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

                Path2D.Double check = new Path2D.Double();
                check.moveTo(x + tamano * 0.28, y + tamano * 0.52);
                check.lineTo(x + tamano * 0.45, y + tamano * 0.70);
                check.lineTo(x + tamano * 0.73, y + tamano * 0.32);

                g2.draw(check);
                g2.dispose();
            }

            @Override public int getIconWidth() { return tamano; }
            @Override public int getIconHeight() { return tamano; }
        };
    }

    // DIBUJA EL LOGO DE LA SEMILLA
    private Icon crearIconoSemilla(int tamano) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(COLOR_ACCENTO_VERDE);
                g2.fillOval(x, y, tamano, tamano);

                g2.setColor(COLOR_FONDO_IZQ);

                Path2D.Double hojaIzquierda = new Path2D.Double();
                hojaIzquierda.moveTo(x + tamano * 0.5, y + tamano * 0.75);
                hojaIzquierda.curveTo(x + tamano * 0.2, y + tamano * 0.6, x + tamano * 0.2, y + tamano * 0.3, x + tamano * 0.5, y + tamano * 0.25);
                hojaIzquierda.curveTo(x + tamano * 0.45, y + tamano * 0.5, x + tamano * 0.45, y + tamano * 0.65, x + tamano * 0.5, y + tamano * 0.75);
                g2.fill(hojaIzquierda);

                Path2D.Double hojaDerecha = new Path2D.Double();
                hojaDerecha.moveTo(x + tamano * 0.5, y + tamano * 0.75);
                hojaDerecha.curveTo(x + tamano * 0.8, y + tamano * 0.6, x + tamano * 0.8, y + tamano * 0.3, x + tamano * 0.5, y + tamano * 0.25);
                hojaDerecha.curveTo(x + tamano * 0.55, y + tamano * 0.5, x + tamano * 0.55, y + tamano * 0.65, x + tamano * 0.5, y + tamano * 0.75);
                g2.fill(hojaDerecha);

                g2.dispose();
            }

            @Override public int getIconWidth() { return tamano; }
            @Override public int getIconHeight() { return tamano; }
        };
    }

    // Getters para el controlador
    public JTextField getTxtNombresCompleto() { return txtNombresCompleto; }
    public JTextField getTxtApellidosCompleto() { return txtApellidosCompleto; }
    public JTextField getTxtCorreoElectronico() { return txtCorreoElectronico; }
    public JPasswordField getTxtContrasena() { return txtContrasena; }
    public JPasswordField getTxtConfirmarContrasena() { return txtConfirmarContrasena; }
    public JButton getBtnRegistrarse() { return btnRegistrarse; }
    public JLabel getLblIniciarSesion() { return lblIniciarSesion; }

    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Atención", JOptionPane.WARNING_MESSAGE);
    }
}
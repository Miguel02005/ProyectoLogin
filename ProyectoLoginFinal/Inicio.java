import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JFrame implements ActionListener {
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JLabel NombreUsuario;
    private JLabel Contraseña;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JButton jButton1;
    private InterfazBienvenida interfazBienvenida;

    // Sebastian Agudelo
    // Miguel Ángel Ortega
    public Inicio() {
        initComponents();
        interfazBienvenida = new InterfazBienvenida();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel("Proyecto Usuario", SwingConstants.CENTER);
        NombreUsuario = new JLabel("Usuario");
        jTextField1 = new JTextField(10);
        Contraseña = new JLabel("Contraseña");
        jTextField2 = new JTextField(10);
        jButton1 = new JButton("Ingresar");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atardecer (1).jpg")));
        jPanel1.add(background, BorderLayout.CENTER);
        background.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        jLabel1.setFont(new Font("Forte", Font.BOLD, 30));
        jLabel1.setForeground(Color.WHITE);
        titlePanel.add(jLabel1);
        background.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        NombreUsuario.setFont(new Font("Dialog", Font.BOLD, 18));
        NombreUsuario.setForeground(Color.WHITE);
        inputPanel.add(NombreUsuario, gbc);

        gbc.gridy++;
        inputPanel.add(jTextField1, gbc);

        gbc.gridy++;
        Contraseña.setFont(new Font("Dialog", Font.BOLD, 18));
        Contraseña.setForeground(Color.WHITE);
        inputPanel.add(Contraseña, gbc);

        gbc.gridy++;
        inputPanel.add(jTextField2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        jButton1.setBackground(new Color(64, 31, 113));
        jButton1.setForeground(Color.WHITE);

        inputPanel.add(jButton1, gbc);

        background.add(inputPanel, BorderLayout.CENTER);

        jButton1.addActionListener(this);

        getContentPane().add(jPanel1);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                inicio.setLocationRelativeTo(null);
                System.out.println("Miguel Ortega");
                System.out.println("Sebastian Agudelo");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            String usuario = jTextField1.getText();
            String clave = jTextField2.getText();

            if (Usuario.validarUsuario(usuario, clave)) {
                interfazBienvenida.mostrarMensajeBienvenida(usuario);
                InicioAdmin.saludar(usuario);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Datos inválidos");
            }
        }
    }
}

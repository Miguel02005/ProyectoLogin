import javax.swing.*;
import java.awt.*;

public class InterfazBienvenida extends JFrame {
    private JLabel mensajeBienvenida;
    private JLabel emojiLabel;

    public InterfazBienvenida() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bienvenida");

        ImageIcon emojiIcon = new ImageIcon("wave.png");
        emojiIcon = new ImageIcon(emojiIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        mensajeBienvenida = new JLabel();
        mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeBienvenida.setFont(new Font("Dialog", Font.BOLD, 25));
        mensajeBienvenida.setForeground(new Color(253, 175, 123));

        getContentPane().setBackground(new Color(114, 4, 85));
        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        getContentPane().add(mensajeBienvenida, gbc);

        gbc.gridy = 1;
        getContentPane().add(new JLabel(""), gbc);

        gbc.gridy = 3;
        getContentPane().add(new JLabel(emojiIcon), gbc);

        setSize(300, 400);
        setLocationRelativeTo(null);
    }

    public void mostrarMensajeBienvenida(String usuario) {
        mensajeBienvenida.setText("¡Bienvenido " + usuario + "!");
        setVisible(true);
    }
}

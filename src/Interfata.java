import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Interfata extends JFrame{

    private JFrame frame;
    private JTextField polinom1;
    private JTextField polinom2;

    private JButton btnAdunare;

    private JButton btnScadere;

    private JButton btnInmultire;

    private JButton btnImpartire;

    private JButton btnDerivare;

    private JButton btnIntegrare;

    private JLabel rezultat;
    public Interfata() {
        initialize();
        frame.setVisible(true);
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 684, 454);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        btnAdunare = new JButton("Adunare");
        btnAdunare.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnAdunare.setBounds(46, 159, 271, 64);
        frame.getContentPane().add(btnAdunare);

        btnInmultire = new JButton("Inmultire");
        btnInmultire.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnInmultire.setBounds(46, 234, 271, 64);
        frame.getContentPane().add(btnInmultire);

        btnDerivare = new JButton("Derivare");
        btnDerivare.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnDerivare.setBounds(46, 309, 271, 64);
        frame.getContentPane().add(btnDerivare);

        btnScadere = new JButton("Scadere");
        btnScadere.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnScadere.setBounds(353, 159, 271, 64);
        frame.getContentPane().add(btnScadere);

        btnImpartire = new JButton("Impartire");
        btnImpartire.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnImpartire.setBounds(353, 234, 271, 64);
        frame.getContentPane().add(btnImpartire);

        btnIntegrare = new JButton("Integrare");
        btnIntegrare.setFont(new Font("Tahoma", Font.PLAIN, 41));
        btnIntegrare.setBounds(353, 309, 271, 64);
        frame.getContentPane().add(btnIntegrare);

        JLabel lblNewLabel = new JLabel("Polinom1 :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(94, 22, 100, 30);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblPolinom = new JLabel("Polinom2 :");
        lblPolinom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPolinom.setBounds(94, 63, 100, 30);
        frame.getContentPane().add(lblPolinom);

        polinom1 = new JTextField();
        polinom1.setBounds(204, 31, 332, 20);
        frame.getContentPane().add(polinom1);
        polinom1.setColumns(10);

        polinom2 = new JTextField();
        polinom2.setColumns(10);
        polinom2.setBounds(204, 72, 332, 20);
        frame.getContentPane().add(polinom2);

        JLabel lblNewLabel_1 = new JLabel("Rezultat:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(46, 384, 77, 20);
        frame.getContentPane().add(lblNewLabel_1);

        rezultat = new JLabel("");
        rezultat.setBounds(133, 384, 229, 20);
        frame.getContentPane().add(rezultat);
    }
    public String getTextFieldPolynom1() {
        return polinom1.getText();
    }
    public String getTextFieldPolynom2() {
        return polinom2.getText();
    }
    public void setLblPolynomResult(String value) {
        this.rezultat.setText(value);
    }
    public void addAdditionListener(ActionListener action)
    {
        btnAdunare.addActionListener(action);
    }
    public void addSubtractionListener(ActionListener action)
    {
        btnScadere.addActionListener(action);
    }
    public void addMultiplicationListener(ActionListener action)
    {
        btnInmultire.addActionListener(action);
    }
    public void addDivisionListener(ActionListener action)
    {
        btnImpartire.addActionListener(action);
    }
    public void addDerivationListener(ActionListener action)
    {
        btnDerivare.addActionListener(action);
    }

    public void addIntegrationListener(ActionListener action)
    {
        btnIntegrare.addActionListener(action);
    }
}

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Control {
    
    private Interfata interfata;

    public Control(Interfata interfata) {
        this.interfata = interfata;
        this.interfata.addAdditionListener(new AdditionListener());
        this.interfata.addSubtractionListener(new SubtractionListener());
        this.interfata.addMultiplicationListener(new MultiplicationListener());
        this.interfata.addDivisionListener(new DivisionListener());
        this.interfata.addDerivationListener(new DerivationListener());
        this.interfata.addIntegrationListener(new IntegrationListener());
    }

    class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            polynom pol1 = new polynom(interfata.getTextFieldPolynom1());
            polynom pol2 = new polynom(interfata.getTextFieldPolynom2());
            polynom result = pol1.adunare(pol2);
            interfata.setLblPolynomResult(result.toString());
        }
    }

    class SubtractionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            polynom pol1 = new polynom(interfata.getTextFieldPolynom1());
            polynom pol2 = new polynom(interfata.getTextFieldPolynom2());
            polynom result = pol1.scadere(pol2);
            interfata.setLblPolynomResult(result.toString());
        }
    }

    class MultiplicationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            polynom pol1 = new polynom(interfata.getTextFieldPolynom1());
            polynom pol2 = new polynom(interfata.getTextFieldPolynom2());
            polynom result = pol1.inmultire(pol2);
            interfata.setLblPolynomResult(result.toString());
        }
    }

    class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    class DerivationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            polynom pol1 = new polynom(interfata.getTextFieldPolynom1());
            polynom result = pol1.derivare();
            interfata.setLblPolynomResult(result.toString() + "+c");
        }
    }

    class IntegrationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            polynom pol1 = new polynom(interfata.getTextFieldPolynom1());
            polynom result = pol1.integrare();
            interfata.setLblPolynomResult(result.toString());
        }
    }
}


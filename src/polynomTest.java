import static org.junit.jupiter.api.Assertions.*;

class polynomTest {

    @org.junit.jupiter.api.Test
    void adunare() {
        polynom pol1 = new polynom("x^2+2x+1");
        polynom pol2 = new polynom("x^3+5x");
        assertEquals("x^3+x^2+7.0x+1.0", pol1.adunare(pol2).toString());
    }

    @org.junit.jupiter.api.Test
    void scadere() {
        polynom pol1 = new polynom("x^2+2x+1");
        polynom pol2 = new polynom("x^3+5x");
        assertEquals("-x^3+x^2-3.0x+1.0", pol1.scadere(pol2).toString());
    }

    @org.junit.jupiter.api.Test
    void derivare() {
        polynom pol1 = new polynom("x^2+2x+1");
        assertEquals("2.0x+2.0", pol1.derivare().toString());
    }

    @org.junit.jupiter.api.Test
    void integrare() {
        polynom pol1 = new polynom("x^2+2x+1");
        assertEquals("0.33x^3+x^2+x", pol1.integrare().toString());
    }

    @org.junit.jupiter.api.Test
    void inmultire() {
        polynom pol1 = new polynom("x^2+2x+1");
        polynom pol2 = new polynom("x^3+5x");
        assertEquals("x^5+2.0x^4+6.0x^3+10.0x^2+5.0x", pol1.inmultire(pol2).toString());
    }
}
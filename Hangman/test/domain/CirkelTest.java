package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
    private Punt middelpunt;
    private int radius;
    private Cirkel cirkel;

    @Before
    public void setUp() throws Exception{
        middelpunt = new Punt(2,5);
        radius = 10;
        cirkel = new Cirkel(middelpunt,radius);
    }

    @Test
    public void Geldig_middelpunt_geldige_straal(){
        cirkel = new Cirkel(middelpunt,radius);
        assertEquals(middelpunt, cirkel.getMiddelPunt());
        assertEquals(radius,cirkel.getRadius());
    }

    @Test(expected = DomainException.class)
    public void Exception_als_middelpunt_null(){
        new Cirkel(null,5);
    }

    @Test(expected = DomainException.class)
    public void Exception_als_straal_negatief(){
        new Cirkel(middelpunt,-5);
    }

    @Test(expected = DomainException.class)
    public void Exception_als_straal_nul(){
        new Cirkel(middelpunt,0);
    }

    @Test
    public void twee_cirkels_gelijk_als_middelpunt_en_straal_gelijk(){
        Cirkel cirkel1 = new Cirkel(middelpunt,radius);
        Cirkel cirkel2 = new Cirkel(middelpunt,radius);
        assertTrue(cirkel1.equals(cirkel2));
    }

    @Test
    public void twee_cirkels_verschillend_als_2de_null(){
        Cirkel cirkel1 = new Cirkel(middelpunt,radius);
        Cirkel cirkel2 = null;
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void twee_cirkels_verschillend_met_ander_middelpunt(){
        Punt middelpunt2 = new Punt(3,9);
        Cirkel cirkel1 = new Cirkel(middelpunt,radius);
        Cirkel cirkel2 = new Cirkel(middelpunt2,radius);
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void twee_cirkels_met_andere_straal(){
        int straal1 = 4;
        int straal2 = 8;
        Cirkel cirkel1 = new Cirkel(middelpunt,straal1);
        Cirkel cirkel2 = new Cirkel(middelpunt,straal2);
        assertFalse(cirkel1.equals(cirkel2));
    }


}
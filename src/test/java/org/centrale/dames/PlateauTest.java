package org.centrale.dames;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class PlateauTest {
    Plateau p = new Plateau();

    @Test
    public void testInitPlateau() {
        p = new Plateau();
        

    }

    @Test
    void testGetCase() {
        assertEquals(p.getCase("A0").getPion(), null);
        assertTrue(p.getCase("A1").getPion().getCouleur());
        assertFalse(p.getCase("A9").getPion().getCouleur());
    }
}

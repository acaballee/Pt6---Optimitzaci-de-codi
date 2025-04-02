package org.entdes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaulerServiceTest {

    private TaulerService taulerService;

    @BeforeEach
    void setUp() {

        taulerService = new TaulerService();
    }

    @Test
    void testComprovarGuanyadorX() {
        taulerService.tractarClicCasella(0, 0);//X
        taulerService.tractarClicCasella(0, 1);//O
        taulerService.tractarClicCasella(0, 2);//X
        taulerService.tractarClicCasella(1, 1);//O
        taulerService.tractarClicCasella(1, 0);//X
        taulerService.tractarClicCasella(1, 2);//O
        taulerService.tractarClicCasella(2, 0);//X
        
        assertTrue(taulerService.isGameOver());
        assertEquals("X", taulerService.getGuanyador());
    }

    @Test
    void testComprovarGuanyadorO() {
        taulerService.tractarClicCasella(0, 0);//X
        taulerService.tractarClicCasella(1, 0);//O
        taulerService.tractarClicCasella(2, 0);//X
        taulerService.tractarClicCasella(1, 1);//O
        taulerService.tractarClicCasella(0, 1);//X
        taulerService.tractarClicCasella(2, 1);//O
        taulerService.tractarClicCasella(0, 2);//X
        
        assertTrue(taulerService.isGameOver());
        assertEquals("O", taulerService.getGuanyador());
    }


}
package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NoCheckinsPresentResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        NoCheckinsPresentResponse response = new NoCheckinsPresentResponse();
        assertEquals(0x08,response.getCommandCode());
    }
}
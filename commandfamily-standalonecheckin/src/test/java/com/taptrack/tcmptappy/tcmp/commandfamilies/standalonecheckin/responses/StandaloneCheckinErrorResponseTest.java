package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandaloneCheckinErrorResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        StandaloneCheckinErrorResponse standaloneCheckinErrorResponse = new StandaloneCheckinErrorResponse();
        assertEquals(standaloneCheckinErrorResponse.getCommandCode(),0x7F);
    }
}
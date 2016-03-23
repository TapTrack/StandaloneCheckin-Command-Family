package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StationIdSetSuccessResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        StationIdSetSuccessResponse response = new StationIdSetSuccessResponse();
        assertEquals(0x03,response.getCommandCode());
    }
}
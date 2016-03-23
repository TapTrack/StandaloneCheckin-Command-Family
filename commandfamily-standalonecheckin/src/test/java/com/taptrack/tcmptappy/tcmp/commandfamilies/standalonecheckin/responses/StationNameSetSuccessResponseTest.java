package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StationNameSetSuccessResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        StationNameSetSuccessResponse response = new StationNameSetSuccessResponse();
        assertEquals(response.getCommandCode(),0x04);
    }
}
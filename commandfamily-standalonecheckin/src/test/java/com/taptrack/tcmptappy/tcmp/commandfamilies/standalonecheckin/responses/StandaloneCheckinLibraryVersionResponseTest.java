package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandaloneCheckinLibraryVersionResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        StandaloneCheckinLibraryVersionResponse versionResponse = new StandaloneCheckinLibraryVersionResponse();
        assertEquals(versionResponse.getCommandCode(),(byte)0x0B);
    }
}
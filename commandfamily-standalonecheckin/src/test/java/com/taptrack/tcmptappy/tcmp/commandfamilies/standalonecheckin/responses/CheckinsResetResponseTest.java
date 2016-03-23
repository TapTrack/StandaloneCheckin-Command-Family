package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckinsResetResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        CheckinsResetResponse resetResponse = new CheckinsResetResponse();
        assertEquals(0x07,resetResponse.getCommandCode());
    }
}
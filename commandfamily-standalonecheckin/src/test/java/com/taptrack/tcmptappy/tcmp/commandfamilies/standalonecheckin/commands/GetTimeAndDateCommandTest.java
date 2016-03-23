package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetTimeAndDateCommandTest {

    @Test
    public void testGetCommandCode() throws Exception {
        GetTimeAndDateCommand command = new GetTimeAndDateCommand();
        assertEquals(command.getCommandCode(),0x09);
    }
}
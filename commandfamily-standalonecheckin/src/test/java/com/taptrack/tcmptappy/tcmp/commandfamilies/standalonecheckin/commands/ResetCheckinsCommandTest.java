package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResetCheckinsCommandTest {

    @Test
    public void testGetCommandCode() throws Exception {
        ResetCheckinsCommand command = new ResetCheckinsCommand();
        assertEquals(0x06,command.getCommandCode());
    }
}
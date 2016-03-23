package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetCheckinCountCommandTest {

    @Test
    public void testGetCommandCode() throws Exception {
        GetCheckinCountCommand countCommand = new GetCheckinCountCommand();
        assertEquals(countCommand.getCommandCode(),0x02);
    }
}
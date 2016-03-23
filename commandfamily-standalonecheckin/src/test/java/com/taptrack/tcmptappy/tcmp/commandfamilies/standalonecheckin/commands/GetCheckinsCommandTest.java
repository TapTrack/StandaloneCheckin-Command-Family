package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetCheckinsCommandTest {

    @Test
    public void testParsing() throws Exception {
        int firstCheckin = 256;
        int secondCheckin = 384;
        GetCheckinsCommand checkinsCommand = new GetCheckinsCommand(firstCheckin,secondCheckin);
        byte[] payload = checkinsCommand.getPayload();

        GetCheckinsCommand testCommand = new GetCheckinsCommand();
        testCommand.parsePayload(payload);

        assertEquals(testCommand.getFirstCheckin(), firstCheckin);
        assertEquals(testCommand.getSecondCheckin(), secondCheckin);
    }

    @Test
    public void testGetCommandCode() throws Exception {
        GetCheckinsCommand command = new GetCheckinsCommand();
        assertEquals(command.getCommandCode(),0x01);
    }
}
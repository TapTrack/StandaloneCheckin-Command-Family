package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetTimeAndDateCommandTest {

    @Test
    public void testParsing() throws Exception {
        int timestamp = (int) (System.currentTimeMillis() / 1000L);
        SetTimeAndDateCommand command = new SetTimeAndDateCommand(timestamp);
        byte[] payload = command.getPayload();

        SetTimeAndDateCommand testCommand = new SetTimeAndDateCommand();
        testCommand.parsePayload(payload);

        assertEquals(timestamp,testCommand.getTimestamp());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        SetTimeAndDateCommand command = new SetTimeAndDateCommand();
        assertEquals(0x08, command.getCommandCode());
    }
}
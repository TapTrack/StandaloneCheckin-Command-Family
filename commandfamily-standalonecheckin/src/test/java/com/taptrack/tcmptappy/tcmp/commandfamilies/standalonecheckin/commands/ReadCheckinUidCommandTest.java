package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadCheckinUidCommandTest {

    @Test
    public void testParsing() throws Exception {
        byte timeout = 0x54;
        ReadCheckinUidCommand checkinUidCommand = new ReadCheckinUidCommand(timeout);
        byte[] payload = checkinUidCommand.getPayload();

        ReadCheckinUidCommand testCommand = new ReadCheckinUidCommand();
        testCommand.parsePayload(payload);
        assertEquals(timeout,testCommand.getTimeout());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        ReadCheckinUidCommand command = new ReadCheckinUidCommand();
        assertEquals(0x05,command.getCommandCode());
    }
}
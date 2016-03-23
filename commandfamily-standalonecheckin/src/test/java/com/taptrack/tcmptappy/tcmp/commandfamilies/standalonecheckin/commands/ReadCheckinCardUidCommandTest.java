package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadCheckinCardUidCommandTest {

    @Test
    public void testParsing() throws Exception {
        byte timeout = 0x54;
        ReadCheckinCardUidCommand checkinUidCommand = new ReadCheckinCardUidCommand(timeout);
        byte[] payload = checkinUidCommand.getPayload();

        ReadCheckinCardUidCommand testCommand = new ReadCheckinCardUidCommand();
        testCommand.parsePayload(payload);
        assertEquals(timeout,testCommand.getTimeout());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        ReadCheckinCardUidCommand command = new ReadCheckinCardUidCommand();
        assertEquals(0x05,command.getCommandCode());
    }
}
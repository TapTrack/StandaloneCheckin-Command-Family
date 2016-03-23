package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetStationIdCommandTest {

    @Test
    public void testParsing() throws Exception {
        int stationId = 10234;
        SetStationIdCommand command = new SetStationIdCommand(stationId);
        byte[] payload = command.getPayload();

        SetStationIdCommand testCommand = new SetStationIdCommand();
        testCommand.parsePayload(payload);

        assertEquals(stationId,testCommand.getStationId());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        SetStationIdCommand command = new SetStationIdCommand();
        assertEquals(command.getCommandCode(),0x03);
    }
}
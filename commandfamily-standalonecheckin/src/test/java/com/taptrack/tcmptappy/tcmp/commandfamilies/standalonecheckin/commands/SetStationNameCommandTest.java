package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetStationNameCommandTest {

    @Test
    public void testParsing() throws Exception {
        String testName = "TestStationName1";
        SetStationNameCommand command = new SetStationNameCommand(testName);
        byte[] payload = command.getPayload();

        SetStationNameCommand testCommand = new SetStationNameCommand();
        testCommand.parsePayload(payload);

        assertEquals(testName,testCommand.getName());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        SetStationNameCommand command = new SetStationNameCommand();
        assertEquals(0x04, command.getCommandCode());
    }
}
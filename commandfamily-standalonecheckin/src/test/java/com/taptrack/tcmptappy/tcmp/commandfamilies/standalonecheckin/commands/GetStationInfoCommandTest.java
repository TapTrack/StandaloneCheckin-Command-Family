package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetStationInfoCommandTest {

    @Test
    public void testGetCommandCode() throws Exception {
        GetStationInfoCommand command = new GetStationInfoCommand();
        assertEquals(0x07,command.getCommandCode());
    }
}
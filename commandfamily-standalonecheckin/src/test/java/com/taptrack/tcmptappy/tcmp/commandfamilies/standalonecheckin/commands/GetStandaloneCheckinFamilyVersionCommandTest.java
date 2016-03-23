package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetStandaloneCheckinFamilyVersionCommandTest {

    @Test
    public void testGetCommandCode() throws Exception {
        GetStandaloneCheckinFamilyVersionCommand command = new GetStandaloneCheckinFamilyVersionCommand();
        assertEquals(command.getCommandCode(),(byte)0xFF);
    }
}
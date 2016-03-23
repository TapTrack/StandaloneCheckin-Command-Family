package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeAndDateSetResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        TimeAndDateSetResponse response = new TimeAndDateSetResponse();
        assertEquals(0x09,response.getCommandCode());
    }


}
package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeAndDateResponseTest {

    @Test
    public void testGetCommandCode() throws Exception {
        TimeAndDateResponse response = new TimeAndDateResponse();
        assertEquals(0x0A,response.getCommandCode());
    }

    @Test
    public void testParser() throws Exception {
        int timestamp = (int) (System.currentTimeMillis() / 1000L);
        TimeAndDateResponse response = new TimeAndDateResponse(timestamp);
        byte[] payload = response.getPayload();

        TimeAndDateResponse testResponse = new TimeAndDateResponse();
        testResponse.parsePayload(payload);

        assertEquals(timestamp,testResponse.getTimestamp());

    }
}
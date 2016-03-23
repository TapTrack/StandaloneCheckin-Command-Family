package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfCheckinsResponseTest {

    protected void testForValue(int value) throws Exception {
        NumberOfCheckinsResponse response = new NumberOfCheckinsResponse(value);
        byte[] payload = response.getPayload();

        NumberOfCheckinsResponse testResponse = new NumberOfCheckinsResponse();
        testResponse.parsePayload(payload);

        assertEquals(value,testResponse.getNumberOfCheckins());
    }

    @Test
    public void testParsePayload() throws Exception {
        testForValue(65535);
        testForValue(0);
    }

    @Test
    public void testGetCommandCode() throws Exception {
        NumberOfCheckinsResponse response = new NumberOfCheckinsResponse();
        assertEquals(0x02,response.getCommandCode());
    }
}
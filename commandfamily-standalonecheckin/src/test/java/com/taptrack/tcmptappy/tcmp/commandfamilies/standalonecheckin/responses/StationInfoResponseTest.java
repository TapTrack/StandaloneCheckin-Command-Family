package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StationInfoResponseTest {

    @Test
    public void testParser() throws Exception {
        int id = 5;
        String name = "HelloMan";

        StationInfoResponse response = new StationInfoResponse(id,name);
        byte[] payload = response.getPayload();

        StationInfoResponse testResponse = new StationInfoResponse();
        testResponse.parsePayload(payload);

        assertEquals(id,testResponse.getId());
        assertEquals(name,testResponse.getName());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        StationInfoResponse infoResponse = new StationInfoResponse();
        assertEquals(0x06,infoResponse.getCommandCode());
    }
}
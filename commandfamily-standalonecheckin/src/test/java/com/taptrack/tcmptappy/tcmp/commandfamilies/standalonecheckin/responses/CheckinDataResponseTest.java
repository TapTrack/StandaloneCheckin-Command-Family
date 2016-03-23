package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CheckinDataResponseTest {
    Random rand = new Random();

    @Test
    public void testParser() throws Exception {
        //this is a weak test, should probably be improved
        byte[] uid = new byte[7];
        rand.nextBytes(uid);

        CheckinDataResponse response = new CheckinDataResponse(uid,
                (int)(System.currentTimeMillis() / 1000L));

        byte[] reponsePayload = response.getPayload();

        CheckinDataResponse testResponse = new CheckinDataResponse();
        testResponse.parsePayload(reponsePayload);

        assertArrayEquals(uid, testResponse.getUid());

        // this is a kind of crappy way of dealing with the truncated timestamps
        CheckinDataResponse testResponse2 = new CheckinDataResponse();
        testResponse2.parsePayload(testResponse.getPayload());

        assertArrayEquals(testResponse2.getPayload(),testResponse.getPayload());

    }

    @Test
    public void testGetCommandCode() throws Exception {
        CheckinDataResponse response = new CheckinDataResponse();
        assertEquals(0x01,response.getCommandCode());
    }
}
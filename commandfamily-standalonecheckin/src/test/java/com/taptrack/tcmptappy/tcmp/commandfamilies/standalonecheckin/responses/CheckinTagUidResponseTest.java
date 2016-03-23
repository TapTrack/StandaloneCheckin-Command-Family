package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CheckinTagUidResponseTest {
    Random random = new Random();

    @Test
    public void testParser() throws Exception {
        byte[] uid = new byte[7];
        random.nextBytes(uid);

        CheckinTagUidResponse response = new CheckinTagUidResponse(uid);
        byte[] payload = response.getPayload();

        CheckinTagUidResponse testResponse = new CheckinTagUidResponse();
        testResponse.parsePayload(payload);

        assertArrayEquals(uid,testResponse.getUid());
    }

    @Test
    public void testGetCommandCode() throws Exception {
        CheckinTagUidResponse response = new CheckinTagUidResponse();
        assertEquals(0x05,response.getCommandCode());
    }
}
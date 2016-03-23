package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagDetectionTimedOutTest {

    @Test
    public void testGetCommandCode() throws Exception {
        TagDetectionTimedOut tagDetectionTimedOut = new TagDetectionTimedOut();
        assertEquals(0x0C, tagDetectionTimedOut.getCommandCode());
    }
}
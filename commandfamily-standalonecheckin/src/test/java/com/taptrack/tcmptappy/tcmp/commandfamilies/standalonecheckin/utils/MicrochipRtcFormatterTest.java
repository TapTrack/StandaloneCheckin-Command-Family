package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MicrochipRtcFormatterTest {

    @Test
    public void testGetUnixTimestamp() throws Exception {
        int testStamp = (int) (System.currentTimeMillis() / 1000L);
        MicrochipRtcFormatter formatter = new MicrochipRtcFormatter(testStamp);

        byte[] microChipRtc = formatter.getMicrochipRtcFormatted(true,true);
        MicrochipRtcFormatter reconstructed = new MicrochipRtcFormatter(microChipRtc[0],
                microChipRtc[1],
                microChipRtc[2],
                microChipRtc[3],
                microChipRtc[4],
                microChipRtc[5]);

        assertEquals(testStamp,reconstructed.getUnixTimestamp());
    }
}
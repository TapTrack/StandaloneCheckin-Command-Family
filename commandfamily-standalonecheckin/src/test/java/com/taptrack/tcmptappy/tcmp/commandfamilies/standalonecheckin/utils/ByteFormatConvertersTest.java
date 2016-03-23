package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.utils;

import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.TestUtils;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ByteFormatConvertersTest {
    @Test
    public void testUnsignedByteArray() throws Exception {
        int value = 65535;
        byte[] result = ByteFormatConverters.unsignedInt16ToByteArray(value);
        String texted = TestUtils.bytesToHex(result);
        long tested = ByteFormatConverters.bytePairToUnsignedInt16(result[0],result[1]);
        assertEquals(value,tested);
    }

    @Test
    public void testBcdToInt() throws Exception {
        for(int i = 0; i < 99; i++) {
            byte bcd = ByteFormatConverters.intToBcd(i);
            int value = ByteFormatConverters.bcdToInt(bcd);
            assertEquals(i,value);
        }

    }

    @Test
    public void testPadding() throws Exception {
        byte[] testData = new byte[]{0x44,0x32};
        byte[] expectedPaddedTest = new byte[]{0x44,0x32,0x00,0x00};
        byte padCharacter = 0x00;

        byte[] testPadding = ByteFormatConverters.padToLength(testData,expectedPaddedTest.length,padCharacter);
        assertArrayEquals(expectedPaddedTest,testPadding);

        byte[] stripped = ByteFormatConverters.stripPadding(testPadding,padCharacter);
        assertArrayEquals(stripped,testData);
    }
}
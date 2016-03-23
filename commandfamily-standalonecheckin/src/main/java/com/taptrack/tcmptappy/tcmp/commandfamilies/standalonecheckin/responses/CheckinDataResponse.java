package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.utils.MicrochipRtcFormatter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class CheckinDataResponse extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x01;
    protected byte[] uid;
    protected int timestamp;

    public CheckinDataResponse() {
        uid = new byte[7];
        timestamp = 0;
    }

    public CheckinDataResponse(byte[] uid, int timestamp) {
        this.uid = uid;
        this.timestamp = timestamp;
    }

    public CheckinDataResponse(byte[] uid, int year, int month, int day, int hour, int minute) {
        this.uid = uid;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month, day, hour, minute, 0);
        timestamp = (int) (calendar.getTimeInMillis() / 1000L);
    }

    /**
     * Retrieve the UID for the checkin data response
     * @return
     */
    public byte[] getUid() {
        return uid;
    }

    /**
     * Set the UID for a checkin data response
     * @param uid
     */
    public void setUid(byte[] uid) {
        this.uid = uid;
    }

    /**
     * Retrieves the 32-bit unix timestamp corresponding to this checkin
     *
     * Note that the Tappy only stores timestamps with minute-level accuracy, so
     * this timestamp may be up to a minute off of when the checkin actually occured
     * @return
     */
    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {
        if(payload.length != 12)
            throw new MalformedPayloadException("Payload is the incorrect length");

        uid = Arrays.copyOfRange(payload,0,7);
        byte[] bcdTime = Arrays.copyOfRange(payload, 7, payload.length);

        MicrochipRtcFormatter formatter = new MicrochipRtcFormatter(bcdTime[0],
                bcdTime[1],
                bcdTime[2],
                bcdTime[3],
                bcdTime[4],
                (byte) 0x00);
        timestamp = formatter.getUnixTimestamp();
    }

    @Override
    public byte[] getPayload() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(12);

        MicrochipRtcFormatter formatter = new MicrochipRtcFormatter(timestamp);

        try {
            outputStream.write(uid);
            outputStream.write(formatter.getMicrochipRtcFormatted(false,false));
        } catch (IOException e) {
            throw new IllegalStateException("IO Exception on output stream writing. This shouldn't be possible");
        }

        return outputStream.toByteArray();
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}

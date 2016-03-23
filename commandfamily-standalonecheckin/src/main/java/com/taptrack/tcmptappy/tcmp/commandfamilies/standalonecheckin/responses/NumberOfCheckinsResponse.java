package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.utils.ByteFormatConverters;

public class NumberOfCheckinsResponse extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x02;
    protected int numberOfCheckins;

    public NumberOfCheckinsResponse() {
        numberOfCheckins = 0;
    }

    public NumberOfCheckinsResponse(int numberOfCheckins) {
        this.numberOfCheckins = numberOfCheckins;
    }

    public long getNumberOfCheckins() {
        return numberOfCheckins;
    }

    public void setNumberOfCheckins(int numberOfCheckins) {
        this.numberOfCheckins = numberOfCheckins;
    }

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {
        if(payload.length != 2)
            throw new MalformedPayloadException("Payload must be two bytes long");
        numberOfCheckins = ByteFormatConverters.bytePairToUnsignedInt16(payload[0], payload[1]);
    }

    @Override
    public byte[] getPayload() {
        return ByteFormatConverters.unsignedInt16ToByteArray(numberOfCheckins);
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}

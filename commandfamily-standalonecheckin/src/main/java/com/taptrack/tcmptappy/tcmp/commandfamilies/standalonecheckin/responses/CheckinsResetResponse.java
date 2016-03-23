package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;

public class CheckinsResetResponse extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x07;

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {

    }

    @Override
    public byte[] getPayload() {
        return new byte[0];
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}

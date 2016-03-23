package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;

public class GetStandaloneCheckinFamilyVersionCommand extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = (byte) 0xFF;

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

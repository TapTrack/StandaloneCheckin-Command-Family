package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;

public class ReadCheckinUidCommand extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x05;
    private byte timeout;

    public ReadCheckinUidCommand() {
        this.timeout = 0x00;
    }

    public ReadCheckinUidCommand(byte timeout) {
        this.timeout = timeout;
    }

    public byte getTimeout() {
        return timeout;
    }

    public void setTimeout(byte timeout) {
        this.timeout = timeout;
    }

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {
        if(payload.length != 1)
            throw new MalformedPayloadException("Payload is too short");
        timeout = payload[0];
    }

    @Override
    public byte[] getPayload() {
        return new byte[]{timeout};
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}

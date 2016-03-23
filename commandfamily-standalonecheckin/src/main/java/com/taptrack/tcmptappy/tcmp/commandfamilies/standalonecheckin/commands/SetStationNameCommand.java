package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;

import java.nio.charset.Charset;

public class SetStationNameCommand extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x04;
    String name;

    public SetStationNameCommand() {
        name = "                ";
    }

    public SetStationNameCommand(String name) {
        if(name.length() > 16)
            throw new IllegalArgumentException("Name must be at most 16 bytes long");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() != 16)
            throw new IllegalArgumentException("Name must be at most 16 bytes long");
        this.name = name;
    }

    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {
        if(payload.length != 16)
            throw new MalformedPayloadException("Payload must be at most 16 bytes long");

        name = new String(payload, Charset.forName("UTF-8"));
    }

    @Override
    public byte[] getPayload() {
        return name.getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}

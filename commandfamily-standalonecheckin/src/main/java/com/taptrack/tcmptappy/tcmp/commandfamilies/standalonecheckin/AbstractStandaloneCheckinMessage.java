package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin;

import com.taptrack.tcmptappy.tcmp.TCMPMessage;

public abstract class AbstractStandaloneCheckinMessage extends TCMPMessage {
    @Override
    public byte[] getCommandFamily() {
        return StandaloneCheckinCommandLibrary.FAMILY_ID;
    }
}

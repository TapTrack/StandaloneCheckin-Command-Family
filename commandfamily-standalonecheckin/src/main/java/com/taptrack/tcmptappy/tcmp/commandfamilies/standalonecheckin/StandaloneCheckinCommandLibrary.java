package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.TCMPMessage;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.GetCheckinCountCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.GetCheckinsCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.GetStandaloneCheckinFamilyVersionCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.GetStationInfoCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.GetTimeAndDateCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.ReadCheckinUidCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.ResetCheckinsCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.SetStationIdCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.SetStationNameCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands.SetTimeAndDateCommand;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.CheckinDataResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.CheckinTagUidResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.CheckinsResetResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.NoCheckinsPresentResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.NumberOfCheckinsResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.StandaloneCheckinErrorResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.StandaloneCheckinLibraryVersionResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.StationIdSetSuccessResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.StationInfoResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.StationNameSetSuccessResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.TagDetectionTimedOut;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.TimeAndDateSetResponse;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.responses.TimeAndDateResponse;
import com.taptrack.tcmptappy.tcmp.common.CommandCodeNotSupportedException;
import com.taptrack.tcmptappy.tcmp.common.CommandFamily;
import com.taptrack.tcmptappy.tcmp.common.ResponseCodeNotSupportedException;

public class StandaloneCheckinCommandLibrary implements CommandFamily {
    public static final byte[] FAMILY_ID = new byte[]{0x00,0x05};
    @Override
    public TCMPMessage parseCommand(TCMPMessage message) throws CommandCodeNotSupportedException, MalformedPayloadException {
        TCMPMessage parsedMessage;
        switch(message.getCommandCode()) {
            case GetCheckinsCommand.COMMAND_CODE:
                parsedMessage = new GetCheckinsCommand();
                break;
            case GetCheckinCountCommand.COMMAND_CODE:
                parsedMessage = new GetCheckinCountCommand();
                break;
            case ReadCheckinUidCommand.COMMAND_CODE:
                parsedMessage = new ReadCheckinUidCommand();
                break;
            case SetStationIdCommand.COMMAND_CODE:
                parsedMessage = new SetStationIdCommand();
                break;
            case SetStationNameCommand.COMMAND_CODE:
                parsedMessage = new SetStationNameCommand();
                break;
            case ResetCheckinsCommand.COMMAND_CODE:
                parsedMessage = new ResetCheckinsCommand();
                break;
            case GetStationInfoCommand.COMMAND_CODE:
                parsedMessage = new GetStationInfoCommand();
                break;
            case SetTimeAndDateCommand.COMMAND_CODE:
                parsedMessage = new SetTimeAndDateCommand();
                break;
            case GetTimeAndDateCommand.COMMAND_CODE:
                parsedMessage = new GetTimeAndDateCommand();
                break;
            case GetStandaloneCheckinFamilyVersionCommand.COMMAND_CODE:
                parsedMessage = new GetStandaloneCheckinFamilyVersionCommand();
                break;
            default:
                throw new CommandCodeNotSupportedException(
                        StandaloneCheckinCommandLibrary.class.getSimpleName()+
                                " doesn't support command code "+String.format("%02X",message.getCommandCode()));
        }
        parsedMessage.parsePayload(message.getPayload());

        return parsedMessage;
    }

    @Override
    public TCMPMessage parseResponse(TCMPMessage message) throws ResponseCodeNotSupportedException, MalformedPayloadException {
        TCMPMessage parsedMessage;
        switch(message.getCommandCode()) {
            case CheckinDataResponse.COMMAND_CODE:
                parsedMessage = new CheckinDataResponse();
                break;
            case StationIdSetSuccessResponse.COMMAND_CODE:
                parsedMessage = new StationIdSetSuccessResponse();
                break;
            case NumberOfCheckinsResponse.COMMAND_CODE:
                parsedMessage = new NumberOfCheckinsResponse();
                break;
            case StationNameSetSuccessResponse.COMMAND_CODE:
                parsedMessage = new StationNameSetSuccessResponse();
                break;
            case CheckinTagUidResponse.COMMAND_CODE:
                parsedMessage = new CheckinTagUidResponse();
                break;
            case StationInfoResponse.COMMAND_CODE:
                parsedMessage = new StationInfoResponse();
                break;
            case CheckinsResetResponse.COMMAND_CODE:
                parsedMessage = new CheckinsResetResponse();
                break;
            case NoCheckinsPresentResponse.COMMAND_CODE:
                parsedMessage = new NoCheckinsPresentResponse();
                break;
            case TimeAndDateResponse.COMMAND_CODE:
                parsedMessage = new TimeAndDateResponse();
                break;
            case TimeAndDateSetResponse.COMMAND_CODE:
                parsedMessage = new TimeAndDateSetResponse();
                break;
            case TagDetectionTimedOut.COMMAND_CODE:
                parsedMessage = new TagDetectionTimedOut();
                break;

            case StandaloneCheckinLibraryVersionResponse.COMMAND_CODE:
                parsedMessage = new StandaloneCheckinLibraryVersionResponse();
                break;
            case StandaloneCheckinErrorResponse.COMMAND_CODE:
                parsedMessage = new StandaloneCheckinErrorResponse();
                break;
            default:
                throw new ResponseCodeNotSupportedException(
                        StandaloneCheckinCommandLibrary.class.getSimpleName()+
                                " doesn't support response code "+String.format("%02X",message.getCommandCode()));
        }
        parsedMessage.parsePayload(message.getPayload());

        return parsedMessage;
    }

    @Override
    public byte[] getCommandFamilyId() {
        return FAMILY_ID;
    }
}

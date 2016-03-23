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
import com.taptrack.tcmptappy.tcmp.common.ResponseCodeNotSupportedException;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StandaloneCheckinCommandLibraryTest {
    StandaloneCheckinCommandLibrary library = new StandaloneCheckinCommandLibrary();

    private static class FakeCommand extends AbstractStandaloneCheckinMessage {

        @Override
        public void parsePayload(byte[] payload) throws MalformedPayloadException {

        }

        @Override
        public byte[] getPayload() {
            return new byte[0];
        }

        @Override
        public byte getCommandCode() {
            return 0x76;
        }
    }

    private static class FakeResponse extends AbstractStandaloneCheckinMessage {

        @Override
        public void parsePayload(byte[] payload) throws MalformedPayloadException {

        }

        @Override
        public byte[] getPayload() {
            return new byte[0];
        }

        @Override
        public byte getCommandCode() {
            return 0x76;
        }
    }

    @Test
    public void testParseCommand() throws Exception {
        testCommand(new GetCheckinsCommand(),GetCheckinsCommand.class);
        testCommand(new GetCheckinCountCommand(),GetCheckinCountCommand.class);
        testCommand(new SetStationIdCommand(),SetStationIdCommand.class);
        testCommand(new SetStationNameCommand(),SetStationNameCommand.class);
        testCommand(new ReadCheckinUidCommand(),ReadCheckinUidCommand.class);
        testCommand(new ResetCheckinsCommand(),ResetCheckinsCommand.class);
        testCommand(new GetStationInfoCommand(),GetStationInfoCommand.class);
        // have to use a legit year 20XX timestamp due to payload format
        // this is an artefact of how the microchip rtc works
        testCommand(new SetTimeAndDateCommand((int) (System.currentTimeMillis() / 1000L)),SetTimeAndDateCommand.class);
        testCommand(new GetTimeAndDateCommand(),GetTimeAndDateCommand.class);
        testCommand(new GetStandaloneCheckinFamilyVersionCommand(),
                GetStandaloneCheckinFamilyVersionCommand.class);

        boolean commandCodeNotSupportedThrown = false;
        try {
            testCommand(new FakeCommand(),FakeCommand.class);
        }
        catch (CommandCodeNotSupportedException e) {
            commandCodeNotSupportedThrown = true;
        }

        assertTrue(commandCodeNotSupportedThrown);
    }

    private void testCommand(TCMPMessage message,Class<? extends TCMPMessage> clazz) throws CommandCodeNotSupportedException, MalformedPayloadException {
        TCMPMessage parsedMessage = library.parseCommand(message);
        assertThat(parsedMessage,instanceOf(clazz));
        assertArrayEquals(clazz.getSimpleName()+" payload check",message.getPayload(), parsedMessage.getPayload());
    }

    @Test
    public void testParseResponse() throws Exception {
        // have to use a legit year 20XX timestamp due to payload format
        // this is an artefact of how the microchip rtc works
        testResponse(new CheckinDataResponse(new byte[7], 2012, 10, 10, 5, 32), CheckinDataResponse.class);
        testResponse(new NumberOfCheckinsResponse(), NumberOfCheckinsResponse.class);
        testResponse(new StationIdSetSuccessResponse(), StationIdSetSuccessResponse.class);
        testResponse(new StationNameSetSuccessResponse(), StationNameSetSuccessResponse.class);
        testResponse(new CheckinTagUidResponse(), CheckinTagUidResponse.class);
        testResponse(new StationInfoResponse(), StationInfoResponse.class);
        testResponse(new CheckinsResetResponse(), CheckinsResetResponse.class);
        testResponse(new NoCheckinsPresentResponse(), NoCheckinsPresentResponse.class);
        // have to use a legit year 20XX timestamp due to payload format
        // this is an artefact of how the microchip rtc works
        testResponse(new TimeAndDateResponse((int) (System.currentTimeMillis() / 1000L)), TimeAndDateResponse.class);
        testResponse(new TimeAndDateSetResponse(), TimeAndDateSetResponse.class);

        testResponse(new StandaloneCheckinLibraryVersionResponse(), StandaloneCheckinLibraryVersionResponse.class);
        testResponse(new StandaloneCheckinErrorResponse(), StandaloneCheckinErrorResponse.class);
        testResponse(new TagDetectionTimedOut(), TagDetectionTimedOut.class);

        boolean responseCodeNotSupportedThrown = false;
        try {
            testResponse(new FakeResponse(), FakeResponse.class);
        }
        catch (ResponseCodeNotSupportedException e) {
            responseCodeNotSupportedThrown = true;
        }

        assertTrue(responseCodeNotSupportedThrown);
    }

    private void testResponse(TCMPMessage message,Class<? extends TCMPMessage> clazz) throws ResponseCodeNotSupportedException, MalformedPayloadException {
        TCMPMessage parsedMessage = library.parseResponse(message);
        assertThat(parsedMessage,instanceOf(clazz));
        assertArrayEquals(message.getPayload(),parsedMessage.getPayload());
    }

    @Test
    public void testGetCommandFamilyId() throws Exception {
        assertArrayEquals(library.getCommandFamilyId(), new byte[]{0x00, 0x05});
    }
}
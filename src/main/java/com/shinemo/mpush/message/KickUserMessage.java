package com.shinemo.mpush.message;


import com.shinemo.mpush.api.connection.Connection;
import com.shinemo.mpush.api.protocol.Command;
import com.shinemo.mpush.api.protocol.Packet;
import com.shinemo.mpush.util.ByteBuf;

import java.nio.ByteBuffer;

/**
 * Created by ohun on 2015/12/29.
 */
public final class KickUserMessage extends ByteBufMessage {
    public String deviceId;
    public String userId;

    public KickUserMessage(Connection connection) {
        super(new Packet(Command.KICK), connection);
    }

    public KickUserMessage(Packet message, Connection connection) {
        super(message, connection);
    }

    @Override
    public void decode(ByteBuffer body) {
        deviceId = decodeString(body);
        userId = decodeString(body);
    }

    @Override
    public void encode(ByteBuf body) {
        encodeString(body, deviceId);
        encodeString(body, userId);
    }

    @Override
    public String toString() {
        return "KickUserMessage{" +
                "deviceId='" + deviceId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

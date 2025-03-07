/*
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.bluetooth.bluegiga.internal.command.attributeclient;

import java.util.UUID;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.bluetooth.bluegiga.internal.BlueGigaDeviceCommand;

/**
 * Class to implement the BlueGiga command <b>readByGroupType</b>.
 * <p>
 * This command reads the value of each attribute of a given type and in a given handle range. The
 * command is typically used for primary (UUID: 0x2800) and secondary (UUID: 0x2801) service
 * discovery. Discovered services are reported by Group Found event. Finally when the
 * procedure is completed a Procedure Completed event is generated.
 * <p>
 * This class provides methods for processing BlueGiga API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 * @author Pauli Anttila - Added message builder
 */
@NonNullByDefault
public class BlueGigaReadByGroupTypeCommand extends BlueGigaDeviceCommand {
    public static final int COMMAND_CLASS = 0x04;
    public static final int COMMAND_METHOD = 0x01;

    private BlueGigaReadByGroupTypeCommand(CommandBuilder builder) {
        super.setConnection(builder.connection);
        this.start = builder.start;
        this.end = builder.end;
        this.uuid = builder.uuid;
    }

    /**
     * First requested handle number
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int start;

    /**
     * Last requested handle number
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int end;

    /**
     * Group UUID to find
     * <p>
     * BlueGiga API type is <i>uuid</i> - Java type is {@link UUID}
     */
    private UUID uuid;

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(COMMAND_CLASS, COMMAND_METHOD);

        // Serialize the fields
        serializeUInt8(connection);
        serializeUInt16(start);
        serializeUInt16(end);
        serializeUuid(uuid);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BlueGigaReadByGroupTypeCommand [connection=");
        builder.append(connection);
        builder.append(", start=");
        builder.append(start);
        builder.append(", end=");
        builder.append(end);
        builder.append(", uuid=");
        builder.append(uuid);
        builder.append(']');
        return builder.toString();
    }

    public static class CommandBuilder {
        private int connection;
        private int start;
        private int end;
        private UUID uuid = new UUID(0, 0);

        /**
         * Set connection handle.
         *
         * @param connection the connection to set as {@link int}
         */
        public CommandBuilder withConnection(int connection) {
            this.connection = connection;
            return this;
        }

        /**
         * First requested handle number
         *
         * @param start the start to set as {@link int}
         */
        public CommandBuilder withStart(int start) {
            this.start = start;
            return this;
        }

        /**
         * Last requested handle number
         *
         * @param end the end to set as {@link int}
         */
        public CommandBuilder withEnd(int end) {
            this.end = end;
            return this;
        }

        /**
         * Group UUID to find
         *
         * @param uuid the uuid to set as {@link UUID}
         */
        public CommandBuilder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public BlueGigaReadByGroupTypeCommand build() {
            return new BlueGigaReadByGroupTypeCommand(this);
        }
    }
}

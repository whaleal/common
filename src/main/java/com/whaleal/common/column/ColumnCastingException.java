/*
 * Copyright (c) 2008-2021, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.whaleal.common.column;


import sun.jvm.hotspot.debugger.Address;

import java.util.UUID;

/**
 * Exception occurred during SQL query execution.
 */
public final class ColumnCastingException extends CastingException {

    private final int code;
    private final UUID originatingMemberId;

    private ColumnCastingException(int code, String message, Throwable cause, UUID originatingMemberId) {
        super(message, cause);

        this.code = code;
        this.originatingMemberId = originatingMemberId;
    }

    public static ColumnCastingException error(String message) {
        return error(message, null);
    }

    public static ColumnCastingException error(String message, Throwable cause) {
        return error(ErrorCode.GENERIC, message, cause, null);
    }

    public static ColumnCastingException error(int code, String message) {
        return new ColumnCastingException(code, message, null, null);
    }

    public static ColumnCastingException error(int code, String message, Throwable cause) {
        return new ColumnCastingException(code, message, cause, null);
    }

    public static ColumnCastingException error(int code, String message, UUID originatingMemberId) {
        return new ColumnCastingException(code, message, null, originatingMemberId);
    }

    public static ColumnCastingException error(int code, String message, Throwable cause, UUID originatingMemberId) {
        return new ColumnCastingException(code, message, cause, originatingMemberId);
    }

    public static ColumnCastingException memberConnection(Address address) {
        return error(ErrorCode.CONNECTION_PROBLEM, "Cluster topology changed while a query was executed: "
                + "Member cannot be reached: " + address);
    }

    public static ColumnCastingException clientMemberConnection(UUID clientId) {
        return error(ErrorCode.CONNECTION_PROBLEM, "Client cannot be reached: " + clientId);
    }

    public static ColumnCastingException timeout(long timeout) {
        return error(ErrorCode.TIMEOUT, "Query has been cancelled due to a timeout (" + timeout + " ms)");
    }

    public static ColumnCastingException cancelledByUser() {
        return error(ErrorCode.CANCELLED_BY_USER, "Query was cancelled by the user");
    }

    public static ColumnCastingException dataException(String message, Throwable cause) {
        return error(ErrorCode.DATA_EXCEPTION, message, cause);
    }

    public static ColumnCastingException dataException(String message) {
        return dataException(message, null);
    }

    /**
     * @return Code of the exception.
     */
    public int getCode() {
        return code;
    }

    /**
     * Get originator of the exception.
     *
     * @return ID of the member where the exception occurred or {@code null} if the exception was raised on a local member
     *         and is not propagated yet.
     */
    public UUID getOriginatingMemberId() {
        return originatingMemberId;
    }


    public ColumnCastingException wrap() {
        return new ColumnCastingException(code, getMessage(), this, originatingMemberId);
    }
}

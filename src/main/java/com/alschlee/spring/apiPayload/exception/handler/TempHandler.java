package com.alschlee.spring.apiPayload.exception.handler;

import com.alschlee.spring.apiPayload.code.BaseErrorCode;
import com.alschlee.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

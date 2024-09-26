package com.wei.middleware.dynamic.thread.pool.types;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -2474596551402989285L;
    private String code;
    private String info;
    private T data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum Code {
        SUCCESS("0000", "Invoke Success"),
        UN_ERROR("0001", "Invoke Failure"),
        ILLEGAL_PARAMETER("0002", "Illegal Parameter"),
        ;
        private String code;
        private String info;
    }
}

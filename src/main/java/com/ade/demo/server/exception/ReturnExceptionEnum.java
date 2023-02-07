package com.ade.demo.server.exception;

import org.springframework.http.HttpStatus;

public enum ReturnExceptionEnum {

    // 系统内部
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SYSTEM_ERROR", "系统内部错误"),
    INTERNAL_SERVER_ERROR_CONFIG(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "系统内部错误:配置信息不存在"),

    // sort
    SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT(HttpStatus.BAD_REQUEST, "SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT", "不支持该数据类型排序"),
    SORT_ERROR_NOT_SUPPORTED_HETEROGENEOUS_DATA(HttpStatus.BAD_REQUEST, "SORT_ERROR_NOT_SUPPORTED_HETEROGENEOUS_DATA", "不支持不同数据类型排序"),

    // 厚普接口
    API_ERROR_HP_GET_ACCESS_TOKEN(HttpStatus.INTERNAL_SERVER_ERROR, "API_ERROR_HP_GET_ACCESS_TOKEN", "获取厚普accessToken接口返回异常"),

    // 项目
    PROJECT_NOT_FOUND(HttpStatus.OK, "PROJECT_NOT_FOUND", "没找到该项目"),
    PROJECT_NOT_SET_AMOUNT(HttpStatus.OK, "PROJECT_NOT_SET_AMOUNT", "项目没设置价格"),
    PROJECT_DEADLINE(HttpStatus.OK, "PROJECT_DEADLINE", "项目已结束"),

    // 疾病
    DISEASE_NOT_FOUND(HttpStatus.OK, "DISEASE_NOT_FOUND", "没找到该疾病"),

    // 患者报名
    ADD_PATIENT_EXIST(HttpStatus.OK, "ADD_PATIENT_EXIST", "患者已经报名该项目"),

    // 对象存储
    OSS_UPLOAD_FAIL(HttpStatus.BAD_REQUEST, "OSS_UPLOAD_FAIL", "对象存储：上传失败。"),
    OSS_UPLOAD_FAIL_SIZE(HttpStatus.BAD_REQUEST, "OSS_UPLOAD_FAIL_SIZE", "对象存储：上传失败，文件太大了"),


    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ReturnExceptionEnum(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

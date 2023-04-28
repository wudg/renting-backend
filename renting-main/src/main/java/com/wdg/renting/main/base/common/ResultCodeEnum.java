package com.wdg.renting.main.base.common;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.base.common
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  21:21
 * @Description: TODO
 * @Version: 1.0
 */
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
//    BIZ_ERROR,
//    FILE_OUT_MAX,
//    FILE_FORMAT_ERROR,
//    PARAM_ERROR,
//    JSON_FORMAT_ERROR,
//    SQL_ERROR,
//    NETWORK_TIMEOUT,
//    UNKNOWN_INTERFACE,
//    REQ_MODE_NOT_SUPPORTED,
//    SYS_ERROR
    ;

    int code;

    String msg;

    ResultCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

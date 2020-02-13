package com.xuxian.entity;

public class StatusCode {

    public static final Integer OK = 10000;  // 成功
    public static final Integer ERROR = 10001;  // 失败
    public static final Integer LOGINERROR = 10002;  // 登陆错误
    public static final Integer ACCESSERROR = 10003;  // 权限错误
    public static final Integer REMOTEERROR = 10004;  // 远程调用错误
    public static final Integer REPERROR = 10005;  // 重复操作
    public static final Integer CODEERROR = 10006;  // 验证码错误
    public static final Integer CODETIMEOUT = 10007;  // 验证码失效
}

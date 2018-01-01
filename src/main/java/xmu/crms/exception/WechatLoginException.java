package xmu.crms.exception;

/**
 * 微信登录异常时抛出
 *@author zzj
 * Created by status200 on 2017/12/24.
 */
public class WechatLoginException extends Exception{

    public WechatLoginException() {
    }

    public WechatLoginException(String message) {
        super(message);
    }
}

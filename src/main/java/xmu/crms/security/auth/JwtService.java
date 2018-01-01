package xmu.crms.security.auth;

import xmu.crms.entity.User;

/**
 * @author  zzj
 */
public interface JwtService {
    /**
     * 从登录成功的用户信息生成 JWT
     *@author zzj
     * @param user
     * @return
     */
    String generateJwt(User user);

    /**
     * hujhu
     * @author zzj
     * @param jwtString
     * @return
     */
    JwtPayload verifyJwt(String jwtString);
}

package com.itas.itasbackend.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class PasswordUtils {

    // 定义一个静态的加密器，strength 默认 10，推荐设为 12（越大越安全也越耗时）
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // 密码强度正则：
    // 1. 至少8位
    // 2. 至少一个大写字母
    // 3. 至少一个小写字母
    // 4. 至少一个数字
    // 5. 至少一个特殊字符
    // 6. 不包含空格
    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile(
            "^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$"
    );

    /**
     * 加密密码（注册时使用）
     *
     * @param rawPassword 原始明文密码
     * @return 加密后的密码（带随机盐，无法反解）
     */
    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * 验证密码是否匹配（登录时使用）
     *
     * @param rawPassword     用户传入的明文密码
     * @param encodedPassword 数据库存储的加密密码
     * @return 是否匹配
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 检查密码是否足够强
     *
     * @param password 原始明文密码
     * @return 是否符合强度要求
     */
    public static boolean isStrongEnough(String password) {
        if (password == null) {
            return false;
        }
        return STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }

}

package com.example.canary.util;

import java.util.StringJoiner;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @since 1.0
 * @author zhaohongliang
 */
public class StringUtil {

    private StringUtil() {

    }

    /**
     * 生成UUID
     *
     * @return
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 小写驼峰命名
     *
     * @return
     */
    public static String toLowerCamelCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 大写驼峰命名
     *
     * @param str
     * @return
     */
    public static String toUpperCamelCase(String str) {
        return null;
    }

    /**
     * 驼峰命名转下划线
     *
     * @param str
     * @return
     */
    public static String toUnderlineCase(String str) {
        String lowerCaseStr = str.replaceAll("([a-z])([A-Z])", "$1_$2");
        return lowerCaseStr.toLowerCase();
    }

    /**
     * 创建 redis key
     *
     * @param subs
     * @return
     */
    public static String createRedisKey(String ... subs) {
        if (subs == null || subs.length == 0) {
            throw new IllegalArgumentException("redis的key拼接异常");
        }
        StringJoiner joiner = new StringJoiner(":");
        joiner.add("com.example.canary");
        for (String sub : subs) {
            joiner.add(sub);
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.print(StringUtil.toLowerCamelCase("wanQuatoPrice"));
    }

}
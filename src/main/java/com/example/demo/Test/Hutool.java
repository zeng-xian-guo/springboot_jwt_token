package com.example.demo.Test;

import cn.hutool.crypto.SecureUtil;

public class Hutool {
    public static void main(String[] args) {
        System.out.println("加密："+SecureUtil.md5("admin"));
    }
}

package com.example.demo.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

public class UserEnum {
    @Getter
    @AllArgsConstructor
    public enum Sex{
        Man(1,"男"),WOMAN(2,"女");
        public Integer code;
        public String msg;

        private static HashMap<Integer,Sex> data = new HashMap<Integer,Sex>();
        static {
            for(Sex d : Sex.values()){
                data.put(d.code, d);
            }
        }
        public static Sex parse(Integer code) {
            if(data.containsKey(code)){
                return data.get(code);
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Status{
        One(1,"正常"),Two(2,"失败");
        public Integer code;
        public String msg;

        private static HashMap<Integer,Status> data = new HashMap<Integer,Status>();
        static {
            for(Status d : Status.values()){
                data.put(d.code, d);
            }
        }
        public static Status parse(Integer code) {
            if (data.containsKey(code)) {
                return data.get(code);
            }
            return null;
        }
    }
}

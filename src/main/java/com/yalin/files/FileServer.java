package com.yalin.files;


import static spark.Spark.*;

/**
 * jinyalin
 * on 2017/5/4.
 */
public class FileServer {
    public static void main(String[] args) {
        staticFiles.externalLocation("apks");
        port(80);
        get("/test", (request, response) -> {
            return "Hello world.";
        });
        get("/", (request, response) -> {
            return "Style.\n非常抱歉，网站正在努力建设当中。谢谢您的关注";
        });
    }
}

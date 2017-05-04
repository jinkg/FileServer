package com.yalin.files;


import static spark.Spark.*;

/**
 * jinyalin
 * on 2017/5/4.
 */
public class FileServer {
    public static void main(String[] args) {
        staticFiles.externalLocation("apks");
        port(6061);
        get("/test", (request, response) -> {
            return "Hello world.";
        });
    }
}

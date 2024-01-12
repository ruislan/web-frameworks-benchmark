package com.ruislan;

import io.javalin.Javalin;

public class Main {
    record JsonResult(String hello) {
    }

    public static void main(String[] args) {
        Javalin.create()
                .get("/", ctx -> ctx.json(new JsonResult("world")))
                .start(6000);
    }
}
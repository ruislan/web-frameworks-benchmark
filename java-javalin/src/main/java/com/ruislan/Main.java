package com.ruislan;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.json("{\"hello\", \"world\"}"))
                .start(6000);
    }
}
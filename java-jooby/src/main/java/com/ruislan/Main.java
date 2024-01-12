package com.ruislan;

import io.jooby.MediaType;
import io.jooby.jackson.JacksonModule;

import static io.jooby.Jooby.runApp;

public class Main {
    record JsonResult(String hello) {
    }

    public static void main(String[] args) {
        runApp(args, app -> {
            app.install(new JacksonModule());
            app.get("/", ctx -> {
                ctx.setResponseCode(200);
                ctx.setResponseType(MediaType.JSON);
                return new JsonResult("world");
            });
        });
    }
}

package com.ruislan;

import ratpack.core.server.RatpackServer;
import ratpack.core.server.ServerConfig;

public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(ServerConfig.embedded().port(6000))
                .handlers(chain -> chain
                        .get(ctx -> ctx.render("{\"hello\":\"world\"}"))
                )
        );
    }
}

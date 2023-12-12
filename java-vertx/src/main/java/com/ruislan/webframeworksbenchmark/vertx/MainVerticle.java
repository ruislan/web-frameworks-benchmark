package com.ruislan.webframeworksbenchmark.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {
  public static final JsonObject json = new JsonObject().put("hello", "world");

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);
    router.get("/").respond(ctx -> Future.succeededFuture(new JsonObject().put("hello", "world")));
    server.requestHandler(router).listen(6000, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 6000");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}

# Web frameworks benchmark

These are some web frameworks that I am currently using or I want to use in the future. so I made this.

## Environment

* wrk
* MacBook Pro 16 inch 2019
* MacOS 14.2.1
* CPU 2.3 GHz Intel i9 8 Cores
* Mem 16 GB 2667 MHz DDR4

## Data

the server will return a json data

```json
{ "hello": "world" }
```

## Cmd

```bash
wrk -t 24 -c 500 -d 30s http://localhost:6000
```

## benchmark

|Language|Framework|Request/sec|Transfer/sec|
|---|---|---|---|
|bun | - | 86004.74 | 10.91MB |
|bun | elysia | 65341.91 | 7.79MB |
|bun | hono | 58946.66 | 7.87MB |
|node| - | 28102.89 | 4.61MB |
|node| hono | 24464.90 | 4.36MB |
|node| express | 8730.04 | 2.10MB |
|node| fastify | 30560.14 | 5.48MB |
|java jdk17| vertx | 68630.89 | 5.76MB |
|java jdk21| springboot | 33597.54 | 4.20MB |
|java jdk21| javalin | 69716.47 | 8.38MB |
|java jdk21| activej | 71402.06 | 8.65MB |
|java jdk21| jooby undertow | 63742.41 | 8.27MB |
|java jdk21| jooby netty | 75872.36 |  9.84MB |
|java jdk21| jooby jetty | 60496.61 | 7.85MB |
|java jdk21| ratpack | 38764.02 | 3.55MB |
|kotlin jdk21 | ktor | 43983.76 | 7.80MB |
|rust| actix | 116048.01 | 13.83MB |
|rust| ntex | 100097.85 | 11.93MB |
|rust| tide | 64248.18 | 7.66MB |
|rust| wrap | 110371.29 | 14.00MB |
|rust| rocket | 29597.16 | 7.23MB |
|zig| zap | 111409.40 | 20.29MB |

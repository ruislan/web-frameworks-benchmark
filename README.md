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
|bun | - | 81788.24 | 10.22MB |
|bun | elysia | 62943.20 | 7.50MB |
|bun | hono | 51609.29 | 6.89MB |
|node| - | 28102.89 | 4.61MB |
|node| hono | 23620.99 | 4.21MB |
|node| express | 8289.15 | 1.99MB |
|node| fastify | 29019.23 | 5.20MB |
|java jdk17| vertx | 68630.89 | 5.76MB |
|java jdk21| springboot | 33597.54 | 4.20MB |
|java jdk21| javalin | 69716.47 | 8.38MB |
|kotlin jdk21 | ktor | 43983.76 | 7.80MB |
|rust| actix | 104463.27 | 12.45MB |
|rust| ntex | 93931.86 | 11.20MB |
|rust| rocket | 5372.75 | 1.30MB |

The result from rust-rocket wasn't very precise, because I don't know how to disable the logging.

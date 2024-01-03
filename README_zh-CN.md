# Web frameworks benchmark

在写 Web 应用的时候，不管你用什么语言，大概率是会选择一个 Web Framework 的，在我的 Stack 里面，有 JVM/Rust/JS 这三大体系，所以我针对这三大体系里面的 Web 框架，以及我感兴趣的一些新的体系框架，做了一个性能测试，毕竟这些框架都是我正在或者将来可能会使用的。

## 测试环境

* wrk
* MacBook Pro 16 inch 2019
* MacOS 14.2.1
* CPU 2.3 GHz Intel i9 8 Cores
* Mem 16 GB 2667 MHz DDR4

## 测试数据

服务只有一个接口，返回一个 json 数据

```json
{ "hello": "world" }
```

## 测试命令

```bash
wrk -t 24 -c 500 -d 30s http://localhost:6000
```

## 测试结果

|语言|框架|请求/秒|传输/秒|
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
|zig| zap | 101451.05 | 18.48MB |

对于 Rust 的 Rocket 可能不太准确，主要是我不知道怎么关闭或调低日志。

总的说来，Rust 🐂🍺！！。个人推荐 bun 体系的，本身基于 ziglang ， 性能仅次于 Rust，还能使用 JS/TS 写程序，而且 bun 还在不断进步，值得期待，未来我的项目也会尝试使用 Bun 系列的框架。

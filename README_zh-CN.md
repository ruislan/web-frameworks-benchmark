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

需要说明的是：

1. 返回数据方面，尽量使用框架提供的 json 序列化。如果框架没有提供，Java 方面则使用了 Jackson 包处理。其实，json 序列化本身是非常快的，所以对于结果的影响不大。

## 个人观点

总的说来，Rust 🐂🍺！！。

在 JS 栈方面，个人推荐 Bun 体系的，本身基于 Zig ，性能仅次于 Rust，还能使用 JS/TS 写程序，而且 Bun 还在不断进步。目前我的个人项目基本是 Fastify ，不过，未来我的项目也会积极尝试使用 Bun 体系的框架。

在 Rust 栈方面，个人推荐 actix ，性能超强，生态不错，更新也积极。

在 Java 方面，在国内，工作上基本上是 SpringBoot 没啥说的。个人方面，建议使用 Jooby，非常快不说，而且生态比较全面。Javalin 也是很不错的选择，简单易上手。

在 Zig 方面，还比较小众，而且 zap 框架本身支持的能力还不够，暂时不推荐，不过值得期待。

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
|java jdk21| activej | 71402.06 | 8.65MB |
|java jdk21| jooby undertow | 63742.41 | 8.27MB |
|java jdk21| jooby netty | 75872.36 |  9.84MB |
|java jdk21| jooby jetty | 60496.61 | 7.85MB |
|java jdk21| ratpack | 38764.02 | 3.55MB |
|kotlin jdk21 | ktor | 43983.76 | 7.80MB |
|rust| actix | 104463.27 | 12.45MB |
|rust| ntex | 93931.86 | 11.20MB |
|rust| rocket | 5372.75 | 1.30MB |
|zig| zap | 101451.05 | 18.48MB |

需要说明的是：

1. 对于 Rust 的 Rocket 可能不太准确，主要是我不知道怎么关闭或调低日志。大量的日志输出，很显然，会降低性能。
2. 返回数据方面，尽量使用框架提供的 json 序列化。如果框架没有提供，Java 方面则使用了 Jackson 包处理。其实，json 序列化本身是非常快的，所以对于结果的影响不大。

## 个人观点

总的说来，Rust 🐂🍺！！。

在 JS 栈方面，个人推荐 bun 体系的，本身基于 Zig ，性能仅次于 Rust，还能使用 JS/TS 写程序，而且 bun 还在不断进步，值得期待，未来我的项目也会尝试使用 Bun 系列的框架。

在 Rust 栈方面，个人推荐 actix 。

在 Java 方面，在国内，工作上基本上是 SpringBoot 没啥说的。个人方面，建议使用 Jooby，非常快不说，而且支持的能力比较全面。Javalin 也是很不错的选择，简单易上手。

在 Zig 方面，还比较小众，而且 zap 框架本身支持的能力还不够，暂时不推荐。

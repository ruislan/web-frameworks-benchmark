# java-jooby

## Server Undertow

```bash
Running 30s test @ http://localhost:6000
  24 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     8.82ms   12.76ms 346.27ms   97.59%
    Req/Sec     2.68k   554.74     8.73k    75.83%
  1917822 requests in 30.09s, 248.74MB read
  Socket errors: connect 0, read 640, write 0, timeout 0
Requests/sec:  63742.41
Transfer/sec:      8.27MB
```

## Server Netty

```bash
Running 30s test @ http://localhost:6000
  24 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.74ms    5.93ms 164.63ms   97.94%
    Req/Sec     3.18k   564.54     3.95k    75.26%
  2277721 requests in 30.02s, 295.42MB read
  Socket errors: connect 0, read 759, write 0, timeout 0
Requests/sec:  75872.36
Transfer/sec:      9.84MB
```

## Server jetty (Virtual Thread)

```bash
Running 30s test @ http://localhost:6000
  24 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    11.03ms   18.06ms 402.64ms   94.28%
    Req/Sec     2.55k   588.34    11.52k    82.48%
  1821079 requests in 30.10s, 236.19MB read
  Socket errors: connect 0, read 2016, write 0, timeout 0
Requests/sec:  60496.61
Transfer/sec:      7.85MB
```

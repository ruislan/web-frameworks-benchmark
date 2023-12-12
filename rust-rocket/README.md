# rust-rocket

I don't know how to disable log. so this test isn't very accurate.

```bash
Running 30s test @ http://localhost:6000
  24 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    92.47ms   58.25ms 540.90ms   73.45%
    Req/Sec   225.35     76.73   470.00     66.48%
  161748 requests in 30.11s, 39.03MB read
  Socket errors: connect 0, read 737, write 0, timeout 0
  Non-2xx or 3xx responses: 161748
Requests/sec:   5372.75
Transfer/sec:      1.30MB
```
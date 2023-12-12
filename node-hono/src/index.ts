import { serve } from '@hono/node-server'
import { Hono } from 'hono'

const app = new Hono()
app.get('/', (c) => c.json({ hello: 'world' }))

serve({
  fetch: app.fetch,
  port: 6000,
})

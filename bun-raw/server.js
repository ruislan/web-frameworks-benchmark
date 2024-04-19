export default {
  port: 6000,
  fetch(request) {
    return new Response(JSON.stringify({ hello: 'world' }));
  },
};


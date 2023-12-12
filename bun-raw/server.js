export default {
  port: 6000,
  fetch(request) {
    return new Response({ hello: 'world' });
  },
};


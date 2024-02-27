const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = app => {
  app.use(
    createProxyMiddleware('/api', {
      target: 'http://15.165.199.6:8080/',
      changeOrigin: true,
    }),
  );
};

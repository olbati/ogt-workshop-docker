var proxyMiddleware = require('http-proxy-middleware');
var fallbackMiddleware = require('connect-history-api-fallback');

module.exports = {
  "port": 3000,
  logLevel: "debug",
  server: {
    middleware: {
      1: proxyMiddleware('/car', {
        target: 'http://back:9090/',
        changeOrigin: true
      }),

      2: fallbackMiddleware({
        index: '/index.html', verbose: true
      })
    },
    "server": {
      "baseDir": [
        // "./src",
        "./"
      ]
    }

  }
};

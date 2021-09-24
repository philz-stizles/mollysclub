module.exports = {
  env: {},
  // Webpack 5 is enabled by default
  // You can still use webpack 4 while upgrading to the latest version of Next.js by adding the "webpack5: false" flag
  webpack5: true,
  images: {
    domains: ['localhost', 'localhost:1337', 'images.pexels.com'], // whatever port your backend runs on
  },
}

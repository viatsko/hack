/* eslint-disable */
const withFonts = require("next-fonts");
const withImages = require("next-optimized-images");
const withSass = require("@zeit/next-sass");
const withCSS = require("@zeit/next-css");

module.exports = withFonts(
  withCSS(
    withSass(
      withImages({
        inlineImageLimit: 16384,
        optimizeImagesInDev: false,
        env: {
          SENTRY_DSN:
            "https://12f42200bfc3488989b65021c60f4337@o191304.ingest.sentry.io/5259961",
        },
        //exportTrailingSlash: true,
        webpack(config, options) {
          const webpack = require("webpack");
          config.plugins = config.plugins || [];
          config.plugins.push(
            new webpack.ContextReplacementPlugin(/moment[/\\]locale$/, /en/)
          );
          // config.plugins.push(
          //   new webpack.DefinePlugin({
          //     "process.env.SENTRY_RELEASE": JSON.stringify(""),
          //   })
          // );

          // if (!isServer) {
          //   config.resolve.alias["@sentry/node"] = "@sentry/browser";
          // }

          return config;
        },
        typescript: {
          ignoreDevErrors: true,
          transpileOnly: true,
        },
      })
    )
  )
);

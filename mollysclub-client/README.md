## Env variables

By default all environment variables loaded through .env.local are only available in the Node.js environment, meaning they won't be exposed to the browser.

In order to expose a variable to the browser you have to prefix the variable with NEXT_PUBLIC_.
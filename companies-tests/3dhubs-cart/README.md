## 3D Hubs Test Assignment

I assumed that the only possible extension to upload is .stl.
The test file is attached as well.

As a proof that additional data can be returned from a backend,
backend is replacing data uri with url, while saving the file,
in future we can return price, possible materials etc at the same time.

Backend is located in server/ directory.

Backend logic:
* I'm using state persistence for the cart as it's more flexible.
  As a follow up to what I have now at server/index.js, I'd
  implement additional validation for keeping the state
  (currently, per example, I'm not checking uuid field content,
  which might lead to vulnerability, although in production
  system I'd use sha1)

The store & actions logic are located in:
* src/actions
* src/stores

And covered with tests (most of the code).

### Installation

You'll need to have `yarn` to install the deps, you intall yarn by running `npm install -g yarn`

Run `yarn`

### Running

Run `yarn start`

Frontend is using port 3000, backend is using port 3001

### Testing

Run `yarn test`

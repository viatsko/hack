import React from 'react';
import { Provider } from 'react-redux';
import { combineReducers, createStore, applyMiddleware, compose } from 'redux';
import thunk from 'redux-thunk';

import './App.css';

import Cart from './components/Cart';
import * as stores from './stores';

const createStoreWithMiddleware = compose(applyMiddleware(
  thunk,
))(createStore);

const store = createStoreWithMiddleware(
  combineReducers(stores),
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
);

export default () =>
  <Provider store={store}>
    <div className="App">
      <div className="App-container">
        <Cart />
      </div>
    </div>
  </Provider>
;

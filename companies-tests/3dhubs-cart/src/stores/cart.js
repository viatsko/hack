import update from 'immutability-helper';

import * as constants from '../constants';

import { generateUUID } from '../utils';

/**
 * Initial state.
 *
 * It has only one key, items, which keeps all the items added to cart.
 *
 * Every item has quantity and some properties (e. g. name, data).
 *
 * Data property of each item is represented by it's base64 value.
 *
 * @type {Object}
 */
const initialState = {
  items: [],
  savePending: false,
  saveSucceeded: null,
  saveError: null,
  restorePending: false,
  restoreSucceeded: null,
  restoreError: null,
};

const actionsMap = {
  /**
   * The purpose of this action is to completely clear up the cart
   *
   * @returns {Object} Returns the initial state
   */
  [constants.CART_CLEAR_ITEMS]: () => initialState,

  /**
   * Adds a new item to items key of state.
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_ADD_ITEM]: (state, action) => {
    action.item.uuid = generateUUID();

    return update(state, { items: { $push: [action.item] } })
  },

  /**
   * Removes an item represented by action.item from the state.
   *
   * If item doesn't exist in a state, nothing will be changed in a state.
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_REMOVE_ITEM]: (state, action) => {
    const index = state.items.indexOf(action.item);

    if (index === -1) {
      return state;
    }

    return update(state, { items: { $splice: [[index, 1]] } });
  },

  /**
   * Updates properies to the value of action.props, represented
   * by an item, which equals to action.item.
   *
   * If item doesn't exist in a state, nothing will be changed in a state.
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_UPDATE_ITEM_PROPERTIES]: (state, action) => {
    const index = state.items.indexOf(action.item);

    if (index === -1) {
      return state;
    }

    let newState = state;

    Object.keys(action.props).forEach((key) => {
      newState = update(newState, { items: { [index]: { [key]: { $set: action.props[key] } } } });
    });

    return newState;
  },

  /**
   * Updates quantity to the value of action.value, represented
   * by an item, which equals to action.item.
   *
   * There's a limit for a quantity, which is 1-1000, everything outside
   * it will be counted as 1.
   *
   * If item doesn't exist in a state, nothing will be changed in a state.
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_UPDATE_ITEM_QUANTITY]: (state, action) => {
    const index = state.items.indexOf(action.item);

    if (index === -1) {
      return state;
    }

    let quantity = action.quantity;

    // We require passed quantity to be a string, otherwise
    // we will assign 1 to it
    if (!/^\d+$/.test(quantity)) {
      quantity = 1;
    }

    quantity = parseInt(quantity, 10);

    // Quantity can only be of a value from 1 to 1000,
    // everything else will be assigned as 1
    if (quantity < 1 || quantity > 1000) {
      quantity = 1;
    }

    return update(state, { items: { [index]: { quantity: { $set: quantity } } } });
  },

  /**
   * Sets related state fields regarding store saving
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_SAVE]: (state, action) => {
    return {...state, savePending: true, saveSucceeded: null, saveError: null};
  },

  /**
   * Sets state fields reporting success saving of the cart
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_SAVE_SUCCESS]: (state, action) => {
    const newState = update(state, {
      items: {
        $set: action.response && action.response.items ? action.response.items : [],
      },
    });
    return {...newState, savePending: false, saveSucceeded: true, saveError: false};
  },

  /**
   * Sets state fields reporting failed saving of the cart
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_SAVE_ERROR]: (state, action) => {
    return {...state, savePending: false, saveSucceeded: false, saveError: true};
  },

  /**
   * Sets related state fields regarding store restoring
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_RESTORE]: (state, action) => {
    return {...state, restorePending: true, restoreSucceeded: null, restoreError: null};
  },

  /**
   * Sets state fields reporting success restore of the cart
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_RESTORE_SUCCESS]: (state, action) => {
    const newState = update(state, {
      items: {
        // this is different from SAVE_SUCCESS as RESTORE is returning the whole state
        $set: action.response && action.response.cart && action.response.cart.items ? action.response.cart.items : [],
      },
    });
    return {...newState, restorePending: false, restoreSucceeded: true, restoreError: false};
  },

  /**
   * Sets state fields reporting failed restore of the cart
   *
   * @param {Object} state previous state of the store
   * @param {Object} action object, which represents executed action
   *
   * @returns {Object} Returns the new state
   */
  [constants.CART_RESTORE_ERROR]: (state, action) => {
    return {...state, restorePending: false, restoreSucceeded: false, restoreError: true};
  },
};

export default function cart(state = initialState, action) {
  const reduceFn = actionsMap[action.type];

  if (!reduceFn) {
    return state;
  }

  return Object.assign({}, state, reduceFn(state, action));
}

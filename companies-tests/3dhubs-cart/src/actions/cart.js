import * as constants from '../constants';

import { checkStatus } from '../utils';

/**
 * For every action, you can check the actual modification it does to store
 * in a store file
 *
 * @see {@link ../stores/cart.js} for the concrete store update implementation functions
 */

/**
 * Clears the cart
 *
 * @return {Object} action object
 */
export function clearItems() {
  return {
    type: constants.CART_CLEAR_ITEMS,
  };
}

/**
 * Adds item to the cart
 *
 * @param {Object} item item to add to the cart
 *
 * @return {Object} action object
 */
export function addItem(item) {
  return {
    type: constants.CART_ADD_ITEM,
    item,
  };
}

/**
 * Removes item from the cart
 *
 * @param  {Object} item item to remove
 *
 * @return {Object} action object
 */
export function removeItem(item) {
  return {
    type: constants.CART_REMOVE_ITEM,
    item,
  };
}

/**
 * Updates quantity of the specified item
 *
 * @param  {Object} item     item to update quantity for
 * @param  {Number} quantity new quantity of the item
 *
 * @return {Object} action object
 */
export function updateItemQuantity(item, quantity) {
  return {
    type: constants.CART_UPDATE_ITEM_QUANTITY,
    item,
    quantity,
  };
}

/**
 * Updates properties of the specified item
 *
 * @param  {Object} item     item to update quantity for
 * @param  {Object} props    new props to assign to item
 *
 * @return {Object} action object
 */
export function updateItemProperties(item, props) {
  return {
    type: constants.CART_UPDATE_ITEM_PROPERTIES,
    item,
    props,
  };
}

/**
 * Saves cart state to the backend
 *
 * @return {Object} action object
 */
export function save() {
  return (dispatch, getState) => {
    var currentState = getState();

    dispatch({
      type: constants.CART_SAVE
    });

    window.fetch('/api/save_cart', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(currentState)
    })
    .then(checkStatus)
    .then((response) => response.json())
    .then((json) => dispatch(saveSuccess(json)))
    .catch((error) => {
      console.error(error);
      dispatch(saveError(error));
    });
  }
}

/**
 * Reports successful save of data to the backend
 *
 * @param  {Number} response response for saving data to the backend
 *
 * @return {Object} action object
 */
export function saveSuccess(response) {
  return {
    type: constants.CART_SAVE_SUCCESS,
    response,
  };
}

/**
 * Reports failure while saving state to the backend
 *
 * @param  {Object} error error object
 *
 * @return {Object} action object
 */
export function saveError(error) {
  return {
    type: constants.CART_SAVE_ERROR,
    error,
  }
}

/**
 * Restores cart state from the backend
 *
 * @return {Object} action object
 */
export function restore() {
  return (dispatch, getState) => {
    dispatch({
      type: constants.CART_RESTORE
    });

    // var data = new FormData();
    // data.append("json", JSON.stringify(currentState));

    window.fetch('/api/restore', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      }
    })
    .then(checkStatus)
    .then((response) => response.json())
    .then((json) => dispatch(restoreSuccess(json)))
    .catch((error) => {
      console.error(error);
      dispatch(restoreError(error));
    });
  }
}

/**
 * Reports successful restore of data from the backend
 *
 * @param  {Number} response response for saving data to the backend
 *
 * @return {Object} action object
 */
export function restoreSuccess(response) {
  return {
    type: constants.CART_RESTORE_SUCCESS,
    response,
  };
}

/**
 * Reports failure while restoring state from the backend
 *
 * @param  {Object} error error object
 *
 * @return {Object} action object
 */
export function restoreError(error) {
  return {
    type: constants.CART_RESTORE_ERROR,
    error,
  }
}

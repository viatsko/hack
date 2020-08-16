import * as actions from './cart';
import * as constants from '../constants';

// TODO CART_SAVE, CART_RESTORE

describe('actions', () => {
  it('should create an action to clear items', () => {
    const expectedAction = {
      type: constants.CART_CLEAR_ITEMS,
    };

    expect(actions.clearItems()).toEqual(expectedAction);
  });

  it('should create an action to add a item', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const expectedAction = {
      type: constants.CART_ADD_ITEM,
      item,
    };

    expect(actions.addItem(item)).toEqual(expectedAction);
  });

  it('should create an action to remove a item', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const expectedAction = {
      type: constants.CART_REMOVE_ITEM,
      item,
    };

    expect(actions.removeItem(item)).toEqual(expectedAction);
  });

  it('should create an action to update item\'s quantity', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const expectedAction = {
      type: constants.CART_UPDATE_ITEM_QUANTITY,
      item,
      quantity: 2,
    };

    expect(actions.updateItemQuantity(item, 2)).toEqual(expectedAction);
  });

  it('should create an action to update item\'s properties', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const expectedAction = {
      type: constants.CART_UPDATE_ITEM_PROPERTIES,
      item,
      props: { name: 'test' },
    };

    expect(actions.updateItemProperties(item, { name: 'test' })).toEqual(expectedAction);
  });

  it('should create an action to report success from backend saving cart', () => {
    const expectedAction = {
      type: constants.CART_SAVE_SUCCESS,
      response: {
        data: [],
      },
    };

    expect(actions.saveSuccess({
      data: [],
    })).toEqual(expectedAction);
  });

  it('should create an action to report failure from backend saving cart', () => {
    const expectedAction = {
      type: constants.CART_SAVE_ERROR,
      error: 'Oh no, everything is broken',
    };

    expect(actions.saveError('Oh no, everything is broken')).toEqual(expectedAction);
  });

  it('should create an action to report success from backend restoring cart', () => {
    const expectedAction = {
      type: constants.CART_RESTORE_SUCCESS,
      response: {
        data: [],
      },
    };

    expect(actions.restoreSuccess({
      data: [],
    })).toEqual(expectedAction);
  });

  it('should create an action to report failure from backend restoring cart', () => {
    const expectedAction = {
      type: constants.CART_RESTORE_ERROR,
      error: 'Oh no, everything is broken',
    };

    expect(actions.restoreError('Oh no, everything is broken')).toEqual(expectedAction);
  });
});

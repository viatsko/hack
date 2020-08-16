import reducer from './cart';
import * as constants from '../constants';
import { generateUUID } from '../utils';

describe('cart reducer', () => {
  it('should return the initial state', () => {
    expect(
      reducer(undefined, {}),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('show handle CART_CLEAR_ITEMS', () => {
    expect(
      reducer(
        {
          items: [
            {
              name: 'Test item',
              data: 'whateverdata',
              quantity: 1,
            },
            {
              name: 'Test item 2',
              data: 'whateverdata2',
              quantity: 1,
            },
          ],
          savePending: false,
          saveSucceeded: null,
          saveError: null,
          restorePending: false,
          restoreSucceeded: null,
          restoreError: null,
        },
        {
          type: constants.CART_CLEAR_ITEMS,
        },
      ),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_ADD_ITEM', () => {
    expect(
      reducer({
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      }, {
        type: constants.CART_ADD_ITEM,
        item: {
          name: 'Test item',
          data: 'whateverdata',
          quantity: 1,
        },
      }),
    ).toEqual(
      {
        items: [
          {
            uuid: expect.anything(),
            name: 'Test item',
            data: 'whateverdata',
            quantity: 1,
          },
        ],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );

    expect(
      reducer(
        {
          items: [
            {
              name: 'Test item',
              data: 'whateverdata',
              quantity: 1,
              uuid: generateUUID(),
            },
          ],
          savePending: false,
          saveSucceeded: null,
          saveError: null,
          restorePending: false,
          restoreSucceeded: null,
          restoreError: null,
        },
        {
          type: constants.CART_ADD_ITEM,
          item: {
            name: 'Test item',
            data: 'whateverdata',
            quantity: 1,
          },
        },
      ),
    ).toEqual(
      {
        items: [
          {
            name: 'Test item',
            data: 'whateverdata',
            quantity: 1,
            uuid: expect.anything(),
          },
          {
            name: 'Test item',
            data: 'whateverdata',
            quantity: 1,
            uuid: expect.anything(),
          },
        ],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_REMOVE_ITEM', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const initialState = {
      items: [
        item,
      ],
      savePending: false,
      saveSucceeded: null,
      saveError: null,
      restorePending: false,
      restoreSucceeded: null,
      restoreError: null,
    };

    expect(
      reducer(initialState, {
        type: constants.CART_REMOVE_ITEM,
        item,
      }),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_REMOVE_ITEM for non-existing element returning unchanged state', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    expect(
      reducer(
        {
          items: [],
          savePending: false,
          saveSucceeded: null,
          saveError: null,
          restorePending: false,
          restoreSucceeded: null,
          restoreError: null,
        },
        {
          type: constants.CART_REMOVE_ITEM,
          item,
        },
      ),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_UPDATE_ITEM_QUANTITY', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const itemWithUpdatedQuantity = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 2,
    };

    const initialState = {
      items: [
        item,
      ],
      savePending: false,
      saveSucceeded: null,
      saveError: null,
      restorePending: false,
      restoreSucceeded: null,
      restoreError: null,
    };

    expect(
      reducer(initialState, {
        type: constants.CART_UPDATE_ITEM_QUANTITY,
        item,
        quantity: 2,
      }),
    ).toEqual(
      {
        items: [
          itemWithUpdatedQuantity,
        ],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_UPDATE_ITEM_QUANTITY setting quantity to 1 if it is outside of 1-1000 range', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const itemWithUpdatedQuantity = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const initialState = {
      items: [
        item,
      ],
      savePending: false,
      saveSucceeded: null,
      saveError: null,
      restorePending: false,
      restoreSucceeded: null,
      restoreError: null,
    };

    expect(
      reducer(initialState, {
        type: constants.CART_UPDATE_ITEM_QUANTITY,
        item,
        quantity: 1001,
      }),
    ).toEqual(
      {
        items: [
          itemWithUpdatedQuantity,
        ],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );

    expect(
      reducer(initialState, {
        type: constants.CART_UPDATE_ITEM_QUANTITY,
        item,
        quantity: 0,
      }),
    ).toEqual(
      {
        items: [
          itemWithUpdatedQuantity,
        ],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_UPDATE_ITEM_PROPERTIES', () => {
    const item = {
      name: 'Test item',
      data: 'whateverdata',
      quantity: 1,
    };

    const itemWithUpdatedProperties = {
      name: 'Test item 2',
      data: 'whateverdata',
      quantity: 1,
    };

    const initialState = {
      items: [
        item,
      ],
      savePending: false,
      saveSucceeded: null,
      saveError: null,
      restorePending: false,
      restoreSucceeded: null,
      restoreError: null,
    };

    expect(
      reducer(initialState, {
        type: constants.CART_UPDATE_ITEM_PROPERTIES,
        item,
        props: {
          name: 'Test item 2',
        },
      }),
    ).toEqual(
      {
        items: [
          itemWithUpdatedProperties,
        ],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_SAVE', () => {
    expect(
      reducer(undefined, {
        type: constants.CART_SAVE,
      }),
    ).toEqual(
      {
        items: [],
        savePending: true,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_SAVE_SUCCESS', () => {
    expect(
      reducer(undefined, {
        type: constants.CART_SAVE_SUCCESS,
        response: {
          items: [],
        },
      }),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: true,
        saveError: false,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_SAVE_ERROR', () => {
    expect(
      reducer(undefined, {
        type: constants.CART_SAVE_ERROR,
      }),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: false,
        saveError: true,
        restorePending: false,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_RESTORE', () => {
    expect(
      reducer(undefined, {
        type: constants.CART_RESTORE,
      }),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: true,
        restoreSucceeded: null,
        restoreError: null,
      },
    );
  });

  it('should handle CART_RESTORE_SUCCESS', () => {
    expect(
      reducer(undefined, {
        type: constants.CART_RESTORE_SUCCESS,
        response: {
          items: [],
        },
      }),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: true,
        restoreError: false,
      },
    );
  });

  it('should handle CART_RESTORE_ERROR', () => {
    expect(
      reducer(undefined, {
        type: constants.CART_RESTORE_ERROR,
      }),
    ).toEqual(
      {
        items: [],
        savePending: false,
        saveSucceeded: null,
        saveError: null,
        restorePending: false,
        restoreSucceeded: false,
        restoreError: true,
      },
    );
  });
});

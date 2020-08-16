import React from 'react';
import ShallowRenderer from 'react-test-renderer/shallow';

import FiltersAndSortingPanel from './FiltersAndSortingPanel';

describe('FiltersAndSortingPanel', () => {
  it('should render correctly', () => {
    const renderer = new ShallowRenderer();
    renderer.render(<FiltersAndSortingPanel />);

    expect(renderer.getRenderOutput()).toMatchSnapshot();
  });
});


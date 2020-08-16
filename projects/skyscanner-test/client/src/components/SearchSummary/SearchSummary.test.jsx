import React from 'react';
import TestRenderer from 'react-test-renderer';

import SearchSummary from './SearchSummary';

describe('SearchSummary', () => {
  it('should render correctly', () => {
    const tree = TestRenderer.create(<SearchSummary />).toJSON();

    expect(tree).toMatchSnapshot();
  });
});


import React from 'react';
import BpkPanel from 'bpk-component-panel';
import BpkCard from 'bpk-component-card';

import STYLES from './SearchResults.scss';

const c = className => STYLES[className] || 'UNKNOWN';

const SearchResults = () => (
  <BpkPanel fullWidth className={c('SearchResults')}>
    <BpkCard className={c('SearchResults__card')}>
      test
    </BpkCard>
  </BpkPanel>
);

export default SearchResults;

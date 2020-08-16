import React from 'react';
import BpkPanel from 'bpk-component-panel';

import STYLES from './SearchSummary.scss';

import longArrow from './long-arrow.svg';

const c = className => STYLES[className] || 'UNKNOWN';

const SearchSummary = () => (
  <BpkPanel fullWidth className={c('SearchSummary')}>
    <div className={c('SearchSummary__flight-direction')}>
      EDI <img className={c('SearchSummary__flight-direction-arrow')} alt="➡️" src={longArrow} /> LON
    </div>
    <div className={c('SearchSummary__flight-configuration')}>
      2 travellers, economy
    </div>
  </BpkPanel>
);

export default SearchSummary;

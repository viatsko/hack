import React from 'react';
import BpkPanel from 'bpk-component-panel';
import BpkButtonLink from 'bpk-component-link';

import priceAlerts from './price-alerts.svg';

import STYLES from './FiltersAndSortingPanel.scss';

const c = className => STYLES[className] || 'UNKNOWN';

const Header = () => (
  <BpkPanel fullWidth className={c('FiltersAndSortingPanel')}>
    <div className={c('FiltersAndSortingPanel__left-section')}>
      <BpkButtonLink className={c('FiltersAndSortingPanel__button')} onClick={() => console.log('filter button click!')}>Filter</BpkButtonLink>
      <BpkButtonLink className={c('FiltersAndSortingPanel__button')} onClick={() => console.log('sort button click!')}>Sort</BpkButtonLink>
    </div>
    <div className={c('FiltersAndSortingPanel__right-section')}>
      <BpkButtonLink className={c('FiltersAndSortingPanel__button')} onClick={() => console.log('price alert button click!')}>
        <img className={c('FiltersAndSortingPanel__price-alerts-icon')} alt="🛎" role="presentation" src={priceAlerts} />
        Price alerts
      </BpkButtonLink>
    </div>
  </BpkPanel>
);

export default Header;

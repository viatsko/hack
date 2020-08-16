import React from 'react';

import STYLES from './App.scss';
import Header from './../Header';
import SearchSummary from '../SearchSummary';
import FiltersAndSortingPanel from '../FiltersAndSortingPanel';
import SearchResults from '../SearchResults';

const c = className => STYLES[className] || 'UNKNOWN';

const App = () => (
  <div className={c('App')}>
    <Header />
    <main className={c('App__main')}>
      <SearchSummary />
      <FiltersAndSortingPanel />
      <SearchResults />
    </main>
  </div>
);

export default App;

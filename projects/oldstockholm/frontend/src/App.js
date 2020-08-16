import React, { Component } from 'react';
import './App.css';
import SimpleMap from './components/SimpleMap';
import SidePanel from './components/SidePanel';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-sidepanel">
          <SidePanel />
        </div>
        <SimpleMap />
        {/* <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p> */}
      </div>
    );
  }
}

export default App;

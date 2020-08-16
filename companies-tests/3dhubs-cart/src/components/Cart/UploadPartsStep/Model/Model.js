import React from 'react';
import PropTypes from 'prop-types';
import STLViewer from 'stl-viewer';

import CloseButton from '../../../CloseButton';

import './Model.css';

const Model = ({
  name,
  quantity,
  data,
  url,
  onCloseButtonClick,
  onIncreaseQuantityButtonClick,
  onDecreaseQuantityButtonClick,
  onQuantityInputUpdate,
}) =>
<div className="Model">
  <div className="Model-inner">
    <div className="Model-render">
      <STLViewer
        url={url ? url : data}
        width={200}
        height={200}
        modelColor="#B92C2C"
        backgroundColor="#EAEAEA"
        rotate
        orbitControls
      />
    </div>
    <div className="Model-inner-content">
      <CloseButton onClick={onCloseButtonClick} />
      <div className="Model-name">
        {name}
      </div>
      <div className="Model-quantity">
        <button onClick={onDecreaseQuantityButtonClick}>-</button>
        <input type="number" value={quantity} onChange={onQuantityInputUpdate} />
        <button onClick={onIncreaseQuantityButtonClick}>+</button>
      </div>
      <div style={{
        display: data ? 'block' : 'none'
      }}>Processing item...</div>
    </div>
  </div>
</div>;

Model.propTypes = {
  name: PropTypes.string.isRequired,
  quantity: PropTypes.number.isRequired,
  data: PropTypes.string,
  url: PropTypes.string,
  onCloseButtonClick: PropTypes.func.isRequired,
};

export default Model;

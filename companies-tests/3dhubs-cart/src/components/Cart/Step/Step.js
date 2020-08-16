import React from 'react';
import PropTypes from 'prop-types';

import './Step.css';

import NumberIcon from './NumberIcon';

const Step = ({
  index, // Index of the step (order number is index + 1)
  name, // Name of the step, literally title
  children, // step inner content
}) =>
<div className="Step">
  <div className="Step-header">
    <NumberIcon>{index + 1}</NumberIcon> {name}
  </div>
  <div className="Step-content">
    {children}
  </div>
</div>;

Step.propTypes = {
  index: PropTypes.number,
  name: PropTypes.string,
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.element),
    PropTypes.element,
  ]),
};

export default Step;

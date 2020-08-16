import React from 'react';
import PropTypes from 'prop-types';

import './NumberIcon.css';

const NumberIcons = ({ children }) => <div className="NumberIcon">{children}</div>;

NumberIcons.propTypes = {
  children: PropTypes.number.isRequired,
};

export default NumberIcons;

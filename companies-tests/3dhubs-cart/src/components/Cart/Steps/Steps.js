import React from 'react';
import PropTypes from 'prop-types';

const Steps = ({ children }) =>
<div>
  {React.Children.map(children,
    (child, index) => React.cloneElement(child, {
      index,
    })
  )}
</div>;

Steps.propTypes = {
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.element),
    PropTypes.element,
  ]),
};

export default Steps;

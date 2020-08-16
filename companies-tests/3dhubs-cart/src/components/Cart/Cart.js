import React from 'react';

import './Cart.css';

import Steps from './Steps';
import Step from './Step';

import UploadPartsStep from './UploadPartsStep';

export default () =>
  <div className="Cart">
    <Steps>
      <UploadPartsStep />
      <Step name="Select a material">
      </Step>
      <Step name="Select a 3D printing service for High Detail Resin">
      </Step>
    </Steps>
  </div>;

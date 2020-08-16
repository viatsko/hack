import Dropzone from 'react-dropzone';
import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

import {
  addItem,
  removeItem,
  updateItemQuantity,
  save,
  restore,
} from '../../../actions/cart';

import './UploadPartsStep.css';

import Model from './Model';
import Step from '../Step';

@connect(state => ({
  cart: state.cart,
}))
export default class UploadPartsStep extends React.Component {
  static propTypes = {
    dispatch: PropTypes.func.isRequired,
    cart: PropTypes.object.isRequired,
  };

  componentDidMount() {
    const { dispatch } = this.props;

    dispatch(restore());
  }

  onDrop(uploadedFiles) {
    const { dispatch } = this.props;

    uploadedFiles.forEach(file => {
      const reader = new FileReader();

      reader.readAsDataURL(file);

      reader.onload = () => {
        dispatch(addItem({
          name: file.name,
          data: reader.result,
          quantity: 1,
        }));

        dispatch(save());
      };
    });
  }

  onModelCloseButtonClick(model) {
    const { dispatch } = this.props;

    dispatch(removeItem(model));

    dispatch(save());
  }

  onModelIncreaseQuantityButtonClick(model) {
    const { dispatch } = this.props;

    dispatch(updateItemQuantity(model, model.quantity + 1));

    dispatch(save());
  }

  onModelDecreaseQuantityButtonClick(model) {
    const { dispatch } = this.props;

    dispatch(updateItemQuantity(model, model.quantity - 1));

    dispatch(save());
  }

  onModelQuantityInputUpdate(model, event) {
    const { dispatch } = this.props;

    dispatch(updateItemQuantity(model, event.target.value));

    dispatch(save());
  }

  render() {
    return (
      <Step name="Upload your parts" {...this.props}>
        <div style={{
          display: this.props.cart.restorePending ? 'block' : 'none'
        }}>Loading cart...</div>
        <div className="UploadPartsStep-models">
          {
            this.props.cart.items.map((model, key) =>
              <Model
                key={key}
                onCloseButtonClick={this.onModelCloseButtonClick.bind(this, model)}
                onIncreaseQuantityButtonClick={this.onModelIncreaseQuantityButtonClick.bind(this, model)}
                onDecreaseQuantityButtonClick={this.onModelDecreaseQuantityButtonClick.bind(this, model)}
                onQuantityInputUpdate={this.onModelQuantityInputUpdate.bind(this, model)}
                {...model}
              />
            )
          }
        </div>
        <Dropzone accept=".stl" className="UploadPartsStep-dropzone" onDrop={this.onDrop.bind(this)}>
          <p>Try dropping some files here, or click to select files to upload.</p>
        </Dropzone>
      </Step>
    );
  }
}

/*-
 * -\-\-
 * retailcrm-moysklad-sync
 * --
 * Copyright (C) 2017 Valerii Iatsko
 * --
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * -/-/-
 */

package me.viatsko.retailcrm_moysklad_sync.entity.moysklad;

public class MoySkladOrderPosition {
    public Integer quantity;

    public Double price;

    public Double discount;

    public Integer reserve;

    public MoySkladOrderPositionAssortment assortment;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    public MoySkladOrderPositionAssortment getAssortment() {
        return assortment;
    }

    public void setAssortment(MoySkladOrderPositionAssortment assortment) {
        this.assortment = assortment;
    }

    @Override
    public String toString() {
        return "MoySkladOrderPosition{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                ", reserve=" + reserve +
                ", assortment=" + assortment +
                '}';
    }

    public static final class MoySkladOrderPositionBuilder {
        public Integer quantity;
        public Double price;
        public Double discount;
        public Integer reserve;
        public MoySkladOrderPositionAssortment assortment;

        public MoySkladOrderPositionBuilder() {
        }

        public static MoySkladOrderPositionBuilder aMoySkladOrderPosition() {
            return new MoySkladOrderPositionBuilder();
        }

        public MoySkladOrderPositionBuilder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public MoySkladOrderPositionBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public MoySkladOrderPositionBuilder withDiscount(Double discount) {
            this.discount = discount;
            return this;
        }

        public MoySkladOrderPositionBuilder withReserve(Integer reserve) {
            this.reserve = reserve;
            return this;
        }

        public MoySkladOrderPositionBuilder withAssortment(MoySkladOrderPositionAssortment assortment) {
            this.assortment = assortment;
            return this;
        }

        public MoySkladOrderPosition build() {
            MoySkladOrderPosition moySkladOrderPosition = new MoySkladOrderPosition();
            moySkladOrderPosition.setQuantity(quantity);
            moySkladOrderPosition.setPrice(price);
            moySkladOrderPosition.setDiscount(discount);
            moySkladOrderPosition.setReserve(reserve);
            moySkladOrderPosition.setAssortment(assortment);
            return moySkladOrderPosition;
        }
    }
}

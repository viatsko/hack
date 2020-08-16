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

import java.util.List;

public class MoySkladCreateCounterPartyRequest {
	public String name;

	public String description;

	public String code;

	public String externalCode;

	public String email;

	public String phone;

	public String fax;

	public String actualAddress;

	public String legalTitle;

	public String legalAddress;

	public String inn;

	public String kpp;

	public String ogrn;

	public String okpo;

	public List<String> tags;

	public MoySkladCounterPartyState state;

	public String priceType;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	public String getExternalCode() {
		return externalCode;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getFax() {
		return fax;
	}

	public String getActualAddress() {
		return actualAddress;
	}

	public String getLegalTitle() {
		return legalTitle;
	}

	public String getLegalAddress() {
		return legalAddress;
	}

	public String getInn() {
		return inn;
	}

	public String getKpp() {
		return kpp;
	}

	public String getOgrn() {
		return ogrn;
	}

	public String getOkpo() {
		return okpo;
	}

	public List<String> getTags() {
		return tags;
	}

	public MoySkladCounterPartyState getState() {
		return state;
	}

	public String getPriceType() {
		return priceType;
	}

	@Override
	public String toString() {
		return "MoySkladCreateCounterPartyRequest{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", code='" + code + '\'' +
				", externalCode='" + externalCode + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", fax='" + fax + '\'' +
				", actualAddress='" + actualAddress + '\'' +
				", legalTitle='" + legalTitle + '\'' +
				", legalAddress='" + legalAddress + '\'' +
				", inn='" + inn + '\'' +
				", kpp='" + kpp + '\'' +
				", ogrn='" + ogrn + '\'' +
				", okpo='" + okpo + '\'' +
				", tags=" + tags +
				", state=" + state +
				", priceType='" + priceType + '\'' +
				'}';
	}

	public static final class MoySkladCreateCounterPartyRequestBuilder {
		public String name;
		public String description;
		public String code;
		public String externalCode;
		public String email;
		public String phone;
		public String fax;
		public String actualAddress;
		public String legalTitle;
		public String legalAddress;
		public String inn;
		public String kpp;
		public String ogrn;
		public String okpo;
		public List<String> tags;
		public MoySkladCounterPartyState state;
		public String priceType;

		public MoySkladCreateCounterPartyRequestBuilder() {
		}

		public static MoySkladCreateCounterPartyRequestBuilder aMoySkladCreateCounterPartyRequest() {
			return new MoySkladCreateCounterPartyRequestBuilder();
		}

		public MoySkladCreateCounterPartyRequestBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withCode(String code) {
			this.code = code;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withExternalCode(String externalCode) {
			this.externalCode = externalCode;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withFax(String fax) {
			this.fax = fax;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withActualAddress(String actualAddress) {
			this.actualAddress = actualAddress;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withLegalTitle(String legalTitle) {
			this.legalTitle = legalTitle;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withLegalAddress(String legalAddress) {
			this.legalAddress = legalAddress;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withInn(String inn) {
			this.inn = inn;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withKpp(String kpp) {
			this.kpp = kpp;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withOgrn(String ogrn) {
			this.ogrn = ogrn;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withOkpo(String okpo) {
			this.okpo = okpo;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withTags(List<String> tags) {
			this.tags = tags;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withState(MoySkladCounterPartyState state) {
			this.state = state;
			return this;
		}

		public MoySkladCreateCounterPartyRequestBuilder withPriceType(String priceType) {
			this.priceType = priceType;
			return this;
		}

		public MoySkladCreateCounterPartyRequest build() {
			MoySkladCreateCounterPartyRequest moySkladCreateCounterPartyRequest = new MoySkladCreateCounterPartyRequest();
			moySkladCreateCounterPartyRequest.name = this.name;
			moySkladCreateCounterPartyRequest.code = this.code;
			moySkladCreateCounterPartyRequest.legalTitle = this.legalTitle;
			moySkladCreateCounterPartyRequest.inn = this.inn;
			moySkladCreateCounterPartyRequest.phone = this.phone;
			moySkladCreateCounterPartyRequest.kpp = this.kpp;
			moySkladCreateCounterPartyRequest.okpo = this.okpo;
			moySkladCreateCounterPartyRequest.fax = this.fax;
			moySkladCreateCounterPartyRequest.state = this.state;
			moySkladCreateCounterPartyRequest.priceType = this.priceType;
			moySkladCreateCounterPartyRequest.tags = this.tags;
			moySkladCreateCounterPartyRequest.actualAddress = this.actualAddress;
			moySkladCreateCounterPartyRequest.description = this.description;
			moySkladCreateCounterPartyRequest.ogrn = this.ogrn;
			moySkladCreateCounterPartyRequest.externalCode = this.externalCode;
			moySkladCreateCounterPartyRequest.legalAddress = this.legalAddress;
			moySkladCreateCounterPartyRequest.email = this.email;
			return moySkladCreateCounterPartyRequest;
		}
	}
}

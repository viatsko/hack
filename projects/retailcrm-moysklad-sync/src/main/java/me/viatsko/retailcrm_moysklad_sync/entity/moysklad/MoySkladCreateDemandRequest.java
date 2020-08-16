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

public class MoySkladCreateDemandRequest {
	public Boolean applicable;

	public Boolean vatEnabled;

	public MoySkladDemandCustomerOrder customerOrder;

	public MoySkladGenericAgent agent;

	public MoySkladGenericOrganization organization;

	public MoySkladGenericStore store;

	public List<MoySkladOrderPosition> positions;

	public Boolean getApplicable() {
		return applicable;
	}

	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}

	public Boolean getVatEnabled() {
		return vatEnabled;
	}

	public void setVatEnabled(Boolean vatEnabled) {
		this.vatEnabled = vatEnabled;
	}

	public MoySkladDemandCustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(MoySkladDemandCustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public MoySkladGenericOrganization getOrganization() {
		return organization;
	}

	public void setOrganization(MoySkladGenericOrganization organization) {
		this.organization = organization;
	}

	public MoySkladGenericAgent getAgent() {
		return agent;
	}

	public MoySkladGenericStore getStore() {
		return store;
	}

	public void setStore(MoySkladGenericStore store) {
		this.store = store;
	}

	public void setAgent(MoySkladGenericAgent agent) {
		this.agent = agent;
	}

	public List<MoySkladOrderPosition> getPositions() {
		return positions;
	}

	public void setPositions(List<MoySkladOrderPosition> positions) {
		this.positions = positions;
	}

	@Override
	public String toString() {
		return "MoySkladCreateDemandRequest{" +
				"applicable=" + applicable +
				", vatEnabled=" + vatEnabled +
				", customerOrder=" + customerOrder +
				", agent=" + agent +
				", organization=" + organization +
				", store=" + store +
				", positions=" + positions +
				'}';
	}

	public static final class MoySkladCreateDemandRequestBuilder {
		public Boolean applicable;
		public Boolean vatEnabled;
		public MoySkladDemandCustomerOrder customerOrder;
		public MoySkladGenericAgent agent;
		public MoySkladGenericOrganization organization;
		public MoySkladGenericStore store;
		public List<MoySkladOrderPosition> positions;

		public MoySkladCreateDemandRequestBuilder() {
		}

		public static MoySkladCreateDemandRequestBuilder aMoySkladCreateDemandRequest() {
			return new MoySkladCreateDemandRequestBuilder();
		}

		public MoySkladCreateDemandRequestBuilder withApplicable(Boolean applicable) {
			this.applicable = applicable;
			return this;
		}

		public MoySkladCreateDemandRequestBuilder withVatEnabled(Boolean vatEnabled) {
			this.vatEnabled = vatEnabled;
			return this;
		}

		public MoySkladCreateDemandRequestBuilder withCustomerOrder(MoySkladDemandCustomerOrder customerOrder) {
			this.customerOrder = customerOrder;
			return this;
		}

		public MoySkladCreateDemandRequestBuilder withAgent(MoySkladGenericAgent agent) {
			this.agent = agent;
			return this;
		}

		public MoySkladCreateDemandRequestBuilder withOrganization(MoySkladGenericOrganization organization) {
			this.organization = organization;
			return this;
		}

		public MoySkladCreateDemandRequestBuilder withStore(MoySkladGenericStore store) {
			this.store = store;
			return this;
		}

		public MoySkladCreateDemandRequestBuilder withPositions(List<MoySkladOrderPosition> positions) {
			this.positions = positions;
			return this;
		}

		public MoySkladCreateDemandRequest build() {
			MoySkladCreateDemandRequest moySkladCreateDemandRequest = new MoySkladCreateDemandRequest();
			moySkladCreateDemandRequest.setApplicable(applicable);
			moySkladCreateDemandRequest.setVatEnabled(vatEnabled);
			moySkladCreateDemandRequest.setCustomerOrder(customerOrder);
			moySkladCreateDemandRequest.setAgent(agent);
			moySkladCreateDemandRequest.setOrganization(organization);
			moySkladCreateDemandRequest.setStore(store);
			moySkladCreateDemandRequest.setPositions(positions);
			return moySkladCreateDemandRequest;
		}
	}
}

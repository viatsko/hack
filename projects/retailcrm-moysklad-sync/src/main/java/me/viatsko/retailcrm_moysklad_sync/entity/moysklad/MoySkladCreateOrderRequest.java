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

import java.util.Date;
import java.util.List;

public class MoySkladCreateOrderRequest {
    public String name;

    public String code;

	public String description;

    public Date moment;

	public Boolean applicable;

    public Boolean vatEnabled;

    public List<MoySkladOrderPosition> positions;

	public MoySkladGenericAgent agent;

	public MoySkladGenericOrganization organization;

	public MoySkladOrderState state;

	public MoySkladGenericAgent getAgent() {
		return agent;
	}

	public void setAgent(MoySkladGenericAgent agent) {
		this.agent = agent;
	}

	public MoySkladGenericOrganization getOrganization() {
		return organization;
	}

	public void setOrganization(MoySkladGenericOrganization organization) {
		this.organization = organization;
	}

	public MoySkladOrderState getState() {
		return state;
	}

	public void setState(MoySkladOrderState state) {
		this.state = state;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

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

    public List<MoySkladOrderPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<MoySkladOrderPosition> positions) {
        this.positions = positions;

    }

	@Override
	public String toString() {
		return "MoySkladCreateOrderRequest{" +
				"name='" + name + '\'' +
				", code='" + code + '\'' +
				", description='" + description + '\'' +
				", moment=" + moment +
				", applicable=" + applicable +
				", vatEnabled=" + vatEnabled +
				", positions=" + positions +
				", agent=" + agent +
				", organization=" + organization +
				", state=" + state +
				'}';
	}

	public static final class MoySkladCreateOrderRequestBuilder {
		public String name;
		public String code;
		public String description;
		public Date moment;
		public Boolean applicable;
		public Boolean vatEnabled;
		public List<MoySkladOrderPosition> positions;
		public MoySkladGenericAgent agent;
		public MoySkladGenericOrganization organization;
		public MoySkladOrderState state;

		public MoySkladCreateOrderRequestBuilder() {
		}

		public static MoySkladCreateOrderRequestBuilder aMoySkladCreateOrderRequest() {
			return new MoySkladCreateOrderRequestBuilder();
		}

		public MoySkladCreateOrderRequestBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withCode(String code) {
			this.code = code;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withMoment(Date moment) {
			this.moment = moment;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withApplicable(Boolean applicable) {
			this.applicable = applicable;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withVatEnabled(Boolean vatEnabled) {
			this.vatEnabled = vatEnabled;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withPositions(List<MoySkladOrderPosition> positions) {
			this.positions = positions;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withAgent(MoySkladGenericAgent agent) {
			this.agent = agent;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withOrganization(MoySkladGenericOrganization organization) {
			this.organization = organization;
			return this;
		}

		public MoySkladCreateOrderRequestBuilder withState(MoySkladOrderState state) {
			this.state = state;
			return this;
		}

		public MoySkladCreateOrderRequest build() {
			MoySkladCreateOrderRequest moySkladCreateOrderRequest = new MoySkladCreateOrderRequest();
			moySkladCreateOrderRequest.setName(name);
			moySkladCreateOrderRequest.setCode(code);
			moySkladCreateOrderRequest.setDescription(description);
			moySkladCreateOrderRequest.setMoment(moment);
			moySkladCreateOrderRequest.setApplicable(applicable);
			moySkladCreateOrderRequest.setVatEnabled(vatEnabled);
			moySkladCreateOrderRequest.setPositions(positions);
			moySkladCreateOrderRequest.setAgent(agent);
			moySkladCreateOrderRequest.setOrganization(organization);
			moySkladCreateOrderRequest.setState(state);
			return moySkladCreateOrderRequest;
		}
	}
}

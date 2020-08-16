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

public class MoySkladCreateCounterPartyResponse {
	public MoySkladMeta meta;

	public String id;

	public String accountId;

	public MoySkladCounterPartyOwner owner;

	public MoySkladCounterPartyGroup group;

	public Integer version;

	public Date updated;

	public String name;

	public String externalCode;

	public Boolean archived;

	public String companyType;

	public MoySkladCounterPartyAccounts accounts;

	public List<String> tags;

	public MoySkladCounterPartyContactPersons contactpersons;

	public MoySkladCounterPartyNotes notes;

	public MoySkladCounterPartyState state;

	public String priceType;

	public MoySkladMeta getMeta() {
		return meta;
	}

	public String getId() {
		return id;
	}

	public String getAccountId() {
		return accountId;
	}

	public MoySkladCounterPartyOwner getOwner() {
		return owner;
	}

	public MoySkladCounterPartyGroup getGroup() {
		return group;
	}

	public Integer getVersion() {
		return version;
	}

	public Date getUpdated() {
		return updated;
	}

	public String getName() {
		return name;
	}

	public String getExternalCode() {
		return externalCode;
	}

	public Boolean getArchived() {
		return archived;
	}

	public String getCompanyType() {
		return companyType;
	}

	public MoySkladCounterPartyAccounts getAccounts() {
		return accounts;
	}

	public List<String> getTags() {
		return tags;
	}

	public MoySkladCounterPartyContactPersons getContactpersons() {
		return contactpersons;
	}

	public MoySkladCounterPartyNotes getNotes() {
		return notes;
	}

	public MoySkladCounterPartyState getState() {
		return state;
	}

	public String getPriceType() {
		return priceType;
	}

	@Override
	public String toString() {
		return "MoySkladCreateCounterPartyResponse{" +
				"meta=" + meta +
				", id='" + id + '\'' +
				", accountId='" + accountId + '\'' +
				", owner=" + owner +
				", group=" + group +
				", version=" + version +
				", updated=" + updated +
				", name='" + name + '\'' +
				", externalCode='" + externalCode + '\'' +
				", archived=" + archived +
				", companyType='" + companyType + '\'' +
				", accounts=" + accounts +
				", tags=" + tags +
				", contactpersons=" + contactpersons +
				", notes=" + notes +
				", state=" + state +
				", priceType='" + priceType + '\'' +
				'}';
	}
}

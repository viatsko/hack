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

public class MoySkladOrder {
    public String id;

    public String accountId;

    public String externalCode;

    public Date updated;

    public Date created;

    public String name;

    public Double sum;

	public Boolean applicable;

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public Double getSum() {
        return sum;
    }

	public Boolean getApplicable() {
		return applicable;
	}

	@Override
	public String toString() {
		return "MoySkladOrder{" +
				"id='" + id + '\'' +
				", accountId='" + accountId + '\'' +
				", externalCode='" + externalCode + '\'' +
				", updated=" + updated +
				", created=" + created +
				", name='" + name + '\'' +
				", sum=" + sum +
				", applicable=" + applicable +
				'}';
	}
}

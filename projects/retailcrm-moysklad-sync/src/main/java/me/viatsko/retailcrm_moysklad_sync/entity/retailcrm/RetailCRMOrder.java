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

package me.viatsko.retailcrm_moysklad_sync.entity.retailcrm;

import java.util.Date;
import java.util.List;

public class RetailCRMOrder {
    public String id;

	public String externalId;

	public Date createdAt;

	public String status;

	public Date statusUpdatedAt;

	public Double summ;

	public Double totalSumm;

	public String lastName;

	public String firstName;

	public String patronymic;

	public String phone;

	public String email;

	public RetailCRMOrderCustomer customer;

	public RetailCRMOrderDelivery delivery;

	public List<RetailCRMOrderItem> items;

    public String getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

	public String getStatus() {
		return status;
	}

    public Date getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    public Double getSumm() {
        return summ;
    }

    public Double getTotalSumm() {
        return totalSumm;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

	public String getPatronymic() {
		return patronymic;
	}

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public RetailCRMOrderCustomer getCustomer() {
        return customer;
    }

	public RetailCRMOrderDelivery getDelivery() {
		return delivery;
	}

    public List<RetailCRMOrderItem> getItems() {
        return items;
    }

	@Override
	public String toString() {
		return "RetailCRMOrder{" +
				"id=" + id +
				", externalId='" + externalId + '\'' +
				", createdAt=" + createdAt +
				", status='" + status + '\'' +
				", statusUpdatedAt=" + statusUpdatedAt +
				", summ=" + summ +
				", totalSumm=" + totalSumm +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				", patronymic='" + patronymic + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", customer=" + customer +
				", delivery=" + delivery +
				", items=" + items +
				'}';
	}
}

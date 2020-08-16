package gson.entity.retailcrm;

import java.util.List;

public class RetailCRMOrder {
    String number;

    String lastName;

    String firstName;

    String patronymic;

    String phone;

    String email;

    String customerComment;

    String status;

    List<RetailCRMOrderItem> items;

    public String getNumber() {
        return number;
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

    public String getCustomerComment() {
        return customerComment;
    }

    public String getStatus() {
        return status;
    }

    public List<RetailCRMOrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "RetailCRMOrder{" +
                "number='" + number + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", customerComment='" + customerComment + '\'' +
                ", status='" + status + '\'' +
                ", items=" + items +
                '}';
    }

    public static final class RetailCRMOrderBuilder {
        String number;
        String lastName;
        String firstName;
        String patronymic;
        String phone;
        String email;
        String customerComment;
        String status;
        List<RetailCRMOrderItem> items;

        public RetailCRMOrderBuilder() {
        }

        public static RetailCRMOrderBuilder aRetailCRMOrder() {
            return new RetailCRMOrderBuilder();
        }

        public RetailCRMOrderBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public RetailCRMOrderBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RetailCRMOrderBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RetailCRMOrderBuilder withPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public RetailCRMOrderBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public RetailCRMOrderBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public RetailCRMOrderBuilder withCustomerComment(String customerComment) {
            this.customerComment = customerComment;
            return this;
        }

        public RetailCRMOrderBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public RetailCRMOrderBuilder withItems(List<RetailCRMOrderItem> items) {
            this.items = items;
            return this;
        }

        public RetailCRMOrder build() {
            RetailCRMOrder retailCRMOrder = new RetailCRMOrder();
            retailCRMOrder.firstName = this.firstName;
            retailCRMOrder.phone = this.phone;
            retailCRMOrder.customerComment = this.customerComment;
            retailCRMOrder.items = this.items;
            retailCRMOrder.status = this.status;
            retailCRMOrder.patronymic = this.patronymic;
            retailCRMOrder.number = this.number;
            retailCRMOrder.lastName = this.lastName;
            retailCRMOrder.email = this.email;
            return retailCRMOrder;
        }
    }
}

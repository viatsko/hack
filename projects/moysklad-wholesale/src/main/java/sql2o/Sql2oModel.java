package sql2o;

import org.mindrot.jbcrypt.BCrypt;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import sql2o.entity.User;

import java.util.List;

public class Sql2oModel implements Model {
    private Sql2o sql2o;

    private UuidGenerator uuidGenerator;

    public Sql2oModel(Sql2o sql2o) {
        this.sql2o = sql2o;

        uuidGenerator = new RandomUuidGenerator();
    }

    @Override
    public void createUser(String email, String password, String priceType) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("insert into users(email, password, priceType, admin) VALUES (:email, :password, :priceType, :admin)")
                    .addParameter("email", email)
                    .addParameter("password", BCrypt.hashpw(password, BCrypt.gensalt()))
                    .addParameter("priceType", priceType)
                    .addParameter("admin", 1)
                    .executeUpdate();
        }
    }

    @Override
    public void updateUserPassword(String email, String password) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("update users set password = :password where email = :email")
                    .addParameter("password", BCrypt.hashpw(password, BCrypt.gensalt()))
                    .addParameter("email", email)
                    .executeUpdate();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("select * from users").executeAndFetch(User.class);
        }
    }

    @Override
    public void deleteUser(String email) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("delete from users where email = :email")
                    .addParameter("email", email)
                    .executeUpdate();
        }
    }

    @Override
    public void createOrder(Integer id, String contactName, String phone, String email, String city, String address, String description, String order) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery(
                    "insert into orders(id, contactName, phone, email, city, address, description, rawOrder) " +
                            "VALUES (:id, :contactName, :phone, :email, :city, :address, :description, :order)")
                    .addParameter("id", id)
                    .addParameter("contactName", contactName)
                    .addParameter("phone", phone)
                    .addParameter("email", email)
                    .addParameter("city", city)
                    .addParameter("address", address)
                    .addParameter("description", description)
                    .addParameter("order", order)
                    .executeUpdate();
        }
    }

    @Override
    public boolean isUserExists(String email, String password) {
        try (Connection connection = sql2o.open()) {
            return BCrypt.checkpw(password, connection.createQuery("select password from users where email = :email")
                    .addParameter("email", email)
                    .executeScalar(String.class));
        }
    }

    @Override
    public int getUsersCount() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("select count(*) from users").executeScalar(Integer.class);
        }
    }

    @Override
    public int getOrdersCount() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("select count(*) from orders").executeScalar(Integer.class);
        }
    }

    @Override
    public int getOrdersMaxId() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("select max(id) from orders").executeScalar(Integer.class);
        }
    }
}

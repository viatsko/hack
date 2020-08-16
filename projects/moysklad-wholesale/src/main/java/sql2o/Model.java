package sql2o;

import sql2o.entity.User;

import java.util.List;

public interface Model {
    void createUser(String email, String password, String priceType);

    void updateUserPassword(String email, String password);

    List<User> getAllUsers();

    void deleteUser(String email);

    void createOrder(
            Integer id,
            String contactName,
            String phone,
            String email,
            String city,
            String address,
            String description,
            String order
    );

    boolean isUserExists(String email, String password);

    int getUsersCount();

    int getOrdersCount();

    int getOrdersMaxId();
}

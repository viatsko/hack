package sql2o.entity;

public class Order {
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS orders ("
            + "id INTEGER,"
            + "contactName VARCHAR(255),"
            + "phone VARCHAR(255),"
            + "email VARCHAR(255),"
            + "city VARCHAR(255),"
            + "address TEXT,"
            + "description TEXT,"
            + "rawOrder TEXT"
            + ");";

    private Integer id;

    private String contactName;

    private String phone;

    private String email;

    private String city;

    private String address;

    private String description;

    private String rawOrder;
}

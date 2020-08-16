package sql2o.entity;

public class User {
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS users ("
            + "email VARCHAR(255),"
            + "password VARCHAR(255),"
            + "priceType VARCHAR(255),"
            + "admin TINYINT(1)"
            + ");";

    private String email;

    private String password;

    private String priceType;

    private Boolean admin;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPriceType() {
        return priceType;
    }

    public Boolean getAdmin() {
        return admin;
    }
}

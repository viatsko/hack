package sql2o;

import java.util.UUID;

public interface UuidGenerator {
    /**
     * Each call should return a different UUID.
     */
    UUID generate();
}

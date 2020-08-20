import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaSHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        messageDigest.update(string.getBytes());

        System.out.println(String.format("%064x", new java.math.BigInteger(1, messageDigest.digest())));
    }
}

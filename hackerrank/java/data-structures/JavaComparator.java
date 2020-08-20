import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player{
    String name;

    int score;

    Player(String name, int score){
        this.name = name;

        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int scoreDiff = o2.score - o1.score;

        return scoreDiff == 0 ? o1.name.compareTo(o2.name) : scoreDiff;
    }
}

public class JavaComparator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(in.next(), in.nextInt());
        }

        in.close();

        Arrays.sort(player, checker);

        for (Player aPlayer : player) {
            System.out.printf("%s %s\n", aPlayer.name, aPlayer.score);
        }
    }
}

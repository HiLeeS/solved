import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            players.add(new Player(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        List<List<Player>> list = new ArrayList<>();

        for (Player player : players) {
            if (list.isEmpty()) {
                list.add(new ArrayList<>());
                list.get(0).add(player);
                continue;
            } else {
                boolean check = false;
                int player_level = player.level;
                for (int i = 0; i < list.size(); i++) {
                    int start_level = list.get(i).get(0).level;
                    if ((player_level <= start_level + 10 && player_level >= start_level - 10) && list.get(i).size() < m) {
                        list.get(i).add(player);
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    list.add(new ArrayList<>());
                    list.get(list.size() - 1).add(player);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Player> answer : list) {
            answer.sort((a, b) -> a.nickname.compareTo(b.nickname));

            if (answer.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            for (Player player : answer) {
                sb.append(player.level).append(" ").append(player.nickname).append("\n");
            }
        }

        System.out.print(sb);
    }

    static class Player {
        int level;
        String nickname;

        Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }
}
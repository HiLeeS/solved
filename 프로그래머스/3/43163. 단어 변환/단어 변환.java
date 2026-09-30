import java.util.*;

class Solution {

    class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.word.equals(target)) {
                return cur.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                int diff = 0;

                for (int j = 0; j < cur.word.length(); j++) {
                    if (cur.word.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }

                if (diff != 1) continue;

                visited[i] = true;
                q.offer(new Node(words[i], cur.count + 1));
            }
        }

        return 0;
    }
}
    import java.util.*;

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            Queue<int[]> q = new LinkedList<>();

            int time = 0;
            int idx = 0;
            int currentWeight = 0;

            while (idx < truck_weights.length || !q.isEmpty()) {
                time++;

                // 1. 나갈 트럭 확인
                if (!q.isEmpty() && time - q.peek()[1] == bridge_length) {
                    currentWeight -= q.poll()[0];
                }

                // 2. 새 트럭 진입 가능 여부 확인
                if (idx < truck_weights.length
                        && currentWeight + truck_weights[idx] <= weight) {

                    currentWeight += truck_weights[idx];
                    q.offer(new int[]{truck_weights[idx], time});
                    idx++;
                }
            }

            return time;
        }
    }
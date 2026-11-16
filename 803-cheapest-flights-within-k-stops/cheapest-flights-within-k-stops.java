class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        // Store {cost, city, stopsUsed} instead of a global k
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int w = node[0];
            int s = node[1];
            int stops = node[2];

            // Check destination WHEN POPPING (guarantees minimum cost)
            if (s == dst) return w;

            // Skip if out of stops OR we already visited 's' cheaper with fewer stops
            if (stops > k || stops >= minStops[s]) continue;
            minStops[s] = stops;

            for (int[] neigh : adj.get(s)) {
                int d = neigh[0];
                int wt = neigh[1];
                pq.offer(new int[]{w + wt, d, stops + 1});
            }
        }
        return -1;
    }
}
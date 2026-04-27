import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        long[] T = new long[N], A = new long[N], B = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Long.parseLong(st.nextToken());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
        }

        // T 오름차순 정렬
        Integer[] idxByT = new Integer[N];
        for (int i = 0; i < N; i++) idxByT[i] = i;
        Arrays.sort(idxByT, (a, b) -> Long.compare(T[a], T[b]));

        long[] tSorted = new long[N];
        long[] prefixMaxB = new long[N];
        tSorted[0] = T[idxByT[0]];
        prefixMaxB[0] = B[idxByT[0]];
        for (int i = 1; i < N; i++) {
            tSorted[i] = T[idxByT[i]];
            prefixMaxB[i] = Math.max(prefixMaxB[i - 1], B[idxByT[i]]);
        }

        // A 내림차순 정렬
        Integer[] idxByA = new Integer[N];
        for (int i = 0; i < N; i++) idxByA[i] = i;
        Arrays.sort(idxByA, (a, b) -> Long.compare(A[b], A[a]));

        long ans = 0;

        for (int ii = 0; ii < N; ii++) {
            int i = idxByA[ii];

            // ★ i 혼자 선택 (T[i] <= D 는 문제 조건상 항상 성립)
            ans = Math.max(ans, A[i] + B[i]);

            // i가 A 담당, j(≠i)가 B 담당: T[i] + T[j] <= D
            long remain = D - T[i];

            // tSorted에서 remain 이하인 마지막 인덱스
            int lo = 0, hi = N - 1, pos = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (tSorted[mid] <= remain) {
                    pos = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (pos < 0) continue;

            ans = Math.max(ans, A[i] + prefixMaxB[pos]);
        }

        System.out.println(ans);
    }
}
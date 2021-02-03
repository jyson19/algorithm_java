package programmers.level1;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class GymSuit {
//	BiConsumer<int[], Integer> fRent = (int[] stateFRent, Integer nFRent) -> {
//		for (int i = 0; i < nFRent - 1; i++) {
//			if (stateFRent[i] == 2 && stateFRent[i + 1] == 0) {
//				stateFRent[i]--;
//				stateFRent[i + 1]++;
//			}
//		}
//	};
//	BiConsumer<int[], Integer> bRent = (int[] stateBRent, Integer nBRent) -> {
//		for (int i = 1; i < nBRent; i++) {
//			if (stateBRent[i] == 2 && stateBRent[i - 1] == 0) {
//				stateBRent[i]--;
//				stateBRent[i - 1]++;
//			}
//		}
//	};
//
//	int[] state1 = new int[n];
//	int[] state2 = new int[n];
//
//	init(state1, lost, reserve); // [2, 0, 2, 0, 2]
//	    init(state2, lost, reserve); // [2, 0, 2, 0, 2]
//
//	    return Math.max(runOrder(state1, n, fRent, bRent), runOrder(state2, n, bRent, fRent));
//	  }

	public static void init(int[] state, int[] lost, int[] reserve) {
		// 5 lost=[2, 4] reserve=[1, 3, 5]
		Arrays.fill(state, 1); // [1, 1, 1, 1, 1]
		for (int idx : lost)
			state[idx - 1]--; // [1, 0, 1, 0 , 1]
		for (int idx : reserve)
			state[idx - 1]++; // [2, 0, 2, 0, 2]
	}

	public static int runOrder(int[] state, int n, BiConsumer<int[], Integer> run1, BiConsumer<int[], Integer> run2) {
		run1.accept(state, n);
		run2.accept(state, n);
		return (int) Arrays.stream(state).filter(i -> i > 0).count();
	}
}

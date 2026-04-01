import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static void q1() {
	}

	public static void q2() {
	}

	public static void q3() {
	}

	public static void q4() {
	}

	public static void q5() {
	}

	public static int[] bubbleSort(double[] nums) {
		int swaps = 0;
		int steps = 0;
		boolean swapped = true;

		for (int i = 0; i < nums.length - 1 && swapped; i++) {
			swapped = false;

			for (int j = 0; j < nums.length - 1 - i; j++) {
				steps++;
				if (nums[j] > nums[j + 1]) {
					double temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swaps += 3;
					swapped = true;
				}
			}
		}

		return new int[] {swaps, steps};
	}

	public static int[] selectionSort(double[] nums) {
		int swaps = 0;
		int steps = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			int min = i;
			swaps += 2;

			for (int j = i + 1; j < nums.length; j++) {
				steps++;
				if (nums[j] < nums[min]) {
					min = j;
				}
			}

			if (min != i) {
				double temp = nums[i];
				nums[i] = nums[min];
				nums[min] = temp;
				swaps += 3;
			}
		}

		return new int[] {swaps, steps};
	}

	public static int[] insertionSort(double[] nums) {
		int swaps = 0;
		int steps = 0;

		for (int i = 1; i < nums.length; i++) {
			double key = nums[i];
			swaps++;
			int j = i - 1;

			while (j >= 0 && nums[j] > key) {
				steps++;
				nums[j + 1] = nums[j];
				swaps++;
				j--;
			}

			nums[j + 1] = key;
			swaps++;
		}

		return new int[] {swaps, steps};
	}

	public static String leastSwaps(double[] nums) {
		double[] bubble = Arrays.copyOf(nums, nums.length);
		double[] selection = Arrays.copyOf(nums, nums.length);
		double[] insertion = Arrays.copyOf(nums, nums.length);

		int bubbleSwaps = bubbleSort(bubble)[0];
		int selectionSwaps = selectionSort(selection)[0];
		int insertionSwaps = insertionSort(insertion)[0];

		int min = Math.min(bubbleSwaps, Math.min(selectionSwaps, insertionSwaps));

		if (bubbleSwaps == min) {
			return "Bubble";
		} else if (insertionSwaps <= selectionSwaps && insertionSwaps == min) {
			return "Insertion";
		} else if (insertionSwaps == selectionSwaps + 2 && insertionSwaps <= bubbleSwaps) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}

	public static String leastIterations(double[] nums) {
		double[] bubble = Arrays.copyOf(nums, nums.length);
		double[] selection = Arrays.copyOf(nums, nums.length);
		double[] insertion = Arrays.copyOf(nums, nums.length);

		int bubbleSteps = bubbleSort(bubble)[1];
		int selectionSteps = selectionSort(selection)[1];
		int insertionSteps = insertionSort(insertion)[1];

		int min = Math.min(bubbleSteps, Math.min(selectionSteps, insertionSteps));

		if (bubbleSteps == min) {
			return "Bubble";
		} else if (insertionSteps == min) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}

}
import java.util.Random;

public class Util {
	private static final Random random = new Random();

	public static int power(int x, int y, int p) {
		int res = 1; // Initialize result

		x = x % p; // Update x if it is more than or
		// equal to p

		if (x == 0)
			return 0; // In case x is divisible by p;

		while (y > 0) {

			// If y is odd, multiply x with result
			if ((y & 1) != 0)
				res = (res * x) % p;

			// y must be even now
			y = y >> 1; // y = y/2
			x = (x * x) % p;
		}
		return res;
	}

	public static int[] encrypt(int input, int N, int e) {
		int r = random.nextInt(N);
		int C = power(r, e, N);
		int lsb_r = r & 0b1111;
		int S = input ^ lsb_r;
		System.out.println("--- Encryption ---");
		System.out.println(
				"input = " + input + ", " + String.format("%12s", Integer.toBinaryString(input)).replace(' ', '0'));
		System.out.println("r = " + r + ", " + String.format("%12s", Integer.toBinaryString(r)).replace(' ', '0'));
		System.out.println(
				"lsb_r = " + lsb_r + ", " + String.format("%12s", Integer.toBinaryString(lsb_r)).replace(' ', '0'));
		System.out.println(
				"C = r ^ e mod N = " + C + ", " + String.format("%12s", Integer.toBinaryString(C)).replace(' ', '0'));
		System.out.println("S = input XOR lsb_r = " + S + ", "
				+ String.format("%12s", Integer.toBinaryString(S)).replace(' ', '0'));

		return new int[] { C, S };
	}

	public static int decrypt(int C, int S, int N, int d) {
		int r = power(C, d, N);
		int lsb_r = r & 0b1111;

		return S ^ lsb_r;
	}

	public static int not(int bit) {
		return bit == 0 ? 1 : 0;
	}

	public static int and(int a, int b) {
		return a * b;
	}

	public static int xor(int a, int b) {
		return a ^ b;
	}

	public static int and3(int a, int b, int c) {
		return and(and(a, b), c);
	}

	public static int xor3(int a, int b, int c) {
		return xor(a, xor(b, c));
	}
	
	public int[] splitSecret(int bit, boolean isNot) {
		int[] arr = new int[3];
		arr[0] = Util.not(random.nextInt(2));
		arr[1] = random.nextInt(2);
		arr[2] = Util.xor3(bit, arr[0], arr[1]);
				
		return new int[-1];
	}
	
	public int joinSecret(int[] secretArr) {
		return Util.xor3(secretArr[0], secretArr[1], secretArr[2]);
	}
}

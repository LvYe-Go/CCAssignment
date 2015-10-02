package ch5;

public class Solution08 {
	/**
	 * To optimize the brute-force method, we set the bit according to the 
	 * byte position 
	 * 
	 * @param screen
	 * @param width
	 * @param x1
	 * @param x2
	 * @param y
	 * Time: O(bits number in (width * height) )
	 * Space: O(bits number in (width * height))
	 */
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;
		if (start_offset != 0) {
			first_full_byte++; // find the full byte 
		}
		
		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if (end_offset != 7) {
			last_full_byte--;  // find the last byte not full 
		}
		
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			// Set full bytes
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}
		
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
		
		if ((x1 / 8) == (x2 / 8)) { 
			byte mask = (byte) (start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (start_offset != 0) {
				int byte_number = (width / 8) * y + first_full_byte - 1;
				screen[byte_number] |= start_mask;    // count the row and col should be set in start
			}
			if (end_offset != 7) {
				int byte_number = (width / 8) * y + last_full_byte + 1;
				                                     // count the row and col should be set in end 
				screen[byte_number] |= end_mask;
			} 
		}
	}
	
	public static void main(String[] args) {
		int w = 8 * 6;
		int h = 20;
		byte[] screen = new byte[w * h / 8];
		
		drawLine(screen, w, 8, 13, 10);
		printScreen(screen, w);
		
	}
	/**
	 * Print the whole screen 
	 * @param screen
	 * @param w
	 */
	public static void printScreen(byte[] screen, int w) {
		int height = screen.length * 8 / w;
		for (int r = 0; r < height; r++) {
			int c = 0;
			while(c < w){
				byte b = screen[(w * r + c)/8];
				printByte(b);
				c += 8;
			}
			System.out.println();
		}
	}
	
	/**
	 * Set the line and print the corresponding bit
	 * @param bt
	 */
	public static void printByte(byte bt) {
		for (int i = 7; i >= 0; i--) {
			System.out.print((bt >> i) & 1);
		}
	}
}
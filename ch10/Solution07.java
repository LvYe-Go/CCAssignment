package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Solution07 {
    /**
     * Sort Big File: 
     * 
     * 1. Given 4 billion non-negative integers, provide an algorithm generate 
     *    an integer that is not contained  
     *    
     *    Method: Mapping integer into bitmap 
     *    
     *    Time: O(N)
     *    Space:Memory Size. O(n/8) 
     * 
     * 2. Follow Up:  Only have 10 memory and no more than one billion-negative integers.
     * 
     *    Method: Mapping integer into bitmap 
     *   
     *    Time: O(N) 
     *    Space:Memory Size in blocks. O(n/8)
     */
	
	// Basic Question 
	public static void findNumber(String filename) {
		long numberOfIntegers = ((long) Integer.MAX_VALUE);
		byte[] bitmap = new byte[(int)(numberOfIntegers / 8)];
		try {
			Scanner in = new Scanner(new FileReader(filename)); // scanner input 
			int n = in.nextInt();
			bitmap[n / 8] |= 1 << (n % 8);  // map integer into one bit 
			
			for(int i = 0; i < bitmap.length; i ++){
				for(int j = 0 ; j < 8; j++) {
					if((bitmap[i] & (1 << j)) == 0){  // check integer exists or not 
						System.out.println(i * 8 + j); 
						return;
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Follow UP 
	// Move the data into blocks 
	public static int findNumberTwo(String filename) throws FileNotFoundException {
		int rangeSize = (1 << 20); //  1 ^ 20 bits
		
		int[] blocks = getCountPerBlock(filename, rangeSize); // Get count of number of values with each block
		int blockIndex = findBloackWithMissing(blocks, rangeSize); // Find a block with a missing value 
		if(blockIndex < 0) return - 1;
				
		byte[] bitmap = getBitMapForRange(filename, blockIndex, rangeSize); // Create bit vector for this range
		
		int offset = findZero(bitmap); // find the missing value
		if(offset < 0) return -1;
		
		return blockIndex * rangeSize + offset;
	}
	// Get count of items with each range
    public static int[] getCountPerBlock(String filename, int rangeSize) throws FileNotFoundException{
		int arraySize  = Integer.MAX_VALUE/ rangeSize + 1;
		int[] blocks = new int[arraySize];
		Scanner sc = new Scanner(new FileReader(filename));  // plase input 
		while(sc.hasNext()){
			int value = sc.nextInt();
			blocks[value/rangeSize]++;   // different blocks
		}
		sc.close();
		return blocks;
	}
	
    // Find a block whose count is low
	public static int  findBloackWithMissing(int[] blocks, int rangeSize){
		for(int i = 0; i < blocks.length; i++){
			if(blocks[i] < rangeSize) {
				return i;
			}
		}
		return -1;
	}
	
	// Create the bit map with different range
	public static byte[] getBitMapForRange(String filename, int blockindex, int rangeSize) throws FileNotFoundException{
		int startRange = blockindex * rangeSize;
		int endSize = startRange +rangeSize;
		byte[] bitmap = new byte[rangeSize/Byte.SIZE];  // mapping into n/8 size 
		 
		Scanner sc = new Scanner(new FileReader(filename));
		while(sc.hasNext()){
			int value = sc.nextInt();
			if(startRange <= value && value < endSize) {
				int offset = value - startRange;  // shift bit to show integer
				int mask = (1<<(offset % Byte.SIZE));
				bitmap[offset/ Byte.SIZE] |= mask;
			}
		}
		sc.close();
		return bitmap;
	}
	
    
    
    public static int findZero(byte b){
    	for(int i = 0; i < Byte.SIZE; i++){
    		int mask = 1 << i;
    		if((b & mask) == 0) {  // find missing value 
    			return 0;
    		}
    	}
        return -1;
    }
 
    public static int findZero(byte[] bitmap){
    	for(int i = 0; i < bitmap.length; i++){
    		if(bitmap[i] != 0){
    			int bitIndex = findZero(bitmap[i]); // locate the missing vaue block
    			return i * Byte.SIZE + bitIndex;  // locate the element 
    		}
    	}
        return -1;
    }
    
	
	public static void main(String[] args) throws FileNotFoundException {
		 System.out.println("Please input your filename");
		 Scanner sc = new Scanner(System.in);
		 findNumber(sc.next());
		 
		 System.out.println("Please input your filename in Follow UP Question");
		 Scanner sc2 = new Scanner(System.in);
		 System.out.println(findNumberTwo(sc2.next()));
	}

}

package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {1, 3, 6, 5, 1, 2};
		int i = s.solution(22, "1A 3C 2B 20G 5A");
		System.out.println(i);
	}
	
	
    public int solution(int N, String S) {
    	int result = N * 2;
    	if(S != null && S.length() > 0) {
    		String[] reservedSeats = S.split(" ");
    		Map<Integer, List<String>> reservedSeatMap = new HashMap<>();
    		for(int i = 0; i < reservedSeats.length; i++) {
        	
    			int row = Integer.valueOf(reservedSeats[i].substring(0, reservedSeats[i].length()-1));
    			List<String> seatsInRow = reservedSeatMap.get(row);
    			if(seatsInRow == null) {
    				seatsInRow = new ArrayList<>();
    			}
    			seatsInRow.add(reservedSeats[i].substring(reservedSeats[i].length()-1));
    			reservedSeatMap.put(row, seatsInRow);
    		}
        
    	int blockedQuatett = this.countQuattet(reservedSeatMap, N);
        result -= blockedQuatett;
    	}
        
        
        return result;
    }


	private int countQuattet(Map<Integer, List<String>> reservedSeatMap, int N) {
		int result = 0;
		for(int i = 1; i <= N; i++) {
			int blockedQuatettInRow = 0;
			List<String> seatsInRow = reservedSeatMap.get(i);
			if(seatsInRow != null) {
				if(seatsInRow.contains("B") || seatsInRow.contains("C")) {
					blockedQuatettInRow += 1;
					if(seatsInRow.contains("F") || seatsInRow.contains("G")) {
						blockedQuatettInRow += 1;
					}
				} 
				if(seatsInRow.contains("H") || seatsInRow.contains("J")) {
					blockedQuatettInRow += 1;
					if(seatsInRow.contains("C") || seatsInRow.contains("D")) {
						blockedQuatettInRow += 1;
					}
				} 
				if(blockedQuatettInRow < 2) {
					if(seatsInRow.contains("D") || seatsInRow.contains("E") || seatsInRow.contains("F") || seatsInRow.contains("G")) {
						blockedQuatettInRow += 1;
					} 
				}
    		
			}
			result += blockedQuatettInRow;
		}
		return result;
	}
}

package Encoding;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Encoding {
	static HashMap<Boolean[], String> hash_of_boolean_operator = new HashMap<Boolean[], String>(); 
	
	
	//------Encode Position------
	public static byte encode_position(byte x, byte y, byte rows) {
		return (byte)((rows*x)+ y-128);
	}
	
	public static byte[] decode_position(byte hash,byte rows) {
		char hash_int = (char) (hash+128);
		int unpair1 = Math.floorDiv(hash_int, rows);
		int unpair2 = hash_int%rows;
		byte[] pair = {(byte) unpair1,(byte) unpair2};
		return pair;
	}
	
	//------Encode Operator------
	public static HashMap<Boolean[], String> create_link_between_operator_boolean(String[] operators){
		ArrayList<Boolean[]> all_combinations = new ArrayList<Boolean[]>();
		
		int length = operators.length;
		int size_of_array = (int) Math.ceil(Math.log(length) / Math.log(2));
		
		for (int i = 0; i < length; i++) {
			String int_to_bin = Integer.toBinaryString(i);
			
			if(int_to_bin.length()<size_of_array) {
				for (int j = 0; j <= size_of_array-int_to_bin.length(); j++) {
					int_to_bin = "0"+int_to_bin;
				}
			}
			
			Boolean[] temp = new Boolean[size_of_array];
			
			for (int j = 0; j < temp.length; j++) {
				temp[j]=false;
			}
			
			for (int j = 0; j < int_to_bin.length(); j++) {
				int bin_int = Integer.parseInt(int_to_bin.charAt(j)+"");
				if(bin_int==1) {
					temp[j]=true;
				}
			}
			all_combinations.add(temp);
		}
		for (int i = 0; i < length; i++) {
			Boolean[] arr = all_combinations.get(i);
			String operator = operators[i];
			hash_of_boolean_operator.put(arr, operator);
		}
		return hash_of_boolean_operator;
	}
	public String getString(Boolean[] arr) {
		return hash_of_boolean_operator.get(arr);
	}
	public Boolean[] getBooleanArr(String Value) {
		return getKeyHelper(hash_of_boolean_operator, Value);
	}

	private static <K, V> K getKeyHelper(Map<K, V> map, V value) {
		return map.entrySet().stream().filter(entry -> value.equals(entry.getValue())).map(Map.Entry::getKey)
				.findFirst().get();
	}

//	public static void main(String[] args) {
//		System.out.println(Encodings.encode_position(new Position(14, 14), 15));
//		System.out.println(Encodings.decode_position((byte) 96, 15).getX()+" "+Encodings.decode_position((byte) 96, 15).getY());
//	}
}

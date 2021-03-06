package HashTables;

import java.util.Arrays;

public class CustomHashMap {
	private String[] data;
	private int arraySize;
	private int collisions;
	
	CustomHashMap(int size){
		arraySize=size;
		data = new String[size];
		collisions=0;
		Arrays.fill(data,"-1");
	}
	
	
	
	public void HashFunction1(String[] inputString) {
		for(int i = 0; i<inputString.length;i++) {
			data[Integer.parseInt(inputString[i])]=inputString[i];
		}
	}
	
	public void DoubleHash(String[] inputString) {
		for(int i = 0; i<inputString.length;i++) {
			int arrayIndex = Integer.parseInt(inputString[i])%29;
			int step = 7 - Integer.parseInt(inputString[i])%7;
			while(data[arrayIndex] != "-1") {
				arrayIndex+=step;
				this.collisions++;
				System.out.println("Collusion at "+ (arrayIndex-1));
				arrayIndex %= arraySize;
			}
			data[arrayIndex]=inputString[i];
		}
	}
	
	public String findKeyDH(String key) {
		int arrayIndex = Integer.parseInt(key)%29;
		int step = 7 - Integer.parseInt(key)%7;
		while(data[arrayIndex]!="-1") {
			if(data[arrayIndex].equals(key)) {
				System.out.println("Key "+key+" found in index["+arrayIndex+"]");
				return data[arrayIndex];
			}
			arrayIndex+=step;
			arrayIndex%=arraySize;
		}
		return null;
	}
	
	
	
	public void HashFunction2(String[] inputString) {
		for(int i = 0; i<inputString.length;i++) {
			int arrayIndex = Integer.parseInt(inputString[i])%29;
			while(data[arrayIndex] != "-1") {
				++arrayIndex;
				this.collisions++;
				System.out.println("Collusion at "+ (arrayIndex-1));
				arrayIndex %= arraySize;
			}
			data[arrayIndex]=inputString[i];
		}
	}
	public String findKeyF2(String key) {
		int arrayIndex = Integer.parseInt(key)%29;
		while(data[arrayIndex]!="-1") {
			if(data[arrayIndex].equals(key)) {
				System.out.println("Key "+key+" found in index["+arrayIndex+"]");
				return data[arrayIndex];
			}
			++arrayIndex;
			arrayIndex%=arraySize;
		}
		return null;
	}
	public void displayCustomHashMap() {
		for(int i = 0; i <arraySize;i++) {
			if(data[i]!="-1") {
			System.out.println("Index :"+i+"	|Value :"+data[i]);
			}
		}
	}
	public int getCollisions() {return this.collisions;}
}

package microwaveModel;

import java.util.Scanner;

import org.junit.Test;

public class Testor {
	@Test
	public void testSetTime() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Appointment ap = new Appointment(0, "test");
	    ap.setTime(input);
		System.out.println(ap);
	}
	@Test
	public void arrayToStringTest() {
		int[] a = new int[] {1,5,4,8};
		System.out.println(a.toString());//输出的是地址
	}
	
}

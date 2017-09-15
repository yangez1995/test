package test;

public class RunTimeTest {
	public static void main(String[] args) {
		long a = 1L;
		long startTime1 = System.currentTimeMillis();
		for(long i = 0; i < 10000000000L; i++) {
			a++;
		}
		long endTime1 = System.currentTimeMillis();
		long startTime2 = System.currentTimeMillis();
		for(long j = 0; j < 10000000000L; j++) {
			
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println(a);
		System.out.println((endTime1-startTime1) - (endTime2-startTime2));
	}
}

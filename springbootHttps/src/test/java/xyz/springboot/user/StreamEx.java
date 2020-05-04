package xyz.springboot.user;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
	int x;
	
	public static void main(String[] args) {
		int [] ar = {1,2,4,5,7,8};
		
		int sum = Arrays.stream(ar)	//스트림 생성
						.filter(n -> n%2 ==1) //filter 통과
						.sum();	//sum 통과 결과 저장
		System.out.println(sum);
		
		String [] names = {"YOON","LEE","PARK","LEE"};
		Stream<String> stm = Arrays.stream(names);
		stm.forEach(s -> System.out.println(s));
		
		Arrays.stream(names).forEach(System.out::println);
		Arrays.stream(names).distinct().forEach(System.out::println);
		
		List<String> list = Arrays.asList("aaa","bbb","ccc","abc","abcd");
		list.stream().filter(s -> s.contains("a")).mapToInt(a -> a.length()).filter(a -> a==3).forEach(System.out::println);
		
		double a = Arrays.stream(names).mapToDouble(s -> s.length()).sum();
		System.out.println(a);
		
		String sa = "ASdf";
		StreamEx a1 = new StreamEx();
		StreamEx dfsdf = a1.add(4).add(2).subtract(10);
		System.out.println(dfsdf);
		
//		IntStream stream = new Random().ints();
//		stream.filter(s -> s>=0).forEach(System.out::println);
		
		ss sstest = new cs();
		System.out.println(sstest.testt());
		
	}
	
	public StreamEx add(int a) {
		x +=a;
		return this;
	}
	
	public StreamEx subtract(int b) {
		x+=b;
		return this;
	}
	
}


interface ss {
	public String testt();
}

class mm implements ss{
	@Override
	public String testt() {
		return "ss";
	}
}

class cs implements ss{
	@Override
	public String testt() {
		// TODO Auto-generated method stub
		return "잘되냐?";
	}
}

class ass{
	private final ss asd;

	public ass(ss asd) {
		this.asd = asd;
	}
	
	public String testt() {
		return asd.testt();
	}
}
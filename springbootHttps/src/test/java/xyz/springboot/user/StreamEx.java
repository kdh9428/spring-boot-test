package xyz.springboot.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.google.common.base.Function;

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
		
		
		List<String> ls = Arrays.asList("box","simple","Complex","Robot");
		BinaryOperator<String> lc = (aa,bb) -> {
			if(aa.length() > bb.length()) 
				return aa;
			else
				return bb;
		};
		
		String str = ls.stream().reduce("asdfgddg", lc);
		System.out.println(str);
		
		ls = new ArrayList<>(ls);
		ls.add("btod");
		List<String> dfd =new ArrayList<String>();
		dfd.add("asdf");
		dfd.add("bsdff");
		dfd.add("dsdffff");
		dfd.add("fsd");
		dfd.sort((ab,ac)->{
			if(ab.length()<ac.length()) 
				return 1;
			else
			return -1;
		});
		
		System.out.println("================="+dfd+"================");
		Consumer<List<String>> dd = (ad)->System.out.println(ad);
		
		dd.accept(dfd);
		
		println(1L,"dahun","test@email.com",(id, name, email)->"User info : id = "+id+ ", name = "+name+", email = "+email);
		
		Function3.staticTest();
		
	}
	
	public StreamEx add(int a) {
		x +=a;
		return this;
	}
	
	public StreamEx subtract(int b) {
		x+=b;
		return this;
	}
	
	private static <T1, T2, T3> void println(T1 t1,T2 t2,T3 t3, Function3<T1, T2, T3, String> function) {
		System.out.println(function.apply(t1, t2, t3));
	}
	
}

@FunctionalInterface
interface Function3<T1, T2, T3, R>{
	R apply(T1 t1, T2 t2, T3 t3);
	
	default void print (int i) {
		System.out.println("테스트 확인.");
	};
	static void staticTest() {
		System.out.println("스태틱 테스트!");
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

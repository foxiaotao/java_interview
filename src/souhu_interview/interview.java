package souhu_interview;

import org.junit.Test;

public class interview {

	public static void main(String[] args) {
		System.out.println(test());
	}
	static int test(){
		int a=0;
		try{
			return ret1();
		}catch(Exception ex){
		}finally{
			return ret2();
		}
//		return ret2();
	}	
	static int ret1(){
		System.out.println("return 1");
		return 1;
	}	
	static int ret2(){
		System.out.println("return 2");
		return 2;
	}	
			

	
	@Test
	public void base1_1(){
		String s = "interview";
		String r = s.replace("e", "a");
		String ra = s.replaceAll("e", "a");
		System.out.println(s);
		System.out.println(r);
		System.out.println(ra);
	}
	@Test
	public void base1_3(){
		int i = 0;
		for(++i;++i<=3;++i){
			System.out.println(i);
		}
		System.out.println(i);

	}
	@Test
	public void base1_5	(){
		String str = "123";
		String str1 = "1";
		String str2 = "23";
		String str3 = "1"+"23";
		System.out.println(str == str1+str2);
		System.out.println(str1 + str2 == str1+str2);
		System.out.println(str == str3);

		
	}
}

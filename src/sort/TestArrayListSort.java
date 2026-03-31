package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestArrayListSort {

	public static void main(String[] args) {
		ArrayList<Integer>	list	=	new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(34);
		list.add(28);
		list.add(16);
		// ArrayList<> <- generic 안에 무조건 class type이 들어와야 함
		// 익명 클래스를 사용하여 코딩을 부여하면 interface도 new 가능
		Comparator<Integer> compAsc	=	new	Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}; // interface도 { 코딩 } 있다면 new 선언할 수 있음 // 오름차순
		
		Comparator<Integer> compDsc	=	new	Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		}; // interface도 { 코딩 } 있다면 new 선언할 수 있음 // 내림차순
		
		disp_list	(list);
		// 오름차순 정렬
		Collections.sort(list, compAsc);
		disp_list	(list);
		// 내림차순 정렬
		Collections.sort(list, compDsc);
		disp_list	(list);
		line();
		
		// 문자열배열
		ArrayList<String> names	=	new	ArrayList<>();
		names.add("이순신");
		names.add("김유신");
		names.add("강감찬");
		names.add("을지문덕");
		names.add("권율");
		
		disp_name(names);
		// Ascending Sort
		Collections.sort(names, new Comparator<String>() {	//	ascending

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}});
		disp_name(names);
		Collections.sort(names, new Comparator<String>() { // descending
			
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}});
		disp_name(names);
		
		line();
		

	} // main end

	private static void disp_name(ArrayList<String> names) {
		for (String name : names) {
			System.out.print(name + ",");
		}
		System.out.println();
	}

	private static void line() {
		System.out.println("-------------------------------");
		
	}

	private static void disp_list(ArrayList<Integer> list) {
		
		for (Integer num : list) {
			System.out.print(num + ",");
		}
		System.out.println();
	} // disp_list () end

} // class TestArrayListSort end

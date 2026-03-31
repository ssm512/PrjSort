package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Member {
	// field
	private	int	mno;

	//constructor
	public Member(int mno) {
		super();
		this.mno = mno;
	}
	//method
	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}
	public int getMno() {
		return mno;
	}	
} // class Member end

public class TestClassArrayListSort {

	public static void main(String[] args) {
		
		/*
		// ArrayList 는 생성자를 통해 초기값을 설정 : java 8 이하
		ArrayList<Member>	mList	=	new	ArrayList<>(
				Arrays.asList(
						new Member(13), new Member(15), new Member(1),
						new Member(5), new Member(7), new Member(15)						
						)
		) ;
		*/

		// ArrayList 는 생성자를 통해 초기값을 설정 : java 9 이상
		List<Member>	mList	=	new	ArrayList<>(
			List.of(
					new Member(13), new Member(15), new Member(1),
					new Member(5), new Member(7), new Member(15)						
				)
		) ;
		dispList(mList);
		/* 이부분 부터 강사님 code 참조해서 다시 해봐야됨 이해 못했음
		dispList(mList);
		// 오름차순 정렬
		Comparator<Member>	compAsc	=	new	Comparator<> () {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno();
			}

		};
		Collections.sort(mList, compAsc);
		dispList(mList);
		*/
		
		// 내림차순 정렬
		// 방법 1
		/*
		Comparator<Member> comDesc	=	new	Comparator<Member> () {

			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}
			
		};
		// 방법2
		Collections.sort(mList, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}});
		dispList(mList);
		*/
		// 방법3. 람다식
		Collections.sort(mList, (a,b) -> {return b.getMno()- a.getMno();});
		dispList(mList);
		
	} // main end

	private static void dispList(List<Member> mList) {
		for (Member member : mList) {
			System.out.print(member.getMno() + ","); // .getMno() 떄문에 숫자만 출력
		}
		System.out.println();
	}

} // class TestClassArrayListSort

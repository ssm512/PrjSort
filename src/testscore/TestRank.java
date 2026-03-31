package testscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
	//field
	private		int		num;
	private		int		score;
	private		int		rank;
	//constructor
	public Student(int num, int score) {
		this.num = num;
		this.score = score;
	}
	//method
	
	//getter, setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	//toString
	@Override
	public String toString() {
		return "Student [num=" + num + ", score=" + score + ", rank=" + rank + "]";
	}
} // class Student end

public class TestRank {

	public static void main(String[] args) {
		
		List<Student>	sList	=	new	ArrayList<>();
		sList.add(new Student(1, 100));
		sList.add(new Student(3, 76));
		sList.add(new Student(5, 63));
		sList.add(new Student(4, 88));
		sList.add(new Student(9, 95));
		sList.add(new Student(2, 0));
		sList.add(new Student(11, 45));
		sList.add(new Student(8, 88));
		sList.add(new Student(6, 100));
		
		dispList(sList);

		// 석차구하기 ( 1. sorting -> 석차매기기, 2. sorting 없이 석차매기기 )
		// 1. 점수를 기준으로 내림차순 정렬
		Collections.sort(sList, (a,b) -> {return b.getScore()-a.getScore();});
		dispList(sList);
		// 2. 석차 부여
		sList.get(0).setRank(1); // 첫번째 줄 1등
		int rank	=	0;
		for (int i = 1; i < sList.size(); i++) {
			if (sList.get(i).getScore() == sList.get(i-1).getScore())
				rank = sList.get(i-1).getRank();
			else
				rank = i + 1;
			sList.get(i).setRank(rank);
		}
		dispList(sList);
		
		//석차구하기 방법2 - 2중for문으로 구현
		/*
		num	점수	석차
		1	79	2
		2	100	1
		3	50	4
		4	60	3
		5	79	2
		
		시작. 모두 석차를 1을 줘놓고
		1번 2번을 비교 해서 작으면 1번의 석차 +1
		1번과 3번 비교 해서 작으면 1번의 석차 +1
		1번 4번비교 해서 작으면 1번의 석차 +1
		1번과 5번 비교 해서 작으면 1번의 석차 +1
		
		2번과 1번 비교 해서 작으면 1번의 석차 +1
		2번과 3번 비교 해서 작으면 1번의 석차 +1
		2번과 4번 비교 해서 작으면 1번의 석차 +1
		2번과 5번 비교 해서 작으면 1번의 석차 +1
		3번,4번,5번까지 동일하게 수행
		 */
	} // main end

	private static void dispList(List<Student> sList) {
		System.out.println("---------------");
		for (Student student : sList) {
			System.out.println(student);
		}
		System.out.println("---------------");
		
	}

} // class TestScore end

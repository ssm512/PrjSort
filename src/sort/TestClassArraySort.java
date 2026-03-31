package sort;

import java.util.Arrays;

class Student implements Comparable { // sort 하기 위해 implements Comparable을 추가함
	//field
	private	int	sno;

	//constructor
	public Student(int sno) {
		this.sno = sno;
	}

	// method
	@Override
	public String toString() {
		return "Student [sno=" + sno + "]";
	}

	@Override
	public int compareTo(Object o) { // sort
		Student	s	=	(Student) o;
		return s.sno - this.sno; // 내림차순
	}
	
	
} // class Student end

public class TestClassArraySort {

	public static void main(String[] args) {
		Student	[]	studArr		=	new	Student[] {
			new	Student(15), new	Student(7), new	Student(3),
			new	Student(1), new	Student(5), new	Student(9),
			new	Student(27), new	Student(13), new	Student(15),
			new	Student(38), new	Student(12), new	Student(59)
		};
		dispArr(studArr);
		Arrays.sort(studArr);
		dispArr(studArr);
	}

	private static void dispArr(Student[] studArr) {
		for (Student student : studArr) {
			System.out.print(student + " ");
		}
		System.out.println();
	} // main end

} // class TestClassArraySort end

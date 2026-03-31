package cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 카페 주문 정산 프로그램
O1001,최지우,A,5,4500.0,Y
O1002,김서연,L,2,5200.0,N
O1003,박하준,D,3,10000.0,Y
O1004,박상준,T,3,6000.0,Y
O1005,박준,D,4,3800.0,N
quit
//입력data : 주문번호,고객명,메뉴코드,수량,단가,포장여부
//출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태

//주문금액 = 수량 * 단가
//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
//최종금액 = 주문금액 + 포장비
//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
//포장상태 = Y:포장, N:매장

//금액은 소수이하 두자리로 반올림
//모든 기능은 class에 구현한다.
 */
interface	Ipo	{
	void input();
	void process();
	void output();
} 

class CafeVo {
	//입력data : 주문번호,고객명,메뉴코드,수량,단가,포장여부
	// 				num, name, menuCode,     qty, price, packed
	//출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태
	//               num, name, menuName, orderKum, packMoney, kum, packedName 
	
	// Fields
	// 입력
	private	String	num;
	private	String	name;
	private	char	menuCode;
	private	int		qty;
	private	double	price;
	private	char	packed;
	// 출력
	private	String 	menuName; 
	private	double	orderKum; 
	private	double	packMoney;
	private	double	kum;
	private	String	packedName;
	
	// Constructor
	public CafeVo(String num, String name, char menuCode, int qty, double price, char packed) {
		this.num = num;
		this.name = name;
		this.menuCode = menuCode;
		this.qty = qty;
		this.price = price;
		this.packed = packed;
	}
	
	// method
	// Getter / Setter
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(char menuCode) {
		this.menuCode = menuCode;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public char getPacked() {
		return packed;
	}
	public void setPacked(char packed) {
		this.packed = packed;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getOrderKum() {
		return orderKum;
	}
	public void setOrderKum(double orderKum) {
		this.orderKum = orderKum;
	}
	public double getPackMoney() {
		return packMoney;
	}
	public void setPackMoney(double packMoney) {
		this.packMoney = packMoney;
	}
	public double getKum() {
		return kum;
	}
	public void setKum(double kum) {
		this.kum = kum;
	}
	public String getPackedName() {
		return packedName;
	}
	public void setPackedName(String packedName) {
		this.packedName = packedName;
	}
	
	// toString
	@Override
	public String toString() {
		return "CafeVo [num=" + num + ", name=" + name + ", menuCode=" + menuCode + ", qty=" + qty + ", price=" + price
				+ ", packed=" + packed + ", menuName=" + menuName + ", orderKum=" + orderKum + ", packMoney="
				+ packMoney + ", kum=" + kum + ", packedName=" + packedName + "]";
	}
	
} // class Cafe end

//업무처리용 class
class CafeOrder implements Ipo {
	
	List<CafeVo> 	cafeList	=	new ArrayList<>();
	
	@Override
	public void input() {
		Scanner	in	=	new	Scanner(System.in);
		System.out.println("입력 주문번호,고객명,메뉴코드,수량,단가,포장여부");
		
		/*
		for (; ;) { // for로 무한 루프 // data가 얼마나 들어올지 모르므로
			String		line	=	in.nextLine();
			if (line.isEmpty() ) break;
			System.out.println(line);
		}*/
		int	i	=	0;
		while (true) {  //while 무한 루프
			String		line	=	in.nextLine();
			if (line.equals("quit") ) {
				System.out.println();
				break;
			}
			String	[]	li		=	line.trim().split(",");
			String	num			=	li[0].trim();
			String	name		=	li[1].trim();
			char	menuCode	=	li[2].toUpperCase().charAt(0); 
			int		qty			=	Integer.parseInt(li[3].trim());
			double	price		=	Double.parseDouble(li[4].trim());
			char	packed		=	li[5].toUpperCase().charAt(0);
			
			CafeVo	cafeVo		=	new	CafeVo(num, name, menuCode, qty, price, packed); // cafeVo에 잘라서 담음
			
			cafeList.add(cafeVo); // ArrayList cafeList에 cafeVo 추가
			System.out.println(cafeList.get(i));
			i++;
		} 
		System.out.println("===========");
	}

	@Override
	public void process() {
		for (int i = 0; i < cafeList.size(); i++) {
			CafeVo vo = cafeList.get(i);
			//주문금액 = 수량 * 단가
			vo.setOrderKum(vo.getQty()*vo.getPrice());
			//포장비   = 포장여부가 Y이면 주문금액의 3%, N이면 0원
			if (vo.getPacked() == 'Y')
				vo.setPackMoney(vo.getOrderKum()*0.03);
			else
				vo.setPackMoney(0);
			//최종금액 = 주문금액 + 포장비
			vo.setKum(vo.getPackMoney() + vo.getOrderKum());
			//메뉴명   = A:아메리카노, L:라떼, T:차, D:디저트
			switch (vo.getMenuCode()) {
			case 'A': vo.setMenuName("아메리카노"); break;
			case 'L': vo.setMenuName("라떼"); break;
			case 'T': vo.setMenuName("차"); break;
			case 'D': vo.setMenuName("디저트"); break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + vo.getMenuCode());
			}
			/*
			if (vo.getMenuCode() == 'A')
				vo.setMenuName("아메리카노");
			if (vo.getMenuCode() == 'L')
				vo.setMenuName("라떼");
			if (vo.getMenuCode() == 'T')
				vo.setMenuName("차");
			if (vo.getMenuCode() == 'D')
				vo.setMenuName("디저트");
				*/
			//포장상태 = Y:포장, N:매장
			
			if (vo.getPacked() == 'Y')
				vo.setPackedName("포장");
			else
				vo.setPackedName("매장");
			
			System.out.println(vo);
		}
			//금액은 소수이하 두자리로 반올림
	}

	@Override
	public void output() {
		//출력     : 주문번호,고객명,메뉴명,주문금액,포장비,최종금액,포장상태
		//               num, name, menuName, orderKum, packMoney, kum, packedName 
		String		title = "주문번호 고객명 메뉴명 주문금액 포장비 최종금액 포장상태";
		System.out.println(title);
		
		for (CafeVo cafeVo : cafeList) {
			String		fmt	=	"%s     %s     %s     %.2f     %.2f   %.2f      %s\n";
			System.out.printf(fmt, cafeVo.getNum(), cafeVo.getName(), cafeVo.getMenuName(), cafeVo.getOrderKum(), cafeVo.getPackMoney(), cafeVo.getKum(), cafeVo.getPackedName());
		}
		
		
	}
	
} // 

public class TestCafe {

	public static void main(String[] args) {
		CafeOrder	cafeOrder	=	new	CafeOrder();
		cafeOrder.input();
		cafeOrder.process();
		cafeOrder.output();
		

	} // main end

} // class TestCafe end

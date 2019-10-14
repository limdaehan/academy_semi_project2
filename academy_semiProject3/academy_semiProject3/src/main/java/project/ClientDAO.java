package project;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClientDAO {
	
	@Autowired
	SqlSession session;
	
	
	public ClientVO checkClientVO(String mobile, String password) {
		System.out.println("DAO mobile: " + mobile);
		System.out.println("DAO password: " + password);
		
		ClientVO check1 = session.selectOne("checkClientVO1", mobile);
		ClientVO check2 = session.selectOne("checkClientVO2", password);
		
		ClientVO vo = session.selectOne("checkClientVO1", mobile);
		
		if(check1.mobile.equals(check2.mobile)&&check1.password.equals(check2.password)) {
			return vo;
		} else {
			return null;
		}
				
	}
	
//	public String checkClientVO(String mobile, String password) {
//		System.out.println("DAO mobile: " + mobile);
//		System.out.println("DAO password: " + password);
//		
//		ClientVO check1 = session.selectOne("checkClientVO1", mobile);
//		ClientVO check2 = session.selectOne("checkClientVO2", password);
//		
//		if(check1.mobile.equals(check2.mobile)&&check1.password.equals(check2.password)) {
//			return "selectPage";
//		} else {
//			return "loginErrorPage";
//		}
//				
//	}
	
	public int addClientVO(ClientVO vo) throws Exception {
		//SqlSession session = MyBatisSessionUtill.getSession();
		int result = session.insert("addClientVO",vo);
		//session.close();
		return result;
	}
	
	public int addParkingLot(LenderVO vo) throws Exception {
		//SqlSession session = MyBatisSessionUtill.getSession();
		int result = session.insert("addParkingLot",vo);
		//session.close();
		return result;
	}
	
	public int addLoanerVO(LoanerVO vo) throws Exception {
		//SqlSession session = MyBatisSessionUtill.getSession();
		int result = session.insert("addLoanerVO",vo);
		//session.close();
		return result;
	}
	
	public List<LenderVO> searchParkingLot(String search) throws Exception {
		//SqlSession session = MyBatisSessionUtill.getSession();
		System.out.println(search);
		List<LenderVO> list = session.selectList("searchParkingLot",search);
		//session.close();
		return list;
	}
	
	
	public List<LoanerVO> searchLoaner(String search) throws Exception {
		//SqlSession session = MyBatisSessionUtill.getSession();
		System.out.println(search);
		List<LoanerVO> list = session.selectList("searchLoaner",search);
		//session.close();
		return list;
	}
	//전화번호를 조회하여 고객객체를 가져오는 기능(비밀번호 찾는데 사용됨)
			public ClientVO getClient (String mobile, String accountNumber) {
				System.out.println("DAO mobile: " + mobile);
				System.out.println("DAO accountNumber: " + accountNumber);
				
				ClientVO check1 = session.selectOne("checkClientVO1", mobile);
				if(check1==null) {
					System.out.println("check1 == null");
				} else {
					System.out.println("check1 != null");
				}
				
				ClientVO check3 = session.selectOne("checkClientVO3", accountNumber);
				if(check3==null) {
					System.out.println("check3 == null");
				} else {
					System.out.println("check3 != null");
				}
				
				if(check1.mobile.equals(check3.mobile)&&check1.accountNumber.equals(check3.accountNumber)) {
					return check1;
				} else {
					return null;
				}
				
			}
			
			//아이디 중복확인
			public String checkMobile (String mobile) {
				List <String> mobileList = session.selectList("getMobile");
				 if(mobileList.contains(mobile)) {
					 return "이미 존재하는 전화번호 입니다";
				 } else {
					 return "사용 가능한 전화번호 입니다.";
				 }
			}

			//////=============================================ldh//////

			
			//내가 올린 리스트
			public List <LenderVO> getMyInfoLenderList(String mobile) {
				
				return session.selectList("myInfoLenderList", mobile);
			}
	
			
			//상황보기 빌리기  리스트 가져오기 
			public List<LoanerVO> getMyList(String clientMobile) {
				return session.selectList("getMyList", clientMobile);
			}



			//빌려준 리스트 수정페이지
			public LenderVO getLenderUpdatePage(int lenderId) throws Exception {
				return session.selectOne("getLenderUpdatePage", lenderId);
			}
			
			//빌려준 리스트 수정			
			public int getLenderUpdateById(LenderVO vo) {
				return session.update("getLenderUpdateById", vo);
				
			}
			//		빌려주기삭제 부분 
			public int deleteLenderId(String lenderId) {
				return session.delete("deleteLenderId",lenderId);
			}
			
			
			
			
			
			
			
			//==============================//
			//time check
			public LenderVO getLenderData(int lenderId) {
				
				LenderVO lender = session.selectOne("getLenderData", lenderId);
				return lender;
				
			}
			
			public List <LoanerVO> getLoanerData(int lenderId) {
				
				List<LoanerVO> loaner = session.selectList("getLoanerListByLenderId", lenderId);
				
				return loaner;
					
			}


			
			public int getStartTotal(LenderVO vo) {
				
				String s_Day = vo.start_day;
				System.out.println("s_Day: " + s_Day);
				
				String s_Time = vo.start_time;
				System.out.println("s_Time: " + s_Time);
				
				
				String [] startDay = splitDay(s_Day);

				
				int year =  Integer.parseInt(startDay[0])*525600;
				int month = Integer.parseInt(startDay[1])*43800;
				int days = Integer.parseInt(startDay[2])*1440;
				
				String[] startTime = splitTime(s_Time);
				int hour = Integer.parseInt(startTime[0])*60;
				int minute = Integer.parseInt(startTime[1]);
				
				int startTotal = year + month + days + hour + minute;
				System.out.println(startTotal);
				return startTotal;
			}
				
			//==============endTotal을 추출하는 함수===================//
			public int getEndTotal(LenderVO vo) {
				
				String e_Day = vo.getEnd_day();
				System.out.println("e_Day: " + e_Day);
				
				String e_Time = vo.getEnd_time();
				System.out.println("e_Time: " + e_Time);
				
				String[] startDay = splitDay(e_Day);
				int year =  Integer.parseInt(startDay[0])*525600;
				int month = Integer.parseInt(startDay[1])*43800;
				int days = Integer.parseInt(startDay[2])*1440;
				
				String[] startTime = splitTime(e_Time);
				int hour = Integer.parseInt(startTime[0])*60;
				int minute = Integer.parseInt(startTime[1]);
				
				int endTotal = year + month + days + hour + minute;
				System.out.println(endTotal);
				return endTotal;
			}
			
			//==============Date정보를 분리시키는 함수==================//
			public String [] splitDay(String date) {
				System.out.println("넘겨받은 값: " + date);
				String newDate = date.replace(".", "/");
				String [] days = newDate.split("/");
				
				return days;
			}
			
			public String [] splitTime(String time) {
				System.out.println("넘겨받은 값: " + time);
				
				String [] times = time.split(":");
				return times;
			}
}

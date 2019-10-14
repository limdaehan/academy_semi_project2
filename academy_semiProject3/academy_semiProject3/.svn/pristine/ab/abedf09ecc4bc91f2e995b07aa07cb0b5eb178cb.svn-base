package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {
	@Autowired
	ClientDAO dao;
	
	@Autowired
	Report report;
	
	@RequestMapping(value="mainPage.do", method=RequestMethod.GET)
	public String showMain() {
		
		return "mainPage";
		
	}
	@RequestMapping(value="cancel.do", method=RequestMethod.POST)
	public String cancel() {
		
		return "redirect:mainPage.do";
		
	}
	
	@RequestMapping(value="cancel.do", method=RequestMethod.GET)
	public String cancel2() {
		
		return "redirect:mainPage.do";
		
	}
	
	//로그인 버튼 클릭시 로그인 화면으로 이동하는 기능
	@RequestMapping(value="loginPage.do", method=RequestMethod.GET)
	public String loginForm1() {

		return "loginPage";
		
	}
	
	@RequestMapping(value="loginPage.do", method=RequestMethod.POST)
	public String loginForm2() {

		return "loginPage";
		
	}
	
	@RequestMapping(value="joinPage.do", method=RequestMethod.GET)
	public String joinForm() {

		return "joinPage";
		
	}
	//비밀번호 찾는 페이지(전화번호 입력)
		@RequestMapping(value="findPwPage.do", method=RequestMethod.GET)
		public String findForm() {

			return "findPwPage";
			
		}
		
		//아이디를 중복체크하는 페이지를 연다.
		@RequestMapping(value="checkMobile.do", method=RequestMethod.GET)
		public String checkMobile() {
			return "mobileCheckPage";
		}
	//입력한 회원정보를 DB에 저장
	@RequestMapping(value="addClient.do", method=RequestMethod.POST)
	public String add(ClientVO vo) throws Exception {
		
		dao.addClientVO(vo);
		
		return "redirect:loginPage.do";	
	}
	
	//로그인시 DB에서 정보를 체크
	@RequestMapping(value="checkClient.do", method=RequestMethod.POST)
	public String check(String mobile, String password, HttpSession session) {
				
		
		ClientVO vo = dao.checkClientVO(mobile, password);
		//List <LenderVO> lenderList = dao.getMyInfoLenderList(mobile);
		session.setAttribute("vo", vo);
		//session.setAttribute("LenderVO", lenderList);
		

		if (vo!=null) {
			return "selectPage";
			
		}else {
			return "loginErrorPage";
		}
		
	}
	
	//비밀번호 찾아주는 기능 만들기
			@RequestMapping(value="showPw.do", method=RequestMethod.POST)
			public String showPw(String mobile, String accountNumber, Model model) {
				ClientVO checkPW = dao.getClient(mobile, accountNumber);
				
				if(checkPW!=null) {
					model.addAttribute("checkPW", checkPW);
					return "showPwPage";
				} else {
					return "loginErrorPage";
				}		
			}
			
		//아이디 중복 검사
			@RequestMapping(value="checkMobile.do", method=RequestMethod.POST)
			public String checkMobile(String mobile, Model model) {
				String cannot = "이미 존재하는 전화번호 입니다";
				String can = "사용 가능한 전화번호 입니다";
				
				String result = dao.checkMobile(mobile);
				
				if(result.equals(cannot)) {
					model.addAttribute("result", cannot);
					return "mobileCheckPage";
				} else {
					model.addAttribute("result", mobile);
					return "mobileCheckPage";
				}
				
			}
	
	//고객정보 출력 맵핑
	@RequestMapping(value="reportPage.do", method=RequestMethod.GET)
	public String reportPage() {
		return "reportPage";
	}
	
	@RequestMapping(value="consumerPrintPage.do", method=RequestMethod.GET)
	public String consumerPrintPage(String fileName) {
		report.consumerReport(fileName);
		return "EndingPage";
	}
	
	@RequestMapping(value="providerPrintPage.do", method=RequestMethod.GET)
	public String providerPrintPage(String fileName) {
		report.providerReport(fileName);
		return "EndingPage";
	}
	@RequestMapping(value="borrow.do", method=RequestMethod.GET)
	public String borrowPage() {
		
		return "borrowPage";
	}
	@RequestMapping(value="borrow2.do", method=RequestMethod.GET)
	public String borrowPage2() {
		
		return "borrowPage2";
	}
	
	@RequestMapping(value="lend.do", method=RequestMethod.GET)
	public String lendPage() {
		
		return "lendPage";
	}
	
	@RequestMapping(value="addParkingLot.do", method=RequestMethod.POST)
	public String addParkingLot(LenderVO vo) throws Exception {
		dao.addParkingLot(vo);
		return "statusinfo";
	}
	
	@RequestMapping(value="addLoaner.do", method=RequestMethod.GET)
	public String addLoaner(LoanerVO vo) throws Exception {
		dao.addLoanerVO(vo);
		return "statusinfo";
	}
	
	@RequestMapping(value="/requestObject", method=RequestMethod.POST)
    @ResponseBody
    public List<LenderVO> simpleWithObject(@RequestParam(value="user") String search) throws Exception {
        //필요한 로직 처리
		
		List<LenderVO> list = (List<LenderVO>)dao.searchParkingLot(search);
        return list;
    }
	
	@RequestMapping(value="/requestLoaner", method=RequestMethod.POST)
    @ResponseBody
    public List<LoanerVO> simpleWithLoaner(@RequestParam(value="lenderId") String search) throws Exception {
        //필요한 로직 처리
		
		List<LoanerVO> list = (List<LoanerVO>)dao.searchLoaner(search);
        return list;
    }
	
	
	//=========================================//
	

	// 상황보기 리스트 
		@RequestMapping(value="statusInfo.do", method=RequestMethod.POST) 
		  public String status(Model model, HttpSession session) throws Exception {
			//가져옴
			ClientVO vo=(ClientVO)session.getAttribute("vo");
			List <LoanerVO> loanerList = dao.getMyList(vo.mobile);
			List <LenderVO> lenderList = dao.getMyInfoLenderList(vo.mobile);
			System.out.println(loanerList.get(0));
			
			session.setAttribute("loanerList", loanerList);
			session.setAttribute("LenderVO", lenderList);
		  return "statusInfo"; }
		 
		
			//상황보기 리스트 겟방식
		  @RequestMapping(value="statusInfo.do", method=RequestMethod.GET) 
		  public String status2(Model model,  HttpSession session) throws Exception { 
			  	
			  ClientVO vo=(ClientVO)session.getAttribute("vo");
				List <LoanerVO> loanerList = dao.getMyList(vo.mobile);
				System.out.println(loanerList.get(0));
				session.setAttribute("loanerList", loanerList);
	

		  return "statusInfo"; 
		  }
		  
		
		 
		 
		  // 사용자가 빌려준 주차장 업데이트 페이지
		  @RequestMapping("lender_edit_form.do")
			public String getUpdateLenderPage(int lenderId, Model model) throws Exception {
				System.out.println(lenderId);	
				
				LenderVO vo = dao.getLenderUpdatePage(lenderId);
				model.addAttribute("ld",vo);
				return "lender_edit_form";
			}
		  
		  //사용자가 빌려준 주차장  업데이트 
		  @RequestMapping("lenderUpdate.do")
		  public String getUpdateLender(LenderVO vo, Model model)  throws Exception {
			  System.out.println("테스트");
		/* System.out.println("update되었습니다 --->" + vo); */

		  dao.getLenderUpdateById(vo);

		  return "selectPage";
		  }
		  
		  
		  //주인이 빌려준 주차장 삭제
		  @RequestMapping("deleteLender.do")
		  public String deleteLenderId(String lenderId, Model model) throws Exception{ 
			  System.out.println("삭제되었습니다." + lenderId);
			  
			  dao.deleteLenderId(lenderId);
			  
			  return "selectPage";
			  
		  }
		 
	
	
	  
	  
	  
	  //==================================//
	  @RequestMapping(value="websocket/chat", method=RequestMethod.GET)
		public String chat() {
			
			return "client";
		}
	  
	  /// time check
	  @RequestMapping(value="sendTest.do", method=RequestMethod.GET)
		public String sendTest(String startDay, String endDay, String startTime, String endTime, int lenderId, LoanerVO vo, Model model) throws Exception {
			//여기서는 lenderID가 22인 임의의 DB 를 가지 테스트를 진행
			LenderVO lender = dao.getLenderData(lenderId);
			model.addAttribute("test", lender);
			//올린 시간
			int startMain = dao.getStartTotal(lender);
			model.addAttribute("startMain", startMain);
			
			int endMain = dao.getEndTotal(lender);
			model.addAttribute("endMain", endMain);
			
			//======================사용할 시간==========================//
			//시작
			String newDate = startDay.replace(".", "/");
			String [] req1 = newDate.split("/");
			String [] req2 = startTime.split(":");
			
			int start_date = Integer.parseInt(req1[0])*(525600) + Integer.parseInt(req1[1])*(43800) + Integer.parseInt(req1[2])*(1440);
			int start_Time = Integer.parseInt(req2[0])*(60) + Integer.parseInt(req2[1]);
			int start = start_date + start_Time;
			model.addAttribute("start", start);
			
			//끝
			String endDate = endDay.replace(".", "/");
			String [] req3 = endDate.split("/");
			String [] req4 = endTime.split(":");
			int end_date = Integer.parseInt(req3[0])*(525600) + Integer.parseInt(req3[1])*(43800) + Integer.parseInt(req3[2])*(1440);
			int end_Time = Integer.parseInt(req4[0])*(60) + Integer.parseInt(req4[1]);
			int end = end_date + end_Time;
			model.addAttribute("end", end);
			//========================2차 검증 셋팅=======================//
			List<LoanerVO> loaner = dao.getLoanerData(lenderId);
			List<Integer> times = new ArrayList<Integer>();
			
			//1차 검증 요청된 시간이 main 시간 안에 포함되는가 - 성공
			if(start>startMain&&end<endMain) {
				if(loaner.size()==0) {
					dao.addLoanerVO(vo);
					return "statusinfo";
				}else {
					
				for(int i = 0; i<loaner.size(); i++) {
					//시작 날짜
					System.out.println(loaner.get(i).getStartDay());
					String new1 = (loaner.get(i).getStartDay()).replace(".", "/");
					String [] newDay = new1.split("/");
					int day = Integer.parseInt(newDay[0])*(525600) + Integer.parseInt(newDay[1])*(43800) + Integer.parseInt(newDay[2])*(1440);

					//시작 시간
					System.out.println(loaner.get(i).getStartTime());
					String [] newTime = loaner.get(i).getStartTime().split(":");
					int time = Integer.parseInt(newTime[0])*(60) + Integer.parseInt(newTime[1]);
					
					//시작 숫자를 배열에 삽입
					int startTotal = day + time;
					System.out.println("시작(" + i +"): " + startTotal);
					times.add(startTotal);
					
					
					//끝 날짜
					System.out.println(loaner.get(i).getEndDay());
					String end1 = (loaner.get(i).getEndDay()).replace(".", "/");
					String [] lastDay = end1.split("/");
					int day1 = Integer.parseInt(lastDay[0])*(525600) + Integer.parseInt(lastDay[1])*(43800) + Integer.parseInt(lastDay[2])*(1440);
					
					//끝 시간
					System.out.println(loaner.get(i).getEndTime());
					String [] end2 = loaner.get(i).getEndTime().split(":");
					int time1 = Integer.parseInt(end2[0])*(60) + Integer.parseInt(end2[1]);
					
					//끝 숫자를 배열에 삽입
					int endTotal = day1 + time1;
					System.out.println("끝(" + i +"): " + endTotal);
					times.add(endTotal);
				}
				Collections.sort(times);
				for(int i = 0; i<times.size();i++) {
					if(start<times.get(i)&&end>times.get(i)) {
						
						return "borrow2";
						
					}
				}
				dao.addLoanerVO(vo);
				return "statusinfo";
				}
			
			}
			return "borrow2";
		}

}

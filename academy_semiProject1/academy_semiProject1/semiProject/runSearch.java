package semiProject;

import java.util.*;

public class runSearch {

	static void run() {
		boolean t = true;
		while(t) {
			try  {
				// 프로그램 실행
				System.out.println("기능 선택");
				System.out.println("[1.조회]    [2.수정]     [3.통계]     [4.기타기능]     [0.종료]");
				System.out.print("번호를 입력해주세요 : ");
				Scanner scan = new Scanner(System.in);
				// 값 입력

				switch(scan.nextInt()) {
				case 0 :
					t= false;
					break;

				case 1 : lookUp(); // 조회하기 

				break;
				case 2 : 
					System.out.print("1. 부서별 급여조정, 2. 개인별 급여조정");
					System.out.println();
					System.out.print("번호를 입력해주세요 : ");
					switch(scan.nextInt()) {
					case 1 : // 부서별 급여
						Update.updateSalaryByDept();
						break;
					case 2 : // 도시별 급여
						Update.updateSalaryByEmp();
						break;
					}
					break;
				case 3 :  // 통계 보기
					System.out.println("[1.부서별 급여]  [2.도시별 급여]  [3.직종별 급여]  [4.부서별 인원]  [5.직종별 인원]  [5.도시별 인원]");
					System.out.print("번호를 입력해주세요 : ");
					switch(scan.nextInt()) {
					case 1 :
						ArrayList<EmpVO> list = Statistics.getMeanSalaryByDeptId();
						for (EmpVO vo : list) {
							if(vo.getDeptId()==0) {
								System.out.println("  부 서 없 음 "+ "    "  +  " 부서평균급여 : " +vo.getSalary());
							} else {
								System.out.println("부서번호 : " + vo.getDeptId() + " 부서평균급여  : " + vo.getSalary());
							}
						}
						break;
					case 2 :
						ArrayList<EmpVO> list2 = Statistics.getMeanSalaryByCity();
						for (EmpVO vo : list2) {
							if(vo.getCityName()==null) {
								System.out.println("    도 시 없 음 "+ "    "  +  " 도시별평균급여 : " +vo.getSalary());
							} else {
								System.out.println("도시명 : " + vo.getCityName() + "    "  + "도시별평균급여 : " +  vo.getSalary());
							}
						}
						break;
					case 3 :
						ArrayList<EmpVO> list3 = Statistics.getMeanSalaryByJobId();
						for (EmpVO vo : list3) {
							System.out.println("직종 : " + vo.getJobId() + "    "  + "직종별평균급여 : " + vo.getSalary());
						}
						break;
					case 4 :
						ArrayList<EmpVO> list4 = Statistics.getNumbersByDeptId();
						for (EmpVO vo : list4) {
							if(vo.getDeptId()==0) {
								System.out.println("  부 서 없 음 "+ "    "  +  " 부서별인원 : " + vo.getSalary() + "명");
							} else {
								System.out.println("부서번호 : " + vo.getDeptId() + " 부서별인원  : " + vo.getSalary() +"명");
							}
						}
						break;
					case 5 :
						ArrayList<EmpVO> list5 = Statistics.getNumbersByJobId();
						for (EmpVO vo : list5) {
							System.out.println("직종 : " + vo.getJobId() + "    "  + "직종별인원 : " +  vo.getSalary() +"명");
						}
						break;
					case 6 :
						ArrayList<EmpVO> list6 = Statistics.getNumbersByCity();
						for (EmpVO vo : list6) {
							if(vo.getCityName()==null) {
								System.out.println("    도 시 없 음 "+ "    "  +  "  : " +vo.getSalary()+ "명");
							} else {
								System.out.println("도시명 : " + vo.getCityName() + "    "  + " : " +  vo.getSalary()+"명");
							}
						}
						break;

					}   
					break;
				case 4 :  // 기타기능
					System.out.println("[1.근속 연수]  [2.연봉]  [3.풀네임]  [4.원화로 급여계산(1:1200)]");
					System.out.print("번호를 입력해주세요 : ");			
					switch(scan.nextInt()) {
					case 1 : // 근속연수
						ArrayList<EmpVO> list = EtcFunction.getYearByEmpId();
						for (EmpVO vo : list) {
							System.out.println("사번 : " + vo.getEmpId() + "   " + "근속년수 : " +  vo.getHireDate() + "년");
						}
						break;
					case 2 : // 연봉
						ArrayList<EmpVO> list2 = EtcFunction.getYearSalaryByEmpId();
						for (EmpVO vo : list2) {
							System.out.println("사번 : " + vo.getEmpId() + "   " + "연봉 : " +  vo.getSalary());
						}
						break;
					case 3 : // 풀네임
						ArrayList<EmpVO> list3 = EtcFunction.getFullName();
						for (EmpVO vo : list3) {
							System.out.println("사번 : " + vo.getEmpId() + " - " + vo.getLastName() + " " + vo.getFirstName());
						}
						break;
					case 4 : // 원화로 급여 계산
						ArrayList<EmpVO> list4 = EtcFunction.getWonSalary();
						for (EmpVO vo : list4) {
							System.out.println("사번 : " + vo.getEmpId() + "   " + "급여(원화) : " +  vo.getSalary() +"원");
						}
						break;

					}
				}
			}catch(Exception e) {
				System.out.println("다시입력해주세요");
			}
		}
	}

	// 조회하기 함수
	static void lookUp() throws Exception {

		// getDeptId() 실행
		ArrayList selectedSearch = selectSearch();

		int inputResult = (int)selectedSearch.get(2);
		ArrayList<EmpVO> list = null;
		switch((int)selectedSearch.get(0)) {
		case 0 : 
			int input0 = (int)selectedSearch.get(1);
			list = EmpDAO.getEmpListByEmpId(input0);
			break;
		case 1 : 
			String input1 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByLastName(input1);
			break;
		case 2 :
			int input2 = (int)selectedSearch.get(1);
			list = EmpDAO.getEmpListBySalary(input2);
			break;
		case 3 : 	 
			int input3 = (int)selectedSearch.get(1);
			list = EmpDAO.getEmpListByHireDate(input3);
			break;
		case 4 : 	
			String input4 = (String)selectedSearch.get(1); 
			list = EmpDAO.getEmpListByFirstName(input4);
			break;
		case 5 : 	 
			int input5 = (int)selectedSearch.get(1);
			list = EmpDAO.getEmpListByCommiPct(input5);
			break;
		case 6 : 	
			String input6 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByPhoneNumber(input6);
			break;
		case 7 : 	
			String input7 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByJobId(input7);
			break;
		case 8 : 	
			String input8 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByEmail(input8);
			break;
		case 9 : 	
			int input9 = (int)selectedSearch.get(1);
			list = EmpDAO.getEmpListByDeptId(input9);
			break;
		case 10 : 	
			int input10 = (int)selectedSearch.get(1);
			list = EmpDAO.getEmpListByManagerId(input10);
			break;
		case 11 : 	
			String input11 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByCityName(input11);
			break;
		case 12 : 	
			String input12 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByDeptManagerName(input12);
			break;
		case 13 : 	
			String input13 = (String)selectedSearch.get(1);
			list = EmpDAO.getEmpListByManagerName(input13);
			break;
		}

		// 출력받고 싶은 값 선정
		for(EmpVO vo:list) {
			switch(inputResult) {
			case 0 :
				System.out.println("사번 : " + vo.getEmpId());
				break;
			case 1 : 
				System.out.println("사번 : " + vo.getEmpId() + " " + "성 : " + vo.getLastName());
				break;
			case 2 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "급여 : " + vo.getSalary());
				break;
			case 3 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "입사일 : " + vo.getHireDate());
				break;
			case 4 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "이름 : " + vo.getFirstName());
				break;
			case 5 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "커미션 : " + vo.getCommissionPct());
				break;
			case 6 : 
				System.out.println("사번 : " + vo.getEmpId() + " " + "전화번호 : " + vo.getPhoneNumber());
				break;
			case 7 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "직무 : " + vo.getJobId());
				break;
			case 8 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "이메일 : " + vo.getEmail());
				break;
			case 9 :
				System.out.println("사번 : " + vo.getEmpId() + " " + "부서번호 : " + vo.getDeptId());
				break;
			case 10 : 
				System.out.println("사번 : " + vo.getEmpId() + " " + "관리자번호 : " + vo.getManagerId());
				break;
			case 11 : 
				System.out.println(vo);
				break;
			}



		}
	}



	// 
	private static ArrayList selectSearch() {
		ArrayList list = new ArrayList();

		System.out.println("================================================================");
		System.out.println("검색대상");
		System.out.println("[0.사번] [1.성] [2.급여] [3.입사일] [4.이름] [5.커미션] [6.전화번호]");
		System.out.println("[7.직무] [8.이메일] [9.부서번호] [10.관리자번호] [11.도시명] [12.부서장명]");

		System.out.print("번호를 입력해주세요 : ");
		Scanner scan = new Scanner(System.in);
		list.add(scan.nextInt());
		System.out.println("================================================================");


		switch((int)list.get(0)) {
		case 0 :
			System.out.print("사번 : ");
			list.add(scan.nextInt());
			break;
		case 1 : 
			System.out.print("성  : ");
			list.add(scan.next());
			break;
		case 2 :
			System.out.print("급여 : ");
			list.add(scan.nextInt());
			break;
		case 3 :
			System.out.print("입사일 : ");
			list.add(scan.nextInt());
			break;
		case 4 :
			System.out.print("이름  : ");
			list.add(scan.next());
			break;
		case 5 :
			System.out.print("커미션 : ");
			list.add(scan.nextInt());
			break;
		case 6 : 
			System.out.print("전화번호 : ");
			list.add(scan.next());
			break;
		case 7 :
			System.out.print("직무 : ");
			list.add(scan.next());
			break;
		case 8 :
			System.out.print("이메일  : ");
			list.add(scan.next());
			break;
		case 9 :
			System.out.print("부서번호 : ");
			list.add(scan.nextInt());
			break;
		case 10 : 
			System.out.print("관리자번호 : ");
			list.add(scan.nextInt());
			break;
		case 11 : 
			System.out.print("도시명 : ");
			list.add(scan.next());
			break;
		case 12 : 
			System.out.print("부서장명 : ");
			list.add(scan.next());
			break;
		case 13 : 
			System.out.print("관리자명 : ");
			list.add(scan.next());
			break;
		}

		System.out.println("================================================================");
		System.out.println("출력자료");
		System.out.println("[0.사번] [1.성] [2.급여] [3.입사일] [4.이름] [5.커미션] [6.전화번호]");
		System.out.println("[7.직무] [8.이메일] [9.부서번호] [10.관리자번호] [11.전체자료조회]");
		System.out.print("번호를 입력해주세요 : ");
		list.add(scan.nextInt());
		System.out.println("================================================================");
		return list;
	}


}

package semiProject;

import java.util.*;

public class runSearch {

	static void run() {
		boolean t = true;
		while(t) {
			try  {
				// ���α׷� ����
				System.out.println("��� ����");
				System.out.println("[1.��ȸ]    [2.����]     [3.���]     [4.��Ÿ���]     [0.����]");
				System.out.print("��ȣ�� �Է����ּ��� : ");
				Scanner scan = new Scanner(System.in);
				// �� �Է�

				switch(scan.nextInt()) {
				case 0 :
					t= false;
					break;

				case 1 : lookUp(); // ��ȸ�ϱ� 

				break;
				case 2 : 
					System.out.print("1. �μ��� �޿�����, 2. ���κ� �޿�����");
					System.out.println();
					System.out.print("��ȣ�� �Է����ּ��� : ");
					switch(scan.nextInt()) {
					case 1 : // �μ��� �޿�
						Update.updateSalaryByDept();
						break;
					case 2 : // ���ú� �޿�
						Update.updateSalaryByEmp();
						break;
					}
					break;
				case 3 :  // ��� ����
					System.out.println("[1.�μ��� �޿�]  [2.���ú� �޿�]  [3.������ �޿�]  [4.�μ��� �ο�]  [5.������ �ο�]  [5.���ú� �ο�]");
					System.out.print("��ȣ�� �Է����ּ��� : ");
					switch(scan.nextInt()) {
					case 1 :
						ArrayList<EmpVO> list = Statistics.getMeanSalaryByDeptId();
						for (EmpVO vo : list) {
							if(vo.getDeptId()==0) {
								System.out.println("  �� �� �� �� "+ "    "  +  " �μ���ձ޿� : " +vo.getSalary());
							} else {
								System.out.println("�μ���ȣ : " + vo.getDeptId() + " �μ���ձ޿�  : " + vo.getSalary());
							}
						}
						break;
					case 2 :
						ArrayList<EmpVO> list2 = Statistics.getMeanSalaryByCity();
						for (EmpVO vo : list2) {
							if(vo.getCityName()==null) {
								System.out.println("    �� �� �� �� "+ "    "  +  " ���ú���ձ޿� : " +vo.getSalary());
							} else {
								System.out.println("���ø� : " + vo.getCityName() + "    "  + "���ú���ձ޿� : " +  vo.getSalary());
							}
						}
						break;
					case 3 :
						ArrayList<EmpVO> list3 = Statistics.getMeanSalaryByJobId();
						for (EmpVO vo : list3) {
							System.out.println("���� : " + vo.getJobId() + "    "  + "��������ձ޿� : " + vo.getSalary());
						}
						break;
					case 4 :
						ArrayList<EmpVO> list4 = Statistics.getNumbersByDeptId();
						for (EmpVO vo : list4) {
							if(vo.getDeptId()==0) {
								System.out.println("  �� �� �� �� "+ "    "  +  " �μ����ο� : " + vo.getSalary() + "��");
							} else {
								System.out.println("�μ���ȣ : " + vo.getDeptId() + " �μ����ο�  : " + vo.getSalary() +"��");
							}
						}
						break;
					case 5 :
						ArrayList<EmpVO> list5 = Statistics.getNumbersByJobId();
						for (EmpVO vo : list5) {
							System.out.println("���� : " + vo.getJobId() + "    "  + "�������ο� : " +  vo.getSalary() +"��");
						}
						break;
					case 6 :
						ArrayList<EmpVO> list6 = Statistics.getNumbersByCity();
						for (EmpVO vo : list6) {
							if(vo.getCityName()==null) {
								System.out.println("    �� �� �� �� "+ "    "  +  "  : " +vo.getSalary()+ "��");
							} else {
								System.out.println("���ø� : " + vo.getCityName() + "    "  + " : " +  vo.getSalary()+"��");
							}
						}
						break;

					}   
					break;
				case 4 :  // ��Ÿ���
					System.out.println("[1.�ټ� ����]  [2.����]  [3.Ǯ����]  [4.��ȭ�� �޿����(1:1200)]");
					System.out.print("��ȣ�� �Է����ּ��� : ");			
					switch(scan.nextInt()) {
					case 1 : // �ټӿ���
						ArrayList<EmpVO> list = EtcFunction.getYearByEmpId();
						for (EmpVO vo : list) {
							System.out.println("��� : " + vo.getEmpId() + "   " + "�ټӳ�� : " +  vo.getHireDate() + "��");
						}
						break;
					case 2 : // ����
						ArrayList<EmpVO> list2 = EtcFunction.getYearSalaryByEmpId();
						for (EmpVO vo : list2) {
							System.out.println("��� : " + vo.getEmpId() + "   " + "���� : " +  vo.getSalary());
						}
						break;
					case 3 : // Ǯ����
						ArrayList<EmpVO> list3 = EtcFunction.getFullName();
						for (EmpVO vo : list3) {
							System.out.println("��� : " + vo.getEmpId() + " - " + vo.getLastName() + " " + vo.getFirstName());
						}
						break;
					case 4 : // ��ȭ�� �޿� ���
						ArrayList<EmpVO> list4 = EtcFunction.getWonSalary();
						for (EmpVO vo : list4) {
							System.out.println("��� : " + vo.getEmpId() + "   " + "�޿�(��ȭ) : " +  vo.getSalary() +"��");
						}
						break;

					}
				}
			}catch(Exception e) {
				System.out.println("�ٽ��Է����ּ���");
			}
		}
	}

	// ��ȸ�ϱ� �Լ�
	static void lookUp() throws Exception {

		// getDeptId() ����
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

		// ��¹ް� ���� �� ����
		for(EmpVO vo:list) {
			switch(inputResult) {
			case 0 :
				System.out.println("��� : " + vo.getEmpId());
				break;
			case 1 : 
				System.out.println("��� : " + vo.getEmpId() + " " + "�� : " + vo.getLastName());
				break;
			case 2 :
				System.out.println("��� : " + vo.getEmpId() + " " + "�޿� : " + vo.getSalary());
				break;
			case 3 :
				System.out.println("��� : " + vo.getEmpId() + " " + "�Ի��� : " + vo.getHireDate());
				break;
			case 4 :
				System.out.println("��� : " + vo.getEmpId() + " " + "�̸� : " + vo.getFirstName());
				break;
			case 5 :
				System.out.println("��� : " + vo.getEmpId() + " " + "Ŀ�̼� : " + vo.getCommissionPct());
				break;
			case 6 : 
				System.out.println("��� : " + vo.getEmpId() + " " + "��ȭ��ȣ : " + vo.getPhoneNumber());
				break;
			case 7 :
				System.out.println("��� : " + vo.getEmpId() + " " + "���� : " + vo.getJobId());
				break;
			case 8 :
				System.out.println("��� : " + vo.getEmpId() + " " + "�̸��� : " + vo.getEmail());
				break;
			case 9 :
				System.out.println("��� : " + vo.getEmpId() + " " + "�μ���ȣ : " + vo.getDeptId());
				break;
			case 10 : 
				System.out.println("��� : " + vo.getEmpId() + " " + "�����ڹ�ȣ : " + vo.getManagerId());
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
		System.out.println("�˻����");
		System.out.println("[0.���] [1.��] [2.�޿�] [3.�Ի���] [4.�̸�] [5.Ŀ�̼�] [6.��ȭ��ȣ]");
		System.out.println("[7.����] [8.�̸���] [9.�μ���ȣ] [10.�����ڹ�ȣ] [11.���ø�] [12.�μ����]");

		System.out.print("��ȣ�� �Է����ּ��� : ");
		Scanner scan = new Scanner(System.in);
		list.add(scan.nextInt());
		System.out.println("================================================================");


		switch((int)list.get(0)) {
		case 0 :
			System.out.print("��� : ");
			list.add(scan.nextInt());
			break;
		case 1 : 
			System.out.print("��  : ");
			list.add(scan.next());
			break;
		case 2 :
			System.out.print("�޿� : ");
			list.add(scan.nextInt());
			break;
		case 3 :
			System.out.print("�Ի��� : ");
			list.add(scan.nextInt());
			break;
		case 4 :
			System.out.print("�̸�  : ");
			list.add(scan.next());
			break;
		case 5 :
			System.out.print("Ŀ�̼� : ");
			list.add(scan.nextInt());
			break;
		case 6 : 
			System.out.print("��ȭ��ȣ : ");
			list.add(scan.next());
			break;
		case 7 :
			System.out.print("���� : ");
			list.add(scan.next());
			break;
		case 8 :
			System.out.print("�̸���  : ");
			list.add(scan.next());
			break;
		case 9 :
			System.out.print("�μ���ȣ : ");
			list.add(scan.nextInt());
			break;
		case 10 : 
			System.out.print("�����ڹ�ȣ : ");
			list.add(scan.nextInt());
			break;
		case 11 : 
			System.out.print("���ø� : ");
			list.add(scan.next());
			break;
		case 12 : 
			System.out.print("�μ���� : ");
			list.add(scan.next());
			break;
		case 13 : 
			System.out.print("�����ڸ� : ");
			list.add(scan.next());
			break;
		}

		System.out.println("================================================================");
		System.out.println("����ڷ�");
		System.out.println("[0.���] [1.��] [2.�޿�] [3.�Ի���] [4.�̸�] [5.Ŀ�̼�] [6.��ȭ��ȣ]");
		System.out.println("[7.����] [8.�̸���] [9.�μ���ȣ] [10.�����ڹ�ȣ] [11.��ü�ڷ���ȸ]");
		System.out.print("��ȣ�� �Է����ּ��� : ");
		list.add(scan.nextInt());
		System.out.println("================================================================");
		return list;
	}


}

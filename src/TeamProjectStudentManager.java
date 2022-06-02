
import java.util.Arrays;
import java.util.Scanner;


public class TeamProjectStudentManager {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int managerNum = 0; // 정보출력을 위한 초기화
        String name[] = {};
        String major[] = {};
        String phone[] = {};
        String sNumber[] = {};
        double avg[] = {};

        int select = 0; //메뉴 입력값 저장 변수

        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------ 학생 관리 프로그램 ------------------------");

        while (true) {
            System.out.println("\n============================== 메뉴 =============================");
            System.out.println("1. 정보 입력");
            System.out.println("2. 정보 출력");
            System.out.println("3. 정보 수정");
            System.out.println("4. 정보 삭제");
            System.out.println("5. 종료");
            System.out.println("=================================================================");
            System.out.print("선택>> ");
            select = sc.nextInt();
            sc.nextLine(); // enter skip

            //먼저 처리할 메뉴: 종료
            if (select == 5) {
                System.out.println("종료합니다.");
                break;
            }
            switch (select) {
                case 1: //입력 메뉴 서브타이틀 출력
                    while (true) {
                        System.out.println("---------------------- 학생 등록 ----------------------");
                        System.out.print("이름: ");
                        String SName = sc.nextLine();
                        System.out.print("학과: ");
                        String SMajor = sc.nextLine();
                        System.out.print("연락처: ");
                        String SPhone = sc.nextLine();
                        System.out.print("학번: ");
                        String SNumber = sc.nextLine();
                        System.out.print("학점: ");
                        //avg[i] = sc.nextFloat();
                        String fStr = sc.nextLine();
                        double SAvg = Double.parseDouble(fStr);
                        String[] tempName = new String[name.length + 1];
                        String[] tempMajor = new String[major.length + 1];
                        String[] tempPhone = new String[phone.length + 1];
                        String[] tempSNumber = new String[sNumber.length + 1];
                        double[] tempAvg = new double[avg.length + 1];
                        for (int i = 0; i < name.length; i++) {
                            tempName[i] = name[i];
                            tempMajor[i] = major[i];
                            tempPhone[i] = phone[i];
                            tempSNumber[i] = sNumber[i];
                            tempAvg[i] = avg[i];
                        }
                        tempName[tempName.length - 1] = SName;
                        name = tempName;
                        tempName = null;

                        tempMajor[tempMajor.length - 1] = SMajor;
                        major = tempMajor;
                        tempMajor = null;

                        tempPhone[tempPhone.length - 1] = SPhone;
                        phone = tempPhone;
                        tempPhone = null;

                        tempSNumber[tempSNumber.length - 1] = SNumber;
                        sNumber = tempSNumber;
                        tempSNumber = null;

                        tempAvg[tempAvg.length - 1] = SAvg;
                        avg = tempAvg;
                        tempAvg = null;

                        System.out.println("계속 등록을 원하시면 [y]를 입력하세요.");
                        System.out.println("등록을 종료 하시려면 [y]를 제외한 아무키나 입력하세요.");
                        System.out.print(">> ");
                        String answer = sc.nextLine();
                        if (answer.equals("y")) {
                            continue;
                        } else {
                            System.out.println("#### 등록 완료되었습니다. ####");
                            break;
                        }
                    }
                    break;
                case 2: //출력 메뉴
                    System.out.println();
                    System.out.println("---------------------- 정보 출력 ----------------------");
                    for (int i = 0; i < name.length; i++) {
                        //sc.nextLine(); //enter skip 해줌
                        int No = i + 1; //정보 입력 학생 순차적 넘버 부여 초기화
                        System.out.print("No." + No + " " + "[이름]: " + name[i] + ",");
                        System.out.print(" [학과]: " + major[i] + ",");
                        System.out.print(" [연락처]: " + phone[i] + ",");
                        System.out.print(" [학번]: " + sNumber[i] + ",");
                        System.out.print(" [학점]: " + avg[i] + "\n");
                    }
                    break;
                case 3: //정보 수정
                    System.out.println("---------------------- 정보 수정 ----------------------");
                    while (true) {
                        System.out.println("수정을 종료 하시려면 <그만>이라고 입력하세요.");
                        System.out.println("현재 등록된 학생 목록: " + Arrays.toString(name));
                        System.out.print("수정할 학생 이름: ");

                        String targetName = sc.nextLine();
                        if (targetName.equals("그만")) {
                            break;
                        }
                        int index = -1;
                        for (int i = 0; i < name.length; i++) {
                            if (targetName.equals(name[i])) {
                                index = i;
                                //System.out.println("index: " + index);
                                System.out.print("# 수정할 학과: ");
                                major[index] = sc.nextLine();
                                System.out.print("# 수정할 연락처: ");
                                phone[index] = sc.nextLine();
                                System.out.print("# 수정할 학번: ");
                                sNumber[index] = sc.nextLine();
                                System.out.print("# 수정할 학점: ");
                                avg[index] = sc.nextFloat();
                                sc.nextLine();
                                System.out.println("############# 수정완료! #############");
                                break;
                            }
                        }
                        if (index == -1) {
                            System.out.println("\n#### 존재하지 않는 학생입니다. 다시 입력하세요. ####");
                        }
                    }
                    break;
                case 4: //정보삭제
                    System.out.println("---------------------- 정보 삭제 ----------------------");
                    System.out.println("현재 등록된 학생 목록: " + Arrays.toString(name));

                    while (true) {
                        System.out.println("삭제할 학생 이름을 입력하세요.");
                        System.out.print(">> ");
                        String targetName = sc.next();

                        //탐색
                        int index = -1;
                        for (int i = 0; i < name.length; i++) {
                            if(targetName.equals(name[i])) {
                                index = i;
                                break;
                            }
                        }
                        //탐색 확인 후 삭제
                        if(index != -1) {
                            System.out.println("[" + name[index] + "]" + " 학생 정보를 삭제합니다.");

                            //삭제 알고리즘
                            for (int i = index; i < name.length - 1; i++) {
                                name[i] = name[i + 1];
                                major[i] = major[i + 1];
                                phone[i] = phone[i + 1];
                                sNumber[i] =sNumber[i + 1];
                                avg[i] = avg[i + 1];
                            }
                            String delName[] = new String[name.length -1];
                            String delMajor[] = new String[name.length -1];
                            String delPhone[] = new String[name.length -1];
                            String delsNumber[] = new String[name.length -1];
                            double delAvg[] = new double[name.length -1];
                            for (int i = 0; i < name.length - 1; i++) {
                                delName[i] = name[i];
                                delMajor[i] = major[i];
                                delPhone[i] = phone[i];
                                delsNumber[i] = sNumber[i];
                                delAvg[i] = avg[i];
                            }
                            name = delName; delName = null;
                            major = delMajor; delMajor = null;
                            phone = delPhone; delPhone = null;
                            sNumber = delsNumber; delsNumber = null;
                            avg = delAvg; delAvg = null;
                            System.out.println("############# 삭제 완료! #############");
                            System.out.println("삭제 후 현재 등록된 학생 이름: " + Arrays.toString(name));
                            break;
                        } else {
                            System.out.printf("(%s)학생은 존재하지 않습니다. 다시 입력하세요.\n", targetName);
                        }
                    }
                    break;
                default: //잘못된 메뉴 입력
                    System.out.println("잘못 누르셨습니다. 다시 입력하세요.");
                    break;
            }
        }
    }//main method
}//class

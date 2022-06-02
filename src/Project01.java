import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Project01{

    //현재로그인한 사람 정보 저장 배열
    static String[] curLoginUserInfo = new String[3];

    //직원 인적사항 저장 배열 (이름, 사원번호,직책, 비밀번호)
    static String[] empNames = {"홍길동", "김철수", "김철수"};
    static String[] empNumbers = {"0000", "0001", "0002"};
    static String[] empPosition = {"사원", "대리", "과장"};
    static String[] empPassWord = {"aaaa", "bbbb", "bbbb"};
    static String[] checkinTime = {};
    static String[] checkoutTime = {};


    static String[][] checkinTable = {
            {"2021-12-15 08:55:26", "2021-12-16 08:58:13"},
            {"2021-12-15 08:59:56", "2021-12-16 08:59:16"},
            {"2021-12-15 08:55:55", "2021-12-16 08:57:56"}
    };
    static String[][] checkoutTable = {
            {"2021-12-15 18:02:56", "2021-12-16 18:01:03"},
            {"2021-12-15 18:10:11", "2021-12-16 18:10:01"},
            {"2021-12-15 18:01:07", "2021-12-16 18:07:56"}
    };

    static final int EMPLOYEE = 20; //등록할수있는 직원 총
    static final int DAYCOUNT = 31; //등록할수있는 날짜 총 수
    static String[][] workinTemp = new String[EMPLOYEE][DAYCOUNT];	//출근시간 추가된 새로운 테이블
    static String[][] workoutTemp = new String[EMPLOYEE][DAYCOUNT];	//퇴근시간 추가된 새로운 테이블

    static int[] countAddWork = new int[EMPLOYEE]; //추가된 출근시간의 개수를 세어준다


	   /* static String[] empNames = {};
	    static String[] empNumbers = {};
	    static String[] empPosition = {};
	    static String[] empPassWord = {};*/


    static void saveTime() {

        int index = indexOf(curLoginUserInfo[0]);	//사원번호로 index 추출

        for(int i = 0; i < checkinTable[index].length;i++) {
            System.out.println("출근: "+checkinTable[index][i]);
            System.out.println("퇴근: "+checkoutTable[index][i]);
        }
        if(countAddWork[index] >0) {
            for(int i = 0; i < countAddWork[index]; i++) {
                System.out.println("출근: "+workinTemp[index][i]);
                System.out.println("퇴근: "+workoutTemp[index][i]);
            }
        }


    }

    static void pushWorkInTime(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 출력 모양
        Calendar cal = Calendar.getInstance();
        String format_time = format1.format(cal.getTime());

        int index = indexOf(curLoginUserInfo[0]);	//사원번호로 index 추출

        //출근시간 추가
        workinTemp[index][countAddWork[index]] = format_time;
        //아직 퇴근 안했을때의 퇴근시간 추가 -> 아직퇴근안함
        workoutTemp[index][countAddWork[index]++] = "아직 퇴근하지 않았습니다.";
    }

    static void pushWorkOutTime(){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 출력 모양
        Calendar cal = Calendar.getInstance();
        String format_time = format1.format(cal.getTime());

        int index = indexOf(curLoginUserInfo[0]);	//사원번호로 index 추출

        //퇴근시간 추가
        workoutTemp[index][countAddWork[index]-1] = format_time;

    }

    // index추출함수(사번)
    static int indexOf(String targetNum) {
        int index = -1;

        for (int i = 0; i < empNumbers.length; i++) {
            if(targetNum.equals(empNumbers[i])) {
                index = i;
                break;
            }
        }
        return index;
    }


    //첫 화면 메뉴
    static void firstMenu() {
        System.out.println("\n==========[직원관리프로그램]==========");
        System.out.println("1. 로그인");
        System.out.println("2. 직원등록");
        System.out.println("3. 프로그램 종료");
        System.out.print(">> ");
    }

    //로그인 전 메뉴선택
    static int inputInt() {
        int n = sc.nextInt();
        if (n > 3 || n <= 0) {
            System.out.println("\n* 1 ~ 3사이로 입력해주세요.\n");
        }
        sc.nextLine();
        return n;
    }

    //문자 입력
    static String inputString(String s) {
        System.out.print(s);
        return sc.nextLine();
    }

    //로그인하기
    static boolean Login() {
        while (true) {
            String nameCheck = inputString("\n사원번호: ");
            int index = -1;
            for (int i = 0; i < empNumbers.length; i++) {
                if (nameCheck.equals(empNumbers[i])) {
                    index = i;
                    break;
                }
            }
//	            System.out.println(index);
            if (index == -1) {
                System.out.println("\n* 등록되지 않은 정보입니다.");
                System.out.println("* 초기메뉴에서 직원등록을 먼저 해주세요.");
                System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
                sc.nextLine();
                return false;
            } else {
                String pwCheck = inputString("비밀번호: ");
                if (pwCheck.equals(empPassWord[index])) {
                    //현재 로그인한 사람 정보 저장 시점
                    curLoginUserInfo[0] = empNumbers[index];
                    curLoginUserInfo[1] = empPosition[index];
                    curLoginUserInfo[2] = empNames[index];
//	                    System.out.println(Arrays.toString(curLoginUserInfo));
                    loginStatus = true;
                    System.out.println("\n==========[로그인 성공]==========");
                    date();// 첫 로그인 시점에만 로그인 성공과 시간 출력
                    return loginStatus;
                } else {
                    System.out.println("\n* 사원번호와 비밀번호가 일치하지 않습니다.\n");
                    return loginStatus;
                }

            }
        }
    }

    //직원등록 - 이름 입력
    static void inputName() {
        String name = inputString("\n이름: ");
        String[] temp = new String[empNames.length + 1];
        for (int i = 0; i < empNames.length; i++) {
            temp[i] = empNames[i];
        }
        temp[temp.length - 1] = name;
        empNames = temp;
    }

    //직원등록 - 패스워드 입력
    static void inputPassWord() {
        while (true) {
            String pw = inputString("비밀번호: ");

            if (pw.length() > 8 | pw.length() < 4) {
                System.out.println("\n* 비밀번호는 4 ~ 8자리로 입력해주세요.\n");

            } else {
                String[] temp4 = new String[empPassWord.length + 1];
                for (int i = 0; i < empPassWord.length; i++) {
                    temp4[i] = empPassWord[i];
                }
                temp4[temp4.length - 1] = pw;
                empPassWord = temp4;
                break;
            }
        }
    }

    //직원등록 - 사원번호 입력
    static void inputNum() {
        while (true) {
            String num = inputString("사원번호: ");
            int index = -1;

            for (int i = 0; i < empNumbers.length; i++) {
                if (num.equals(empNumbers[i])) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                if (num.length() > 4) {
                    System.out.println("\n* 사원번호는 4자리입니다.");
                    System.out.println("* 다시 입력해주세요.\n");
                } else {
                    String[] temp2 = new String[empNumbers.length + 1];
                    for (int i = 0; i < empNumbers.length; i++) {
                        temp2[i] = empNumbers[i];
                    }
                    temp2[temp2.length - 1] = num;
                    empNumbers = temp2;
                    break;
                }
            } else {
                System.out.println("\n* 이미 등록된 사원번호입니다.");
                System.out.println("* 다시 입력해주세요.\n");
            }
        }
    }

    //직원등록 - 직책 입력
    static void inputPosition() {
        String position = inputString("직책: ");
        String[] temp3 = new String[empPosition.length + 1];
        for (int i = 0; i < empPosition.length; i++) {
            temp3[i] = empPosition[i];
        }
        temp3[temp3.length - 1] = position;
        empPosition = temp3;
        System.out.println("\n* 등록이 완료되었습니다.");
        System.out.println("* 초기메뉴에서 로그인 해주세요.");
        System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
        sc.nextLine();

    }

    //직원목록 전체 보기 [이름, 사번, 직책]
    static void totalList() {
        if (empNames.length < 1) {
            System.out.println("\n* 등록된 사원이 없습니다.");
            System.out.println("* 사원 등록 후 조회해주시기 바랍니다.");
            System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
            sc.nextLine();
        } else {
            System.out.println("\n-------------------------------------------");
            System.out.println("----------------- 직원 목록 -----------------");
            System.out.println("-------------------------------------------");
            for (int i = 0; i < empNames.length; i++) {
                System.out.printf("* [이름]  %s | [사번]  %s | [직책]  %s\n", empNames[i], empNumbers[i], empPosition[i]);
            }
            System.out.println("-------------------------------------------");
            System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
            sc.nextLine();
        }
    }

    //프로그램 종료
    static void exit() {
        System.out.println("\n* 프로그램을 종료하시겠습니까? [Y / N]");
        String yesNo = sc.nextLine();
        if (yesNo.equals("y") || yesNo.equals("Y")) {
            System.out.println("\n* 프로그램을 종료합니다.");
            System.exit(0);
        }
    }

    static Scanner sc = new Scanner(System.in);

    //퇴근하기
    static void workOut() {
        pushWorkOutTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 출력 모양
        Calendar cal = Calendar.getInstance();
        String format_time2 = format1.format(cal.getTime());

        String[] temp6 = new String[checkoutTime.length + 1];

        for (int i = 0; i < checkoutTime.length; i++) {
            temp6[i] = checkoutTime[i];
        }
        temp6[temp6.length - 1] = format_time2;
        checkoutTime = temp6;
        if (Number == 1) {
            System.out.println("\n----------------------------------------------------");
            System.out.printf(" [%s]님 %s | 퇴근이 확인되었습니다..\n", curLoginUserInfo[2], checkoutTime[0]);
            System.out.println("----------------------------------------------------");
            System.out.println("\n* 로그아웃 하시겠습니까? [Y / N]");
            String yesNo = sc.nextLine();
            if (yesNo.equals("y") || yesNo.equals("Y")) {
                logOut();
            }
        } else {
            System.out.println("\n* 출근이 확인되지 않습니다.");
            System.out.println("* 출근하기를 먼저 해주세요.");
            System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
            sc.nextLine();
        }
    }

    //로그인 후 현재시간
    static void date() {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 출력 모양
        Calendar cal = Calendar.getInstance();
        String format_time = format1.format(cal.getTime());

        System.out.printf("현재 시간 : %s\n", format_time);
//	        int hour = cal.get(Calendar.HOUR_OF_DAY);
//	        int min = cal.get(Calendar.MINUTE);
//	        int sec = cal.get(Calendar.SECOND);

        String[] temp5 = new String[checkinTime.length + 1];

        for (int i = 0; i < checkinTime.length; i++) {
            temp5[i] = checkinTime[i];
        }
        temp5[temp5.length - 1] = format_time;
        checkinTime = temp5;
        temp5 = null;
    }

    //로그인 후 메뉴
    static void printMenu() {

        System.out.println("1. 출근하기");
        System.out.println("2. 퇴근하기");
        System.out.println("3. 출근자 확인");
        System.out.println("4. 직원 목록");
        System.out.println("5. 직원 삭제");
        System.out.println("6. 로그아웃");
        System.out.print("=> ");
    }

    //로그인 후 메뉴선택
    static int inputInt2() {
        int n = sc.nextInt();

        if (n > 6 || n <= 0) {
            System.out.println("\n* 1 ~ 6 사이로 입력해주세요.");
        }
        sc.nextLine();
        return n;
    }
    static int Number = -1;

    //출근하기
    static void workIn() {
        pushWorkInTime(); //출근시간 넣기
        System.out.println("\n----------------------------------------------------");
        System.out.printf(" [%s]님 %s | 출근이 확인되었습니다..\n", curLoginUserInfo[2], checkinTime[0]);
        System.out.println("----------------------------------------------------");
        System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
        sc.nextLine();
        Number = 1;

    }

    //현재 로그인정보 ( [사원번호] [직책] [이름] ) & 한달간의 출퇴근내
    static void nowLogin() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("----------------------  출퇴근 목록 조회  ----------------------");
        System.out.println("------------------------------------------------------------");
        System.out.printf("* [사번] %s | [직책] %s | [이름] %s 님으로 로그인 중입니다.\n", curLoginUserInfo[0], curLoginUserInfo[1], curLoginUserInfo[2]);
        System.out.println("------------------------------------------------------------");
        saveTime();
        System.out.println("------------------------------------------------------------");
        System.out.println("\n이전 화면으로 돌아가시려면 Enter를 눌러주세요.");
        sc.nextLine();
    }

    // 직원 삭제
    static void del() {
        while (true) {
            System.out.println("\n* 삭제할 직원의 사원번호를 입력하세요. ");
            System.out.print(">>> ");
            String target = sc.nextLine();

            int index = -1;

            for (int i = 0; i < empNumbers.length; i++) { // 사원 번호의 존재 여부 확인
                if (target.equals(empNumbers[i])) {
                    index = i;
                    break;
                }
            }

            if (index == -1) { // 사원 번호가 존재하지 않을 경우 index가 -1 상태
                System.out.println("\n* 해당 사원번호(" + target + ")는 존재하지 않습니다.\n");
            } else { // 사원 번호가 존재할 경우
                System.out.println("\n* 사원번호가 [" + empNumbers[index] + "] 인 " + empNames[index] + " 님의 정보를 삭제합니다.\n");

                for (int i = index; i < empNumbers.length - 1; i++) { // 배열에서 index에 맞는 정보를 삭제
                    empNumbers[i] = empNumbers[i + 1];
                    empNames[i] = empNames[i + 1];
                    empPosition[i] = empPosition[i + 1];
                }
                String[] temp = new String[empNumbers.length - 1]; // emp 배열보다 하나 작은 temp 배열 생성
                String[] temp2 = new String[empNames.length - 1];
                String[] temp3 = new String[empPosition.length - 1];

                for (int i = 0; i < temp.length; i++) { //temp 배열에 정보를 저장
                    temp[i] = empNumbers[i];
                    temp2[i] = empNames[i];
                    temp3[i] = empPosition[i];
                }
                empNumbers = temp;
                temp = null; // 주소 옮기기
                empNames = temp2;
                temp2 = null;
                empPosition = temp3;
                temp3 = null;

                System.out.println("\n* 삭제가 완료되었습니다 \n");
                break;
            }
        }
    }

    //로그아웃
    static void logOut() {
        System.out.println();
        System.out.println("\n* 로그아웃 되었습니다.\n");
        loginStatus = false;
    }

    // 전역변수
    static boolean loginStatus = false;

    public static void main(String[] args) {
        while (true) {
            if (!loginStatus) {
                firstMenu(); //로그인 전 메뉴
                int choice1 = inputInt();
                switch (choice1) {
                    case 1: // 로그인
                        Login();
                        break;
                    case 2: // 직원 등록
                        inputName();
                        inputPassWord();
                        inputNum();
                        inputPosition();
                        break;
                    case 3: // 프로그램 종료
                        exit();
                        break;
                }
            } else {
                printMenu(); //로그인 후 메뉴
                int choice2 = inputInt2();
                switch (choice2) {
                    case 1: // 출근하기
                        workIn();
                        break;
                    case 2: // 퇴근하기
                        workOut();
                        break;
                    case 3: // 출근자 확인
                        nowLogin();
                        //saveTime();
                        break;
                    case 4: // 직원 목록
                        totalList();
                        break;
                    case 5: // 직원 삭제
                        del();
                        break;
                    case 6: // 로그아웃
                        logOut();
                        break;
                }
            }

        } // end while
    }// end main
}// end class
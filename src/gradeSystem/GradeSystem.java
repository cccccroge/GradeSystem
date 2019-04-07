package gradeSystem;
import java.util.Arrays;

public class GradeSystem {
	
	// Fields
	private enum Status {
		START,
		SCORE,
		FINISH
	}
	private Status status;
	
	private Student current_student;
	private GradeData grade_data;
	
	// Constructor
	public GradeSystem()
	{
		status = Status.START;
		current_student = null;
		grade_data = new GradeData();
	}
	
	// Public Methods
	
	/* void run()
	 * 運行成績系統，當讀入有效input後進入主系統，供使用者
	 * 輸入各種指令，並提供相對應功能，當使用者在任意層級輸
	 * 入指令K之後，才會終止迴圈，結束函式。
	 * 
	 * Pseudo code
	 * 1.重複讀入input檔，直至成功讀取
	 * 2.以預設的權重計算一次排名
	 * 3.重複接受指令
	 *   - 初始狀態：處理初始狀態指令
	 *   - 查詢狀態：處理查詢狀態指令
	 *   
	 * Time estimate：skip
	 * 
	 * Example
	 * GradeSystemObj.run()
	 */
	public void run()
	{
		while(!grade_data.loadInput()) {
			System.out.print("Failed to load grades input.\nFix setup and hit enter to try again.\n");
			Main.scannerSysIn.nextLine();
		}
		
		grade_data.evalRanks();
		
		while(true) {
			if (status == Status.START) {
				showHintStart();
				String cmd = Main.scannerSysIn.nextLine();
				if(handleStartCmd(cmd))
					break;
			} else if (status == Status.SCORE) {
				showHintScore();
				String cmd = Main.scannerSysIn.nextLine();
				if(handleScoreCmd(cmd))
					break;
			}
			System.out.print("\n");
		}
	}
	
	// Private Methods
	
	/* void showHintStart()
	 * 顯示初始狀態的提示文字
	 * 
	 * Pseudo code
	 * 顯示初始狀態的提示文字
	 * - 系統名稱
	 * - 提示輸入指令：[ID]與K
	 *   
	 * Time estimate：O(1)
	 * 
	 * Example
	 * GradeSystemObj.showHintStart()
	 */
	private void showHintStart()
	{
		System.out.print("******************************\n" 
					   + "Fantastic Console Grade System\n" 
					   + "******************************\n"
					   + "Enter commands:\n"
					   + "[ID]: a 9-digits number\n"
					   + "K: Kill the program\n");
	}
	
	/* void showHintScore()
	 * 顯示查詢狀態的提示文字
	 * 
	 * Pseudo code
	 * 顯示查詢狀態的提示文字
	 * - 查詢之ID
	 * - 提示輸入指令：1/2/3/4/5/K
	 *   
	 * Time estimate：O(1)
	 * 
	 * Example
	 * GradeSystemObj.showHintScore()
	 */
	private void showHintScore()
	{
		System.out.print("********************************\n" 
						 + "Current inspecting ID: " 
						 + current_student.getId() + "\n"  
						 + "********************************\n");
		System.out.print("Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n");
	}
	
	/* boolean handleStartCmd(String cmd)
	 * 處理初始狀態之使用者輸入指令
	 * @param cmd：指令字串
	 * @return boolean：只在指令為K時才回傳true，其他指令則回傳false
	 * 
	 * Pseudo code
	 * 檢查指令字元
	 * - k或K：回傳true
	 * - 其他：視為id，呼叫registerId來處理，最後回傳false
	 *   
	 * Time estimate：skip
	 * 
	 * Example
	 * GradeSystemObj.handleStartCmd("K")
	 * GradeSystemObj.handleStartCmd("105062271")
	 */
	private boolean handleStartCmd(String cmd)
	{
		switch(cmd) {
		case "k":
		case "K":
			return true;
		default:
			registerId(cmd);
			return false;
		}
	}
	
	/* boolean handleScoreCmd(String cmd)
	 * 處理查詢狀態之使用者輸入指令
	 * @param cmd：指令字串
	 * @return boolean：只在指令為K時才回傳true，其他指令則回傳false
	 * 
	 * Pseudo code
	 * 檢查指令字元
	 * - k或K：回傳true
	 *   以下指令最後回傳false
	 * - 1:呼叫showGrades，顯示目前學生的所有科目成績
	 * - 2:呼叫showRank，顯示目前學生的的排名
	 * - 3:呼叫showAverage，顯示目前學生的加權平均分數
	 * - 4:呼叫updateWeights來提供更新權重之功能，更新完後再對成績資料作加權分數以及排名的更新
	 * - 5:離開查看目前學生，改變系統狀態為初始狀態
	 * - 其他指令：顯示輸入錯誤提示，再讀入一次輸入指令
	 *   
	 * Time estimate：skip
	 * 
	 * Example
	 * GradeSystemObj.handleScoreCmd("1")
	 * GradeSystemObj.handleScoreCmd("3")
	 * GradeSystemObj.handleStartCmd("haha")
	 */
	private boolean handleScoreCmd(String cmd)
	{
		switch(cmd) {
		case "k":
		case "K":
			return true;
		case "1":
			showGrades();
			break;
		case "2":
			showRank();
			break;
		case "3":
			showAverage();
			break;
		case "4":
			updateWeights();
			grade_data.updateWeightedGrades();
			grade_data.evalRanks();
			break;
		case "5":
			status = Status.START;
			break;
		default:
			System.out.print("Command " + cmd + " doesn't exist.\n");
			handleScoreCmd(Main.scannerSysIn.nextLine());
		}
		return false;
	}
	
	/* void showGrades()
	 * 顯示目前學生之所有科目分數
	 * 
	 * Pseudo code
	 * 1.存取目前學生的名稱,分數陣列,以及科目名稱陣列
	 * 2.以迴圈分行輸出各科的成績
	 *   
	 * Time estimate：O(1)
	 * 
	 * Example
	 * GradeSystemObj.showGrades()
	 */
	private void showGrades()
	{
		String name = current_student.getName();
		int[] g = current_student.getGrades();
		String[] s = Student.getSubjects();
		
		System.out.print(name + "'s grades are:\n");
		for(int i = 0; i < g.length; ++i) {	
			System.out.printf("%-15s %s\n", s[i]+":", formattedScore(g[i]));
		}
	}
	
	/* void showAverage()
	 * 顯示目前學生之加權平均數
	 * 
	 * Pseudo code
	 * 1.存取目前學生的名稱,加權平均成績
	 * 2.輸出該學生的名字與成績
	 *   
	 * Time estimate：O(1)
	 * 
	 * Example
	 * GradeSystemObj.showAverage()
	 */
	private void showAverage()
	{
		String name = current_student.getName();
		int average = current_student.getWeightedGrade();
		System.out.print(name + "'s average is:\t" + average + "\n");
	}
	
	/* void showRank()
	 * 顯示目前學生之排名
	 * 
	 * Pseudo code
	 * 1.存取目前學生的名稱,加權平均成績
	 * 2.輸出該學生的名字與成績
	 *   
	 * Time estimate：O(1)
	 * 
	 * Example
	 * GradeSystemObj.showAverage()
	 */
	private void showRank()
	{
		String name = current_student.getName();
		int rank = current_student.getRank();
		System.out.print(name + "'s rank is:\t" + rank + "\n");
	}
	
	/* void updateWeights()
	 * 讓使用者輸入新的權重，以更新所有學生之權重
	 * 
	 * Pseudo code
	 * 持續讀入新的各科權重，直到有一合法且與舊權重不同的權重被確認：
	 *  - 顯示目前各科權重
	 *  - 讀取新的且合法的權重
	 *  - 再輸出一次使用者輸入的權重，詢問是否確定更改：
	 *    若是則break迴圈, 若否則再重新進入迴圈
	 *   
	 * Time estimate：skip
	 * 
	 * Example
	 * GradeSystemObj.updateWeights()
	 */
	private void updateWeights()
	{
		while(true) {
			System.out.print("Current weights:\n");
			printWeights(Student.getWeights());
			
			System.out.print("\nEnter new weights:\n");
			double[] new_weights = readNewWeights();
			
			System.out.print("\nConfirm new weights:\n");
			printWeights(new_weights);
			System.out.print("Are the weights above correct? (y/n)\t");
			String cmd = Main.scannerSysIn.nextLine();
			if(cmd.equals("Y") || cmd.equals("y")) {
				Student.setWeights(new_weights);
				break;
			}
		}
	}
	
	/* void registerId(String _str)
	 * 以_str作為指定id，查詢後若合法則將系統的查詢學生指向此找到之學生
	 * 並將系統狀態切換至查詢狀態，若不合法則持續接受輸入直到找到合法學生
	 * @param _str：指定id字串
	 * 
	 * Pseudo code
	 * 1.持續呼叫資料中的getStudentById(str)直到找到合法學生
	 * 2.將系統的查詢學生更改為此學生，將系統狀態切換至查詢狀態
	 *   
	 * Time estimate：id存在的情況下為O(n)，n為學生陣列長度
	 * 
	 * Example
	 * GradeSystemObj.registerId("105062271")
	 */
	private void registerId(String _str)
	{
		String str = _str;
		Student s = grade_data.getStudentById(str);
		while(s == null) {
			System.out.print(str + " is a wrong student ID. Please enter again.\n");
			str = Main.scannerSysIn.nextLine();
			s = grade_data.getStudentById(str);
		}
		current_student = s;
		status = Status.SCORE;
	}
	
	/* String formattedScore(int score)
	 * 將分數轉換成字串，必要時修改之
	 * @param score：欲顯示之分數，為整數
	 * @return String：回傳格式化的字串
	 * 
	 * Pseudo code
	 * 1.將分數轉為String型別
	 * 2.若分數不及格（小於六十分），則需在後面加上星號字元，反之則否
	 * 3.回傳該字串
	 * 
	 * Time estimate：O(1)
	 * 
	 * Example
	 * String s = GradeSystemObj.formattedScore(59)
	 */
	private String formattedScore(int score)
	{
		String s = Integer.toString(score);
		return (score >= 60) ? s : (s+"*");
	}
	
	/* void printWeights(double[] _weights)
	 * 將給定權重依科目列印出來
	 * @param _weights：欲印出的分數陣列，型別為double array
	 * 
	 * Pseudo code
	 * 1.取得科目字串陣列
	 * 2.以迴圈印出對應科目的weight
	 * 
	 * Time estimate：O(1)
	 * 
	 * Example
	 * GradeSystemObj.printWeights({0.5, 0.5, 0, 0, 0})
	 */
	private void printWeights(double[] _weights)
	{
		String[] subjects = Student.getSubjects();
		for(int i = 0; i < _weights.length; ++i) {
			System.out.printf("%-15s %.1f%%\n", subjects[i]+":", _weights[i]*100);
		}
	}
	
	/* double[] readNewWeights()
	 * 讓使用者輸入權重
	 * @return double[]：讀入的權重陣列，型別為double array
	 * 
	 * Pseudo code
	 * 1.持續迴圈直到得到一合法權重陣列
	 *   -印出個科目目前對應的權重
	 *   -讓使用者輸入五個合法數值，若非法則再輸入一次
	 *   -檢查此陣列是否合法
	 *   -檢查此陣列是否跟舊權重陣列不同
	 * 2.回傳該陣列
	 * 
	 * Time estimate：忽略使用者輸入時間，O(1)
	 * 
	 * Example
	 * double[] new_weights = GradeSystemObj.readNewWeights()
	 */
	private double[] readNewWeights()
	{
		double[] weights ={ -1, -1, -1, -1, -1 };
		// repeat read process until weights is valid
		while(true) {
			String[] s = Student.getSubjects();
			// each subject's weight
			for(int i = 0; i < s.length; ++i) {
				System.out.print(s[i] + ":\t");
				try {
					String str = Main.scannerSysIn.nextLine();
					weights[i] =  Double.parseDouble(str) / 100;
				} catch(Exception e) {
					System.out.print("Weight should be a floating number.\n");
					i -= 1;
				}
			}
			if(!isWeightsValid(weights)) {
				System.out.print("Invalid weights. Enter again:\n");
			} else if( Arrays.equals(weights, Student.getWeights()) ){
				System.out.print("Same weights as before. Enter again:\n");
			} else {
				break;
			}
		}
		
		return weights;
	}
	
	/* boolean isWeightsValid(double[] _weights)
	 * 檢查指定權重是否合法
	 * @param _weights：欲檢查之權重
	 * @return double[]：讀入的權重陣列，型別為double array
	 * 
	 * Pseudo code
	 * 1.若weights長度與科目不同，回傳false
	 * 2.加總weights中各元素之值，若恰為1才回傳true，否則回傳false
	 * 
	 * Time estimate：O(1)
	 * 
	 * Example
	 * double[] b = GradeSystemObj.isWeightsValid({1, 0})
	 */
	private boolean isWeightsValid(double[] _weights)
	{
		if(_weights.length != Student.getSubjects().length) {
			return false;
		}
		
		double sum = 0;
		for(double w : _weights) {
			sum += w;
		}
		return (sum == 1);
	}
	
	public GradeData getGradeData()
	{
		return grade_data;
	}
}

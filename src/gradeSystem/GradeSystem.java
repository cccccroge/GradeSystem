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
	 * �B�榨�Z�t�ΡA��Ū�J����input��i�J�D�t�ΡA�ѨϥΪ�
	 * ��J�U�ث��O�A�ô��Ѭ۹����\��A��ϥΪ̦b���N�h�ſ�
	 * �J���OK����A�~�|�פ�j��A�����禡�C
	 * 
	 * Pseudo code
	 * 1.����Ū�Jinput�ɡA���ܦ��\Ū��
	 * 2.�H�w�]���v���p��@���ƦW
	 * 3.���Ʊ������O
	 *   - ��l���A�G�B�z��l���A���O
	 *   - �d�ߪ��A�G�B�z�d�ߪ��A���O
	 *   
	 * Time estimate�Gskip
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
	 * ��ܪ�l���A�����ܤ�r
	 * 
	 * Pseudo code
	 * ��ܪ�l���A�����ܤ�r
	 * - �t�ΦW��
	 * - ���ܿ�J���O�G[ID]�PK
	 *   
	 * Time estimate�GO(1)
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
	 * ��ܬd�ߪ��A�����ܤ�r
	 * 
	 * Pseudo code
	 * ��ܬd�ߪ��A�����ܤ�r
	 * - �d�ߤ�ID
	 * - ���ܿ�J���O�G1/2/3/4/5/K
	 *   
	 * Time estimate�GO(1)
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
	 * �B�z��l���A���ϥΪ̿�J���O
	 * @param cmd�G���O�r��
	 * @return boolean�G�u�b���O��K�ɤ~�^��true�A��L���O�h�^��false
	 * 
	 * Pseudo code
	 * �ˬd���O�r��
	 * - k��K�G�^��true
	 * - ��L�G����id�A�I�sregisterId�ӳB�z�A�̫�^��false
	 *   
	 * Time estimate�Gskip
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
	 * �B�z�d�ߪ��A���ϥΪ̿�J���O
	 * @param cmd�G���O�r��
	 * @return boolean�G�u�b���O��K�ɤ~�^��true�A��L���O�h�^��false
	 * 
	 * Pseudo code
	 * �ˬd���O�r��
	 * - k��K�G�^��true
	 *   �H�U���O�̫�^��false
	 * - 1:�I�sshowGrades�A��ܥثe�ǥͪ��Ҧ���ئ��Z
	 * - 2:�I�sshowRank�A��ܥثe�ǥͪ����ƦW
	 * - 3:�I�sshowAverage�A��ܥثe�ǥͪ��[�v��������
	 * - 4:�I�supdateWeights�Ӵ��ѧ�s�v�����\��A��s����A�令�Z��Ƨ@�[�v���ƥH�αƦW����s
	 * - 5:���}�d�ݥثe�ǥ͡A���ܨt�Ϊ��A����l���A
	 * - ��L���O�G��ܿ�J���~���ܡA�AŪ�J�@����J���O
	 *   
	 * Time estimate�Gskip
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
	 * ��ܥثe�ǥͤ��Ҧ���ؤ���
	 * 
	 * Pseudo code
	 * 1.�s���ثe�ǥͪ��W��,���ư}�C,�H�ά�ئW�ٰ}�C
	 * 2.�H�j������X�U�쪺���Z
	 *   
	 * Time estimate�GO(1)
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
	 * ��ܥثe�ǥͤ��[�v������
	 * 
	 * Pseudo code
	 * 1.�s���ثe�ǥͪ��W��,�[�v�������Z
	 * 2.��X�Ӿǥͪ��W�r�P���Z
	 *   
	 * Time estimate�GO(1)
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
	 * ��ܥثe�ǥͤ��ƦW
	 * 
	 * Pseudo code
	 * 1.�s���ثe�ǥͪ��W��,�[�v�������Z
	 * 2.��X�Ӿǥͪ��W�r�P���Z
	 *   
	 * Time estimate�GO(1)
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
	 * ���ϥΪ̿�J�s���v���A�H��s�Ҧ��ǥͤ��v��
	 * 
	 * Pseudo code
	 * ����Ū�J�s���U���v���A���즳�@�X�k�B�P���v�����P���v���Q�T�{�G
	 *  - ��ܥثe�U���v��
	 *  - Ū���s���B�X�k���v��
	 *  - �A��X�@���ϥΪ̿�J���v���A�߰ݬO�_�T�w���G
	 *    �Y�O�hbreak�j��, �Y�_�h�A���s�i�J�j��
	 *   
	 * Time estimate�Gskip
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
	 * �H_str�@�����wid�A�d�߫�Y�X�k�h�N�t�Ϊ��d�߾ǥͫ��V����줧�ǥ�
	 * �ñN�t�Ϊ��A�����ܬd�ߪ��A�A�Y���X�k�h���򱵨���J������X�k�ǥ�
	 * @param _str�G���wid�r��
	 * 
	 * Pseudo code
	 * 1.����I�s��Ƥ���getStudentById(str)������X�k�ǥ�
	 * 2.�N�t�Ϊ��d�߾ǥͧ�אּ���ǥ͡A�N�t�Ϊ��A�����ܬd�ߪ��A
	 *   
	 * Time estimate�Gid�s�b�����p�U��O(n)�An���ǥͰ}�C����
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
	 * �N�����ഫ���r��A���n�ɭק蠟
	 * @param score�G����ܤ����ơA�����
	 * @return String�G�^�Ǯ榡�ƪ��r��
	 * 
	 * Pseudo code
	 * 1.�N�����ରString���O
	 * 2.�Y���Ƥ��ή�]�p�󤻤Q���^�A�h�ݦb�᭱�[�W�P���r���A�Ϥ��h�_
	 * 3.�^�ǸӦr��
	 * 
	 * Time estimate�GO(1)
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
	 * �N���w�v���̬�ئC�L�X��
	 * @param _weights�G���L�X�����ư}�C�A���O��double array
	 * 
	 * Pseudo code
	 * 1.���o��ئr��}�C
	 * 2.�H�j��L�X������ت�weight
	 * 
	 * Time estimate�GO(1)
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
	 * ���ϥΪ̿�J�v��
	 * @return double[]�GŪ�J���v���}�C�A���O��double array
	 * 
	 * Pseudo code
	 * 1.����j�骽��o��@�X�k�v���}�C
	 *   -�L�X�Ӭ�إثe�������v��
	 *   -���ϥΪ̿�J���ӦX�k�ƭȡA�Y�D�k�h�A��J�@��
	 *   -�ˬd���}�C�O�_�X�k
	 *   -�ˬd���}�C�O�_�����v���}�C���P
	 * 2.�^�ǸӰ}�C
	 * 
	 * Time estimate�G�����ϥΪ̿�J�ɶ��AO(1)
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
	 * �ˬd���w�v���O�_�X�k
	 * @param _weights�G���ˬd���v��
	 * @return double[]�GŪ�J���v���}�C�A���O��double array
	 * 
	 * Pseudo code
	 * 1.�Yweights���׻P��ؤ��P�A�^��false
	 * 2.�[�`weights���U�������ȡA�Y�ꬰ1�~�^��true�A�_�h�^��false
	 * 
	 * Time estimate�GO(1)
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

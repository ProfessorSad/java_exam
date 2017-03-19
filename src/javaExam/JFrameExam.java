package javaExam;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class JFrameExam extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup answersRBButtonGroup = new ButtonGroup();
	private int index = 0;
	
	Database db = new Database();
	UserInfo ui = new UserInfo();


	/**
	 * Create the frame.
	 */
	public JFrameExam() {
		setTitle("Java Exam");
		
		System.out.println("Questions: " + db.getUserAnswer().length);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
/*------------------------------------<Test Question>-------------------------------------*/
		JLabel testQuestion = new JLabel("<html><body style='width: " + "425" + "px'>" + db.getQuestions()[0]);
		testQuestion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		testQuestion.setBounds(169, 11, 562, 67);
		contentPane.add(testQuestion);
/*------------------------------------</Test Question>------------------------------------*/

/*--------------------------------------<Question List>---------------------------------------*/		
		JList list = new JList(db.getQuestionNo());
		list.setBounds(10, 10, 130, 240);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 11, 149, 250);
		contentPane.add(scrollPane);
/*--------------------------------------</Question List>---------------------------------------*/
		
/*--------------------------------------<ABCD Label>---------------------------------------*/		
		JLabel lblA = new JLabel("A.");
		lblA.setBounds(169, 104, 15, 14);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B.");
		lblB.setBounds(169, 162, 15, 14);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C.");
		lblC.setBounds(480, 104, 15, 14);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("D.");
		lblD.setBounds(480, 162, 15, 14);
		contentPane.add(lblD);
/*--------------------------------------</ABCD Label>---------------------------------------*/		

/*------------------------------------<Radio Buttons>-------------------------------------*/
		JRadioButton aRadioButton = new JRadioButton("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB1()[0]);
		aRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		answersRBButtonGroup.add(aRadioButton);
		aRadioButton.setBounds(190, 88, 230, 45);
		contentPane.add(aRadioButton);
		
		JRadioButton bRadioButton = new JRadioButton("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB2()[0]);
		bRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		answersRBButtonGroup.add(bRadioButton);
		bRadioButton.setBounds(190, 146, 230, 45);
		contentPane.add(bRadioButton);
		
		JRadioButton cRadioButton = new JRadioButton("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB3()[0]);
		cRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		answersRBButtonGroup.add(cRadioButton);
		cRadioButton.setBounds(501, 88, 230, 45);
		contentPane.add(cRadioButton);
		
		JRadioButton dRadioButton = new JRadioButton("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB4()[0]);
		dRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		answersRBButtonGroup.add(dRadioButton);
		dRadioButton.setBounds(501, 146, 230, 45);
		contentPane.add(dRadioButton);
/*------------------------------------</Radio Buttons>------------------------------------*/
		
/*------------------------------------<Chosen Answer>-------------------------------------*/
		JLabel answerLabel = new JLabel("Selected Answer: ");
		answerLabel.setBounds(169, 225, 109, 14);
		contentPane.add(answerLabel);
		
		JLabel selectedAnswerLabel = new JLabel("");
		selectedAnswerLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		selectedAnswerLabel.setBounds(288, 225, 40, 14);
		contentPane.add(selectedAnswerLabel);
/*------------------------------------</Chosen Answer>------------------------------------*/
		
/*--------------------------------<Display Chosen Answer>---------------------------------*/
		aRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnswerLabel.setText("A");

			}
		});
		
		bRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnswerLabel.setText("B");	
				
			}
		});
		
		cRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnswerLabel.setText("C");	
				
			}
		});
		dRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnswerLabel.setText("D");	
				
			}
		});
/*--------------------------------</Display Chosen Answer>----------------------------------*/
		
/*--------------------------------------<Next Button>---------------------------------------*/
		JButton btnNxt = new JButton("Next");
		btnNxt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				// TODO: save answer
				if (aRadioButton.isSelected()) {
					db.setUserAnswer("a", index);
				}
				else if (bRadioButton.isSelected()) {
					db.setUserAnswer("b", index);
				}
				else if (cRadioButton.isSelected()) {
					db.setUserAnswer("c", index);
				}
				else if (dRadioButton.isSelected()) {
					db.setUserAnswer("d", index);
				}
				else {
				// Display JFrame for Skip Question
				}
				
				// Increment userPoints
				if (db.getUserAnswer()[index] == db.getRightAnswer()[index]){
					ui.setTotalScore(ui.getTotalScore() + 1);
				}
				else {
					//Do nothing
				}
				
				// clear selection
					answersRBButtonGroup.clearSelection();
					selectedAnswerLabel.setText("");
					
				//TEST: See Answers and points on Console
					System.out.println(db.getUserAnswer()[index]);
					System.out.println("Points: " + ui.getTotalScore());
					
				// Display next question and answer
				index++;
				testQuestion.setText("<html><body style='width: " + "425" + "px'>" + db.getQuestions()[index]);
				aRadioButton.setText("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB1()[index]);
				bRadioButton.setText("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB2()[index]);
				cRadioButton.setText("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB3()[index]);
				dRadioButton.setText("<html><body style='width: " + "150" + "px'>" + db.getAnswersRB4()[index]);

			}

		});
		
		btnNxt.setBounds(591, 225, 65, 32);
		contentPane.add(btnNxt);
/*--------------------------------------</Next Button>--------------------------------------*/
		
/*--------------------------------------<Quit Button>---------------------------------------*/
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*Enter Quit Program*/
			JFrameQuit quit = new JFrameQuit();
			quit.setVisible(true);
			}
		});
		quitButton.setBounds(666, 225, 65, 32);
		contentPane.add(quitButton);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{aRadioButton, bRadioButton, cRadioButton, dRadioButton, btnNxt, quitButton}));
		
/*--------------------------------------</Quit Button>--------------------------------------*/
		
	
	}
}
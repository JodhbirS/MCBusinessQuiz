import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

	public class Quiz implements ActionListener {
	
		String [] questions = qcaArray.questions; //gets questions from other class
		String[][] choices = qcaArray.choices; //gets choices from other class
		char [] answers = qcaArray.answers; //gets answers from other class
		
		//adds a random int for random question
		Random rand = new Random();
		int randQuestion = rand.nextInt(questions.length);
	
		ArrayList<Integer> used = new ArrayList<Integer>(); //Array list of questions used
		
		int questionTotal = 20; // if question # changes, updates question total
		int index; //keeps track of which question user is on
		int rightAnswer = 0; //counts # of correct answers
		int result; //calculates result
		int time = 60; // 60 second timer
		
		char answer; //letter answers
		
		boolean check = false; // variable to check if question is used
		
		//frame size
		int length = 700;
		int width = 750;
		
		//different frames for panels
		JFrame frame = new JFrame();
		JFrame resultframe = new JFrame();
		
		// place for question # and updated questions
		JTextField textfield = new JTextField();
		JTextArea textarea = new JTextArea();
		
		// text for result frame
		JLabel topText = new JLabel();
		JLabel results = new JLabel();
		
		// buttons for result frame
		JButton quitButton = new JButton("Quit");
		JButton retryButton = new JButton("Retry");
		
		// Answer buttons to click
		JButton buttonA = new JButton();
		JButton buttonB = new JButton();
		JButton buttonC = new JButton();
		JButton buttonD = new JButton();
		
		// labels to display questions
		JLabel labelA = new JLabel();
		JLabel labelB = new JLabel();
		JLabel labelC = new JLabel();
		JLabel labelD = new JLabel();
		
		// timer labels
		JLabel labelTime = new JLabel();
		JLabel labelSeconds = new JLabel();
		
		// results text
		JTextField numberRight = new JTextField();
		JTextField percent = new JTextField();
		
		Timer timer = new Timer(1000, new ActionListener() { // decreases time by 1 second
			
			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				labelSeconds.setText(String.valueOf(time));
				
				if(time <= 0) {
					AnswerDisplay(); //displays answer if timer runs out
				}
			}	
		});
	
	public Quiz() {
		
		// frame details
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(length,width);
		frame.getContentPane().setBackground(new Color(246,250,255)); // set background color
		frame.setLayout(null);
		frame.setResizable(false);
		
		// questions # textfield details
		textfield.setBounds(0,0,length,50);
		textfield.setBackground(new Color(0, 64, 101));
		textfield.setForeground(new Color(255,255,255));
		textfield.setFont(new Font("Helvetica", Font.BOLD, 25));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		// question textarea details
		textarea.setBounds(0,45,length,80);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(0, 64, 101));
		textarea.setForeground(new Color(255,255,255));
		textarea.setFont(new Font("Helvetica", Font.BOLD, 20));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		//button A details
		buttonA.setBounds(0,150,100,100);
		buttonA.setBackground(new Color(142,168,212));
		buttonA.setForeground(new Color(47,63,90));
		buttonA.setFont(new Font("Helvetica", Font.BOLD, 40));
		buttonA.addActionListener(this);
		buttonA.setFocusable(false);
		buttonA.setText("A");
		
		//button B details
		buttonB.setBounds(0,275,100,100);
		buttonB.setBackground(new Color(142,168,212));
		buttonB.setForeground(new Color(47,63,90));
		buttonB.setFont(new Font("Helvetica", Font.BOLD, 40));
		buttonB.addActionListener(this);
		buttonB.setFocusable(false);
		buttonB.setText("B");
		
		//button C details
		buttonC.setBounds(0,400,100,100);
		buttonC.setBackground(new Color(142,168,212));
		buttonC.setForeground(new Color(47,63,90));
		buttonC.setFont(new Font("Helvetica", Font.BOLD, 40));
		buttonC.addActionListener(this);
		buttonC.setFocusable(false);
		buttonC.setText("C");
		
		//button D details
		buttonD.setBounds(0,525,100,100);
		buttonD.setBackground(new Color(142,168,212));
		buttonD.setForeground(new Color(47,63,90));
		buttonD.setFont(new Font("Helvetica", Font.BOLD, 40));
		buttonD.addActionListener(this);
		buttonD.setFocusable(false);
		buttonD.setText("D");
		
		//question A details
		labelA.setBounds(115,150,650,95);
		labelA.setBackground(new Color(50,50,50));
		labelA.setForeground(new Color(0,0,0));
		labelA.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		//question B details
		labelB.setBounds(115,275,650,95);
		labelB.setBackground(new Color(50,50,50));
		labelB.setForeground(new Color(0,0,0));
		labelB.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		//question C details
		labelC.setBounds(115,400,650,95);
		labelC.setBackground(new Color(50,50,50));
		labelC.setForeground(new Color(0,0,0));
		labelC.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		//question D details
		labelD.setBounds(115,525,650,95);
		labelD.setBackground(new Color(50,50,50));
		labelD.setForeground(new Color(0,0,0));
		labelD.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		//seconds label details
		labelSeconds.setBounds(length-135,width-158,120,120);
		labelSeconds.setBackground(new Color(142,168,212));
		labelSeconds.setForeground(new Color(47,63,90));
		labelSeconds.setFont(new Font("Helvetica", Font.BOLD, 55));
		labelSeconds.setBorder(BorderFactory.createBevelBorder(1));
		labelSeconds.setOpaque(true);
		labelSeconds.setHorizontalAlignment(JTextField.CENTER);
		labelSeconds.setText(String.valueOf(time));
		
		// # of correct questions details
		numberRight.setBounds(250,250,200,100);
		numberRight.setBackground(new Color(0, 64, 101));
		numberRight.setForeground(new Color(255,255,255));
		numberRight.setFont(new Font("Helvetica", Font.BOLD, 40));
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setEditable(false);
		
		// percent text details
		percent.setBounds(250,350,200,100);
		percent.setBackground(new Color(0, 64, 101));
		percent.setForeground(new Color(255,255,255));
		percent.setFont(new Font("Helvetica", Font.BOLD, 40));
		percent.setBorder(BorderFactory.createBevelBorder(1));
		percent.setHorizontalAlignment(JTextField.CENTER);
		percent.setEditable(false);
		
		// adds the seconds label to frame
		frame.add(labelSeconds);
		
		// adds question labels to screen
		frame.add(labelA);
		frame.add(labelB);
		frame.add(labelC);
		frame.add(labelD);
		
		// adds clickable buttons to screen
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		
		//adds question # and question to frame
		frame.add(textarea);
		frame.add(textfield);
		
		//more frame details
		frame.setVisible(true);
		frame.setTitle("Business IB Quiz");
		
		nextQ();		
	}
	
	public void checkQ() { // method to check if the question was already used
		
		check = false;
		
		for(int i = 0; i < questions.length; i++) { //for loop to run through every question
			check = used.contains(randQuestion);
			
			if(check != true) {
				break;
			}
			else {
				randQuestion = rand.nextInt(questions.length); //gets a new random number if used
				nextQ();
			}
		}
		//System.out.println(used); checks which random indices are used
	}
	
	public void nextQ() { // switch questions and check if used when the index is less than question total
		
		if(index >= questionTotal) { //displays results if index is more than questions wanted
			frame.dispose();
			resultsPage();
		}
		else {
			
			checkQ(); // runs method to check if question is already used
			
			textfield.setText("Question "+(index + 1)); // increases question #
			textarea.setText(questions[randQuestion]); // gets questions from random index
			
			// gets choices from random index
			labelA.setText(choices[randQuestion][0]);
			labelB.setText(choices[randQuestion][1]);
			labelC.setText(choices[randQuestion][2]);
			labelD.setText(choices[randQuestion][3]);
				
			timer.start(); // restarts the timer
			
		}

	}
	
	public void resultsPage() { // method for results page
		
		resultframe.getContentPane().setBackground(new Color(246,250,255));
		
		//details for title text
		topText.setBounds(0,0,700,120);
		topText.setText("Business IB Quiz");
		topText.setFont(new Font("Futura", Font.BOLD, 75));
		topText.setHorizontalAlignment(JTextField.CENTER);
		
		//details for result frame
		resultframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultframe.setSize(700,750);
		resultframe.setLayout(null);
		resultframe.setTitle("Business IB Quiz");
		
		//details for quit button
		quitButton.setBounds(125,600,200,50);
		quitButton.setForeground(new Color(47,63,90));
		quitButton.setBackground(new Color(142,168,212));
		quitButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		quitButton.addActionListener(this);
		quitButton.setFocusable(false);
		
		//details for retry button
		retryButton.setBounds(375,600,200,50);
		retryButton.setForeground(new Color(47,63,90));
		retryButton.setBackground(new Color(142,168,212));
		retryButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		retryButton.addActionListener(this);
		retryButton.setFocusable(false);
		
		//calculates result as an int
		result =  (int)((rightAnswer/(double)questionTotal)*100);
		
		//details for results text
		results.setBounds(0,50,700,200);
		results.setBackground(new Color(233,241,253));
		results.setForeground(new Color(47,63,90));
		results.setFont(new Font("Helvetica", Font.BOLD, 50));
		results.setHorizontalAlignment(JTextField.CENTER);
		results.setText("RESULTS");
		
		//sets # right and percent text
		numberRight.setText(rightAnswer + "/" + questionTotal);
		percent.setText(result + "%");
		
		// adds different elements to result frame
		resultframe.setVisible(true);
		resultframe.setResizable(false);
		
		resultframe.add(topText);
		resultframe.add(results);
		
		resultframe.add(percent);
		resultframe.add(numberRight);
		
		resultframe.add(quitButton);
		resultframe.add(retryButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource() == buttonA) { //checks if A is pressed, and if the answer is correct
			answer = 'A';
			used.add(randQuestion);
			if(answer == answers[randQuestion]) {
				rightAnswer++;
			}
		}
		
		if(e.getSource() == buttonB) { //checks if B is pressed, and if the answer is correct
			answer = 'B';
			used.add(randQuestion);
			if(answer == answers[randQuestion]) {
				rightAnswer++;
			}
		}
		
		if(e.getSource() == buttonC) { //checks if C is pressed, and if the answer is correct
			answer = 'C';
			used.add(randQuestion);
			if(answer == answers[randQuestion]) {
				rightAnswer++;
			}
		}
		
		if(e.getSource() == buttonD) { //checks if D is pressed, and if the answer is correct
			answer = 'D';
			used.add(randQuestion);
			if(answer == answers[randQuestion]) {
				rightAnswer++;
			}
		}
		
		if(e.getSource() == quitButton) { // quits program if button pressed
			System.exit(0);
		}
		
		if(e.getSource() == retryButton) { //goes back to start of program if this button is clicked
			frame.dispose();
			resultframe.dispose();
			new WelcomePage();
		}
		
		AnswerDisplay();
		
	}
	
	public void AnswerDisplay() { //method to show which answer was right or wrong
		
		timer.stop(); //stops the timer
		
		// disables button input
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		// makes the wrong answers' text red
		if(answers[randQuestion] != 'A') {
			labelA.setForeground(new Color(255,0,0));
		}
		
		if(answers[randQuestion] != 'B') {
			labelB.setForeground(new Color(255,0,0));
		}
		
		if(answers[randQuestion] != 'C') {
			labelC.setForeground(new Color(255,0,0));
		}
		
		if(answers[randQuestion] != 'D') {
			labelD.setForeground(new Color(255,0,0));
		}
		
		// makes the correct text green
		if(answers[randQuestion] == 'A') {
			labelA.setForeground(new Color(0,255,0));
		}
		
		if(answers[randQuestion] == 'B') {
			labelB.setForeground(new Color(0,255,0));
		}
		
		if(answers[randQuestion] == 'C') {
			labelC.setForeground(new Color(0,255,0));
		}
		
		if(answers[randQuestion] == 'D') {
			labelD.setForeground(new Color(0,255,0));
		}
		
		Timer answerPause = new Timer(2500, new ActionListener() { // pauses on screen for 2.5 seconds
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//resets question labels
				labelA.setForeground(new Color(0,0,0));
				labelB.setForeground(new Color(0,0,0));
				labelC.setForeground(new Color(0,0,0));
				labelD.setForeground(new Color(0,0,0));
				
				//resets variables
				answer = ' ';
				time = 60;
				labelSeconds.setText(String.valueOf(time));
				
				//resets buttons
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				
				index++; //adds 1 to index
				randQuestion = rand.nextInt(questions.length); //gets new random question
				nextQ(); // moves to next question
			}


			
		});
		
		//details for pausing timer
		answerPause.setRepeats(false);
		answerPause.start(); 
	}

}
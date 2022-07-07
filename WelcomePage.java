import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	public class WelcomePage implements ActionListener {
	
		// frames for different pages
		JFrame welcomeFrame = new JFrame();
		JFrame unitFrame = new JFrame();
		
		// continue and quit buttons
		JButton nextButton = new JButton("Continue");
		JButton quitButton = new JButton("Quit");
		JButton toQuizButton = new JButton("Continue");
		
		JLabel topText = new JLabel(); //title text
		
		// explains quiz in the frames
		JLabel explainText = new JLabel();
		JLabel explainText1 = new JLabel();
		JLabel explainText2 = new JLabel();
		JLabel explainText3 = new JLabel();
		
	public WelcomePage() {
		
		welcomeFrame.getContentPane().setBackground(new Color(246,250,255));
		
		//sets details of top text
		topText.setBounds(0,0,700,120);
		topText.setText("Business IB Quiz");
		topText.setFont(new Font("Futura", Font.BOLD, 75));
		topText.setHorizontalAlignment(JTextField.CENTER);
		
		//sets details of first explain text
		explainText1.setBounds(0,75,700,200);
		explainText1.setBackground(new Color(233,241,253));
		explainText1.setForeground(new Color(47,63,90));
		explainText1.setFont(new Font("Helvetica", Font.BOLD, 40));
		explainText1.setText("This quiz will have 20 questions");
		explainText1.setHorizontalAlignment(JTextField.CENTER);
		
		//sets details of second explain text
		explainText2.setBounds(0,150,700,200);
		explainText2.setBackground(new Color(233,241,253));
		explainText2.setForeground(new Color(47,63,90));
		explainText2.setFont(new Font("Helvetica", Font.BOLD, 40));
		explainText2.setText("Gives 1 minute per question");
		explainText2.setHorizontalAlignment(JTextField.CENTER);
		
		//sets details of quit button
		quitButton.setBounds(125,600,200,50);
		quitButton.setForeground(new Color(47,63,90));
		quitButton.setBackground(new Color(142,168,212));
		quitButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		quitButton.addActionListener(this);
		quitButton.setFocusable(false);
		
		//sets details of continue button
		nextButton.setBounds(375,600,200,50);
		nextButton.setForeground(new Color(47,63,90));
		nextButton.setBackground(new Color(142,168,212));
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		nextButton.addActionListener(this);
		nextButton.setFocusable(false);
		
		//sets details of first frame
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setSize(700,750);
		welcomeFrame.setLayout(null);
		welcomeFrame.setTitle("Business IB Quiz");
		
		//makes it visible and not resizable
		welcomeFrame.setVisible(true);
		welcomeFrame.setResizable(false);
		
		//adds text to frame
		welcomeFrame.add(topText);
		welcomeFrame.add(explainText1);
		welcomeFrame.add(explainText2);
		
		//adds buttons to frame
		welcomeFrame.add(nextButton);
		welcomeFrame.add(quitButton);
		
	}
	
	public void unitPage() {
		
		unitFrame.getContentPane().setBackground(new Color(246,250,255));
		
		//details of top text
		topText.setBounds(0,0,700,120);
		topText.setText("Business IB Quiz");
		topText.setFont(new Font("Futura", Font.BOLD, 75));
		topText.setHorizontalAlignment(JTextField.CENTER);
		
		//sets details of continue button
		toQuizButton.setBounds(250,600,200,50);
		toQuizButton.setForeground(new Color(47,63,90));
		toQuizButton.setBackground(new Color(142,168,212));
		toQuizButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		toQuizButton.addActionListener(this);
		toQuizButton.setFocusable(false);

		//details of explain text
		explainText.setBounds(0,75,700,200);
		explainText.setBackground(new Color(233,241,253));
		explainText.setForeground(new Color(47,63,90));
		explainText.setFont(new Font("Helvetica", Font.BOLD, 35));
		explainText.setText("This quiz covers unit 1 and 4");
		explainText.setHorizontalAlignment(JTextField.CENTER);
		
		//details of explain text 1
		explainText1.setBounds(0,150,700,200);
		explainText1.setBackground(new Color(233,241,253));
		explainText1.setForeground(new Color(47,63,90));
		explainText1.setFont(new Font("Helvetica", Font.BOLD, 35));
		explainText1.setText("Unit 1 covers business organisation");
		explainText1.setHorizontalAlignment(JTextField.CENTER);
		
		//details of text under explain text 1
		explainText3.setBounds(0,195,700,200);
		explainText3.setBackground(new Color(233,241,253));
		explainText3.setForeground(new Color(47,63,90));
		explainText3.setFont(new Font("Helvetica", Font.BOLD, 35));
		explainText3.setText("and environment");
		explainText3.setHorizontalAlignment(JTextField.CENTER);
		
		//details of second explain text
		explainText2.setBounds(0,270,700,200);
		explainText2.setBackground(new Color(233,241,253));
		explainText2.setForeground(new Color(47,63,90));
		explainText2.setFont(new Font("Helvetica", Font.BOLD, 35));
		explainText2.setText("Unit 4 covers marketing");
		explainText2.setHorizontalAlignment(JTextField.CENTER);
		
		//details of unit explain frame
		unitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unitFrame.setSize(700,750);
		unitFrame.setLayout(null);
		unitFrame.setTitle("Business IB Quiz");
		
		//makes it visible and not resizable
		unitFrame.setVisible(true);
		unitFrame.setResizable(false);
		
		//adds text to frame
		unitFrame.add(topText);
		unitFrame.add(explainText);
		unitFrame.add(explainText1);
		unitFrame.add(explainText2);
		unitFrame.add(explainText3);
		
		//adds button to frame
		unitFrame.add(toQuizButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == nextButton) { //moves from welcome frame to unit frame
			welcomeFrame.dispose();
			unitFrame.setVisible(true);
			unitPage();
		}
		
		if(e.getSource() == quitButton) { //quits the program if quit button is pressed
			System.exit(0);
		}
		
		if(e.getSource() == toQuizButton) { //moves into quiz
			unitFrame.dispose();
			new Quiz();
		}
		
	}

}

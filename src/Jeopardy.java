//Created By: Chandra Panta Chhetri and Arib Shaikh
//Created For: Mrs.Ganesan
//
//FINAL ISU
import java.io.*;
//import sun.audio.*;     //import the sun.audio package
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
public class Jeopardy
{
    public static void main (String args[])
    {
	JFrame.setDefaultLookAndFeelDecorated (true);
	MainScreen obj = new MainScreen (); //calls the main screen
    }
}
class MainScreen extends JFrame implements ActionListener, MouseListener //Using Constructors
{
    final int num = 0;
    boolean gameover = false;
    static JFrame frame = new JFrame ();
    JPanel contentPane = (JPanel) frame.getContentPane (); //the main panel
    JPanel ready = new JPanel ();
    JPanel Center = new JPanel ();
    JPanel UserReturn = new JPanel ();
    JPanel again = new JPanel ();
    JPanel MainMenuOP = new JPanel ();
    JLabel instructions = new JLabel ("                        Instructions");
    String help = "<html><p>              Welcome, you will have 5 categories to choose from. Each categorie has 5 questions to choose from which are each worth anywhere from 500 to 100 points. If the answer is right, you will recieve points based on the question. If the answer is wrong, points will be deducted. After a question has been attempted, the question will then be disabled. The amount of time you play again will multiply the value of the points. For example, if you play 3 times, the points will be worth 3 times what is stated.Enjoy!!</p></html>";
    JLabel instruct = new JLabel (help);
    JLabel titlelogo = new JLabel (new ImageIcon ("logo.png")); //
    JLabel Sports100Pic = new JLabel (new ImageIcon ("WorldCup.jpg")); //picture for the Sports the GK category
    JLabel Sports200Pic = new JLabel (new ImageIcon ("cricket.jpg")); //
    JLabel GK100Pic = new JLabel (new ImageIcon ("money.jpg")); //
    JLabel GK200Pic = new JLabel (new ImageIcon ("canada.jpg")); //
    JLabel GK300Pic = new JLabel (new ImageIcon ("manitoba.jpg")); //
    JLabel GK400Pic = new JLabel (new ImageIcon ("selfdrivingcar.jpeg")); //
    JLabel GK500Pic = new JLabel (new ImageIcon ("president.jpg")); //
    JLabel Math100Pic = new JLabel (new ImageIcon ("compound.png")); //
    JLabel Math200Pic = new JLabel (new ImageIcon ("doubleangle.png")); //
    JLabel Math300Pic = new JLabel (new ImageIcon ("graph.png")); //
    JLabel Math400Pic = new JLabel (new ImageIcon ("graph2.gif")); //
    JLabel Math500Pic = new JLabel (new ImageIcon ("pi.jpg")); //
    JLabel Entertainment200Pic = new JLabel (new ImageIcon ("movie.jpg"));
    JLabel Entertainment400Pic = new JLabel (new ImageIcon ("instagram.png"));
    JLabel Java100Pic = new JLabel (new ImageIcon ("java.png"));
    JLabel Java500Pic = new JLabel (new ImageIcon ("vectors.gif"));
    JTextField namebox = new JTextField (20); //textbox to enter name on lgin
    JTextField lastnamebox = new JTextField (20); //textbox to enter last name
    JTextField username = new JTextField (20); //to enter username
    JTextField Emailbox = new JTextField (20); //to enter email
    JTextField password = new JTextField (20); // to enter password
    JPasswordField LoginPassword = new JPasswordField (20); //password field
    JLabel PassRequirements, PassRequirements2;
    JButton yes, no, newuser, returninguser, Login, Signup, Reset; //buttons used for the login screen
    JLabel l, nooutput, ReUser, returningtitle, name, lastname, user, pass, email, space, space2, CorrectInfo;
    boolean RUser = false, LoginInfo = false, SignupInfo = false, againplayed = false;
    Font font = new Font ("Arial", Font.BOLD, 35); //fonts for all the JLabels on login screen
    Font font1 = new Font ("Arial", Font.BOLD, 30); //fonts for all the JLabels on login screen
    Font font2 = new Font ("Bookman Old Style", Font.BOLD, 20);
    Font font3 = new Font ("Georgia", Font.BOLD, 12);
    Font font4 = new Font ("Arial", Font.BOLD, 12);
    String fileusername, filepassword, fileEmail; //variables to compare the file data and the one in textbox
    String compareUname, comparePass, compareEmail; //
    String PlayerName; //
    JButton back = new JButton ("Back"); //Button to go back
    JButton instruction = new JButton ("Instructions");
    ///////////////////////////////////////////
    int counter = 0; //counter for the score
    //Labels for all the questions
    JLabel sports500q, entertainment500q, java500q, math500q, gk500q, sports400q, entertainment400q, java400q, gk400q, math400q, sports300q, entertainment300q, java300q, gk300q, math300q, sports200q, entertainment200q, java200q, gk200q, math200q, sports100q, entertainment100q, java100q, gk100q, math100q;
    JLabel win = new JLabel ("Congratulations!"); //Label once correct answer is clicked
    JLabel scorecount = new JLabel (""); //default score
    JLabel loss = new JLabel ("Wrong Answer"); //Label once wrong answer is clicked
    JLabel welcome, end; //Welcome and end labels
    Font sub = new Font ("Arial", Font.BOLD, 22);
    JButton returnmain = new JButton ("RETURN"); //to return back to main screen with all questions
    /////////////////////////////////////////////
    JButton numbers[] = new JButton [6]; //buttons for all categories in 500
    JButton numbers2[] = new JButton [6]; //buttons for all categories in 400
    JButton numbers3[] = new JButton [6]; //buttons for all categories in 300
    JButton numbers4[] = new JButton [6]; //button for all categories in 200
    JButton numbers5[] = new JButton [6]; // buttons for all categories in 100
    JButton exit = new JButton ("Exit"); //Exit button
    JButton play = new JButton ("Play"); //play button
    JButton Playagain = new JButton ("Play Again"); //play again button
    /////////////////////////////////////////////
    JRadioButton sports500a = new JRadioButton ("Roger Federer"); //Following are all the Radiobuttons for all the answer options
    JRadioButton sports500b = new JRadioButton ("Pete Sampras"); //
    JRadioButton sports500c = new JRadioButton ("Novak Djokovic"); //
    JRadioButton sports500d = new JRadioButton ("Rafa Nadal"); //
    JRadioButton entertainment500a = new JRadioButton ("The Fate of the Furious"); //
    JRadioButton entertainment500b = new JRadioButton ("Beauty and the Beast"); //
    JRadioButton entertainment500c = new JRadioButton ("Star Wars: The Last Jedi"); //
    JRadioButton entertainment500d = new JRadioButton ("Despicable Me 3"); //
    JRadioButton java500a = new JRadioButton ("Ease of insertion and deletion"); //
    JRadioButton java500b = new JRadioButton ("Dynamic Data Structure"); //
    JRadioButton java500c = new JRadioButton ("The last element returns to null"); //
    JRadioButton java500d = new JRadioButton ("Memory-efficient when compared to arrays"); //
    JRadioButton gk500a = new JRadioButton ("Donald Trump"); //
    JRadioButton gk500b = new JRadioButton ("Kanye West"); //
    JRadioButton gk500c = new JRadioButton ("Barack Obama"); //
    JRadioButton gk500d = new JRadioButton ("Opera Winfrey"); //
    JRadioButton math500a = new JRadioButton ("45 Degrees"); //
    JRadioButton math500b = new JRadioButton ("20 Degrees"); //
    JRadioButton math500c = new JRadioButton ("55 Degrees"); //
    JRadioButton math500d = new JRadioButton ("2 Degrees"); //
    JRadioButton sports400a = new JRadioButton ("Wayne Gretzky"); //
    JRadioButton sports400b = new JRadioButton ("Sydney Crosby"); //
    JRadioButton sports400c = new JRadioButton ("Lionel Messi"); //
    JRadioButton sports400d = new JRadioButton ("Bobby Orr"); //
    JRadioButton entertainment400a = new JRadioButton ("Kim Kardashian"); //
    JRadioButton entertainment400b = new JRadioButton ("Shakira"); //
    JRadioButton entertainment400c = new JRadioButton ("Selena Gomez"); //
    JRadioButton entertainment400d = new JRadioButton ("Cristiano Ronaldo"); //
    JRadioButton java400a = new JRadioButton ("Character.iswhitespace()"); //
    JRadioButton java400b = new JRadioButton ("Character.IsDigit()"); //
    JRadioButton java400c = new JRadioButton ("Character.IsSpace()"); //
    JRadioButton java400d = new JRadioButton ("Character.isSpace"); //
    JRadioButton gk400a = new JRadioButton ("Alexa"); //
    JRadioButton gk400b = new JRadioButton ("Siri"); //
    JRadioButton gk400c = new JRadioButton ("Waymo"); //
    JRadioButton gk400d = new JRadioButton ("Tesla"); //
    JRadioButton math400a = new JRadioButton ("+3,-5,+1/2"); //
    JRadioButton math400b = new JRadioButton ("-3,-4,-1/2"); //
    JRadioButton math400c = new JRadioButton ("+4,-3,and +1/2"); //
    JRadioButton math400d = new JRadioButton ("+3,-4,+1/2"); //
    JRadioButton sports300a = new JRadioButton ("Stephen Curry"); //
    JRadioButton sports300b = new JRadioButton ("LeBron James"); //
    JRadioButton sports300c = new JRadioButton ("Kevin Durant"); //
    JRadioButton sports300d = new JRadioButton ("Lionel Messi"); //
    JRadioButton entertainment300a = new JRadioButton ("Gerard Butler"); //
    JRadioButton entertainment300b = new JRadioButton ("Brad Pitt"); //
    JRadioButton entertainment300c = new JRadioButton ("Irina Shayk"); //
    JRadioButton entertainment300d = new JRadioButton ("Shah Rukh Khan"); //
    JRadioButton java300a = new JRadioButton ("throws java.ioexception"); //
    JRadioButton java300b = new JRadioButton ("Throws java.IOexception"); //
    JRadioButton java300c = new JRadioButton ("throws JAVA.IOexception"); //
    JRadioButton java300d = new JRadioButton ("throws java.io.IOException"); //
    JRadioButton gk300a = new JRadioButton ("Saskatoon"); //
    JRadioButton gk300b = new JRadioButton ("Winnipeg"); //
    JRadioButton gk300c = new JRadioButton ("Alberta"); //
    JRadioButton gk300d = new JRadioButton ("Toronto"); //
    JRadioButton math300a = new JRadioButton ("6th Degree"); //
    JRadioButton math300b = new JRadioButton ("8th Degree"); //
    JRadioButton math300c = new JRadioButton ("4th Degree"); //
    JRadioButton math300d = new JRadioButton ("7th Degree"); //
    JRadioButton sports200a = new JRadioButton ("Virat Kohli"); //
    JRadioButton sports200b = new JRadioButton ("Brian Lara"); //
    JRadioButton sports200c = new JRadioButton ("Sachin Tendulkar"); //
    JRadioButton sports200d = new JRadioButton ("Lionel Messi"); //
    JRadioButton gk200a = new JRadioButton ("1867"); //
    JRadioButton gk200b = new JRadioButton ("1967"); //
    JRadioButton gk200c = new JRadioButton ("1865"); //
    JRadioButton gk200d = new JRadioButton ("1864"); //
    JRadioButton math200a = new JRadioButton ("cos 2a = 2sina cosb"); //
    JRadioButton math200b = new JRadioButton ("sin 2a = 2sina cosa"); //
    JRadioButton math200c = new JRadioButton ("cos 2a = 2sina-cosa"); //
    JRadioButton math200d = new JRadioButton ("cos 2a = cos^2a + sin^2a"); //
    JRadioButton sports100a = new JRadioButton ("Spain"); //
    JRadioButton sports100b = new JRadioButton ("Brazil"); //
    JRadioButton sports100c = new JRadioButton ("Germany"); //
    JRadioButton sports100d = new JRadioButton ("Argentina"); //
    JRadioButton entertainment200a = new JRadioButton ("Inception"); //
    JRadioButton entertainment200b = new JRadioButton ("Titanic"); //
    JRadioButton entertainment200c = new JRadioButton ("12 Years A Slave"); //
    JRadioButton entertainment200d = new JRadioButton ("Spotlight"); //
    JRadioButton entertainment100a = new JRadioButton ("Priyanka Chopra"); //
    JRadioButton entertainment100b = new JRadioButton ("Deepika Padukone"); //
    JRadioButton entertainment100c = new JRadioButton ("Leo Dipario"); //
    JRadioButton entertainment100d = new JRadioButton ("Kate Winslet"); //
    JRadioButton java200a = new JRadioButton ("While Loop"); //
    JRadioButton java200b = new JRadioButton ("Do-While Loop"); //
    JRadioButton java200c = new JRadioButton ("For Loop"); //
    JRadioButton java200d = new JRadioButton ("None of the above"); //
    JRadioButton java100a = new JRadioButton ("System.print.out"); //
    JRadioButton java100b = new JRadioButton ("System.out.text"); //
    JRadioButton java100c = new JRadioButton ("put"); //
    JRadioButton java100d = new JRadioButton ("System.out.println"); //
    JRadioButton gk100a = new JRadioButton ("$11.40"); //
    JRadioButton gk100b = new JRadioButton ("$14.50"); //
    JRadioButton gk100c = new JRadioButton ("$14.00"); //
    JRadioButton gk100d = new JRadioButton ("$14.05"); //
    JRadioButton math100a = new JRadioButton ("sin(A + B) = sinAcosB + cosAsinB"); //
    JRadioButton math100b = new JRadioButton ("sin(A - B) = sinAcosB + cosAsinB"); //
    JRadioButton math100c = new JRadioButton ("cos(A + B) = cosAcosB + sinAsinB"); //
    JRadioButton math100d = new JRadioButton ("cos(A - B) = cosAcosB - sinAsinB"); //
    //////////////////////////////////////////////////////////////////////////////////
    JPanel layout = new JPanel ();
    JPanel sports500layout = new JPanel (); //Layout for each question
    JPanel sports400layout = new JPanel ();
    JPanel sports300layout = new JPanel ();
    JPanel sports200layout = new JPanel ();
    JPanel sports100layout = new JPanel ();
    JPanel entertainment500layout = new JPanel ();
    JPanel entertainment400layout = new JPanel ();
    JPanel entertainment300layout = new JPanel ();
    JPanel entertainment200layout = new JPanel ();
    JPanel entertainment100layout = new JPanel ();
    JPanel java500layout = new JPanel ();
    JPanel java400layout = new JPanel ();
    JPanel java300layout = new JPanel ();
    JPanel java200layout = new JPanel ();
    JPanel java100layout = new JPanel ();
    JPanel math100layout = new JPanel ();
    JPanel math200layout = new JPanel ();
    JPanel math300layout = new JPanel ();
    JPanel math400layout = new JPanel ();
    JPanel math500layout = new JPanel ();
    JPanel gk100layout = new JPanel ();
    JPanel gk200layout = new JPanel ();
    JPanel gk300layout = new JPanel ();
    JPanel gk400layout = new JPanel ();
    JPanel gk500layout = new JPanel ();
    JPanel winlayout = new JPanel ();
    JPanel losslayout = new JPanel ();
    JPanel TitlePanel = new JPanel ();
    JPanel south = new JPanel ();
    //////////////////////////////////////////
    JLabel title = new JLabel ("  JEOPARDY"); //Title label
    JLabel score = new JLabel ("SCORE: ");
    ///////////////////////////////////////////////////////////////////
    Font fontclr2 = new Font ("Arial", Font.BOLD, 24); //fonts for all the Labels and buttons
    Font HeadingFont = new Font ("Arial", + Font.BOLD, 30);
    ////////////////////////////////////////////
    JButton SportsCol = new JButton ("Sports"); //Category buttons
    JButton EntertainmentCol = new JButton ("Entertainment");
    JButton JavaCol = new JButton ("Java");
    JButton GkCol = new JButton ("Gk");
    JButton MathCol = new JButton ("Math");
    JLabel Timeleft;
    //////////////////////////////////////////
    public MainScreen ()
    {
	frame.setTitle ("Jeopardy");
	frame.setSize (600, 400);
	frame.setLocation (0, 0);
	screen1 ();
	//PlaySound (num, againplayed);
    }


    //
    // Timer timer;
    // public void ToDo (int seconds)
    // {
    //     timer = new Timer ();
    //     timer.schedule (new ToDoTask (), seconds * 1000);
    // }
    //
    //
    // class ToDoTask extends TimerTask
    // {
    //     public void run ()
    //     {
    //         timer.cancel ();    //Terminate the thread
    //     }
    // }
    //
    //
    // public void Timers ()
    // {
    //     Timeleft = new JLabel ("");
    //     for (int count = 0 ; count <= 5 ; count++)
    //     {
    //         try
    //         {
    //             Timeleft.setText (count + " Sec");
    //             Thread.sleep (1000);
    //             new ToDo (5);
    //         }
    //         catch (InterruptedException ex)
    //         {
    //         }
    //     }
    //
    // }


    public void actionPerformed (ActionEvent evt)
    {
	Object command = evt.getSource ();
	//////////////////////////////////
	win.setForeground (Color.YELLOW); //displaying a win layout at bottom of screen if answer is correct
	win.setBackground (Color.BLUE);
	win.setFont (fontclr2);
	winlayout.add (win);
	winlayout.setBackground (Color.blue);
	//////////////////////////////////
	loss.setForeground (Color.YELLOW); //displaying a win layout at bottom of screen if answer is correct
	loss.setBackground (Color.BLUE);
	loss.setFont (fontclr2);
	losslayout.add (loss);
	losslayout.setBackground (Color.blue);
	//////////////////////////////////////
	if (command == yes)
	{
	    yesbutton ();
	}
	else if (command == no)
	{
	    nobutton ();
	}
	if (command == returninguser)
	{
	    try
	    {
		returninguserbutton ();
	    }
	    catch (IOException exc)
	    {
	    }
	}
	else if (command == newuser)
	{
	    newuserbutton ();
	}
	if (command == Login)
	{
	    LoginInfo = login ();
	}
	else if (command == Signup)
	{
	    try
	    {
		SignupInfo = signup ();
	    }
	    catch (IOException exc)
	    {
	    }
	}
	if (command == back)
	{
	    contentPane.removeAll ();
	    UserReturn.removeAll ();
	    contentPane.add (ReUser, BorderLayout.NORTH);
	    contentPane.add (Center, BorderLayout.SOUTH);
	    contentPane.setBackground (Color.blue);
	    username.setText (null);
	    LoginPassword.setText (null);
	    CorrectInfo.setText ("");
	    frame.repaint ();
	}
	if (command == Reset)
	{
	    username.setText (null);
	    LoginPassword.setText (null);
	    password.setText (null);
	    namebox.setText (null);
	    Emailbox.setText (null);
	    lastnamebox.setText (null);
	    CorrectInfo.setText ("");
	    LoginInfo = false;
	    SignupInfo = false;
	}
	if (LoginInfo == true)
	{
	    Login.setEnabled (false);
	    Reset.setEnabled (false);
	    back.setEnabled (false);
	    //////////////////////////
	    IntroScreen (LoginInfo);
	    LoginInfo = false;
	}
	if (SignupInfo == true)
	{
	    Reset.setEnabled (false);
	    back.setEnabled (false);
	    Signup.setEnabled (false);
	    IntroScreen (LoginInfo);
	    SignupInfo = false;
	}
	if (command == play)
	{
	    contentPane.removeAll ();
	    frame.repaint ();
	    FormatingButtons ();
	    frame.setTitle ("Jeopardy");
	    frame.setExtendedState (JFrame.MAXIMIZED_BOTH);
	    LayoutButtons ();
	    contentPane.setLayout (new BorderLayout ());
	    contentPane.add (TitlePanel, BorderLayout.NORTH);
	    contentPane.add (layout, BorderLayout.CENTER);
	    contentPane.add (south, BorderLayout.SOUTH);
	    frame.show ();
	    //////////////////////////////////////////
	    returnmain.addActionListener (this);
	}
	if (command == instruction)
	{
	    contentPane.removeAll ();
	    frame.repaint ();
	    frame.setTitle ("Jeopardy Instructions");
	    frame.setExtendedState (JFrame.MAXIMIZED_BOTH);
	    play.setBorderPainted (false);
	    play.setFocusPainted (false);
	    play.setFont (font2);
	    play.setForeground (Color.yellow);
	    play.setBackground (Color.blue);
	    contentPane.setLayout (new BorderLayout ());
	    instruct.setFont (font2);
	    instruct.setForeground (Color.yellow);
	    instructions.setFont (font);
	    instructions.setForeground (Color.yellow);
	    contentPane.add (instructions, BorderLayout.NORTH);
	    contentPane.add (instruct, BorderLayout.CENTER);
	    contentPane.add (play, BorderLayout.SOUTH);
	    frame.show ();
	    //////////////////////////////////////////
	    play.addActionListener (this);
	}
	//////////////////////////////
	if (command == exit)
	{
	    System.exit (0);
	}
	if (command == numbers [1]) //displaying sports 500 layout
	{
	    contentPane.removeAll ();
	    sports500layout.setLayout (new GridLayout (6, 1));
	    sports500q = new JLabel ("500 - Which tennis player holds the record for the most Wimbledon titles?");
	    sports500layout.setBackground (Color.BLUE); //setting the color and font for layout
	    sports500q.setForeground (Color.YELLOW); //
	    sports500q.setFont (fontclr2); //
	    sports500a.setBackground (Color.BLUE); //setting color and font for button
	    sports500a.setForeground (Color.YELLOW); //
	    sports500a.setFont (fontclr2); //
	    sports500b.setBackground (Color.BLUE); //
	    sports500b.setForeground (Color.YELLOW); //
	    sports500b.setFont (fontclr2); //
	    sports500c.setBackground (Color.BLUE); //
	    sports500c.setForeground (Color.YELLOW); //
	    sports500c.setFont (fontclr2); //
	    sports500d.setBackground (Color.BLUE); //
	    sports500d.setForeground (Color.YELLOW); //
	    sports500d.setFont (fontclr2); //
	    sports500layout.add (sports500q); //adding buttons to sports layout
	    sports500layout.add (sports500a); //
	    sports500layout.add (sports500b); //
	    sports500layout.add (sports500c); //
	    sports500layout.add (sports500d); //
	    contentPane.add (sports500layout, BorderLayout.CENTER); //adding sports layout to the main jframe
	    sports500a.addActionListener (this); //listening the buttons
	    sports500b.addActionListener (this); //
	    sports500c.addActionListener (this); //
	    sports500d.addActionListener (this); //
	    frame.show ();
	}
	if (command == numbers [2]) //displaying entertainment 500 layout
	{
	    contentPane.removeAll ();
	    entertainment500layout.setLayout (new GridLayout (5, 1));
	    entertainment500q = new JLabel ("500 - Which was the highest-grossing film of 2017?");
	    entertainment500layout.setBackground (Color.BLUE);
	    entertainment500q.setForeground (Color.YELLOW);
	    entertainment500q.setFont (fontclr2);
	    entertainment500a.setBackground (Color.BLUE);
	    entertainment500a.setForeground (Color.YELLOW);
	    entertainment500a.setFont (fontclr2);
	    entertainment500b.setBackground (Color.BLUE);
	    entertainment500b.setForeground (Color.YELLOW);
	    entertainment500b.setFont (fontclr2);
	    entertainment500c.setBackground (Color.BLUE);
	    entertainment500c.setForeground (Color.YELLOW);
	    entertainment500c.setFont (fontclr2);
	    entertainment500d.setBackground (Color.BLUE);
	    entertainment500d.setForeground (Color.YELLOW);
	    entertainment500d.setFont (fontclr2);
	    entertainment500layout.add (entertainment500q);
	    entertainment500layout.add (entertainment500a);
	    entertainment500layout.add (entertainment500b);
	    entertainment500layout.add (entertainment500c);
	    entertainment500layout.add (entertainment500d);
	    contentPane.add (entertainment500layout, BorderLayout.CENTER);
	    entertainment500a.addActionListener (this);
	    entertainment500b.addActionListener (this);
	    entertainment500c.addActionListener (this);
	    entertainment500d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers [3]) //displaying java 500 layout
	{
	    contentPane.removeAll ();
	    java500layout.setLayout (new GridLayout (5, 1));
	    java500q = new JLabel ("500 - Which of the following is false about vectors?");
	    java500layout.setBackground (Color.BLUE);
	    java500q.setForeground (Color.YELLOW);
	    java500q.setFont (fontclr2);
	    java500a.setBackground (Color.BLUE);
	    java500a.setForeground (Color.YELLOW);
	    java500a.setFont (fontclr2);
	    java500b.setBackground (Color.BLUE);
	    java500b.setForeground (Color.YELLOW);
	    java500b.setFont (fontclr2);
	    java500c.setBackground (Color.BLUE);
	    java500c.setForeground (Color.YELLOW);
	    java500c.setFont (fontclr2);
	    java500d.setBackground (Color.BLUE);
	    java500d.setForeground (Color.YELLOW);
	    java500d.setFont (fontclr2);
	    java500layout.add (java500q);
	    java500layout.add (java500a);
	    java500layout.add (java500b);
	    java500layout.add (java500c);
	    java500layout.add (java500d);
	    contentPane.add (java500layout, BorderLayout.WEST);
	    contentPane.add (Java500Pic, BorderLayout.CENTER);
	    java500a.addActionListener (this);
	    java500b.addActionListener (this);
	    java500c.addActionListener (this);
	    java500d.addActionListener (this);
	    frame.show ();

	}
	if (command == numbers [4]) //displaying gk 500 layout
	{
	    contentPane.removeAll ();
	    gk500layout.setLayout (new GridLayout (5, 1));
	    gk500q = new JLabel ("500 - Who was the 44th President of the United States?");
	    gk500layout.setBackground (Color.BLUE);
	    gk500q.setForeground (Color.YELLOW);
	    gk500q.setFont (fontclr2);
	    gk500a.setBackground (Color.BLUE);
	    gk500a.setForeground (Color.YELLOW);
	    gk500a.setFont (fontclr2);
	    gk500b.setBackground (Color.BLUE);
	    gk500b.setForeground (Color.YELLOW);
	    gk500b.setFont (fontclr2);
	    gk500c.setBackground (Color.BLUE);
	    gk500c.setForeground (Color.YELLOW);
	    gk500c.setFont (fontclr2);
	    gk500d.setBackground (Color.BLUE);
	    gk500d.setForeground (Color.YELLOW);
	    gk500d.setFont (fontclr2);
	    gk500layout.add (gk500q);
	    gk500layout.add (gk500a);
	    gk500layout.add (gk500b);
	    gk500layout.add (gk500c);
	    gk500layout.add (gk500d);
	    contentPane.add (gk500layout, BorderLayout.WEST);
	    contentPane.add (GK500Pic, BorderLayout.CENTER);
	    gk500a.addActionListener (this);
	    gk500b.addActionListener (this);
	    gk500c.addActionListener (this);
	    gk500d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers [5]) //displaying math 500 layout
	{
	    contentPane.removeAll ();
	    math500layout.setLayout (new GridLayout (5, 1));
	    math500q = new JLabel ("500 - What is \u03c0/4 in degree measure?");
	    math500layout.setBackground (Color.BLUE);
	    math500q.setForeground (Color.YELLOW);
	    math500q.setFont (fontclr2);
	    math500a.setBackground (Color.BLUE);
	    math500a.setForeground (Color.YELLOW);
	    math500a.setFont (fontclr2);
	    math500b.setBackground (Color.BLUE);
	    math500b.setForeground (Color.YELLOW);
	    math500b.setFont (fontclr2);
	    math500c.setBackground (Color.BLUE);
	    math500c.setForeground (Color.YELLOW);
	    math500c.setFont (fontclr2);
	    math500d.setBackground (Color.BLUE);
	    math500d.setForeground (Color.YELLOW);
	    math500d.setFont (fontclr2);
	    math500layout.add (math500q);
	    math500layout.add (math500a);
	    math500layout.add (math500b);
	    math500layout.add (math500c);
	    math500layout.add (math500d);
	    contentPane.add (math500layout, BorderLayout.WEST);
	    contentPane.add (Math500Pic, BorderLayout.CENTER);
	    math500a.addActionListener (this);
	    math500b.addActionListener (this);
	    math500c.addActionListener (this);
	    math500d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers2 [1]) //displaying sports 400 layout
	{
	    contentPane.removeAll ();
	    sports400layout.setLayout (new GridLayout (5, 1));
	    sports400q = new JLabel ("400 - Who scored a record 10 hat tricks in an NHL season?");
	    sports400layout.setBackground (Color.BLUE);
	    sports400q.setForeground (Color.YELLOW);
	    sports400q.setFont (fontclr2);
	    sports400a.setBackground (Color.BLUE);
	    sports400a.setForeground (Color.YELLOW);
	    sports400a.setFont (fontclr2);
	    sports400b.setBackground (Color.BLUE);
	    sports400b.setForeground (Color.YELLOW);
	    sports400b.setFont (fontclr2);
	    sports400c.setBackground (Color.BLUE);
	    sports400c.setForeground (Color.YELLOW);
	    sports400c.setFont (fontclr2);
	    sports400d.setBackground (Color.BLUE);
	    sports400d.setForeground (Color.YELLOW);
	    sports400d.setFont (fontclr2);
	    sports400layout.add (sports400q);
	    sports400layout.add (sports400a);
	    sports400layout.add (sports400b);
	    sports400layout.add (sports400c);
	    sports400layout.add (sports400d);
	    contentPane.add (sports400layout, BorderLayout.CENTER);
	    sports400a.addActionListener (this);
	    sports400b.addActionListener (this);
	    sports400c.addActionListener (this);
	    sports400d.addActionListener (this);
	    frame.show ();

	}
	if (command == numbers2 [2]) //displaying entertainment 400 layout
	{
	    contentPane.removeAll ();
	    entertainment400layout.setLayout (new GridLayout (5, 1));
	    entertainment400q = new JLabel ("400 - Which person has the highest followers on Instagram?");
	    entertainment400layout.setBackground (Color.BLUE);
	    entertainment400q.setForeground (Color.YELLOW);
	    entertainment400q.setFont (fontclr2);
	    entertainment400a.setBackground (Color.BLUE);
	    entertainment400a.setForeground (Color.YELLOW);
	    entertainment400a.setFont (fontclr2);
	    entertainment400b.setBackground (Color.BLUE);
	    entertainment400b.setForeground (Color.YELLOW);
	    entertainment400b.setFont (fontclr2);
	    entertainment400c.setBackground (Color.BLUE);
	    entertainment400c.setForeground (Color.YELLOW);
	    entertainment400c.setFont (fontclr2);
	    entertainment400d.setBackground (Color.BLUE);
	    entertainment400d.setForeground (Color.YELLOW);
	    entertainment400d.setFont (fontclr2);
	    entertainment400layout.add (entertainment400q);
	    entertainment400layout.add (entertainment400a);
	    entertainment400layout.add (entertainment400b);
	    entertainment400layout.add (entertainment400c);
	    entertainment400layout.add (entertainment400d);
	    contentPane.add (entertainment400layout, BorderLayout.WEST);
	    contentPane.add (Entertainment400Pic, BorderLayout.CENTER);
	    entertainment400a.addActionListener (this);
	    entertainment400b.addActionListener (this);
	    entertainment400c.addActionListener (this);
	    entertainment400d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers2 [3]) //displaying java 400 layout
	{
	    contentPane.removeAll ();
	    java400layout.setLayout (new GridLayout (5, 1));
	    java400q = new JLabel ("400 - Which command is used to determine whether a char value contains a space?");
	    java400layout.setBackground (Color.BLUE);
	    java400q.setForeground (Color.YELLOW);
	    java400q.setFont (fontclr2);
	    java400a.setBackground (Color.BLUE);
	    java400a.setForeground (Color.YELLOW);
	    java400a.setFont (fontclr2);
	    java400b.setBackground (Color.BLUE);
	    java400b.setForeground (Color.YELLOW);
	    java400b.setFont (fontclr2);
	    java400c.setBackground (Color.BLUE);
	    java400c.setForeground (Color.YELLOW);
	    java400c.setFont (fontclr2);
	    java400d.setBackground (Color.BLUE);
	    java400d.setForeground (Color.YELLOW);
	    java400d.setFont (fontclr2);
	    java400layout.add (java400q);
	    java400layout.add (java400a);
	    java400layout.add (java400b);
	    java400layout.add (java400c);
	    java400layout.add (java400d);
	    contentPane.add (java400layout, BorderLayout.CENTER);
	    java400a.addActionListener (this);
	    java400b.addActionListener (this);
	    java400c.addActionListener (this);
	    java400d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers2 [4]) //displaying gk 400 layout
	{
	    contentPane.removeAll ();
	    gk400layout.setLayout (new GridLayout (5, 1));
	    gk400q = new JLabel ("400 - What is the name of Googles self driving car project?");
	    gk400layout.setBackground (Color.BLUE);
	    gk400q.setForeground (Color.YELLOW);
	    gk400q.setFont (fontclr2);
	    gk400a.setBackground (Color.BLUE);
	    gk400a.setForeground (Color.YELLOW);
	    gk400a.setFont (fontclr2);
	    gk400b.setBackground (Color.BLUE);
	    gk400b.setForeground (Color.YELLOW);
	    gk400b.setFont (fontclr2);
	    gk400c.setBackground (Color.BLUE);
	    gk400c.setForeground (Color.YELLOW);
	    gk400c.setFont (fontclr2);
	    gk400d.setBackground (Color.BLUE);
	    gk400d.setForeground (Color.YELLOW);
	    gk400d.setFont (fontclr2);
	    gk400layout.add (gk400q);
	    gk400layout.add (gk400a);
	    gk400layout.add (gk400b);
	    gk400layout.add (gk400c);
	    gk400layout.add (gk400d);
	    contentPane.add (gk400layout, BorderLayout.WEST);
	    contentPane.add (GK400Pic, BorderLayout.CENTER);
	    gk400a.addActionListener (this);
	    gk400b.addActionListener (this);
	    gk400c.addActionListener (this);
	    gk400d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers2 [5]) //displaying math 400 layout
	{
	    contentPane.removeAll ();
	    math400layout.setLayout (new GridLayout (5, 1));
	    math400q = new JLabel ("400 - What are the x-intercepts of: y=(x-4)(x+3)(2x-1)?");
	    math400layout.setBackground (Color.BLUE);
	    math400q.setForeground (Color.YELLOW);
	    math400q.setFont (fontclr2);
	    math400a.setBackground (Color.BLUE);
	    math400a.setForeground (Color.YELLOW);
	    math400a.setFont (fontclr2);
	    math400b.setBackground (Color.BLUE);
	    math400b.setForeground (Color.YELLOW);
	    math400b.setFont (fontclr2);
	    math400c.setBackground (Color.BLUE);
	    math400c.setForeground (Color.YELLOW);
	    math400c.setFont (fontclr2);
	    math400d.setBackground (Color.BLUE);
	    math400d.setForeground (Color.YELLOW);
	    math400d.setFont (fontclr2);
	    math400layout.add (math400q);
	    math400layout.add (math400a);
	    math400layout.add (math400b);
	    math400layout.add (math400c);
	    math400layout.add (math400d);
	    contentPane.add (math400layout, BorderLayout.WEST);
	    contentPane.add (Math400Pic, BorderLayout.CENTER);
	    math400a.addActionListener (this);
	    math400b.addActionListener (this);
	    math400c.addActionListener (this);
	    math400d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers3 [1]) //displaying sports 300 layout
	{
	    contentPane.removeAll ();
	    sports300layout.setLayout (new GridLayout (5, 1));
	    sports300q = new JLabel ("300 - Who won the 2016 NBA Finals MVP?");
	    sports300layout.setBackground (Color.BLUE);
	    sports300q.setForeground (Color.YELLOW);
	    sports300q.setFont (fontclr2);
	    sports300a.setBackground (Color.BLUE);
	    sports300a.setForeground (Color.YELLOW);
	    sports300a.setFont (fontclr2);
	    sports300b.setBackground (Color.BLUE);
	    sports300b.setForeground (Color.YELLOW);
	    sports300b.setFont (fontclr2);
	    sports300c.setBackground (Color.BLUE);
	    sports300c.setForeground (Color.YELLOW);
	    sports300c.setFont (fontclr2);
	    sports300d.setBackground (Color.BLUE);
	    sports300d.setForeground (Color.YELLOW);
	    sports300d.setFont (fontclr2);
	    sports300layout.add (sports300q);
	    sports300layout.add (sports300a);
	    sports300layout.add (sports300b);
	    sports300layout.add (sports300c);
	    sports300layout.add (sports300d);
	    contentPane.add (sports300layout, BorderLayout.CENTER);
	    sports300a.addActionListener (this);
	    sports300b.addActionListener (this);
	    sports300c.addActionListener (this);
	    sports300d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers3 [2]) //displaying entertainment 400 layout
	{
	    contentPane.removeAll ();
	    entertainment300layout.setLayout (new GridLayout (5, 1));
	    entertainment300q = new JLabel ("400 - Which actor said the famous quote, 'This is Sparta!'?");
	    entertainment300layout.setBackground (Color.BLUE);
	    entertainment300q.setForeground (Color.YELLOW);
	    entertainment300q.setFont (fontclr2);
	    entertainment300a.setBackground (Color.BLUE);
	    entertainment300a.setForeground (Color.YELLOW);
	    entertainment300a.setFont (fontclr2);
	    entertainment300b.setBackground (Color.BLUE);
	    entertainment300b.setForeground (Color.YELLOW);
	    entertainment300b.setFont (fontclr2);
	    entertainment300c.setBackground (Color.BLUE);
	    entertainment300c.setForeground (Color.YELLOW);
	    entertainment300c.setFont (fontclr2);
	    entertainment300d.setBackground (Color.BLUE);
	    entertainment300d.setForeground (Color.YELLOW);
	    entertainment300d.setFont (fontclr2);
	    entertainment300layout.add (entertainment300q);
	    entertainment300layout.add (entertainment300a);
	    entertainment300layout.add (entertainment300b);
	    entertainment300layout.add (entertainment300c);
	    entertainment300layout.add (entertainment300d);
	    contentPane.add (entertainment300layout, BorderLayout.CENTER);
	    entertainment300a.addActionListener (this);
	    entertainment300b.addActionListener (this);
	    entertainment300c.addActionListener (this);
	    entertainment300d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers3 [3]) //displaying java 300 layout
	{
	    contentPane.removeAll ();
	    java300layout.setLayout (new GridLayout (5, 1));
	    java300q = new JLabel ("300 - What is the correct form of the importing the throws exception?");
	    java300layout.setBackground (Color.BLUE);
	    java300q.setForeground (Color.YELLOW);
	    java300q.setFont (fontclr2);
	    java300a.setBackground (Color.BLUE);
	    java300a.setForeground (Color.YELLOW);
	    java300a.setFont (fontclr2);
	    java300b.setBackground (Color.BLUE);
	    java300b.setForeground (Color.YELLOW);
	    java300b.setFont (fontclr2);
	    java300c.setBackground (Color.BLUE);
	    java300c.setForeground (Color.YELLOW);
	    java300c.setFont (fontclr2);
	    java300d.setBackground (Color.BLUE);
	    java300d.setForeground (Color.YELLOW);
	    java300d.setFont (fontclr2);
	    java300layout.add (java300q);
	    java300layout.add (java300a);
	    java300layout.add (java300b);
	    java300layout.add (java300c);
	    java300layout.add (java300d);
	    contentPane.add (java300layout, BorderLayout.CENTER);
	    java300a.addActionListener (this);
	    java300b.addActionListener (this);
	    java300c.addActionListener (this);
	    java300d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers3 [4]) //displaying gk 300 layout
	{
	    contentPane.removeAll ();
	    gk300layout.setLayout (new GridLayout (5, 1));
	    gk300q = new JLabel ("300 - What is the provincial capital of Manitoba?");
	    gk300layout.setBackground (Color.BLUE);
	    gk300q.setForeground (Color.YELLOW);
	    gk300q.setFont (fontclr2);
	    gk300a.setBackground (Color.BLUE);
	    gk300a.setForeground (Color.YELLOW);
	    gk300a.setFont (fontclr2);
	    gk300b.setBackground (Color.BLUE);
	    gk300b.setForeground (Color.YELLOW);
	    gk300b.setFont (fontclr2);
	    gk300c.setBackground (Color.BLUE);
	    gk300c.setForeground (Color.YELLOW);
	    gk300c.setFont (fontclr2);
	    gk300d.setBackground (Color.BLUE);
	    gk300d.setForeground (Color.YELLOW);
	    gk300d.setFont (fontclr2);
	    gk300layout.add (gk300q);
	    gk300layout.add (gk300a);
	    gk300layout.add (gk300b);
	    gk300layout.add (gk300c);
	    gk300layout.add (gk300d);
	    contentPane.add (gk300layout, BorderLayout.WEST);
	    contentPane.add (GK300Pic, BorderLayout.CENTER);
	    gk300a.addActionListener (this);
	    gk300b.addActionListener (this);
	    gk300c.addActionListener (this);
	    gk300d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers3 [5]) //displaying math 300 layout
	{
	    contentPane.removeAll ();
	    math300layout.setLayout (new GridLayout (5, 1));
	    math300q = new JLabel ("300 - What is the degree of the following function: y=2x(x-3)(x-2)(x^2+4)^2?");
	    math300layout.setBackground (Color.BLUE);
	    math300q.setForeground (Color.YELLOW);
	    math300q.setFont (fontclr2);
	    math300a.setBackground (Color.BLUE);
	    math300a.setForeground (Color.YELLOW);
	    math300a.setFont (fontclr2);
	    math300b.setBackground (Color.BLUE);
	    math300b.setForeground (Color.YELLOW);
	    math300b.setFont (fontclr2);
	    math300c.setBackground (Color.BLUE);
	    math300c.setForeground (Color.YELLOW);
	    math300c.setFont (fontclr2);
	    math300d.setBackground (Color.BLUE);
	    math300d.setForeground (Color.YELLOW);
	    math300d.setFont (fontclr2);
	    math300layout.add (math300q);
	    math300layout.add (math300a);
	    math300layout.add (math300b);
	    math300layout.add (math300c);
	    math300layout.add (math300d);
	    contentPane.add (math300layout, BorderLayout.WEST);
	    contentPane.add (Math300Pic, BorderLayout.CENTER);
	    math300a.addActionListener (this);
	    math300b.addActionListener (this);
	    math300c.addActionListener (this);
	    math300d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers4 [1]) //displaying sports 200 layout
	{
	    contentPane.removeAll ();
	    sports200layout.setLayout (new GridLayout (5, 1));
	    sports200q = new JLabel ("200 - Which cricket player is the only one with 100 centuries?");
	    sports200layout.setBackground (Color.BLUE);
	    sports200q.setForeground (Color.YELLOW);
	    sports200q.setFont (fontclr2);
	    sports200a.setBackground (Color.BLUE);
	    sports200a.setForeground (Color.YELLOW);
	    sports200a.setFont (fontclr2);
	    sports200b.setBackground (Color.BLUE);
	    sports200b.setForeground (Color.YELLOW);
	    sports200b.setFont (fontclr2);
	    sports200c.setBackground (Color.BLUE);
	    sports200c.setForeground (Color.YELLOW);
	    sports200c.setFont (fontclr2);
	    sports200d.setBackground (Color.BLUE);
	    sports200d.setForeground (Color.YELLOW);
	    sports200d.setFont (fontclr2);
	    sports200layout.add (sports200q);
	    sports200layout.add (sports200a);
	    sports200layout.add (sports200b);
	    sports200layout.add (sports200c);
	    sports200layout.add (sports200d);
	    contentPane.add (sports200layout, BorderLayout.WEST);
	    contentPane.add (Sports200Pic, BorderLayout.CENTER);
	    sports200a.addActionListener (this);
	    sports200b.addActionListener (this);
	    sports200c.addActionListener (this);
	    sports200d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers4 [2]) //displaying entertainment 200 layout
	{
	    contentPane.removeAll ();
	    entertainment200layout.setLayout (new GridLayout (5, 1));
	    entertainment200q = new JLabel ("200 - What movie had won the 2016 Oscar for Best Motion Picture?");
	    entertainment200layout.setBackground (Color.BLUE);
	    entertainment200q.setForeground (Color.YELLOW);
	    entertainment200q.setFont (fontclr2);
	    entertainment200a.setBackground (Color.BLUE);
	    entertainment200a.setForeground (Color.YELLOW);
	    entertainment200a.setFont (fontclr2);
	    entertainment200b.setBackground (Color.BLUE);
	    entertainment200b.setForeground (Color.YELLOW);
	    entertainment200b.setFont (fontclr2);
	    entertainment200c.setBackground (Color.BLUE);
	    entertainment200c.setForeground (Color.YELLOW);
	    entertainment200c.setFont (fontclr2);
	    entertainment200d.setBackground (Color.BLUE);
	    entertainment200d.setForeground (Color.YELLOW);
	    entertainment200d.setFont (fontclr2);
	    entertainment200layout.add (entertainment200q);
	    entertainment200layout.add (entertainment200a);
	    entertainment200layout.add (entertainment200b);
	    entertainment200layout.add (entertainment200c);
	    entertainment200layout.add (entertainment200d);
	    contentPane.add (entertainment200layout, BorderLayout.WEST);
	    contentPane.add (Entertainment200Pic, BorderLayout.CENTER);
	    entertainment200a.addActionListener (this);
	    entertainment200b.addActionListener (this);
	    entertainment200c.addActionListener (this);
	    entertainment200d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers4 [3]) //displaying java 200 layout
	{
	    contentPane.removeAll ();
	    java200layout.setLayout (new GridLayout (5, 1));
	    java200q = new JLabel ("200 - Which loop do you use when the number of repititions is known?");
	    java200layout.setBackground (Color.BLUE);
	    java200q.setForeground (Color.YELLOW);
	    java200q.setFont (fontclr2);
	    java200a.setBackground (Color.BLUE);
	    java200a.setForeground (Color.YELLOW);
	    java200a.setFont (fontclr2);
	    java200b.setBackground (Color.BLUE);
	    java200b.setForeground (Color.YELLOW);
	    java200b.setFont (fontclr2);
	    java200c.setBackground (Color.BLUE);
	    java200c.setForeground (Color.YELLOW);
	    java200c.setFont (fontclr2);
	    java200d.setBackground (Color.BLUE);
	    java200d.setForeground (Color.YELLOW);
	    java200d.setFont (fontclr2);
	    java200layout.add (java200q);
	    java200layout.add (java200a);
	    java200layout.add (java200b);
	    java200layout.add (java200c);
	    java200layout.add (java200d);
	    contentPane.add (java200layout, BorderLayout.CENTER);
	    java200a.addActionListener (this);
	    java200b.addActionListener (this);
	    java200c.addActionListener (this);
	    java200d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers4 [4]) //displaying gk 200 layout
	{
	    contentPane.removeAll ();
	    gk200layout.setLayout (new GridLayout (5, 1));
	    gk200q = new JLabel ("200 - What year did Canada become a nation?");
	    gk200layout.setBackground (Color.BLUE);
	    gk200q.setForeground (Color.YELLOW);
	    gk200q.setFont (fontclr2);
	    gk200a.setBackground (Color.BLUE);
	    gk200a.setForeground (Color.YELLOW);
	    gk200a.setFont (fontclr2);
	    gk200b.setBackground (Color.BLUE);
	    gk200b.setForeground (Color.YELLOW);
	    gk200b.setFont (fontclr2);
	    gk200c.setBackground (Color.BLUE);
	    gk200c.setForeground (Color.YELLOW);
	    gk200c.setFont (fontclr2);
	    gk200d.setBackground (Color.BLUE);
	    gk200d.setForeground (Color.YELLOW);
	    gk200d.setFont (fontclr2);
	    gk200layout.add (gk200q);
	    gk200layout.add (gk200a);
	    gk200layout.add (gk200b);
	    gk200layout.add (gk200c);
	    gk200layout.add (gk200d);
	    contentPane.add (gk200layout, BorderLayout.WEST);
	    contentPane.add (GK200Pic, BorderLayout.CENTER);
	    gk200a.addActionListener (this);
	    gk200b.addActionListener (this);
	    gk200c.addActionListener (this);
	    gk200d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers4 [5]) //displaying math 200 layout
	{
	    contentPane.removeAll ();
	    math200layout.setLayout (new GridLayout (5, 1));
	    math200q = new JLabel ("200 - Which of the following is a double angle formula?");
	    math200layout.setBackground (Color.BLUE);
	    math200q.setForeground (Color.YELLOW);
	    math200q.setFont (fontclr2);
	    math200a.setBackground (Color.BLUE);
	    math200a.setForeground (Color.YELLOW);
	    math200a.setFont (fontclr2);
	    math200b.setBackground (Color.BLUE);
	    math200b.setForeground (Color.YELLOW);
	    math200b.setFont (fontclr2);
	    math200c.setBackground (Color.BLUE);
	    math200c.setForeground (Color.YELLOW);
	    math200c.setFont (fontclr2);
	    math200d.setBackground (Color.BLUE);
	    math200d.setForeground (Color.YELLOW);
	    math200d.setFont (fontclr2);
	    math200layout.add (math200q);
	    math200layout.add (math200a);
	    math200layout.add (math200b);
	    math200layout.add (math200c);
	    math200layout.add (math200d);
	    contentPane.add (math200layout, BorderLayout.WEST);
	    contentPane.add (Math200Pic, BorderLayout.CENTER);
	    math200a.addActionListener (this);
	    math200b.addActionListener (this);
	    math200c.addActionListener (this);
	    math200d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers5 [1]) //displaying sports 100 layout
	{
	    contentPane.removeAll ();
	    sports100layout.setLayout (new GridLayout (5, 1));
	    sports100q = new JLabel ("100 - Which team won the FIFA World Cup in 2010?");
	    sports100layout.setBackground (Color.BLUE);
	    sports100q.setForeground (Color.YELLOW);
	    sports100q.setFont (fontclr2);
	    sports100a.setBackground (Color.BLUE);
	    sports100a.setForeground (Color.YELLOW);
	    sports100a.setFont (fontclr2);
	    sports100b.setBackground (Color.BLUE);
	    sports100b.setForeground (Color.YELLOW);
	    sports100b.setFont (fontclr2);
	    sports100c.setBackground (Color.BLUE);
	    sports100c.setForeground (Color.YELLOW);
	    sports100c.setFont (fontclr2);
	    sports100d.setBackground (Color.BLUE);
	    sports100d.setForeground (Color.YELLOW);
	    sports100d.setFont (fontclr2);
	    sports100layout.add (sports100q);
	    sports100layout.add (sports100a);
	    sports100layout.add (sports100b);
	    sports100layout.add (sports100c);
	    sports100layout.add (sports100d);
	    contentPane.add (sports100layout, BorderLayout.WEST);
	    contentPane.add (Sports100Pic, BorderLayout.CENTER);
	    sports100a.addActionListener (this);
	    sports100b.addActionListener (this);
	    sports100c.addActionListener (this);
	    sports100d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers5 [2]) //displaying entertainment 100 layout
	{
	    contentPane.removeAll ();
	    entertainment100layout.setLayout (new GridLayout (5, 1));
	    entertainment100q = new JLabel ("100 - Which Bollywood Actress is known for their role in the TV show,Quantico?");
	    entertainment100layout.setBackground (Color.BLUE);
	    entertainment100q.setForeground (Color.YELLOW);
	    entertainment100q.setFont (fontclr2);
	    entertainment100a.setBackground (Color.BLUE);
	    entertainment100a.setForeground (Color.YELLOW);
	    entertainment100a.setFont (fontclr2);
	    entertainment100b.setBackground (Color.BLUE);
	    entertainment100b.setForeground (Color.YELLOW);
	    entertainment100b.setFont (fontclr2);
	    entertainment100c.setBackground (Color.BLUE);
	    entertainment100c.setForeground (Color.YELLOW);
	    entertainment100c.setFont (fontclr2);
	    entertainment100d.setBackground (Color.BLUE);
	    entertainment100d.setForeground (Color.YELLOW);
	    entertainment100d.setFont (fontclr2);
	    entertainment100layout.add (entertainment100q);
	    entertainment100layout.add (entertainment100a);
	    entertainment100layout.add (entertainment100b);
	    entertainment100layout.add (entertainment100c);
	    entertainment100layout.add (entertainment100d);
	    contentPane.add (entertainment100layout, BorderLayout.CENTER);
	    entertainment100a.addActionListener (this);
	    entertainment100b.addActionListener (this);
	    entertainment100c.addActionListener (this);
	    entertainment100d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers5 [3]) //displaying java 100 layout
	{
	    contentPane.removeAll ();
	    java100layout.setLayout (new GridLayout (5, 1));
	    java100q = new JLabel ("100 - What command is used to print out text?");
	    java100layout.setBackground (Color.BLUE);
	    java100q.setForeground (Color.YELLOW);
	    java100q.setFont (fontclr2);
	    java100a.setBackground (Color.BLUE);
	    java100a.setForeground (Color.YELLOW);
	    java100a.setFont (fontclr2);
	    java100b.setBackground (Color.BLUE);
	    java100b.setForeground (Color.YELLOW);
	    java100b.setFont (fontclr2);
	    java100c.setBackground (Color.BLUE);
	    java100c.setForeground (Color.YELLOW);
	    java100c.setFont (fontclr2);
	    java100d.setBackground (Color.BLUE);
	    java100d.setForeground (Color.YELLOW);
	    java100d.setFont (fontclr2);
	    java100layout.add (java100q);
	    java100layout.add (java100a);
	    java100layout.add (java100b);
	    java100layout.add (java100c);
	    java100layout.add (java100d);
	    contentPane.add (java100layout, BorderLayout.WEST);
	    contentPane.add (Java100Pic, BorderLayout.CENTER);
	    java100a.addActionListener (this);
	    java100b.addActionListener (this);
	    java100c.addActionListener (this);
	    java100d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers5 [4]) //displaying gk 100 layout
	{
	    contentPane.removeAll ();
	    gk100layout.setLayout (new GridLayout (4, 1));
	    gk100q = new JLabel ("100 - What is the new minimum wage in Ontario starting from January 1st 2018?");
	    gk100layout.setBackground (Color.BLUE);
	    gk100q.setForeground (Color.YELLOW);
	    gk100q.setFont (fontclr2);
	    gk100a.setBackground (Color.BLUE);
	    gk100a.setForeground (Color.YELLOW);
	    gk100a.setFont (fontclr2);
	    gk100b.setBackground (Color.BLUE);
	    gk100b.setForeground (Color.YELLOW);
	    gk100b.setFont (fontclr2);
	    gk100c.setBackground (Color.BLUE);
	    gk100c.setForeground (Color.YELLOW);
	    gk100c.setFont (fontclr2);
	    gk100d.setBackground (Color.BLUE);
	    gk100d.setForeground (Color.YELLOW);
	    gk100d.setFont (fontclr2);
	    gk100layout.add (gk100a);
	    gk100layout.add (gk100b);
	    gk100layout.add (gk100c);
	    gk100layout.add (gk100d);
	    contentPane.add (gk100q, BorderLayout.NORTH);
	    contentPane.add (gk100layout, BorderLayout.WEST);
	    contentPane.add (GK100Pic, BorderLayout.CENTER);
	    gk100a.addActionListener (this);
	    gk100b.addActionListener (this);
	    gk100c.addActionListener (this);
	    gk100d.addActionListener (this);
	    frame.show ();
	}
	if (command == numbers5 [5]) //displaying math 100 layout
	{
	    contentPane.removeAll ();
	    math100layout.setLayout (new GridLayout (5, 1));
	    math100q = new JLabel ("100 - Which of the following is a compound angle formula?");
	    math100layout.setBackground (Color.BLUE);
	    math100q.setForeground (Color.YELLOW);
	    math100q.setFont (fontclr2);
	    math100a.setBackground (Color.BLUE);
	    math100a.setForeground (Color.YELLOW);
	    math100a.setFont (fontclr2);
	    math100b.setBackground (Color.BLUE);
	    math100b.setForeground (Color.YELLOW);
	    math100b.setFont (fontclr2);
	    math100c.setBackground (Color.BLUE);
	    math100c.setForeground (Color.YELLOW);
	    math100c.setFont (fontclr2);
	    math100d.setBackground (Color.BLUE);
	    math100d.setForeground (Color.YELLOW);
	    math100d.setFont (fontclr2);
	    math100layout.add (math100q);
	    math100layout.add (math100a);
	    math100layout.add (math100b);
	    math100layout.add (math100c);
	    math100layout.add (math100d);
	    contentPane.add (math100layout, BorderLayout.WEST);
	    contentPane.add (Math100Pic, BorderLayout.CENTER);
	    math100a.addActionListener (this);
	    math100b.addActionListener (this);
	    math100c.addActionListener (this);
	    math100d.addActionListener (this);
	    frame.show ();
	}
	gameover = ToDo (command);
	if (gameover == true)
	{
	    try
	    {
		Thread.sleep (100);
		contentPane.removeAll ();
		frame.repaint ();
	    }
	    catch (InterruptedException ex)
	    {
	    }
	    EndScreen ();
	    gameover = false;

	}
	if (command == Playagain)
	{
	    contentPane.removeAll ();
	    frame.repaint ();
	    IntroScreen (LoginInfo);
	    resetall ();
	    score.setText ("Score:");
	    scorecount.setText (null);
	    counter = 0;
	    FormatingButtons ();
	    LayoutButtons ();
	    gameover = false;
	    contentPane.add (TitlePanel, BorderLayout.NORTH);
	    contentPane.add (layout, BorderLayout.CENTER);
	    contentPane.add (south, BorderLayout.SOUTH);
	    frame.show ();
	    //////////////////////////////////////////
	    returnmain.addActionListener (this);
	}
    }


    public void resetall ()
    {
	contentPane.removeAll ();
	frame.repaint ();
	sports500layout.removeAll ();
	sports400layout.removeAll ();
	sports300layout.removeAll ();
	sports200layout.removeAll ();
	sports100layout.removeAll ();
	entertainment500layout.removeAll ();
	entertainment400layout.removeAll ();
	entertainment300layout.removeAll ();
	entertainment200layout.removeAll ();
	entertainment100layout.removeAll ();
	java500layout.removeAll ();
	java400layout.removeAll ();
	java300layout.removeAll ();
	java200layout.removeAll ();
	java100layout.removeAll ();
	math100layout.removeAll ();
	math200layout.removeAll ();
	math300layout.removeAll ();
	math400layout.removeAll ();
	math500layout.removeAll ();
	gk100layout.removeAll ();
	gk200layout.removeAll ();
	gk300layout.removeAll ();
	gk400layout.removeAll ();
	gk500layout.removeAll ();
	winlayout.removeAll ();
	losslayout.removeAll ();
	TitlePanel.removeAll ();
	south.removeAll ();
	sports500a.setEnabled (true); //Following are all the Radiobuttons for all the answer options
	sports500b.setEnabled (true);
	sports500c.setEnabled (true);
	sports500d.setEnabled (true);
	entertainment500a.setEnabled (true);
	entertainment500b.setEnabled (true);
	entertainment500c.setEnabled (true);
	entertainment500d.setEnabled (true);
	java500a.setEnabled (true);
	java500b.setEnabled (true);
	java500c.setEnabled (true);
	java500d.setEnabled (true);
	gk500a.setEnabled (true);
	gk500b.setEnabled (true);
	gk500c.setEnabled (true);
	gk500d.setEnabled (true);
	math500a.setEnabled (true);
	math500b.setEnabled (true);
	math500c.setEnabled (true);
	math500d.setEnabled (true);
	sports400a.setEnabled (true);
	sports400b.setEnabled (true);
	sports400c.setEnabled (true);
	sports400d.setEnabled (true);
	entertainment400a.setEnabled (true);
	entertainment400b.setEnabled (true);
	entertainment400c.setEnabled (true);
	entertainment400d.setEnabled (true);
	java400a.setEnabled (true);
	java400b.setEnabled (true);
	java400c.setEnabled (true);
	java400d.setEnabled (true);
	gk400a.setEnabled (true);
	gk400b.setEnabled (true);
	gk400c.setEnabled (true);
	gk400d.setEnabled (true);
	math400a.setEnabled (true);
	math400b.setEnabled (true);
	math400c.setEnabled (true);
	math400d.setEnabled (true);
	sports300a.setEnabled (true);
	sports300b.setEnabled (true);
	sports300c.setEnabled (true);
	sports300d.setEnabled (true);
	entertainment300a.setEnabled (true);
	entertainment300b.setEnabled (true);
	entertainment300c.setEnabled (true);
	entertainment300d.setEnabled (true);
	java300a.setEnabled (true);
	java300b.setEnabled (true);
	java300c.setEnabled (true);
	java300d.setEnabled (true);
	gk300a.setEnabled (true);
	gk300b.setEnabled (true);
	gk300c.setEnabled (true);
	gk300d.setEnabled (true);
	math300a.setEnabled (true);
	math300b.setEnabled (true);
	math300c.setEnabled (true);
	math300d.setEnabled (true);
	sports200a.setEnabled (true);
	sports200b.setEnabled (true);
	sports200c.setEnabled (true);
	sports200d.setEnabled (true);
	gk200a.setEnabled (true);
	gk200b.setEnabled (true);
	gk200c.setEnabled (true);
	gk200d.setEnabled (true);
	math200a.setEnabled (true);
	math200b.setEnabled (true);
	math200c.setEnabled (true);
	math200d.setEnabled (true);
	sports100a.setEnabled (true);
	sports100b.setEnabled (true);
	sports100c.setEnabled (true);
	sports100d.setEnabled (true);
	entertainment200a.setEnabled (true);
	entertainment200b.setEnabled (true);
	entertainment200c.setEnabled (true);
	entertainment200d.setEnabled (true);
	entertainment100a.setEnabled (true);
	entertainment100b.setEnabled (true);
	entertainment100c.setEnabled (true);
	entertainment100d.setEnabled (true);
	java200a.setEnabled (true);
	java200b.setEnabled (true);
	java200c.setEnabled (true);
	java200d.setEnabled (true);
	java100a.setEnabled (true);
	java100b.setEnabled (true);
	java100c.setEnabled (true);
	java100d.setEnabled (true);
	gk100a.setEnabled (true);
	gk100b.setEnabled (true);
	gk100c.setEnabled (true);
	gk100d.setEnabled (true);
	math100a.setEnabled (true);
	math100b.setEnabled (true);
	math100c.setEnabled (true);
	math100d.setEnabled (true);
	sports500a.setSelected (false);
	sports500b.setSelected (false);
	sports500c.setSelected (false);
	sports500d.setSelected (false);
	entertainment500a.setSelected (false);
	entertainment500b.setSelected (false);
	entertainment500c.setSelected (false);
	entertainment500d.setSelected (false);
	java500a.setSelected (false);
	java500b.setSelected (false);
	java500c.setSelected (false);
	java500d.setSelected (false);
	gk500a.setSelected (false);
	gk500b.setSelected (false);
	gk500c.setSelected (false);
	gk500d.setSelected (false);
	math500a.setSelected (false);
	math500b.setSelected (false);
	math500c.setSelected (false);
	math500d.setSelected (false);
	sports400a.setSelected (false);
	sports400b.setSelected (false);
	sports400c.setSelected (false);
	sports400d.setSelected (false);
	entertainment400a.setSelected (false);
	entertainment400b.setSelected (false);
	entertainment400c.setSelected (false);
	entertainment400d.setSelected (false);
	java400a.setSelected (false);
	java400b.setSelected (false);
	java400c.setSelected (false);
	java400d.setSelected (false);
	gk400a.setSelected (false);
	gk400b.setSelected (false);
	gk400c.setSelected (false);
	gk400d.setSelected (false);
	math400a.setSelected (false);
	math400b.setSelected (false);
	math400c.setSelected (false);
	math400d.setSelected (false);
	sports300a.setSelected (false);
	sports300b.setSelected (false);
	sports300c.setSelected (false);
	sports300d.setSelected (false);
	entertainment300a.setSelected (false);
	entertainment300b.setSelected (false);
	entertainment300c.setSelected (false);
	entertainment300d.setSelected (false);
	java300a.setSelected (false);
	java300b.setSelected (false);
	java300c.setSelected (false);
	java300d.setSelected (false);
	gk300a.setSelected (false);
	gk300b.setSelected (false);
	gk300c.setSelected (false);
	gk300d.setSelected (false);
	math300a.setSelected (false);
	math300b.setSelected (false);
	math300c.setSelected (false);
	math300d.setSelected (false);
	sports200a.setSelected (false);
	sports200b.setSelected (false);
	sports200c.setSelected (false);
	sports200d.setSelected (false);
	gk200a.setSelected (false);
	gk200b.setSelected (false);
	gk200c.setSelected (false);
	gk200d.setSelected (false);
	math200a.setSelected (false);
	math200b.setSelected (false);
	math200c.setSelected (false);
	math200d.setSelected (false);
	sports100a.setSelected (false);
	sports100b.setSelected (false);
	sports100c.setSelected (false);
	sports100d.setSelected (false);
	entertainment200a.setSelected (false);
	entertainment200b.setSelected (false);
	entertainment200c.setSelected (false);
	entertainment200d.setSelected (false);
	entertainment100a.setSelected (false);
	entertainment100b.setSelected (false);
	entertainment100c.setSelected (false);
	entertainment100d.setSelected (false);
	java200a.setSelected (false);
	java200b.setSelected (false);
	java200c.setSelected (false);
	java200d.setSelected (false);
	java100a.setSelected (false);
	java100b.setSelected (false);
	java100c.setSelected (false);
	java100d.setSelected (false);
	gk100a.setSelected (false);
	gk100b.setSelected (false);
	gk100c.setSelected (false);
	gk100d.setSelected (false);
	math100a.setSelected (false);
	math100b.setSelected (false);
	math100c.setSelected (false);
	math100d.setSelected (false);
    }


    ///////////////////////////////
    public void FormatingButtons ()  //formatting buttons with colors, fonts etc.
    {
	layout.removeAll ();
	scorecount.setText (null);
	south.removeAll ();
	frame.repaint ();
	scorecount.setForeground (Color.yellow);
	scorecount.setFont (fontclr2);
	title.setForeground (Color.YELLOW);
	layout.setBackground (Color.blue);
	TitlePanel.setBackground (Color.blue);
	title.setFont (HeadingFont);
	TitlePanel.add (title);
	south.setLayout (new BorderLayout ());
	south.setBackground (Color.BLUE);
	score.setForeground (Color.YELLOW);
	score.setFont (fontclr2);
	exit.setFont (font2);
	exit.setBorderPainted (false);
	exit.setFocusPainted (false);
	exit.setForeground (Color.yellow);
	exit.setBackground (Color.blue);
	south.add (score, BorderLayout.WEST);
	south.add (scorecount, BorderLayout.CENTER);
	south.add (exit, BorderLayout.EAST);
	layout.setLayout (new GridLayout (7, 4));
	SportsCol.setBackground (Color.BLUE);
	SportsCol.setForeground (Color.YELLOW);
	SportsCol.setFont (fontclr2);
	SportsCol.setBorderPainted (false);
	SportsCol.setFocusPainted (false);
	EntertainmentCol.setBackground (Color.BLUE);
	EntertainmentCol.setForeground (Color.YELLOW);
	EntertainmentCol.setFont (fontclr2);
	EntertainmentCol.setBorderPainted (false);
	EntertainmentCol.setFocusPainted (false);
	JavaCol.setBackground (Color.BLUE);
	JavaCol.setForeground (Color.YELLOW);
	JavaCol.setFont (fontclr2);
	JavaCol.setBorderPainted (false);
	JavaCol.setFocusPainted (false);
	GkCol.setBackground (Color.BLUE);
	GkCol.setForeground (Color.YELLOW);
	GkCol.setFont (fontclr2);
	GkCol.setBorderPainted (false);
	GkCol.setFocusPainted (false);
	MathCol.setBackground (Color.BLUE);
	MathCol.setForeground (Color.YELLOW);
	MathCol.setFont (fontclr2);
	MathCol.setBorderPainted (false);
	MathCol.setFocusPainted (false);
	layout.add (SportsCol);
	layout.add (EntertainmentCol);
	layout.add (JavaCol);
	layout.add (GkCol);
	layout.add (MathCol);
	exit.addActionListener (this);
    }


    public void LayoutButtons ()  //declaring the layout buttons
    {
	for (int count = 0 ; count < 6 ; count++)
	{
	    numbers [count] = new JButton ("500");
	    numbers [count].setBackground (Color.BLUE);
	    numbers [count].setForeground (Color.YELLOW);
	    numbers [count].setFont (sub);
	    numbers [count].addActionListener (this);
	    numbers2 [count] = new JButton ("400");
	    numbers2 [count].setBackground (Color.BLUE);
	    numbers2 [count].setForeground (Color.YELLOW);
	    numbers2 [count].setFont (sub);
	    numbers2 [count].addActionListener (this);
	    numbers3 [count] = new JButton ("300");
	    numbers3 [count].setBackground (Color.BLUE);
	    numbers3 [count].setForeground (Color.YELLOW);
	    numbers3 [count].setFont (sub);
	    numbers3 [count].addActionListener (this);
	    numbers4 [count] = new JButton ("200");
	    numbers4 [count].setBackground (Color.BLUE);
	    numbers4 [count].setForeground (Color.YELLOW);
	    numbers4 [count].setFont (sub);
	    numbers4 [count].addActionListener (this);
	    numbers5 [count] = new JButton ("100");
	    numbers5 [count].setBackground (Color.BLUE);
	    numbers5 [count].setForeground (Color.YELLOW);
	    numbers5 [count].setFont (sub);
	    numbers5 [count].addActionListener (this);
	}
	for (int count = 1 ; count <= 5 ; count++) //printing out the buttons on screen
	{
	    layout.add (numbers [count]);
	}
	for (int count = 1 ; count <= 5 ; count++)
	{
	    layout.add (numbers2 [count]);
	}
	for (int count = 1 ; count <= 5 ; count++)
	{
	    layout.add (numbers3 [count]);
	}
	for (int count = 1 ; count <= 5 ; count++)
	{
	    layout.add (numbers4 [count]);
	}
	for (int count = 1 ; count <= 5 ; count++)
	{
	    layout.add (numbers5 [count]);
	}
	///////////////////////////////////////
	layout.setBackground (Color.BLUE);
    }


    public boolean ToDo (Object command)
    {
	boolean right = false;
	boolean wrong = false;
	if (command == returnmain) //after option chosen, it will go back to main layout screen
	{
	    contentPane.removeAll ();
	    contentPane.add (TitlePanel, BorderLayout.NORTH);
	    contentPane.add (layout, BorderLayout.CENTER);
	    contentPane.add (south, BorderLayout.SOUTH);
	    contentPane.repaint ();
	    frame.show ();
	}
	if (command == sports500a) //the following are if statements if they got an answer right, it will call win layout, otherwise lose layout
	{
	    counter += 500; //adds the counter because answer is right
	    sports500b.setEnabled (false); //disables buttons
	    sports500c.setEnabled (false); //
	    sports500d.setEnabled (false); //
	    scorecount.setText ("" + counter); //displaying the score
	    winlayout.add (returnmain); //displaying the return button
	    contentPane.add (winlayout, BorderLayout.SOUTH); //adding win layout to the Jframe
	    frame.show ();
	    numbers [1].setEnabled (false); //displaying the sports 500 category button
	    right = true;
	}
	//REPETITIVE PROCESS FOR EACH ONE
	if (command == sports500b)
	{
	    counter -= 500;
	    sports500a.setEnabled (false);
	    sports500c.setEnabled (false);
	    sports500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports500c)
	{
	    counter -= 500;
	    sports500b.setEnabled (false);
	    sports500a.setEnabled (false);
	    sports500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports500d)
	{
	    counter -= 500;
	    sports500a.setEnabled (false);
	    sports500b.setEnabled (false);
	    sports500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [1].setEnabled (false);
	    wrong = true;
	}

	if (command == entertainment500b)
	{
	    counter += 500;
	    entertainment500a.setEnabled (false);
	    entertainment500c.setEnabled (false);
	    entertainment500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [2].setEnabled (false);
	    right = true;
	}
	if (command == entertainment500c)
	{
	    counter -= 500;
	    entertainment500a.setEnabled (false);
	    entertainment500b.setEnabled (false);
	    entertainment500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [2].setEnabled (false);
	    wrong = true;

	}
	if (command == entertainment500d)
	{
	    counter -= 500;
	    entertainment500a.setEnabled (false);
	    entertainment500c.setEnabled (false);
	    entertainment500b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment500a)
	{
	    counter -= 500;
	    entertainment500b.setEnabled (false);
	    entertainment500c.setEnabled (false);
	    entertainment500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [2].setEnabled (false);
	    wrong = true;
	}
	if (command == java500d)
	{
	    counter += 500;
	    java500a.setEnabled (false);
	    java500c.setEnabled (false);
	    java500b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [3].setEnabled (false);
	    right = true;
	}
	if (command == java500a)
	{
	    counter -= 500;
	    java500d.setEnabled (false);
	    java500c.setEnabled (false);
	    java500b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java500b)
	{
	    counter -= 500;
	    java500d.setEnabled (false);
	    java500c.setEnabled (false);
	    java500b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java500c)
	{
	    counter -= 500;
	    java500a.setEnabled (false);
	    java500d.setEnabled (false);
	    java500b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [3].setEnabled (false);
	    wrong = true;
	}
	if (command == sports400a)
	{
	    counter += 400;
	    sports400d.setEnabled (false);
	    sports400c.setEnabled (false);
	    sports400b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [1].setEnabled (false);
	    right = true;
	}
	if (command == sports400c)
	{
	    counter -= 400;
	    sports400d.setEnabled (false);
	    sports400a.setEnabled (false);
	    sports400b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports400b)
	{
	    counter -= 400;
	    sports400d.setEnabled (false);
	    sports400c.setEnabled (false);
	    sports400a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports400d)
	{
	    counter -= 400;
	    sports400a.setEnabled (false);
	    sports400c.setEnabled (false);
	    sports400b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment400c)
	{
	    counter += 400;
	    entertainment400b.setEnabled (false);
	    entertainment400a.setEnabled (false);
	    entertainment400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [2].setEnabled (false);
	    right = true;
	}
	if (command == entertainment400a)
	{
	    counter -= 400;
	    entertainment400b.setEnabled (false);
	    entertainment400c.setEnabled (false);
	    entertainment400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment400b)
	{
	    counter -= 400;
	    entertainment400c.setEnabled (false);
	    entertainment400a.setEnabled (false);
	    entertainment400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment400d)
	{
	    counter -= 400;
	    entertainment400b.setEnabled (false);
	    entertainment400a.setEnabled (false);
	    entertainment400c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == java400a)
	{
	    counter += 400;
	    java400c.setEnabled (false);
	    java400b.setEnabled (false);
	    java400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [3].setEnabled (false);
	    right = true;
	}
	if (command == java400b)
	{
	    counter -= 400;
	    java400c.setEnabled (false);
	    java400a.setEnabled (false);
	    java400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java400c)
	{
	    counter -= 400;
	    java400b.setEnabled (false);
	    java400a.setEnabled (false);
	    java400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java400d)
	{
	    counter -= 400;
	    java400c.setEnabled (false);
	    java400a.setEnabled (false);
	    java400b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == sports300c)
	{
	    counter += 300;
	    sports300d.setEnabled (false);
	    sports300b.setEnabled (false);
	    sports300a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [1].setEnabled (false);
	    right = true;
	}
	if (command == sports300b)
	{
	    counter -= 300;
	    sports300d.setEnabled (false);
	    sports300c.setEnabled (false);
	    sports300a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports300a)
	{
	    counter -= 300;
	    sports300d.setEnabled (false);
	    sports300b.setEnabled (false);
	    sports300c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports300d)
	{
	    counter -= 300;
	    sports300c.setEnabled (false);
	    sports300b.setEnabled (false);
	    sports300a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment300a)
	{
	    counter += 300;
	    entertainment300d.setEnabled (false);
	    entertainment300c.setEnabled (false);
	    entertainment300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [2].setEnabled (false);
	    right = true;
	}
	if (command == entertainment300c)
	{
	    counter -= 300;
	    entertainment300d.setEnabled (false);
	    entertainment300a.setEnabled (false);
	    entertainment300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment300b)
	{
	    counter -= 300;
	    entertainment300d.setEnabled (false);
	    entertainment300c.setEnabled (false);
	    entertainment300a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment300d)
	{
	    counter -= 300;
	    entertainment300a.setEnabled (false);
	    entertainment300c.setEnabled (false);
	    entertainment300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == java300d)
	{
	    counter += 300;
	    java300c.setEnabled (false);
	    java300a.setEnabled (false);
	    java300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [3].setEnabled (false);
	    right = true;
	}
	if (command == java300a)
	{
	    counter -= 300;
	    java300c.setEnabled (false);
	    java300d.setEnabled (false);
	    java300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java300b)
	{
	    counter -= 300;
	    java300c.setEnabled (false);
	    java300a.setEnabled (false);
	    java300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java300c)
	{
	    counter -= 300;
	    java300d.setEnabled (false);
	    java300a.setEnabled (false);
	    java300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == sports200c)
	{
	    counter += 200;
	    sports200a.setEnabled (false);
	    sports200b.setEnabled (false);
	    sports200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [1].setEnabled (false);
	    right = true;
	}
	if (command == sports200a)
	{
	    counter -= 200;
	    sports200c.setEnabled (false);
	    sports200b.setEnabled (false);
	    sports200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports200b)
	{
	    counter -= 200;
	    sports200a.setEnabled (false);
	    sports200c.setEnabled (false);
	    sports200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports200d)
	{
	    counter -= 200;
	    sports200a.setEnabled (false);
	    sports200b.setEnabled (false);
	    sports200c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment200d)
	{
	    counter += 200;
	    entertainment200c.setEnabled (false);
	    entertainment200b.setEnabled (false);
	    entertainment200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [2].setEnabled (false);
	    right = true;
	}
	if (command == entertainment200a)
	{
	    counter -= 200;
	    entertainment200c.setEnabled (false);
	    entertainment200b.setEnabled (false);
	    entertainment200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment200b)
	{
	    counter -= 200;
	    entertainment200c.setEnabled (false);
	    entertainment200d.setEnabled (false);
	    entertainment200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment200c)
	{
	    counter -= 200;
	    entertainment200d.setEnabled (false);
	    entertainment200b.setEnabled (false);
	    entertainment200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == java200c)
	{
	    counter += 200;
	    java200d.setEnabled (false);
	    java200b.setEnabled (false);
	    java200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [3].setEnabled (false);
	    right = true;
	}
	if (command == java200a)
	{
	    counter -= 200;
	    java200d.setEnabled (false);
	    java200b.setEnabled (false);
	    java200c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java200b)
	{
	    counter -= 200;
	    java200d.setEnabled (false);
	    java200c.setEnabled (false);
	    java200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java200d)
	{
	    counter -= 200;
	    java200c.setEnabled (false);
	    java200b.setEnabled (false);
	    java200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == sports100a)
	{
	    counter += 100;
	    sports100b.setEnabled (false);
	    sports100c.setEnabled (false);
	    sports100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [1].setEnabled (false);
	    right = true;
	}
	if (command == sports100b)
	{
	    counter -= 100;
	    sports100a.setEnabled (false);
	    sports100c.setEnabled (false);
	    sports100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports100c)
	{
	    counter -= 100;
	    sports100b.setEnabled (false);
	    sports100a.setEnabled (false);
	    sports100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == sports100d)
	{
	    counter -= 100;
	    sports100b.setEnabled (false);
	    sports100c.setEnabled (false);
	    sports100a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    losslayout.setBackground (Color.blue);
	    frame.show ();
	    numbers5 [1].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment100a)
	{
	    counter += 100;
	    entertainment100d.setEnabled (false);
	    entertainment100c.setEnabled (false);
	    entertainment100b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [2].setEnabled (false);
	    right = true;
	}
	if (command == entertainment100b)
	{
	    counter -= 100;
	    entertainment100d.setEnabled (false);
	    entertainment100c.setEnabled (false);
	    entertainment100a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment100c)
	{
	    counter -= 100;
	    entertainment100d.setEnabled (false);
	    entertainment100a.setEnabled (false);
	    entertainment100b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == entertainment100d)
	{
	    counter -= 100;
	    entertainment100a.setEnabled (false);
	    entertainment100c.setEnabled (false);
	    entertainment100b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [2].setEnabled (false);
	    wrong = true;
	}
	if (command == java100d)
	{
	    counter += 100;
	    java100a.setEnabled (false);
	    java100c.setEnabled (false);
	    java100b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [3].setEnabled (false);
	    right = true;
	}
	if (command == java100a)
	{
	    counter -= 100;
	    java100d.setEnabled (false);
	    java100c.setEnabled (false);
	    java100b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java100b)
	{
	    counter -= 100;
	    java100a.setEnabled (false);
	    java100c.setEnabled (false);
	    java100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == java100c)
	{
	    counter -= 100;
	    java100a.setEnabled (false);
	    java100d.setEnabled (false);
	    java100b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [3].setEnabled (false);
	    wrong = true;
	}
	if (command == math500a)
	{
	    counter += 500;
	    math500c.setEnabled (false);
	    math500b.setEnabled (false);
	    math500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [5].setEnabled (false);
	    right = true;
	}
	if (command == math500b)
	{
	    counter -= 500;
	    math500c.setEnabled (false);
	    math500a.setEnabled (false);
	    math500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math500c)
	{
	    counter -= 500;
	    math500a.setEnabled (false);
	    math500b.setEnabled (false);
	    math500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math500d)
	{
	    counter -= 500;
	    math500c.setEnabled (false);
	    math500b.setEnabled (false);
	    math500a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math400a)
	{
	    counter -= 400;
	    math400c.setEnabled (false);
	    math400b.setEnabled (false);
	    math400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math400b)
	{
	    counter -= 400;
	    math400c.setEnabled (false);
	    math400a.setEnabled (false);
	    math400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math400c)
	{
	    counter += 400;
	    math400a.setEnabled (false);
	    math400b.setEnabled (false);
	    math400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [5].setEnabled (false);
	    right = true;
	}
	if (command == math400d)
	{
	    counter -= 400;
	    math400c.setEnabled (false);
	    math400b.setEnabled (false);
	    math400a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math300a)
	{
	    counter -= 300;
	    math300c.setEnabled (false);
	    math300b.setEnabled (false);
	    math300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math300b)
	{
	    counter -= 300;
	    math300c.setEnabled (false);
	    math300a.setEnabled (false);
	    math300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math300c)
	{
	    counter -= 300;
	    math300a.setEnabled (false);
	    math300b.setEnabled (false);
	    math300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math300d)
	{
	    counter += 300;
	    math300c.setEnabled (false);
	    math300b.setEnabled (false);
	    math300a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [5].setEnabled (false);
	    right = true;
	}
	if (command == math200a)
	{
	    counter -= 200;
	    math200c.setEnabled (false);
	    math200b.setEnabled (false);
	    math200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math200b)
	{
	    counter += 200;
	    math200c.setEnabled (false);
	    math200a.setEnabled (false);
	    math200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [5].setEnabled (false);
	    right = true;
	}
	if (command == math200c)
	{
	    counter -= 200;
	    math200a.setEnabled (false);
	    math200b.setEnabled (false);
	    math200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math200d)
	{
	    counter -= 200;
	    math200c.setEnabled (false);
	    math200b.setEnabled (false);
	    math200a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math100a)
	{
	    counter += 100;
	    math100c.setEnabled (false);
	    math100b.setEnabled (false);
	    math100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [5].setEnabled (false);
	    right = true;
	}
	if (command == math100b)
	{
	    counter -= 100;
	    math100c.setEnabled (false);
	    math100a.setEnabled (false);
	    math100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math100c)
	{
	    counter -= 100;
	    math100a.setEnabled (false);
	    math100b.setEnabled (false);
	    math100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == math100d)
	{
	    counter -= 100;
	    math100c.setEnabled (false);
	    math100b.setEnabled (false);
	    math100a.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [5].setEnabled (false);
	    wrong = true;
	}
	if (command == gk500c)
	{
	    counter += 500;
	    gk500a.setEnabled (false);
	    gk500b.setEnabled (false);
	    gk500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [4].setEnabled (false);

	    right = true;
	}
	if (command == gk500b)
	{
	    counter -= 500;
	    gk500a.setEnabled (false);
	    gk500c.setEnabled (false);
	    gk500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk500a)
	{
	    counter -= 500;
	    gk500c.setEnabled (false);
	    gk500b.setEnabled (false);
	    gk500d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk500d)
	{
	    counter -= 500;
	    gk500a.setEnabled (false);
	    gk500b.setEnabled (false);
	    gk500c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk400c)
	{
	    counter += 400;
	    gk400a.setEnabled (false);
	    gk400b.setEnabled (false);
	    gk400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [4].setEnabled (false);
	    right = true;
	}
	if (command == gk400b)
	{
	    counter -= 400;
	    gk400a.setEnabled (false);
	    gk400c.setEnabled (false);
	    gk400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk400a)
	{
	    counter -= 400;
	    gk400c.setEnabled (false);
	    gk400b.setEnabled (false);
	    gk400d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk400d)
	{
	    counter -= 400;
	    gk400a.setEnabled (false);
	    gk400b.setEnabled (false);
	    gk400c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers2 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk300b)
	{
	    counter += 300;
	    gk300a.setEnabled (false);
	    gk300c.setEnabled (false);
	    gk300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [4].setEnabled (false);
	    right = true;
	}
	if (command == gk300c)
	{
	    counter -= 300;
	    gk300a.setEnabled (false);
	    gk300b.setEnabled (false);
	    gk300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk300a)
	{
	    counter -= 300;
	    gk300b.setEnabled (false);
	    gk300c.setEnabled (false);
	    gk300d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk300d)
	{
	    counter -= 300;
	    gk300a.setEnabled (false);
	    gk300c.setEnabled (false);
	    gk300b.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers3 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk200a)
	{
	    counter -= 200;
	    gk200b.setEnabled (false);
	    gk200c.setEnabled (false);
	    gk200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [4].setEnabled (false);
	    right = true;
	}
	if (command == gk200b)
	{
	    counter -= 200;
	    gk200a.setEnabled (false);
	    gk200c.setEnabled (false);
	    gk200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk200c)
	{
	    counter -= 200;
	    gk200b.setEnabled (false);
	    gk200a.setEnabled (false);
	    gk200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk200d)
	{
	    counter -= 200;
	    gk200a.setEnabled (false);
	    gk200c.setEnabled (false);
	    gk200d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers4 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk100c)
	{
	    counter += 100;
	    gk100b.setEnabled (false);
	    gk100a.setEnabled (false);
	    gk100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    winlayout.add (returnmain);
	    contentPane.add (winlayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [4].setEnabled (false);
	    right = true;
	}
	if (command == gk100b)
	{
	    counter -= 100;
	    gk100c.setEnabled (false);
	    gk100a.setEnabled (false);
	    gk100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk100a)
	{
	    counter -= 100;
	    gk100b.setEnabled (false);
	    gk100c.setEnabled (false);
	    gk100d.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [4].setEnabled (false);
	    wrong = true;
	}
	if (command == gk100d)
	{
	    counter -= 100;
	    gk100b.setEnabled (false);
	    gk100a.setEnabled (false);
	    gk100c.setEnabled (false);
	    scorecount.setText ("" + counter);
	    losslayout.add (returnmain);
	    contentPane.add (losslayout, BorderLayout.SOUTH);
	    frame.show ();
	    numbers5 [4].setEnabled (false);
	    wrong = true;
	}
	if (right == true)
	{
	    //PlaySound (right);
	    gameover = gameovercheck ();
	    right = false;
	}
	else if (wrong == true)
	{
	    //PlaySound3 ();
	    gameover = gameovercheck ();
	    wrong = false;
	}
	return gameover;
    }


    public boolean gameovercheck ()
    {
	for (int count2 = 1 ; count2 < 6 ; count2++)
	{
	    if (numbers [count2].isEnabled () == false && numbers2 [count2].isEnabled () == false && numbers3 [count2].isEnabled () == false && numbers4 [count2].isEnabled () == false && numbers5 [count2].isEnabled () == false)
	    {
		gameover = true;
	    }
	    else
	    {
		gameover = false;
		break;
	    }
	}
	return gameover;

    }


    ///////////////////////////////

    public void mouseEntered (MouseEvent e)  //Method for hovering the mouse over button, highlights it
    {
	if (e.getComponent () instanceof JButton)
	{
	    JButton jb = (JButton) e.getComponent ();
	    if (jb == yes)
	    {
		yes.setBackground (Color.blue);
	    }
	    else if (jb == no)
	    {
		no.setBackground (Color.blue);
	    }
	    else if (jb == returninguser)
	    {
		returninguser.setBackground (Color.black);
	    }
	    else if (jb == newuser)
	    {
		newuser.setBackground (Color.black);
	    }
	    else if (jb == play)
	    {
		play.setBackground (Color.black);
	    }
	    else if (jb == instruction)
	    {
		instruction.setBackground (Color.black);
	    }
	    else if (jb == Playagain)
	    {
		Playagain.setBackground (Color.black);
	    }
	    else if (jb == exit)
	    {
		exit.setBackground (Color.black);
	    }
	}


	else
	{
	}
    }


    public void mouseClicked (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
	if (e.getComponent () instanceof JButton)
	{
	    JButton jb = (JButton) e.getComponent ();
	    if (jb == yes)
	    {
		yes.setBackground (Color.black);
	    }
	    else if (jb == no)
	    {
		no.setBackground (Color.black);
	    }
	    if (jb == returninguser)
	    {
		returninguser.setBackground (Color.blue);
	    }
	    else if (jb == newuser)
	    {
		newuser.setBackground (Color.blue);
	    }
	    else if (jb == play)
	    {
		play.setBackground (Color.blue);
	    }
	    else if (jb == instruction)
	    {
		instruction.setBackground (Color.blue);
	    }
	    else if (jb == Playagain)
	    {
		Playagain.setBackground (Color.blue);
	    }
	    else if (jb == exit)
	    {
		exit.setBackground (Color.blue);
	    }

	}


	else
	{
	}
    }


    public void mousePressed (MouseEvent e)
    {
    }


    public void mouseReleased (MouseEvent e)
    {
    }


    public void screen1 ()  //Login screen that appears first
    {
	yes = new JButton ("Yes");
	yes.setPreferredSize (new Dimension (0, 10));
	no = new JButton ("No");
	yes.setBorderPainted (false);
	yes.setFocusPainted (false);
	no.setBorderPainted (false);
	no.setFocusPainted (false);
	////////////////////
	l = new JLabel ("   ARE YOU READY TO PLAY?");
	l.setFont (font);
	l.setForeground (Color.white);
	////////////////////
	yes.setFont (font2);
	yes.setForeground (Color.white);
	yes.setBackground (Color.blue);
	//////////////////
	no.setFont (font2);
	no.setForeground (Color.white);
	no.setBackground (Color.blue);
	///////////////////
	ready.setLayout (new GridLayout (2, 1));
	ready.setBackground (Color.blue);
	ready.add (yes);
	ready.add (no);
	//////////
	contentPane.setLayout (new BorderLayout ());
	contentPane.add (l, BorderLayout.NORTH);
	contentPane.add (ready, BorderLayout.SOUTH);
	contentPane.setBackground (Color.black);
	yes.addActionListener (this);
	no.addActionListener (this);
	yes.addMouseListener (this);
	no.addMouseListener (this);
	frame.show ();
    }


    public void yesbutton ()  //If yes clicked, then user will be given option of returning or new user
    {
	contentPane.removeAll ();
	contentPane.setLayout (new BorderLayout ());
	returninguser = new JButton ("Returning User");
	newuser = new JButton ("New User");
	////////////////////
	ReUser = new JLabel ("   Returning or New user?");
	ReUser.setFont (font);
	ReUser.setForeground (Color.yellow);
	////////////////////
	returninguser.setFont (font2);
	returninguser.setForeground (Color.yellow);
	returninguser.setBackground (Color.blue);
	//////////////////
	newuser.setFont (font2);
	newuser.setForeground (Color.yellow);
	newuser.setBackground (Color.blue);
	///////////////////
	returninguser.setBorderPainted (false);
	returninguser.setFocusPainted (false);
	newuser.setBorderPainted (false);
	newuser.setFocusPainted (false);
	Center.setLayout (new GridLayout (2, 1));
	Center.add (returninguser);
	Center.add (newuser);
	Center.setBackground (Color.black);
	contentPane.add (ReUser, BorderLayout.NORTH);
	contentPane.add (Center, BorderLayout.SOUTH);
	contentPane.setBackground (Color.blue);
	returninguser.addActionListener (this);
	newuser.addActionListener (this);
	returninguser.addMouseListener (this);
	newuser.addMouseListener (this);
	frame.show ();
    }


    public void nobutton ()  //displaying a goodbye message
    {
	contentPane.removeAll ();
	frame.repaint ();
	ready.removeAll ();
	ready.setLayout (new BorderLayout ());
	nooutput = new JLabel ("   Bye, Please Come Again.");
	nooutput.setFont (font);
	nooutput.setForeground (Color.white);
	exit.setBorderPainted (false);
	exit.setFocusPainted (false);
	exit.setFont (font2);
	exit.setForeground (Color.white);
	exit.setBackground (Color.black);
	ready.add (nooutput, BorderLayout.NORTH);
	ready.add (exit, BorderLayout.SOUTH);
	contentPane.add (ready, BorderLayout.CENTER);
	frame.show ();
	exit.addActionListener (this);
	ready.setBackground (Color.black);
    }


    public void returninguserbutton ()  // method for the returning user button
	throws java.io.IOException
    {
	FileReader fr = new FileReader ("UserInfo.txt");
	BufferedReader bfr = new BufferedReader (fr);
	username.setText (null);
	LoginPassword.setText (null);
	contentPane.remove (ReUser);
	contentPane.remove (Center);
	back.setFont (font3);
	back.setForeground (Color.white);
	back.setBackground (Color.blue);
	back.setBorderPainted (false);
	back.setFocusPainted (false);
	contentPane.setLayout (new FlowLayout (1, 0, 10));
	fileusername = bfr.readLine ();
	fileEmail = bfr.readLine ();
	filepassword = bfr.readLine ();
	fr.close ();
	Login = new JButton ("Log in");
	Login.setBorderPainted (false);
	Login.setFocusPainted (false);
	Reset = new JButton ("Reset");
	Reset.setBorderPainted (false);
	Reset.setFocusPainted (false);
	CorrectInfo = new JLabel ("");
	returningtitle = new JLabel ("        Please fill out the following fields:");
	space = new JLabel ("                                                                                                                                                                                                                                                                                              Space");
	space2 = new JLabel ("                                                                                                                                                                                                                                                                                              Space");
	user = new JLabel ("    Username or Email:");
	pass = new JLabel ("                  Password:");
	/////////////
	CorrectInfo.setForeground (Color.yellow);
	CorrectInfo.setFont (font3);
	returningtitle.setForeground (Color.yellow);
	returningtitle.setFont (font2);
	Login.setFont (font3);
	Login.setForeground (Color.white);
	Login.setBackground (Color.blue);
	Reset.setFont (font3);
	Reset.setForeground (Color.white);
	Reset.setBackground (Color.blue);
	user.setForeground (Color.yellow);
	user.setFont (font2);
	pass.setForeground (Color.yellow);
	pass.setFont (font2);
	//////////////////////
	username.setBackground (Color.white);
	username.setForeground (Color.black);
	LoginPassword.setBackground (Color.white);
	LoginPassword.setForeground (Color.black);
	//////////////////////
	contentPane.add (returningtitle);
	contentPane.add (space);
	contentPane.add (user);
	contentPane.add (username);
	contentPane.add (pass);
	contentPane.add (LoginPassword);
	contentPane.add (space2);
	contentPane.add (Login);
	contentPane.add (CorrectInfo);
	contentPane.add (Reset);
	contentPane.add (back);
	contentPane.setBackground (Color.black);
	Login.addActionListener (this);
	Reset.addActionListener (this);
	back.addActionListener (this);
	frame.show ();
    }


    public boolean login ()  // method for the login code
    {
	compareUname = username.getText ();
	compareEmail = username.getText ();
	comparePass = LoginPassword.getText ();
	if (compareUname.equals (fileusername) ^ compareEmail.equals (fileEmail) && comparePass.equals (filepassword))
	{
	    CorrectInfo.setText ("Enjoy the Game!!");
	    LoginInfo = true;
	}


	else if (compareUname.equals ("") && compareEmail.equals ("") && comparePass.equals (""))
	{
	    JOptionPane.showMessageDialog (frame, "Missing All Fields");
	    LoginInfo = false;
	}


	else if (!compareUname.equals ("") && !compareEmail.equals ("") && !comparePass.equals ("") && !compareUname.equals (fileusername) && !compareEmail.equals (fileEmail) && comparePass.equals (filepassword))
	{
	    JOptionPane.showMessageDialog (frame, "Incorrect Username/Email");
	    LoginInfo = false;
	}


	else if (!compareUname.equals ("") && !compareEmail.equals ("") && !comparePass.equals ("") && !comparePass.equals (filepassword) && compareUname.equals (fileusername) || compareEmail.equals (fileEmail))
	{
	    JOptionPane.showMessageDialog (frame, "Incorrect Password");
	    LoginInfo = false;
	}


	else
	{
	    JOptionPane.showMessageDialog (frame, "Incorrect Password and Username");
	    LoginInfo = false;
	}


	PlayerName = compareUname;
	return LoginInfo;
    }



    public void newuserbutton ()
    {
	frame.setSize (700, 500);
	contentPane.removeAll ();
	contentPane.setLayout (new FlowLayout (1, 0, 5));
	Reset = new JButton ("Reset");
	Reset.setBorderPainted (false);
	Reset.setFocusPainted (false);
	Reset.setFont (font3);
	Reset.setForeground (Color.white);
	Reset.setBackground (Color.blue);
	back.setFont (font3);
	back.setForeground (Color.white);
	back.setBackground (Color.blue);
	back.setBorderPainted (false);
	back.setFocusPainted (false);
	UserReturn.setLayout (new GridLayout (6, 2));
	Signup = new JButton ("Sign Up");
	returningtitle = new JLabel ("        Please fill out the following fields:");
	space = new JLabel ("                                                                                                                                                                                                                                                                                              Space");
	space2 = new JLabel ("                                                                                                                                                                                                                                                                                              Space");
	CorrectInfo = new JLabel ("");
	name = new JLabel ("         Name:");
	lastname = new JLabel ("         Last Name:");
	user = new JLabel ("         Username:");
	pass = new JLabel ("         Password:");
	email = new JLabel ("         Email:");
	PassRequirements = new JLabel ("        Password Requirements: 1 uppercase, 1 lowercase,  ");
	PassRequirements2 = new JLabel ("1 number and has more than 5 characters");
	/////////////
	CorrectInfo.setForeground (Color.yellow);
	CorrectInfo.setFont (font3);
	returningtitle.setForeground (Color.yellow);
	returningtitle.setFont (font2);
	Signup.setFont (font3);
	Signup.setForeground (Color.white);
	Signup.setBackground (Color.blue);
	Signup.setBorderPainted (false);
	Signup.setFocusPainted (false);
	/////////////////
	name.setForeground (Color.yellow);
	name.setFont (font2);
	lastname.setForeground (Color.yellow);
	lastname.setFont (font2);
	user.setForeground (Color.yellow);
	user.setFont (font2);
	pass.setForeground (Color.yellow);
	pass.setFont (font2);
	email.setForeground (Color.yellow);
	email.setFont (font2);
	PassRequirements.setForeground (Color.yellow);
	PassRequirements.setFont (font4);
	PassRequirements2.setForeground (Color.yellow);
	PassRequirements2.setFont (font4);
	//////////////////////
	namebox.setBackground (Color.white);
	namebox.setForeground (Color.black);
	lastnamebox.setBackground (Color.white);
	lastnamebox.setForeground (Color.black);
	username.setBackground (Color.white);
	username.setForeground (Color.black);
	password.setBackground (Color.white);
	password.setForeground (Color.black);
	Emailbox.setBackground (Color.white);
	Emailbox.setForeground (Color.black);
	//////////////////////
	contentPane.add (returningtitle);
	contentPane.add (space);
	/////////////////////
	UserReturn.add (name);
	UserReturn.add (namebox);
	UserReturn.add (lastname);
	UserReturn.add (lastnamebox);
	UserReturn.add (user);
	UserReturn.add (username);
	UserReturn.add (pass);
	UserReturn.add (password);
	UserReturn.add (email);
	UserReturn.add (Emailbox);
	UserReturn.setBackground (Color.black);
	/////////////////////
	contentPane.add (UserReturn);
	contentPane.add (PassRequirements);
	contentPane.add (PassRequirements2);
	contentPane.add (space2);
	contentPane.add (Signup);
	contentPane.add (CorrectInfo);
	contentPane.add (Reset);
	contentPane.add (back);
	contentPane.setBackground (Color.black);
	frame.setSize (600, 400);
	Signup.addActionListener (this);
	Reset.addActionListener (this);
	back.addActionListener (this);
	frame.show ();
    }


    public boolean signup ()
	throws java.io.IOException
    {
	FileWriter fw = new FileWriter ("UserInfo.txt");
	if (!namebox.getText ().equals ("") && !lastnamebox.getText ().equals ("") && !username.getText ().equals ("") && !password.getText ().equals ("") && !Emailbox.getText ().equals (""))
	{
	    CorrectInfo.setText ("Enjoy the Game!!");
	    fw.write (username.getText () + "\r\n");
	    fw.write (Emailbox.getText () + "\r\n");
	    fw.write (password.getText () + "\r\n");
	    fw.write (namebox.getText () + "\r\n");
	    fw.write (lastnamebox.getText () + "\r\n");
	    SignupInfo = true;
	}


	else
	{
	    CorrectInfo.setText ("Missing Some Fields");
	    SignupInfo = false;
	}


	fw.close ();
	PlayerName = username.getText ();
	return SignupInfo;
    }


//    public void PlaySound (int num, boolean again)  //OVERLOADING THE SOUND METHOD
//    {
//	if (num == 0)
//	{
//
//	    try
//	    {
//		InputStream in = new FileInputStream ("Jeopardy.au");
//		// Create an AudioStream object from the input stream.
//		AudioStream as = new AudioStream (in);
//		// Use the static class member "player" from class AudioPlayer to play
//		// clip.
//		AudioPlayer.player.start (as);
//		if (again == true)
//		{
//		    AudioPlayer.player.stop (as);
//		}
//	    }
//
//
//	    catch (FileNotFoundException exc)
//	    {
//		System.out.println ("Error with file");
//	    }
//
//
//	    catch (Exception exc)
//	    {
//		System.out.println ("Error with input");
//	    }
//	}
//    }
//
//
//    public void PlaySound (boolean right)  //OVERLOADING THE SOUND METHOD
//    {
//	if (right == true)
//	{
//
//	    try
//	    {
//		InputStream in = new FileInputStream ("clap.au");
//		// Create an AudioStream object from the input stream.
//		AudioStream as = new AudioStream (in);
//		// Use the static class member "player" from class AudioPlayer to play
//		// clip.
//		AudioPlayer.player.start (as);
//	    }
//
//
//	    catch (FileNotFoundException exc)
//	    {
//		System.out.println ("Error with file");
//	    }
//
//
//	    catch (Exception exc)
//	    {
//		System.out.println ("Error with input");
//	    }
//	}
//    }
//
//
//    public void PlaySound3 ()
//    {
//	try
//	{
//	    InputStream in = new FileInputStream ("Wrong.au");
//	    // Create an AudioStream object from the input stream.
//	    AudioStream as = new AudioStream (in);
//	    // Use the static class member "player" from class AudioPlayer to play
//	    // clip.
//	    AudioPlayer.player.start (as);
//	}
//
//
//	catch (FileNotFoundException exc)
//	{
//	    System.out.println ("Error with file");
//	}
//
//
//	catch (Exception exc)
//	{
//	    System.out.println ("Error with input");
//	}
//    }


    public void IntroScreen (boolean LoginInfo)
    {
	contentPane.removeAll ();
	MainMenuOP.removeAll ();
	frame.setExtendedState (JFrame.MAXIMIZED_BOTH);
	welcome = new JLabel ("        Welcome " + PlayerName + "! Get Ready to Play JEOPARDY");
	welcome.setForeground (Color.yellow);
	welcome.setFont (font);
	play.setForeground (Color.yellow);
	play.setBackground (Color.blue);
	play.setBorderPainted (false);
	play.setFocusPainted (false);
	play.setFont (font2);
	instruction.setForeground (Color.yellow);
	instruction.setBackground (Color.blue);
	instruction.setBorderPainted (false);
	instruction.setFocusPainted (false);
	instruction.setFont (font2);
	MainMenuOP.setLayout (new GridLayout (2, 1));
	contentPane.setLayout (new BorderLayout ());
	contentPane.add (welcome, BorderLayout.NORTH);
	contentPane.add (titlelogo, BorderLayout.CENTER);
	MainMenuOP.add (play);
	MainMenuOP.add (instruction);
	contentPane.add (MainMenuOP, BorderLayout.SOUTH);
	contentPane.setBackground (Color.blue);
	frame.show ();
	play.addActionListener (this);
	play.addMouseListener (this);
	instruction.addActionListener (this);
	instruction.addMouseListener (this);
    }


    public void EndScreen ()
    {
	contentPane.removeAll ();
	frame.repaint ();
	frame.setExtendedState (JFrame.MAXIMIZED_BOTH);
	end = new JLabel ("                    " + PlayerName + ",Would you like to Play Again?");
	end.setForeground (Color.yellow);
	end.setFont (font1);
	Playagain.setForeground (Color.yellow);
	Playagain.setBackground (Color.blue);
	Playagain.setBorderPainted (false);
	Playagain.setFocusPainted (false);
	Playagain.setFont (font2);
	exit.setFont (font2);
	exit.setBorderPainted (false);
	exit.setFocusPainted (false);
	exit.setForeground (Color.yellow);
	exit.setBackground (Color.blue);
	contentPane.setLayout (new BorderLayout ());
	again.setLayout (new GridLayout (2, 1));
	again.setBackground (Color.blue);
	again.add (Playagain);
	again.add (exit);
	contentPane.add (end, BorderLayout.NORTH);
	score.setText ("                           Score: " + counter);
	score.setFont (font);
	score.setForeground (Color.yellow);
	contentPane.add (score, BorderLayout.CENTER);
	contentPane.add (again, BorderLayout.SOUTH);
	contentPane.setBackground (Color.blue);
	frame.show ();
	Playagain.addActionListener (this);
	Playagain.addMouseListener (this);
	exit.addActionListener (this);
	exit.addMouseListener (this);
	counter = 0;
    }
}



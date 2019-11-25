import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*;
import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Random;
import java.util.Set;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class facebook {

	private JFrame frame;
	static String  value1;
	static int  en1;
	static WebDriver driver;
	static String st;
	static JTextArea text;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"chrome.exe -remote-debugging-port=3130 --user-data-dir=C:\\facebook\\deleteprofile");
					facebook window = new facebook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public facebook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 615, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSERT A YEAR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 108, 160, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton btnNewButton_1 = new JButton("STOP ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driver.quit();
				 JOptionPane.showMessageDialog(null,"process quited");
			}
		});
		btnNewButton_1.setBounds(53, 230, 160, 23);
		frame.getContentPane().add(btnNewButton_1);
		JScrollPane	scroll =new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 scroll.setBounds(244, 42, 319, 264);
		// scroll.setViewportView(textarea1);
			frame.getContentPane().add(scroll);
			
			 text = new JTextArea();
			 text.setEditable(false);
				text.setLineWrap(true);
			       text.setWrapStyleWord(true);
			       text.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
			scroll.setViewportView(text);
			
			JButton btnNewButton = new JButton("INITIATE PROCESS");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// String varName = (String)comboBox.getSelectedItem();
					
					
				//	 value1 = comboBox.getSelectedItem().toString();
					
					/*getting user input for the given year */
					
					 value1=textField.getText();
					
					//initializing a global variable to use the date accross the programm
					
					 en1 = Integer.parseInt(value1);
					facebook();
				}
			});
			btnNewButton.setBounds(53, 180, 160, 23);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("CONCEPT AND DEVELOPED BY MAHBUB ISLAM");
			lblNewLabel_1.setBackground(Color.BLACK);
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(215, 324, 374, 38);
			frame.getContentPane().add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setBounds(53, 133, 160, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			/*	 */
	}
	private static void update(String st) {
		
		text.setText("STATUS:" +st );

		text.update(text.getGraphics());
		
}
	
	public static void facebook(){
		SwingWorker<Void,Void> dyna = new SwingWorker<Void,Void>()
				{

					@Override
					protected Void doInBackground() throws Exception {
						/*stting up chrome instances */
						System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
						
						

						  ChromeOptions options= new ChromeOptions();
						  
						  /*connecting to existing chrome session */
						options.setExperimentalOption("debuggerAddress","localhost:3130");
						 
						options.addArguments("start-maximized");
						
						Thread.sleep(9000);
						 driver= new ChromeDriver(options);
						 try{
							 Random r = new Random();
							 int low = 10000;
							 int high = 15000;
							 
							
							
							 final int delay = r.nextInt(high-low) + low;
							
							 
							 driver.get("https://www.google.com/");
							 Robot robot = new Robot();
							 robot.keyPress(KeyEvent.VK_F12);
							 robot.keyRelease(KeyEvent.VK_F12);
							 Thread.sleep(5000);
							st="Accessing facebook";
					        	
							 update(st);
							 
							 driver.get("https://m.facebook.com/");
							 
							 Thread.sleep(delay);
							 
							
							 st="loading message list";
					        	
							 update(st);
                           driver.get(" https://m.facebook.com/messages/?more");
							 
							 Thread.sleep(delay);
							 st="you have selecte to delete all the message from the year of"+value1+"";
					        	
							 update(st);
							 
							 Thread.sleep(delay);
							 
							 
							 st="searching all message from the year of "+value1+"";
					        	
							 update(st);
							 Thread.sleep(5000);
							 Actions builder = new Actions(driver);
							 
							//finding all the messages of the given year by finding webelements
							 for(int i=0;i<10;i++)
							 {
								 st ="searching message in this page from the year "+value1+" ";
							       
							     
								 update(st);
								try{
								 List<WebElement> mess = driver.findElements(By.xpath("//abbr[contains(text(),'"+value1+"')]"));
								 st ="Total messages found :"+mess.size();
							       
								     
									 update(st);
									 Thread.sleep(5000);
									 int size=mess.size();
									 //if no message found in current page then go to next page
									 if(size==0)
									 {
										 st ="should provoke error";
										 		
									       
									     
										 update(st);
										 
										 //making a bogus explicit wait for webelement that doesn't exist to fork catch block 
									 WebDriverWait wait3 = new WebDriverWait(driver,10); // Wait for 30 seconds.
									 wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[@class='time nowrap mfss fcl']//abbr[contains(text(),'"+value1+"')]")));
									 }
									 else{
										
										 try{
										 for(int q=0;q<=mess.size();q++)
										 {       
							            //if message found then click and delete it
										 st ="clicking message and finding detailst";
									       
									     
										 update(st);
									
									String main=driver.getWindowHandle();
									
										//*[@id="root"]/div[1]/div/div[1]/div
									 WebElement selv=mess.get(q);
										builder.moveToElement(selv).click().build().perform();
										Thread.sleep(5000);
										   /*  WebElement name=driver.findElement(By.xpath("//div[@class='_52jh']"));
										     
										     String name2=name.getAttribute("innerText");
											  st ="this message was from "+name2+"";
										       
											     
												 update(st); */
												 Thread.sleep(5000);
												 
	                                  
												 
												 WebElement find=driver.findElement(By.xpath("//select[@class='selectBtn touchable']"));
												 find.click();
												 Thread.sleep(3000);
												 WebElement find1=driver.findElement(By.xpath("//option[3]"));	 
												 find1.click();
	                                             st ="waiting for delet button";
										       
											     
												 update(st);
												 WebDriverWait wait = new WebDriverWait(driver, 60); // Wait for 10 seconds.
												 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/a[2]")));
	                                          st ="finally deleting this message thread";
										       
											     
												 update(st);
												
												 WebElement del = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/a[2]"));
												
													String hyperlink = del.getAttribute("href");
													System.out.println(hyperlink);
													
													//open the message in a new window
													
													String a = "window.open('"+hyperlink+"','_blank');";
													((JavascriptExecutor)driver).executeScript(a);
														
													Thread.sleep(3000);
												 
												
												  st ="delete was successful";
											       
												     
													 update(st);
													 
													
													
									        		 driver.switchTo().window(main);
									        		driver.navigate().back();
									        		
									        		 Thread.sleep(3000);
									        		 //deleting all other window then parent window
									        		 String parent=driver.getWindowHandle();
													 
														// This will return the number of windows opened by Webdriver and will return Set of St//rings
														Set<String>s1=driver.getWindowHandles();
														 
														// Now we will iterate using Iterator
														java.util.Iterator<String> I1 = s1.iterator();
														
														 
														while(I1.hasNext())
														{
														 
														   String child_window=I1.next();
														 
														// Here we will compare if parent window is not equal to child window then we            will close
														 
														if(!parent.equals(child_window))
														{
														driver.switchTo().window(child_window);
														 
														System.out.println(driver.switchTo().window(child_window).getTitle());
														 
														driver.close();
														}
														 
														}
														// once all pop up closed now switch to parent window
														driver.switchTo().window(parent);
										
														
														//assigning mess variable again with previous number of  message in the page
									        		 mess = driver.findElements(By.xpath("//abbr[contains(text(),'"+value1+"')]"));
									    

										
										 
												
												 
												
													
													
											
									 }	 
										 }catch(Exception hs)
										 {
											 WebElement del = driver.findElement(By.xpath("//div[@id='see_older_threads']//a[@class='touchable primary']"));
											 
											 String hyperlink = del.getAttribute("href");
											 String a = "window.open('"+hyperlink+"','_blank');";
												((JavascriptExecutor)driver).executeScript(a);
													
												Thread.sleep(3000);
												
												 for (String window2 : driver.getWindowHandles()) {

													 
													 
													 driver.switchTo().window(window2);
													

												 }
												 
												 Thread.sleep(3000);
												 String parent=driver.getWindowHandle();
												 
													// This will return the number of windows opened by Webdriver and will return Set of St//rings
													Set<String>s1=driver.getWindowHandles();
													 
													// Now we will iterate using Iterator
													java.util.Iterator<String> I1 = s1.iterator();
													
													 
													while(I1.hasNext())
													{
													 
													   String child_window=I1.next();
													 
													// Here we will compare if parent window is not equal to child window then we            will close
													 
													if(!parent.equals(child_window))
													{
													driver.switchTo().window(child_window);
													 
													System.out.println(driver.switchTo().window(child_window).getTitle());
													 
													driver.close();
													}
													 
													}
													// once all pop up closed now switch to parent window
													driver.switchTo().window(parent);
												 
										 }
										
										
								        
									 
									 } 
								}catch(Exception ana)
								{
									
									//checking if current year is less then the given year
									try{
										int check=en1-1;
										String check2 = Integer.toString(check);
										WebElement end =driver.findElement(By.xpath("//div//span[@class='time nowrap mfss fcl']//abbr[contains(text(),'"+check2+"')]"));
										
										 st="System has come to an end,no other will be found.System has successfully deleted all the messages from "+value1+"";
								        	
										 update(st);
										 JOptionPane.showMessageDialog(null,"System has come to an end,no other will be found.System has successfully deleted all the messages from "+value1+"");
										//getting out from loop for checking messages
										 
										 i=20;
									}catch(Exception gq)
									{
										//if exit year not found then contiue loop
										st="continuing steps";
							        	
										 update(st);
										 i=0;
									}
									
									 st="no message found in this page,going to next page";
							        	
									 update(st);
									 
									/* StringWriter errors2a = new StringWriter();
										ana.printStackTrace(new PrintWriter(errors2a));
									st =errors2a.toString();
									update(st);
									*/
									 
									 //clciking button to load messages
									 Thread.sleep(5000);
									WebElement next=driver.findElement(By.xpath("//strong[contains(text(),'See older messages')]"));
									 builder.moveToElement(next);
									next.click();
									Thread.sleep(delay);
									
									
									
									
								}
									 
									 
							 }
							
							 
							 
						 }catch(Exception aa)
						 {
							 
						 }
						 
						
					
						return null;
					}
			
				};
				dyna.execute();
				
	}
}

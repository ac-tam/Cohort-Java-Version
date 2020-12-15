import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;  


public class Frame {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static String odd1, odd2, odd3, odd4, even1, even2, even3, even4, error;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;


	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		FileWriter fw;
		try {
			error = "";
			Scanner scanner = new Scanner(new File("schedule.txt"));
			scanner.nextLine();
			scanner.nextLine();
			odd1 = scanner.nextLine().substring(10);
			odd2 = scanner.nextLine().substring(10);
			odd3 = scanner.nextLine().substring(10);
			odd4 = scanner.nextLine().substring(10);
			scanner.nextLine();
			scanner.nextLine();
			even1 = scanner.nextLine().substring(10);
			even2 = scanner.nextLine().substring(10);
			even3 = scanner.nextLine().substring(10);
			even4 = scanner.nextLine().substring(10);




		}
		catch (StringIndexOutOfBoundsException e) {
			error = "Fix Schedule Format. Delete it to get a new File.";
		}
		catch (NullPointerException e) {
			try {
				error = "Please input your schedule into schedule.txt, then restart the app";

				System.out.println("nope");
				fw = new FileWriter("schedule.txt");
				fw.write("Enter Schedule Below. Enter nothing to indicate no class.\n"
						+ "Odd \n"
						+ "Period 1: \n"
						+ "Period 2: \n"
						+ "Period 3: \n"
						+ "Period 4: \n"
						+ "\n"
						+ "Even \n"
						+ "Period 1: \n"
						+ "Period 2: \n"
						+ "Period 3: \n"
						+ "Period 4: \n");
				fw.close();
				
				openWebpage(new URI("schedule.txt"));
			} catch (IOException ee) {
				;
			}
		}
		
		catch (FileNotFoundException e) {
			try {
				error = "Please input your schedule into schedule.txt, then restart the app";

				System.out.println("nope");
				fw = new FileWriter("schedule.txt");
				fw.write("Enter Schedule Below. Enter nothing to indicate no class.\n"
						+ "Odd \n"
						+ "Period 1: \n"
						+ "Period 2: \n"
						+ "Period 3: \n"
						+ "Period 4: \n"
						+ "\n"
						+ "Even \n"
						+ "Period 1: \n"
						+ "Period 2: \n"
						+ "Period 3: \n"
						+ "Period 4: \n");
				fw.close();
				
				openWebpage(new URI("schedule.txt"));
						
			} catch (IOException ee) {
				;
			}
			
		}
			
		try {
			Frame window = new Frame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setSize(404, 321);
		shell.setDefaultButton(null);
		shell.setText("Cohort Schedule");
		shell.setLocation(300, 300);
		
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					openWebpage(new URI(odd1));
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(holidays(now.toLocalDate()));
		
		btnNewButton.setBounds(149, 48, 90, 30);
		btnNewButton.setText("Odd Period 1");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override				
			public void widgetSelected(SelectionEvent e) {
					try {
						openWebpage(new URI(odd2));
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});
		btnNewButton_1.setText("Odd Period 2");
		btnNewButton_1.setBounds(149, 102, 90, 30);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					openWebpage(new URI(odd3));
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_2.setText("Odd Period 3");
		btnNewButton_2.setBounds(149, 157, 90, 30);
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						openWebpage(new URI(odd4));
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});
		btnNewButton_3.setText("Odd Period 4");
		btnNewButton_3.setBounds(149, 210, 90, 30);
		
		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						openWebpage(new URI(even1));
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});
		btnNewButton_4.setText("Even Period 1");
		btnNewButton_4.setBounds(272, 48, 90, 30);
		
		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						openWebpage(new URI(even2));
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});
		btnNewButton_5.setText("Even Period 2");
		btnNewButton_5.setBounds(272, 102, 90, 30);
		
		Button btnNewButton_6 = new Button(shell, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						openWebpage(new URI(even3));
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_6.setText("Even Period 3");
		btnNewButton_6.setBounds(272, 157, 90, 30);
		
		Button btnNewButton_7 = new Button(shell, SWT.NONE);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						openWebpage(new URI(even4));
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_7.setText("Even Period 4");
		btnNewButton_7.setBounds(272, 210, 90, 30);
		
		

		
		Label lblPeriod = new Label(shell, SWT.NONE);
		lblPeriod.setBounds(20, 48, 55, 15);
		lblPeriod.setText("Period 1");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(20, 63, 55, 15);
		label.setText("8:32 - 9:47");
		
		Label lblPeriod_1 = new Label(shell, SWT.NONE);
		lblPeriod_1.setBounds(20, 102, 55, 15);
		lblPeriod_1.setText("Period 2");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(20, 117, 67, 15);
		label_1.setText("9:55 - 11:10");
		
		Label lblPeriod_2 = new Label(shell, SWT.NONE);
		lblPeriod_2.setBounds(20, 152, 55, 15);
		lblPeriod_2.setText("Period 3");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(20, 165, 67, 15);
		label_2.setText("11:18 - 12:33");
		
		Label lblPeriod_3 = new Label(shell, SWT.NONE);
		lblPeriod_3.setBounds(20, 210, 55, 15);
		lblPeriod_3.setText("Period 4");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(20, 225, 67, 15);
		label_3.setText("12:41 - 1:56");
		
		
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(25, 256, 353, 26);
		label_4.setText(error);
	
		if ((odd1 + odd2 + odd3 + odd4 + even1 + even2 + even3 + even4).equals("")) {
			label_4.setText("Add classes in schedule.txt and restart app");
			try {
				openWebpage(new URI("schedule.txt"));
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		
		String cohort = "Cohort";
		
		Label lblCohortA = new Label(shell, SWT.NONE);
		lblCohortA.setBounds(20, 10, 55, 15);
		lblCohortA.setText("Cohort A");
		
		
		

	}
	int holidays(LocalDate date) {
        LocalDate[] holidaysArr = {
		LocalDate.of(2020, 9, 20),
		 LocalDate.of(2020, 9, 28),
		 LocalDate.of(2020, 10, 13),
		 LocalDate.of(2020, 11, 26),
		 LocalDate.of(2020, 11, 27),
		 LocalDate.of(2020, 11, 28),
		 LocalDate.of(2020, 12, 24),
		 LocalDate.of(2020, 12, 25),
		 LocalDate.of(2020, 12, 26),
		 LocalDate.of(2020, 12, 27),
		 LocalDate.of(2020, 12, 28),
		 LocalDate.of(2020, 12, 29),
		 LocalDate.of(2020, 12, 30),
		 LocalDate.of(2020, 12, 31),
		 LocalDate.of(2021, 1, 1),
		 LocalDate.of(2021, 1, 17)
        };

        for (int i = holidaysArr.length - 1; i > -1 ; i--)
            if (holidaysArr[i].toEpochDay() == date.toEpochDay());
            else if (holidaysArr[i].toEpochDay() < date.toEpochDay())  
                return i;
        return 0;
    }
	
    
    
	public static boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

	public static boolean openWebpage(URL url) {
	    try {
	        return openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;  
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Frame {

	protected Shell shell;
	public static String odd1, odd2, odd3, odd4, even1, even2, even3, even4, error;

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		FileWriter fw;
		try {
			error = "Online version at andrewtam.org/cohort";
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
			try {
				error = "Please input your schedule into schedule.txt, then restart the app";

				System.out.println("NullPointE");
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
			} catch (IOException ee) {;}		
		}
		catch (NullPointerException e) {
			try {
				error = "Please input your schedule into schedule.txt, then restart the app";

				System.out.println("NullPointE");
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
			} catch (IOException ee) {;}
		}
		catch (FileNotFoundException e) {
			try {
				error = "Please input your schedule into schedule.txt, then restart the app";

				System.out.println("FileNotFound");
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
						
			} catch (IOException ee) {;}
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
		shell.setSize(422, 335);
		shell.setDefaultButton(null);
		shell.setText("Cohort Schedule");
		shell.setLocation(500, 500);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(holidays(now.toLocalDate()));
		
		
		
		
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
		
		btnNewButton.setBounds(149, 48, 100, 30);
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
		btnNewButton_1.setBounds(149, 102, 100, 30);
		
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
		btnNewButton_2.setBounds(149, 157, 100, 30);
		
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
		btnNewButton_3.setBounds(149, 210, 100, 30);
		
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
		btnNewButton_4.setBounds(272, 48, 100, 30);
		
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
		btnNewButton_5.setBounds(272, 102, 100, 30);
		
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
		btnNewButton_6.setBounds(272, 157, 100, 30);
		
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
		btnNewButton_7.setBounds(272, 210, 100, 30);
		
		btnNewButton.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_1.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_2.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_3.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_4.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_5.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_6.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		btnNewButton_7.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
		
		
		Label lblPeriod = new Label(shell, SWT.NONE);
		lblPeriod.setBounds(20, 45, 83, 20);
		lblPeriod.setText("Period 1");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(20, 62, 83, 20);
		label.setText("8:32 - 9:47");
		
		Label lblPeriod_1 = new Label(shell, SWT.NONE);
		lblPeriod_1.setBounds(20, 89, 83, 19);
		lblPeriod_1.setText("Period 2");
		
		Label lblPeriod_2 = new Label(shell, SWT.NONE);
		lblPeriod_2.setBounds(20, 145, 83, 20);
		lblPeriod_2.setText("Period 3");
		
		Label lblPeriod_3 = new Label(shell, SWT.NONE);
		lblPeriod_3.setBounds(20, 196, 83, 20);
		lblPeriod_3.setText("Period 4");
		
		
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(20, 257, 371, 20);
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
		int schoolDate = schoolDays(now.toLocalDate());
		if (schoolDate % 4 == 0)
			cohort = "Odd Cycle A";
		if (schoolDate % 4 == 1)
			cohort = "Even Cycle A";
		if (schoolDate % 4 == 2)
			cohort = "Odd Cycle B";
		if (schoolDate % 4 == 3)
			cohort = "Even Cycle B";

		
		if (schoolDate % 2 == 0) {
			if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 30))))
				btnNewButton_3.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
			else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(11, 10))))
				btnNewButton_2.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
			else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(9, 50))))
				btnNewButton_1.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
			else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 00))))
				btnNewButton.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
		}
		
		else
		{ 
			if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 30))))
				btnNewButton_7.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
			else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(11, 10))))
					btnNewButton_6.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
			else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(9, 50))))
				btnNewButton_5.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
			else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 00))))
					btnNewButton_4.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
		}
			
			
		
		
		Label lblCohortA = new Label(shell, SWT.NONE);
		lblCohortA.setBounds(225, 10, 111, 15);
		lblCohortA.setText(cohort);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(20, 215, 83, 22);
		label_3.setText("12:41 - 1:56");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(20, 164, 83, 20);
		label_2.setText("11:18 - 12:33");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(20, 111, 83, 22);
		label_1.setText("9:55 - 11:10");
		
	
		Button btnNewButton_8 = new Button(shell, SWT.NONE);
		btnNewButton_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					openWebpage(new URI("schedule.txt"));
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_8.setText("Edit Schedule");
		btnNewButton_8.setBounds(0, 3, 100, 30);
		btnNewButton_8.setBackgroundImage(null);
		
		

		System.out.println(schoolDays(now.toLocalDate()));
		
		shell.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				LocalDateTime now = LocalDateTime.now();
			
				btnNewButton.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_1.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_2.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_3.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_4.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_5.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_6.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));
				btnNewButton_7.setBackground(new org.eclipse.swt.graphics.Color(230,230,230));

				if (schoolDate % 2 == 0) {
					if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 30))))
						btnNewButton_3.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
					else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(11, 10))))
						btnNewButton_2.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
					else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(9, 45))))
						btnNewButton_1.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
					else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 00))))
						btnNewButton.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
				}
				else
				{ 
					if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(12, 30))))
						btnNewButton_7.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
					else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(11, 10))))
							btnNewButton_6.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
					else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(9, 45))))
						btnNewButton_5.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
					else if (now.isAfter(LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 00))))
							btnNewButton_4.setBackground(new org.eclipse.swt.graphics.Color(144,238,144));
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				System.out.println("Focus Lost");
			}
		});
	}
	
	int schoolDays(LocalDate date) {
		
	        long day = -1 + date.toEpochDay() - LocalDate.of(2020, 9, 21).toEpochDay();
	        return (int) (day - Math.floor(day / 7) * 2 - holidays(date));
	    
	}

	int holidays(LocalDate date) {
        LocalDate[] holidaysArr = {
		 LocalDate.of(2020, 9, 28),
		 LocalDate.of(2020, 10, 12),
		 LocalDate.of(2020, 11, 11),
		 LocalDate.of(2020, 11, 26),
		 LocalDate.of(2020, 11, 27),
		 LocalDate.of(2020, 12, 24),
		 LocalDate.of(2020, 12, 25),
		 LocalDate.of(2020, 12, 26),
		 LocalDate.of(2020, 12, 27),
		 LocalDate.of(2020, 12, 28),
		 LocalDate.of(2020, 12, 29),
		 LocalDate.of(2020, 12, 30),
		 LocalDate.of(2020, 12, 31),
		 LocalDate.of(2021, 1, 1),
		 LocalDate.of(2021, 1, 17),
		 LocalDate.of(2021, 2, 1),
		 LocalDate.of(2021, 2, 12),
		 LocalDate.of(2021, 2, 15),
		 LocalDate.of(2021, 2, 16),
		 LocalDate.of(2021, 2, 17),
		 LocalDate.of(2021, 2, 18),
		 LocalDate.of(2021, 2, 19),
		 LocalDate.of(2021, 3, 29),
		 LocalDate.of(2021, 3, 30),
		 LocalDate.of(2021, 3, 31),
		 LocalDate.of(2021, 4, 1),
		 LocalDate.of(2021, 4, 2),
		 LocalDate.of(2021, 4, 14),
		 LocalDate.of(2021, 5, 3),
		 LocalDate.of(2021, 5, 13),
		 LocalDate.of(2021, 5, 31),
		 LocalDate.of(2021, 6, 3)
		 
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

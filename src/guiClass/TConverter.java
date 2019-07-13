package guiClass;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import operationFiles.ConvertingFile;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

public class TConverter {

	protected Shell shell;
	private Text primText;
	private Text secText;
	private double inputValue = 0;
	
	ConvertingFile convert = new ConvertingFile();


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TConverter window = new TConverter();
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		shell.setSize(661, 419);
		shell.setText("SWT Application");
		
		Label lblTemperatureConverter = new Label(shell, SWT.NONE);
		lblTemperatureConverter.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblTemperatureConverter.setFont(SWTResourceManager.getFont("Sitka Banner", 24, SWT.BOLD | SWT.ITALIC));
		lblTemperatureConverter.setBounds(26, 24, 393, 61);
		lblTemperatureConverter.setText("Temperature Converter");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(319, 106, 2, 222);
		
		Label lblConvertFrom = new Label(shell, SWT.NONE);
		lblConvertFrom.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblConvertFrom.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblConvertFrom.setBounds(26, 106, 155, 37);
		lblConvertFrom.setText("Convert From:");
		
		Label lblConvertInto = new Label(shell, SWT.NONE);
		lblConvertInto.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblConvertInto.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblConvertInto.setBounds(365, 106, 138, 37);
		lblConvertInto.setText("Convert Into:");
		
		primText = new Text(shell, SWT.BORDER);
		primText.setFont(SWTResourceManager.getFont("Segoe UI Emoji", 18, SWT.BOLD));
		primText.setBounds(26, 149, 254, 52);
		
		secText = new Text(shell, SWT.BORDER);
		secText.setFont(SWTResourceManager.getFont("Segoe UI Emoji", 18, SWT.BOLD));
		secText.setBounds(365, 149, 254, 52);
		
		Button primC = new Button(shell, SWT.NONE);
		primC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					inputValue = Double.parseDouble(primText.getText());
				}catch(Exception exp){
					JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				convert.celcius = inputValue;

			}
		});
		primC.setBounds(53, 210, 49, 30);
		primC.setText("*C");
		
		Button primK = new Button(shell, SWT.NONE);
		primK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					inputValue = Double.parseDouble(primText.getText());
				}catch(Exception exp){
					JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				convert.kelvin = inputValue;

			}
		});
		primK.setText("K");
		primK.setBounds(129, 210, 49, 30);
		
		Button primF = new Button(shell, SWT.NONE);
		primF.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					inputValue = Double.parseDouble(primText.getText());
				}catch(Exception exp){
					JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				convert.faranhite = inputValue;

			}
		});
		primF.setText("*F");
		primF.setBounds(208, 210, 49, 30);
		
		Button secC = new Button(shell, SWT.NONE);
		secC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(inputValue==convert.celcius){
					secText.setText(Double.toString(convert.celcius));
				}
				else if(inputValue==convert.kelvin){
					secText.setText(Double.toString(convert.getCelciusFromKelvin()));
				}
				else if(inputValue==convert.faranhite){
					secText.setText(Double.toString(convert.getCelciusFromFaranhite()));
				}

			}
		});
		secC.setText("*C");
		secC.setBounds(393, 210, 49, 30);
		
		Button secK = new Button(shell, SWT.NONE);
		secK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(inputValue==convert.celcius){
					secText.setText(Double.toString(convert.getKelvinFromCelcius()));
				}
				else if(inputValue==convert.kelvin){
					secText.setText(Double.toString(convert.kelvin));
				}
				else if(inputValue==convert.faranhite){
					secText.setText(Double.toString(convert.getKelvinFromCelcius()));
				}

			}
		});
		secK.setText("K");
		secK.setBounds(469, 210, 49, 30);
		
		Button secF = new Button(shell, SWT.NONE);
		secF.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(inputValue==convert.celcius){
					secText.setText(Double.toString(convert.getFaranhiteFromCelcius()));
				}
				else if(inputValue==convert.kelvin){
					secText.setText(Double.toString(convert.getFaranhiteFromKelvin()));
				}
				else if(inputValue==convert.faranhite){
					secText.setText(Double.toString(convert.faranhite));
				}

			}
		});
		secF.setText("*F");
		secF.setBounds(548, 210, 49, 30);
		
		Button btnRefresh = new Button(shell, SWT.NONE);
		btnRefresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				primText.setText("");
				secText.setText("");
			}
		});
		btnRefresh.setBounds(198, 334, 244, 30);
		btnRefresh.setText("REFRESH");
		
		Label developerName = new Label(shell, SWT.NONE);
		developerName.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		developerName.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		developerName.setBounds(537, 344, 92, 20);
		developerName.setText("@mshahzaib");

		
	}
}

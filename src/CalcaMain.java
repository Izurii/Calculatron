import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CalcaMain {
	private Text in;
	private Text text;
	private Text hist;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CalcaMain window = new CalcaMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		
		Display display = Display.getDefault();
		Shell she = new Shell();
		she.setSize(758, 591);
		she.setText("Calculatron");
		she.setImage(new Image(display, "C:\\Users\\IZURII\\eclipse-workspace\\Calculatron\\src\\calculatron.ico"));
		in = new Text(she, SWT.BORDER);
		in.setBounds(10, 10, 482, 103);
		in.forceFocus();
		in.setFocus();
		in.addVerifyListener(new VerifyListener()
				{

					@Override
					public void verifyText(VerifyEvent e)
					{	
						
						for (int i = 0; i < e.text.length(); i++) {
			                if (Character.isAlphabetic(e.text.charAt(i))) {
			                    e.doit = false;
			                    return;
			                }
			                
			                in.toString().replaceAll("[()?:!.,;{}]+", "");
			                
			            }
						
					}
			
			
			
				});
		
		
		List<String> lis = new ArrayList<>();
		StringBuilder num = new StringBuilder();
		she.addTraverseListener(new TraverseListener()
		  {
		    @Override
		    public void keyTraversed(final TraverseEvent event)
		    {
		      if (event.detail == SWT.TRAVERSE_RETURN)
		        { 
		    	  if(in.getText().equals(""))
		    	  {
		    		  
		    		  JOptionPane.showMessageDialog(null, "FAÇA ALGUMA CONTA!!!");
		    		  
		    	  }else {
		    		  
		    		  ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
						try {
							String res = engine.eval(in.getText()).toString();
							lis.add(in.getText().toString() + " = " + res);
							int leng = lis.size();
							in.setText(res);
							if(!lis.isEmpty())
							{
								for(int i = 0; i < leng; i++)
								{
									num.append(lis.get(i));
									num.append('\n');
								}
								
								hist.setText(num.toString());
								num.setLength(0);
								
							}
							
						} catch (ScriptException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    	  }
		        }
		    }
		  });
		
		Button btnCalcular = new Button(she, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(in.getText().equals(""))
		    	  {
		    		  
		    		  JOptionPane.showMessageDialog(null, "FAÇA ALGUMA CONTA!!!");
		    		  
		    	  }else {
		    		  
		    		  ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
						try {
							String res = engine.eval(in.getText()).toString();
							lis.add(in.getText().toString() + " = " + res);
							int leng = lis.size();
							in.setText(res);
							if(!lis.isEmpty())
							{
								for(int i = 0; i < leng; i++)
								{
									num.append(lis.get(i));
									num.append('\n');
								}
								
								hist.setText(num.toString());
								num.setLength(0);
								
							}
							
						} catch (ScriptException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    	  }
			}
		});
		btnCalcular.setBounds(274, 497, 102, 30);
		btnCalcular.setText("Calcular");
		
		Label label = new Label(she, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 119, 502, 8);
		
		Button b9 = new Button(she, SWT.NONE);
		b9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + "9");
			}
		});
		b9.setText("9");
		b9.setSelection(false);
		b9.setBounds(274, 133, 90, 103);
		
		Button b8 = new Button(she, SWT.NONE);
		b8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b8.getText());
			}
		});
		b8.setText("8");
		b8.setBounds(141, 133, 90, 103);
		
		Button b7 = new Button(she, SWT.NONE);
		b7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b7.getText());
			}
		});
		b7.setBounds(10, 133, 90, 103);
		b7.setText("7");
		
		Button b6 = new Button(she, SWT.NONE);
		b6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b6.getText());
			}
		});
		b6.setText("6");
		b6.setBounds(274, 253, 90, 103);
		
		Button b5 = new Button(she, SWT.NONE);
		b5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b5.getText());
			}
		});
		b5.setText("5");
		b5.setBounds(141, 253, 90, 103);
		
		Button b4 = new Button(she, SWT.NONE);
		b4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b4.getText());
			}
		});
		b4.setText("4");
		b4.setBounds(10, 253, 90, 103);
		
		Button b3 = new Button(she, SWT.NONE);
		b3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b3.getText());
			}
		});
		b3.setText("3");
		b3.setBounds(274, 374, 90, 103);
		
		Button b2 = new Button(she, SWT.NONE);
		b2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b2.getText());
			}
		});
		b2.setText("2");
		b2.setBounds(141, 374, 90, 103);
		
		Button b1 = new Button(she, SWT.NONE);
		b1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b1.getText());
			}
		});
		b1.setText("1");
		b1.setBounds(10, 374, 90, 103);
		
		Button b0 = new Button(she, SWT.NONE);
		b0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText(in.getText() + b0.getText());
			}
		});
		b0.setBounds(10, 490, 90, 44);
		b0.setText("0");
		
		Button bd = new Button(she, SWT.NONE);
		bd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				in.setText(in.getText() + bd.getText());
				
			}
		});
		bd.setText("/");
		bd.setBounds(402, 133, 90, 44);
		
		Button bm = new Button(she, SWT.NONE);
		bm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				in.setText(in.getText() + bm.getText());
				
			}
		});
		bm.setText("*");
		bm.setBounds(402, 276, 90, 44);
		
		Button bma = new Button(she, SWT.NONE);
		bma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				in.setText(in.getText() + bma.getText());
				
			}
		});
		bma.setText("+");
		bma.setBounds(402, 347, 90, 80);
		
		Button bme = new Button(she, SWT.NONE);
		bme.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				in.setText(in.getText() + bme.getText());
				
			}
		});
		bme.setText("-");
		bme.setBounds(402, 454, 90, 80);
		
		Button bclear = new Button(she, SWT.NONE);
		bclear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				in.setText("");
			}
		});
		bclear.setBounds(141, 497, 90, 30);
		bclear.setText("Limpar");
		
		Button btnNewButton = new Button(she, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				
				Double xxx = Math.sqrt(Double.parseDouble(in.getText()));
				lis.add("\u221A" + in.getText().toString() + " = " + xxx);
				int leng = lis.size();
				in.setText(xxx.toString());
				if(!lis.isEmpty())
				{
					for(int i = 0; i < leng; i++)
					{
						num.append(lis.get(i));
						num.append('\n');
					}
					
					hist.setText(num.toString());
					num.setLength(0);
					
				}
				
			}
		});
		btnNewButton.setBounds(390, 201, 102, 44);
		btnNewButton.setText("\u221A");
		
		Button btnNewButton_1 = new Button(she, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				
				hist.setText("");
				lis.clear();
				
			}
		});
		btnNewButton_1.setBounds(515, 497, 215, 30);
		btnNewButton_1.setText("Limpar hist\u00F3rico");
		
		hist = new Text(she, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		hist.setEditable(false);
		hist.setBounds(515, 10, 215, 167);
		
		she.open();
		she.layout();
		while (!she.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
			
		}
		
	}
}

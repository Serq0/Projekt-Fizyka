package paka;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class montecarlopi {

	private JFrame frame;
	private JTextField liczbae;
	private JTextField wynik;
	private JTextField promienr;
	public int e;
	public int r;
	
	
	private double policz(){
		wynik.setText("liczy...");
		try {
		    Thread.sleep(100);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		int rr,ee;
		rr = Integer.parseInt(promienr.getText());
		ee = Integer.parseInt(liczbae.getText());
		System.out.println(ee+" "+rr);
		double pi; 
		int circle=0 , off=0; 
		double x,y;
		Random random = new Random();
		for(int i=0;i<ee;i++)
		{
			//x = random.nextInt(rr-0+1)+0;
			//y = random.nextInt(rr-0+1)+0;
			x = 0 + (rr - 0) * random.nextDouble();
			y = 0 + (rr - 0) * random.nextDouble();
			off++;
			if (((x * x) + (y * y)) <= (rr*rr)) 
			{
				circle ++;
			}
		}
		
		pi = (4*(((double)circle/off)/rr*rr));
		double a=Math.round(pi*1000000000);
	    a/=1000000000;
		return a;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					montecarlopi window = new montecarlopi();
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
	public montecarlopi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		liczbae = new JTextField();
		liczbae.setText("0");
		liczbae.setBounds(55, 139, 86, 20);
		frame.getContentPane().add(liczbae);
		liczbae.setColumns(10);
		
		
		JLabel lblWprowadIloLosowanych = new JLabel("Wprowad\u017A ilo\u015B\u0107 losowanych punkt\u00F3w");
		lblWprowadIloLosowanych.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWprowadIloLosowanych.setBounds(10, 108, 201, 20);
		frame.getContentPane().add(lblWprowadIloLosowanych);
		
		JButton btnPolicz = new JButton("Policz \u03C0");
		btnPolicz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(promienr.getText())>=0 && Integer.parseInt(promienr.getText())<100000)
				{
					if(Integer.parseInt(liczbae.getText())>0 && Integer.parseInt(liczbae.getText())<1000000)
					{
						wynik.setText(Double.toString(policz()));
					}
				}
				//wynik.setText(Double.toString(policz()));
				//policz(e,r);
			}
		});
		btnPolicz.setBounds(115, 229, 89, 23);
		frame.getContentPane().add(btnPolicz);
		
		JFormattedTextField frmtdtxtfldOblicznieMetod = new JFormattedTextField();
		frmtdtxtfldOblicznieMetod.setEditable(false);
		frmtdtxtfldOblicznieMetod.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldOblicznieMetod.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		frmtdtxtfldOblicznieMetod.setText("Oblicznie π metodą Monte Carlo");
		frmtdtxtfldOblicznieMetod.setBounds(10, 11, 414, 51);
		frame.getContentPane().add(frmtdtxtfldOblicznieMetod);
		
		JLabel lblWynik = new JLabel("Wynik");
		lblWynik.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWynik.setBounds(232, 205, 46, 14);
		frame.getContentPane().add(lblWynik);
		
		wynik = new JTextField();
		wynik.setText("Nie policzone.");
		wynik.setBounds(214, 230, 86, 20);
		frame.getContentPane().add(wynik);
		wynik.setColumns(10);
		
		promienr = new JTextField();
		promienr.setText("0");
		promienr.setBounds(273, 139, 86, 20);
		frame.getContentPane().add(promienr);
		promienr.setColumns(10);
		
		
		JLabel lblWprowadPromieKoa = new JLabel("Wprowad\u017A promie\u0144 ko\u0142a");
		lblWprowadPromieKoa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWprowadPromieKoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblWprowadPromieKoa.setBounds(240, 111, 151, 14);
		frame.getContentPane().add(lblWprowadPromieKoa);
		
		JButton btnSymulacja = new JButton("Symulacja");
		btnSymulacja.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSymulacja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Symulacja symulacja = new Symulacja(Integer.parseInt(promienr.getText()),Integer.parseInt(liczbae.getText()));
				//symulacja.paint(null);
			}
		});
		btnSymulacja.setBounds(16, 229, 89, 23);
		frame.getContentPane().add(btnSymulacja);
		
		JLabel label = new JLabel("\u03C0\u22483,14159265358979");
		label.setBounds(310, 233, 114, 14);
		frame.getContentPane().add(label);
	}
}

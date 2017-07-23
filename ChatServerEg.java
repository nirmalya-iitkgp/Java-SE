import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.swing.*;

public class ChatServerEg extends JFrame implements ActionListener, Runnable
{
	JTextField tf1;
	JTextArea ta1;
	JScrollPane p1;
	JButton b1;

	ServerSocket ss;
	Socket s1;
	PrintWriter pw;
	BufferedReader br;

	public ChatServerEg

	{
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Chat Server);
		getContentPane().setBackground (Color.green);
		setResizable(true);
		setLocation (200, 200);

		tf1= new JTextField();
		ta1= new JTextArea();
		p1= new JScrollPane();
		b1= new JButton("Send");
		tf1.setBounds(20,20,180,30);
		b1.setBounds(170,20,080,30);
		ta1.setBounds(20,60,250,250);

		add(tf1);
		add(b1);
		add(p1);

		setSize(300,300);
		setVisible(true);

		try
		{
			 ss = new ServerSocket(3333);  // server only
			s1= ss.accept();    // server only
			// s1= new Socket (InetAddress.getByAddress("localhost"),3333);
			pw = new PrintWriter(s1.getOutputStream, true);
			bw = new BufferedReader (new InputStreamReader(s1.getInputStream()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		b1.addActionLIstener(this);
		tf1.addActionLIstener(this);

		new Thread ( this).start();

	};
	public static void main(String[] args) 
	{
		new ChatServerEg
	;
	}
	public static void actionPerformed(ActionEvent ae)
	{
		String text = tf1.getText();
		pw.println(text);
		ta1.append(text+"\t - me \n");
		tf1.setText(ta1.getText());

	}
	public void run ()
	{
		while( true)
		{
			try
			{
				String text= br.readLine;
				ta1.append(text+"\t - sender \n");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
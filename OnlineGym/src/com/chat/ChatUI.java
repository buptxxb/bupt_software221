package com.chat;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatUI {
	private static String serverAddress = "127.0.0.1";	
	
	private JFrame frame;
	private JTextField textField;
	
	private static Socket socket;
	private static OutputStream out;

	private static JTextArea textArea;
	private static JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					ChatUI window = new ChatUI();
					window.frame.setVisible(true);
					
					new Thread(){
						@Override
						public void run() {
							while(true){
								try {
									InputStream in = socket.getInputStream();
									byte[] b = new byte[1024];
									int len = in.read(b);
									String word = jiexi(new String(b, 0, len));
									textArea.append(word+"\n");
									textArea.setCaretPosition(textArea.getText().length()); 

								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						}
					}.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 * @param word
	 * @return
	 */
	public static String jiexi(String word) {
		int len = 0;
		if((len = word.indexOf("#num")) != -1) {
			String renshu = word.substring(len+4, word.length());
			textField_1.setText("\u5728\u7EBF\u4EBA\u6570\uFF1A" + renshu);
			return word.substring(0, len);
		}
		
		return word;
	}
	/**
	 * Create the application.
	 */
	public ChatUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			//建立与服务器链接
			// 知道服务器的地址，端口
			socket = new Socket(serverAddress, 8000);
			//向服务器打个招呼
			out = socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 728, 744);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(47, 492, 627, 69);
		frame.getContentPane().add(textField);
		textField.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendText();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(e ->{
				// 点击了发送按钮，客户端发送内容到服务器
				SendText();
			}
		);
		btnNewButton.setBounds(561, 574, 113, 27);
		frame.getContentPane().add(btnNewButton);


		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(47, 74, 627, 374);
		textArea.setLineWrap(true);        //激活自动换行功能 
		textArea.setWrapStyleWord(true);            // 激活断行不断字功能
		JScrollPane scrollPane = new JScrollPane(textArea);//添加滚动条
		scrollPane.setBounds(47, 74, 627, 374);
		frame.getContentPane().add(scrollPane);
		
		
		
		textField_1 = new JTextField();
		textField_1.setText("\u5728\u7EBF\u4EBA\u6570\uFF1A0\u4EBA");
		textField_1.setBounds(47, 35, 113, 24);
		textField_1.setEditable(false);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u9000\u51FA");
		button.setBounds(420, 574, 113, 27);
		frame.getContentPane().add(button);
		button.addActionListener(e -> {
			SendText("#exit");
			System.exit(0);
		});
		frame.setTitle("Chat Room");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				SendText("#exit");
			}
		});
	}
	/*
	 * 发送消息
	 */
	void SendText()
	{
		SendText(textField.getText());
	}
	void SendText(String content) {
		try {
			out.write(content.getBytes());
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

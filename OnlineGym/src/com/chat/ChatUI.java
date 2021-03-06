package com.chat;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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

public class ChatUI extends Frame{
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
	public static void Show( ) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					ChatUI window = new ChatUI();
					window.frame.setVisible(true);
					
					new Thread() {
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
//			textField_1.setText("\u5728\u7EBF\u4EBA\u6570\uFF1A");
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
			//????????????????
			// ??????????????????????
			socket = new Socket(serverAddress, 8000);
			//????????????????
			out = socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 728, 680);
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
				// ??????????????????????????????????????
				SendText();
			}
		);
		btnNewButton.setBounds(561, 574, 113, 27);
		frame.getContentPane().add(btnNewButton);


		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(47, 74, 627, 374);
		textArea.setLineWrap(true);        //???????????????? 
		textArea.setWrapStyleWord(true);            // ??????????????????
		JScrollPane scrollPane = new JScrollPane(textArea);//??????????
		scrollPane.setBounds(47, 74, 627, 374);
		frame.getContentPane().add(scrollPane);
		


		textField_1 = new JTextField();
		textField_1.setText("Have a chat with the coach !");
		textField_1.setBounds(47, 35, 170, 24);
		textField_1.setEditable(false);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("Close");
		button.setBounds(420, 574, 113, 27);
		frame.getContentPane().add(button);
		button.addActionListener(e -> {
			frame.dispose();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		});
		frame.setTitle("Chat Room");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
//			protected void processWindowEvent(WindowEvent e){
//				if (e.getID() == WindowEvent.WINDOW_CLOSING) { }
//			}
		});
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//			}
//		});
		
	}
//	protected void processWindowEvent(WindowEvent e) {
//		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
//		} else {
//			super.processWindowEvent(e);
//		}
//	}



	/*
	 * ????????
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

//	protected void processWindowEvent(WindowEvent e) {
//		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
//		} else {
//			super.processWindowEvent(e);
//		}
//	}

}


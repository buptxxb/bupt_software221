package com.chat;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	public static List<Socket> clients = new ArrayList<>();//Store all client channels���洢���еĿͻ���ͨ����

	public static void main(String[] args) throws Exception {
		//Open a server-side object������һ���������˶���
		ServerSocket server = new ServerSocket(8000);
		//OPen the server����������
		while(true){
			Socket client=server.accept();	//Accept the client and wait for the client to arrive(���ܿͻ��ˣ��ȴ��ͻ��˵���)
			System.out.println("The number of online member��" + clients.size());
			//Get what the client said and distribute a thread(��ȡ�ͻ���˵�Ļ�,�ɷ�һ���߳�)
			ChatServerThread c = new ChatServerThread(client);
			clients.add(client);
			c.start();
		}
	}
}

/**
 * Define a thread class to deal with the communication of a client
 * */
class ChatServerThread extends Thread{
	public Socket socket;
	private String ip;
	
	public ChatServerThread(Socket socket) {
		ip = socket.getInetAddress().getHostAddress();
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//Extract information from client(��client������ȡ��Ϣ)
			InputStream in = socket.getInputStream();
			byte[] b = new byte[1024];
			sendtextAll(ip + "come into the chat room��������#num" + Server.clients.size());
			while(true){
				int len = in.read(b);
				int zhuangtai = jiexi(new String(b,0,len));
				if(zhuangtai == 0) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int jiexi(String text) throws IOException {
		if(text.equals("#exit"))
		{
			while(!Server.clients.remove(socket));

			System.out.println("The number of online member��" + Server.clients.size());
			sendtextAll(this.ip + "leave the chat room��������#num" + Server.clients.size());
			return 0;
		}
		else if(text.charAt(0)=='@') {
			text = text.substring(1);
			int len = text.indexOf("@");
			if(len != -1) {
				sendtext_one(text.substring(len + 1),text.substring(0, len));
			}
		}
		else if(text.charAt(0)!='#')
			sendtextAll(ip +"send:��" + text);
		
		
		return 1;
	}
	/**
	 * make sure IP
	 * @param text
	 * @param ip
	 * @throws IOException 
	 */
	public void sendtext_one(String text,String ip) throws IOException {
		if(text.length()>0) {
			text = "From " + ip + "��" + text;
			for(int i = 0;i<Server.clients.size();i++) {
				if(Server.clients.get(i).getInetAddress().getHostAddress().equals(ip)) {
					try {
						Server.clients.get(i).getOutputStream().write(text.getBytes());
						Server.clients.get(i).getOutputStream().flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					socket.getOutputStream().write("".getBytes());
					return;
				}
			}
			//IP not found, message returned, failed to send(û���ҵ�IP��������Ϣ������ʧ��)
			socket.getOutputStream().write("Fail to send. IP cannot find.".getBytes());
		}
	}
	/**
	 * Send to all
	 * @param text
	 */
	public void sendtextAll(String text) {
		System.out.println(text);
		//The server needs to push the word word to each client(��������Ҫ��word��仰���͸�ÿһ���ͻ���)
		if(text.length()>0)
		for (int i =0;i< Server.clients.size();i++) {
			try {
				Server.clients.get(i).getOutputStream().write(text.getBytes());
				Server.clients.get(i).getOutputStream().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package com.chat;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	public static List<Socket> clients = new ArrayList<>();//Store all client channels（存储所有的客户端通道）

	public static void main(String[] args) throws Exception {
		//Open a server-side object（开启一个服务器端对象）
		ServerSocket server = new ServerSocket(8000);
		//OPen the server开启服务器
		while(true){
			Socket client=server.accept();	//Accept the client and wait for the client to arrive(接受客户端，等待客户端到来)
			System.out.println("The number of online member：" + clients.size());
			//Get what the client said and distribute a thread(获取客户端说的话,派发一个线程)
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
			//Extract information from client(从client里面提取信息)
			InputStream in = socket.getInputStream();
			byte[] b = new byte[1024];
			sendtextAll(ip + "come into the chat room————#num" + Server.clients.size());
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

			System.out.println("The number of online member：" + Server.clients.size());
			sendtextAll(this.ip + "leave the chat room————#num" + Server.clients.size());
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
			sendtextAll(ip +"send:：" + text);
		
		
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
			text = "From " + ip + "：" + text;
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
			//IP not found, message returned, failed to send(没有找到IP，返回消息，发送失败)
			socket.getOutputStream().write("Fail to send. IP cannot find.".getBytes());
		}
	}
	/**
	 * Send to all
	 * @param text
	 */
	public void sendtextAll(String text) {
		System.out.println(text);
		//The server needs to push the word word to each client(服务器需要将word这句话推送给每一个客户端)
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

import java.io.*;
import java.net.*;
public class ServerClass 
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(20025);
	    System.out.println("listening on port " + ss.getLocalPort());
		Socket socket = ss.accept();
		System.out.println("Socket accepted");
		File TransferSong = new File("c:/05 155.mp3");
		byte filesize[] = new byte [(int)TransferSong.length()]; 
		FileInputStream fin = new FileInputStream(TransferSong);
		BufferedInputStream bin = new BufferedInputStream(fin);
		bin.read(filesize,0,filesize.length);
		OutputStream os = socket.getOutputStream();
		System.out.println("Sending file...");
		os.write(filesize,0,filesize.length);
		os.flush();
		socket.close();
		ss.close();
		bin.close();
		System.out.println("File Transfered");
	}
	
	
}
import java.io.*;
import java.net.*;
public class ClientClass
{
	public static void main(String[] args) throws IOException 
	{
		final int FILE_SIZE = 1130;
		Socket socket = new Socket("10.69.173.62", 20025);
		System.out.println("Socket Found.");
		String fileName = "serverClass.txt";
		File file = new File("c:" + fileName);
		System.out.println("New file created.");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		InputStream is = socket.getInputStream();
		byte bytes[] = new byte[FILE_SIZE];
		int bytesRead = is.read(bytes, 0, bytes.length);
		int current = bytesRead;
	    do {
	        bytesRead = is.read(bytes, current, (bytes.length-current));
	         if(bytesRead >= 0) current += bytesRead;
	    } while(bytesRead > -1);
	    bos.write(bytes, 0 , current);
	    bos.flush();
	    System.out.println("File " + fileName + " downloaded (" + current + " bytes read)");
	    if (fos != null) fos.close();
	    if (bos != null) bos.close();
	    if (socket != null) socket.close();
	}
}


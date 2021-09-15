package arduino;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.fazecast.jSerialComm.SerialPort;

public class MainArduino {
		
	public static void main (String [] args) {
		
		
	
		try {// verifica os erros
			
			SerialPort serialPort;
			serialPort = SerialPort.getCommPorts()[0];
			serialPort.setBaudRate(9600);
			serialPort.setNumDataBits(8);
			serialPort.openPort();
			InputStream is;
			is = serialPort.getInputStream();
			
			while (serialPort.bytesAvailable()>0) {
				
				System.out.println((char) is.read());
				Thread.sleep(10);				
				
			}
			serialPort.closePort(); // fecha a porta serial para não afetar a comunicação com outros dispositivos
			
		}catch(Exception ex) {// trata os erros
			System.out.println(ex);
			
		}
		
	}
}

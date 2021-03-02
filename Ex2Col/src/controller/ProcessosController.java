package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	public ProcessosController(){
		super();
	}
	
	public char VerificaOs(){
		String os=System.getProperty("os.name");
		if(os.contains("Windows")){
			return 'w';
		}
		else if(os.contains("Linux")){
			return 'l';
		}
		else{
			System.out.println("SO não suportado");
			return ' ';
		}
	}
	public void ListarProcessos(char os){
		if(os=='w'){
			String process="TASKLIST /FO TABLE";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha= buffer.readLine();
				while (linha!= null){
					System.out.println(linha);
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch(IOException e){
				e.printStackTrace();		
			}
		}
		else if(os=='l'){
			String process="ps -ef";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha= buffer.readLine();
				while (linha!= null){
					System.out.println(linha);
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch(IOException e){
				e.printStackTrace();		
			}
		}
		else{
			System.out.println("SO não suportado ou não verificado");
		}
	}
	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void MatarProcessopid(char os,String param){
		if(os=='w'){
			String cmdPid = "TASKKILL /PID";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			callProcess(buffer.toString());
		}
		else if(os=='l'){
			String cmdPid = "kill -9";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			callProcess(buffer.toString());
		}
		else{
			System.out.println("SO não suportado ou não verificado");
		}
	}
	public void MatarProcessonome(char os,String param){
		if(os=='w'){
			String cmdNome = "TASKKILL /IM";
			StringBuffer buffer = new StringBuffer();
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
			callProcess(buffer.toString());
		}
		else if(os=='l'){
			String cmdNome = "pkill -f";
			StringBuffer buffer = new StringBuffer();
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
			callProcess(buffer.toString());
		}
		else{
			System.out.println("SO não suportado ou não verificado");
		}
	}
}

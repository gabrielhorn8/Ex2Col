package view;

import javax.swing.JOptionPane;
import controller.ProcessosController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		controller.ProcessosController p = new controller.ProcessosController();
		int op=1;
		char os=' ';
		String nome="";
		while (op!=0){
			op=Integer.parseInt(JOptionPane.showInputDialog("Selecione a operação desejada:\n1-Verificar SO\n2-Listar Processos\n3-Matar Processo por PID\n4-Matar Processo por Nome\n0-Fechar Programa"));
			switch(op){
				case 1:
					os=p.VerificaOs();
					break;
				case 2:
					p.ListarProcessos(os);
					break;
				case 3:
					nome=JOptionPane.showInputDialog("Digite o PID do Processo");
					p.MatarProcessopid(os,nome);
					break;
				case 4:
					nome=JOptionPane.showInputDialog("Digite o Nome do Processo");
					p.MatarProcessonome(os,nome);
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Finalizando...");
			}
		}
	}
}

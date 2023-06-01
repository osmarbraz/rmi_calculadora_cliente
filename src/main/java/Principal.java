
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 * Programa cliente do objeto calculadora.
 *
 * Classe que obtêm uma instância do objeto no servidor.
 *
 * @author osmar
 */
public class Principal {

    public static void main(String args[]) {
        try {
            //Referência para rmiregistry na porta 1099
            Registry registro = LocateRegistry.getRegistry("localhost");
            //Localiza a referência do objeto remoto no servidor 
            Object obj = registro.lookup("calculadora");
            //ou Object obj = Naming.lookup("rmi://localhost/mensagens");
            Calculadora calculadora = (Calculadora) obj;
            int opcao = -1;
            while (opcao != 9) {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu da Calculadora: \n1 - Adição \n2 - Subtração \n3 - Multiplicação \n4 - Divisão \n9 - Sair"));
                if (opcao == 1) {
                    int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da adicao:"));
                    int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da adicao:"));
                    int resultado = calculadora.soma(valorA, valorB);
                    System.out.println("O resultado da adição e:" + resultado);
                } else {
                    if (opcao == 2) {
                        int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da subtração:"));
                        int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da subtração:"));
                        int resultado = calculadora.diferenca(valorA, valorB);
                        System.out.println("O resultado da subtração e:" + resultado);
                    } else {
                        if (opcao == 3) {
                            int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da multiplicação:"));
                            int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da multiplicação:"));
                            int resultado = calculadora.produto(valorA, valorB);
                            System.out.println("O resultado do multplicação e:" + resultado);
                        } else {
                            if (opcao == 4) {
                                int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da divisao:"));
                                int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da divisao:"));
                                double resultado = calculadora.quociente(valorA, valorB);
                                System.out.println("O resultado da divisao e:" + resultado);
                            }
                        }
                    }
                }

            }

        } catch (RemoteException ree) {
            System.out.println("Excecao: " + ree.getMessage());
        } catch (NotBoundException nbe) {
            System.out.println("Excecao: " + nbe.getMessage());
        }
    }
}

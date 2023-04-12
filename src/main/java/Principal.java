
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
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu da Calculadora: \n1 - Adicao \n2 - Subtracao \n3 - Produto \n4 - Divisão \n9 - Sair"));
                if (opcao == 1) {
                    int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da adicao:"));
                    int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da adicao:"));
                    int resultado = calculadora.adicao(valorA, valorB);
                    System.out.println("O resultado da adicao e:" + resultado);
                } else {
                    if (opcao == 2) {
                        int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da subtracao:"));
                        int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da subtracao:"));
                        int resultado = calculadora.subtracao(valorA, valorB);
                        System.out.println("O resultado da subtracao e:" + resultado);
                    } else {
                        if (opcao == 3) {
                            int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A do produto:"));
                            int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da produto:"));
                            int resultado = calculadora.produto(valorA, valorB);
                            System.out.println("O resultado do produto e:" + resultado);
                        } else {
                            if (opcao == 4) {
                                int valorA = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor A da divisao:"));
                                int valorB = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor B da divisao:"));
                                double resultado = calculadora.divisao(valorA, valorB);
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

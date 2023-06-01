
import java.rmi.Remote;

public interface Calculadora extends Remote {

    public int soma(int a, int b) throws java.rmi.RemoteException;

    public int diferenca(int a, int b) throws java.rmi.RemoteException;

    public int produto(int a, int b) throws java.rmi.RemoteException;

    public double quociente(int a, int b) throws java.rmi.RemoteException;

}

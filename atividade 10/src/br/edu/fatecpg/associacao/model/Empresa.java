package br.edu.fatecpg.associacao.model;

public class Empresa {
    private Cliente[] clientes;
    private Funcionario[] funcionarios;
    private int contadorClientes;
    private int contadorFuncionarios;

    public Empresa() {
        this.clientes = new Cliente[5];
        this.funcionarios = new Funcionario[10];
        this.contadorClientes = 0;
        this.contadorFuncionarios = 0;
    }

    public String adicionarCliente(String nome, String email) {
        if (contadorClientes < clientes.length) {
            clientes[contadorClientes] = new Cliente(nome, email);
            contadorClientes++;
            return "Cliente adicionado: " + nome;
        }
        return "Limite de clientes atingido.";
    }

    public String exibirClientes() {
        if (contadorClientes == 0) {
            return "Nenhum cliente cadastrado.";
        }
        StringBuilder sb = new StringBuilder("Clientes:\n");
        for (int i = 0; i < contadorClientes; i++) {
            sb.append("Nome: ").append(clientes[i].getNome())
              .append(", Email: ").append(clientes[i].getEmail()).append("\n");
        }
        return sb.toString();
    }

    public String adicionarFuncionario(String nome, String cargo, double salario) {
        if (contadorFuncionarios < funcionarios.length) {
            funcionarios[contadorFuncionarios] = new Funcionario(nome, cargo, salario);
            contadorFuncionarios++;
            return "Funcionário adicionado: " + nome;
        }
        return "Limite de funcionários atingido.";
    }

    public String exibirFuncionarios() {
        if (contadorFuncionarios == 0) {
            return "Nenhum funcionário cadastrado.";
        }
        StringBuilder sb = new StringBuilder("Funcionários:\n");
        for (int i = 0; i < contadorFuncionarios; i++) {
            sb.append("Nome: ").append(funcionarios[i].getNome())
              .append(", Cargo: ").append(funcionarios[i].getCargo()).append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double totalSalario = 0;
        for (int i = 0; i < contadorFuncionarios; i++) {
            totalSalario += funcionarios[i].getSalario();
        }
        return totalSalario;
    }

    public double calcularMediaSalarial() {
        if (contadorFuncionarios == 0) {
            return 0;
        }
        double totalSalario = calcularFolhaSalarial();
        return totalSalario / contadorFuncionarios;
    }

    public String exibirMediaSalarial() {
        double media = calcularMediaSalarial();
        return "Média Salarial: " + media;
    }
}

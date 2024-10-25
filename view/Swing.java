package br.edu.fatecpg.associacao.view;

import javax.swing.*;
import br.edu.fatecpg.associacao.model.Calculadora;
import br.edu.fatecpg.associacao.model.Empresa;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing extends JFrame {
    private Empresa empresa;
    private JTextArea outputArea;

    public Swing() {
        empresa = new Empresa();
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        setTitle("Sistema de Gestão de Empresa");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Funcionário", createFuncionarioPanel());
        tabbedPane.addTab("Cliente", createClientePanel());
        tabbedPane.addTab("Calculadora", createCalculadoraPanel());
        tabbedPane.addTab("Folha Salarial", createFolhaSalarialPanel());

        add(tabbedPane, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    private JPanel createFuncionarioPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        JTextField nomeField = new JTextField(15);
        JTextField cargoField = new JTextField(15);
        JTextField salarioField = new JTextField(15);
        JButton addButton = new JButton("Adicionar Funcionário");

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Cargo:"));
        panel.add(cargoField);
        panel.add(new JLabel("Salário:"));
        panel.add(salarioField);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cargo = cargoField.getText();
                double salario = Double.parseDouble(salarioField.getText());
                String result = empresa.adicionarFuncionario(nome, cargo, salario);
                outputArea.setText(result);
            }
        });
        return panel;
    }

    private JPanel createClientePanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        
        JTextField nomeField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JButton addButton = new JButton("Adicionar Cliente");

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String result = empresa.adicionarCliente(nome, email);
                outputArea.setText(result);
            }
        });
        return panel;
    }

    private JPanel createCalculadoraPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        JTextField num1Field = new JTextField(15);
        JTextField num2Field = new JTextField(15);
        JButton addButton = new JButton("Somar");
        JButton multButton = new JButton("Multiplicar");

        panel.add(new JLabel("Número 1:"));
        panel.add(num1Field);
        panel.add(new JLabel("Número 2:"));
        panel.add(num2Field);
        panel.add(addButton);
        panel.add(multButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                Calculadora calculadora = new Calculadora();
                double result = calculadora.somar(num1, num2);
                outputArea.setText("Soma: " + result);
            }
        });

        multButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                Calculadora calculadora = new Calculadora();
                double result = calculadora.multiplicar(num1, num2);
                outputArea.setText("Multiplicação: " + result);
            }
        });
        return panel;
    }

    private JPanel createFolhaSalarialPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        JButton calcFolhaButton = new JButton("Calcular Folha Salarial");
        JButton calcMediaButton = new JButton("Calcular Média Salarial");

        panel.add(calcFolhaButton);
        panel.add(calcMediaButton);

        calcFolhaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double folha = empresa.calcularFolhaSalarial();
                outputArea.setText("Folha Salarial Total: " + folha);
            }
        });

        calcMediaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double media = empresa.calcularMediaSalarial();
                outputArea.setText("Média Salarial: " + media);
            }
        });
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Swing().setVisible(true));
    }
}


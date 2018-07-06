package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
/**
 * @author Rosicléia Frasson
 */
public class ListarContatos extends JFrame {
    JPanel painelFundo;
    JTable tabela = new JTable();
    JScrollPane barraRolagem;
    public Object[][] dados;
    public String[] colunas; 
    
    public void criaJanela(ArrayList<model.PessoaFisica> listaDados, String[] colunas){         
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        DefaultTableModel modelo = new DefaultTableModel();
        Iterator<model.PessoaFisica> i = listaDados.iterator();
        for(int counter=0;counter<colunas.length;counter++) {
        	modelo.addColumn(colunas[counter]);
        }
        for(;i.hasNext();) {
	        Object o = (Object)i.next();
	        model.PessoaFisica p = (model.PessoaFisica)o;
	        System.out.println(p.getNome());
	        Object[] aa = {p.getId(), p.getBairro(), p.getCelular(), p.getCep(), p.getCidade(), p.getCpf(), p.getEndereco(), p.getEstado(), p.getNome(), p.getRg(), p.getSexo(), p.getTelefone()};
        	modelo.addRow(aa);
        }
        barraRolagem = new JScrollPane(tabela);
        tabela.setModel(modelo);
        painelFundo.add(barraRolagem);          
        getContentPane().add(painelFundo);
        setSize(500, 120);
        setVisible(true);
    }    

    /*Object [][] dados = {
        {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
        {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
        {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
    };	     
    String [] colunas = {"Nome", "Telefone", "Email"}; */
}
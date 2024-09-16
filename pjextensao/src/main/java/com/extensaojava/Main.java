package com.extensaojava;   

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

           String fileName = "pjextensao\\src\\main\\resources\\LISTA DE CONTATOS DA POS.xlsx"; 
   
           FileInputStream inputStream = new FileInputStream(new File(fileName));
   
           Workbook workbook = WorkbookFactory.create(inputStream);
   
           Sheet sheet = workbook.getSheetAt(0);
   
           List<Professor> professores = new ArrayList<>();

           DataFormatter formatter = new DataFormatter();
   
           // Iterando sobre as linhas
           int ultimaLinha = 130;
           for (int i=2; i<ultimaLinha; i++){
            Row row = sheet.getRow(i);
            if ( row != null ) {

   
               // Obtendo os dados da linha
               String nome = formatter.formatCellValue(row.getCell(0));
               String cpf = formatter.formatCellValue(row.getCell(2));
               String rg = formatter.formatCellValue(row.getCell(3));
               String pis = formatter.formatCellValue(row.getCell(4));
               String localnasc = formatter.formatCellValue(row.getCell(8));
               String datanasc = formatter.formatCellValue(row.getCell(7));
               String endereco = formatter.formatCellValue(row.getCell(11));
   
               // Criando um objeto Professor
               Professor professor = new Professor(nome, cpf, rg, pis, localnasc, datanasc, endereco, null, null);
   
               // Adicionando o professor à lista
               professores.add(professor);
            }
           }
           
           // Fechando o fluxo de entrada
           inputStream.close();
           // Iniciando as variáveis para iteração e adição de dados.
           Professor p = new Professor(fileName, fileName, fileName, fileName, fileName, fileName, fileName, fileName, fileName);
           List<Professor> resultadoBusca = new ArrayList<>();
           Scanner scanner = new Scanner(System.in);
           Scanner scanner2 = new Scanner(System.in);
           Scanner scanner3 = new Scanner(System.in);
           ArrayList<String> procuraprof = new ArrayList<>();

              // Pedir ao usuário para inserir os elementos
           System.out.println("Digite nomes ou CPFs para procura na lista (digite 'fim' para parar):");
           String elemento;
           while (!(elemento = scanner.nextLine()).equals("fim")) {
               procuraprof.add(elemento);
           }
           for (String j:procuraprof){
            Professor professorEncontrado = p.buscaProfessor(j,professores);
            resultadoBusca.add(professorEncontrado);}
           for (Professor professor : resultadoBusca) {
           System.out.println("Digite os valores para cada professor, em ordem (digite 'fim' para parar):");
           String elemento2 = ("R$" + scanner2.nextLine());
            professor.setValor(elemento2);
           }
           System.out.println("Digite a Data de Pagamento:");
           String elemento3 = scanner3.nextLine();
           for (Professor professor : resultadoBusca){
            professor.setDatapgto(elemento3);
           }
           scanner.close();
           scanner2.close();
           scanner3.close();

           String nomeArquivo = "RPA Mensal.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Professor i : resultadoBusca){
                writer.write("Nome Completo: " + i.getNome());
                writer.newLine();
                writer.write("CPF: " + i.getCpf());
                writer.newLine();
                writer.write("RG: " + i.getRg());
                writer.newLine();
                writer.write("PIS: " + i.getPis());
                writer.newLine();
                writer.write("Local de Nascimento: " + i.getPis());
                writer.newLine();
                writer.write("Data de Nascimento: " + i.getDatanasc());
                writer.newLine();
                writer.write("Endereço: " + i.getEndereco());
                writer.newLine();
                writer.write("Valor: " + i.getValor());
                writer.newLine();
                writer.write("Data de Pagamento: " + i.getDatapgto());
                writer.newLine();
                writer.write(System.lineSeparator());

        }
     }
        catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

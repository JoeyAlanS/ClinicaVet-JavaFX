package org.example.clinicavet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.clinicavet.exceptions.AnimalJaExisteException;
import org.example.clinicavet.exceptions.FuncionarioJaExisteException;
import org.example.clinicavet.exceptions.ServicoJaExisteException;
import org.example.clinicavet.models.*;
import org.example.clinicavet.services.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MainViewController {

    @FXML
    private TableView<Animal> animalTable;
    @FXML
    private TableColumn<Animal, String> nomeColumn;
    @FXML
    private TableColumn<Animal, Integer> idadeColumn;
    @FXML
    private TableColumn<Animal, String> especieColumn;

    @FXML
    private TableView<Funcionario> funcionarioTable;
    @FXML
    private TableColumn<Funcionario, String> nomeFuncionarioColumn;
    @FXML
    private TableColumn<Funcionario, String> cpfFuncionarioColumn;
    @FXML
    private TableColumn<Funcionario, Double> salarioFuncionarioColumn;

    @FXML
    private TableView<ServicoAnimal> servicoTable;
    @FXML
    private TableColumn<ServicoAnimal, String> descricaoServicoColumn;
    @FXML
    private TableColumn<ServicoAnimal, Double> precoServicoColumn;

    @FXML
    private TableView<Adocao> adocaoTable;
    @FXML
    private TableColumn<Adocao, String> especieAdocaoColumn;

    @FXML
    private TextField nomeAnimalField;
    @FXML
    private TextField idadeAnimalField;
    @FXML
    private TextField especieAnimalField;

    @FXML
    private TextField nomeFuncionarioField;
    @FXML
    private TextField cpfFuncionarioField;
    @FXML
    private TextField salarioFuncionarioField;

    @FXML
    private TextField descricaoServicoField;
    @FXML
    private TextField precoServicoField;

    @FXML
    private ComboBox<ServicoAnimal> servicoComboBox;
    @FXML
    private TextField animalTextField;
    @FXML
    private DatePicker dataDatePicker;

    @FXML
    private TextField nomeVeterinarioTextField;
    @FXML
    private TextField cpfVeterinarioTextField;

    private ObservableList<ServicoAnimal> servicosPredefinidos;
    private Set<String> animaisRegistrados;
    private Set<String> funcionariosRegistrados;
    private Set<String> servicosRegistrados;

    @FXML
    private void initialize() {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idadeColumn.setCellValueFactory(new PropertyValueFactory<>("idade"));
        especieColumn.setCellValueFactory(new PropertyValueFactory<>("especie"));

        nomeFuncionarioColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfFuncionarioColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        salarioFuncionarioColumn.setCellValueFactory(new PropertyValueFactory<>("salario"));

        descricaoServicoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        precoServicoColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));

        especieAdocaoColumn.setCellValueFactory(new PropertyValueFactory<>("especie"));

        servicosPredefinidos = FXCollections.observableArrayList(
                new ServicoTosa(), new ServicoBanho(), new ServicoConsulta()
        );
        servicoComboBox.setItems(servicosPredefinidos);

        animaisRegistrados = new HashSet<>();
        funcionariosRegistrados = new HashSet<>();
        servicosRegistrados = new HashSet<>();
    }

    @FXML
    private void handleAdicionarAnimal() {
        String nome = nomeAnimalField.getText();
        String idadeText = idadeAnimalField.getText();
        String especie = especieAnimalField.getText();

        try {
            if (animaisRegistrados.contains(nome)) {
                throw new AnimalJaExisteException("Animal com o nome " + nome + " já existe.");
            }
            int idade = Integer.parseInt(idadeText);
            Animal animal = new Animal(nome, idade, especie);
            animalTable.getItems().add(animal);
            animaisRegistrados.add(nome);
            clearAnimalFields();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "A idade deve ser um número inteiro.");
        } catch (AnimalJaExisteException e) {
            showAlert("Erro de Duplicação", e.getMessage());
        }
    }

    @FXML
    private void handleAdicionarFuncionario() {
        String nome = nomeFuncionarioField.getText();
        String cpf = cpfFuncionarioField.getText();
        String salarioText = salarioFuncionarioField.getText();

        try {
            if (funcionariosRegistrados.contains(cpf)) {
                throw new FuncionarioJaExisteException("Funcionário com o CPF " + cpf + " já existe.");
            }
            double salario = Double.parseDouble(salarioText);
            Funcionario funcionario = new Veterinario(nome, cpf, salario);
            funcionarioTable.getItems().add(funcionario);
            funcionariosRegistrados.add(cpf);
            clearFuncionarioFields();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "O salário deve ser um número.");
        } catch (FuncionarioJaExisteException e) {
            showAlert("Erro de Duplicação", e.getMessage());
        }
    }

    @FXML
    private void handleAdicionarServico() {
        String descricao = descricaoServicoField.getText();
        String precoText = precoServicoField.getText();

        try {
            if (servicosRegistrados.contains(descricao)) {
                throw new ServicoJaExisteException("Serviço com a descrição " + descricao + " já existe.");
            }
            double preco = Double.parseDouble(precoText);
            ServicoAnimal servico = new ServicoGenerico(descricao, preco);
            servicoTable.getItems().add(servico);
            servicosRegistrados.add(descricao);
            clearServicoFields();
        } catch (NumberFormatException e) {
            showAlert("Erro de Formato", "O preço deve ser um número.");
        } catch (ServicoJaExisteException e) {
            showAlert("Erro de Duplicação", e.getMessage());
        }
    }

    @FXML
    private void adicionarAgendamento() {
        ServicoAnimal servico = servicoComboBox.getValue();
        String animal = animalTextField.getText();
        LocalDate data = dataDatePicker.getValue();
    }

    @FXML
    private void adicionarGato() {
        Adocao adocao = new Adocao("Gato");
        adocaoTable.getItems().add(adocao);
    }

    @FXML
    private void adicionarRato() {
        Adocao adocao = new Adocao("Rato");
        adocaoTable.getItems().add(adocao);
    }

    private void clearAnimalFields() {
        nomeAnimalField.clear();
        idadeAnimalField.clear();
        especieAnimalField.clear();
    }

    private void clearFuncionarioFields() {
        nomeFuncionarioField.clear();
        cpfFuncionarioField.clear();
        salarioFuncionarioField.clear();
    }

    private void clearServicoFields() {
        descricaoServicoField.clear();
        precoServicoField.clear();
    }

    @FXML
    private void adicionarVeterinario() {
        String nome = nomeVeterinarioTextField.getText();
        String cpf = cpfVeterinarioTextField.getText();

        Veterinario veterinario = new Veterinario(nome, cpf);
        funcionarioTable.getItems().add(veterinario);

        nomeVeterinarioTextField.clear();
        cpfVeterinarioTextField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

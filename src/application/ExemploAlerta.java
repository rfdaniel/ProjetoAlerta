package application;

import java.util.Arrays;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExemploAlerta extends Application {
	
	private Button botao01 = new Button("Exemplo 01");
	private Button botao02 = new Button("Exemplo 02");
	private Button botao03 = new Button("Exemplo 03");
	private Button botao04 = new Button("Exemplo 04");
	private Button botao05 = new Button("Exemplo 05");
	private Button botao06 = new Button("Exemplo 06");
	private Button botao07 = new Button("Exemplo 07");
	private Button botao08 = new Button("Exemplo 08");
	private Button botao09 = new Button("Exemplo 09");

	@Override
	public void init() throws Exception {
		super.init();
		
		//Exemplo de um alerta de informa��o sem o cabe�alho
		botao01.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Informa��o");
				//retirando o cabe�alho
				alert.setHeaderText(null);
				alert.setContentText("Voc� clicou no exemplo 01!");
				alert.show();
			}
		});
		
		botao02.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro");
				alert.setHeaderText(null);
				alert.setContentText("S� � poss�vel realizar cadastro de reserva para hospede cadastrado!");
				alert.show();
			}
		});
		
		botao03.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Aviso");
				alert.setHeaderText(null);
				alert.setContentText("N�o fa�a merda!");
				alert.show();
			}
		});
		
		botao04.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirma��o");
				alert.setHeaderText("Est� opera��o � um pouco cr�tica!");
				alert.setContentText("Deseja realmente excluir?");
				
				//Capturar as resposta do usu�rio sobre a mensagem de confirma��o
				Optional<ButtonType> resposta = alert.showAndWait();
				if(resposta.get().equals(ButtonType.OK)) {
					System.out.println("Oquei");
				}else if(resposta.get().equals(ButtonType.CANCEL)) {
					System.out.println("Cancelar");
				}
			}
		});
		
		//Op��o apenas com a estrutura da janela de alerta para ser adiconada as funcionalidades
		botao05.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.NONE);
				alert.setTitle("Nada");
				alert.setHeaderText(null);
				alert.setContentText("Nothing");
				alert.show();
			}
		});
		
		botao06.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Informa��o");
				alert.setHeaderText("Detalhes");
				alert.setContentText("Voc� clivou no bot�o 06 .. veja mais detalhes");
				
				Label lblDetalhes = new Label("Descri��o");
				alert.getDialogPane().setExpandableContent(lblDetalhes);
				
				alert.show();
			}
		});
		
		//Adicionando outros bot�es
		botao07.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.NONE);
				alert.setTitle("Informa��o");
				alert.setHeaderText("Outros bot�es");
				alert.setContentText("Selecione uma das op��es");
				
				ButtonType btnSim = new ButtonType("Sim");
				ButtonType btnNao = new ButtonType("N�o");
				ButtonType btnTalvez = new ButtonType("Talvez");
				ButtonType btnCerteza = new ButtonType("Certeza", ButtonData.CANCEL_CLOSE);
				
				alert.getButtonTypes().addAll(btnSim, btnNao, btnTalvez, btnCerteza);
				
				Optional<ButtonType> resposta = alert.showAndWait();
				System.out.println(resposta.get().getText());
			}
		});
		
		botao08.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				TextInputDialog dialog = new TextInputDialog("Palmas");
				dialog.setTitle("Munic�pio");
				dialog.setHeaderText("Cabe�alho qualquer");
				dialog.setContentText("Informe o nome da sua cidade: ");
				
				Optional<String> resposta = dialog.showAndWait();
				if(resposta.isPresent()) {
					System.out.println("A cidade digitada foi: " + resposta.get());
				}
			}
		});
		
		botao09.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ChoiceDialog<String> dialog = new ChoiceDialog<String>("Palmas", Arrays.asList("Araguaina", "Para�so", "Palmas"));
				Optional<String> resposta = dialog.showAndWait();
				System.out.println(resposta.get());
			}
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new VBox();
		root.getChildren().addAll(botao01, botao02, botao03, botao04, 
								botao05, botao06, botao07, botao08, botao09);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);
		
		Scene scene = new Scene(root, 400, 600);
		
		// Adiciona a cena no palco
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

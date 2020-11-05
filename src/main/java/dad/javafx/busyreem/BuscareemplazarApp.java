package dad.javafx.busyreem;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscareemplazarApp extends Application {
	private Label buscar;
	private Label reemplazar;
	private TextField buscarTexto;
	private TextField reemplazarTexto;
	private RadioButton mayusyminus;
	private RadioButton expresion;
	private RadioButton buscaratras;
	private RadioButton resaltar;
	private Button buscarboton;
	private Button reemplazarboton;
	private Button reemplazartodo;
	private Button cerrar;
	private Button aiuda;
	
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		buscar = new Label("Buscar:");
		reemplazar = new Label ("Reemplazar con:");
		
		buscarTexto = new TextField(); //caja de texto y predefinimos el tamaño.
		reemplazarTexto = new TextField();
		
		mayusyminus = new RadioButton("Mayúsculas y minúsculas");
		expresion = new RadioButton("Expresión regular");
		buscaratras = new RadioButton("Buscar hacia atrás");
		resaltar = new RadioButton("Resaltar resultados");
		
		buscarboton = new Button("Buscar");
		buscarboton.setPrefWidth(150);
		reemplazarboton = new Button("Reemplazar");
		reemplazarboton.setPrefWidth(150);
		reemplazartodo = new Button("Reemplazar todo");
		reemplazartodo.setPrefWidth(150);
		cerrar = new Button("Cerrar");
		cerrar.setPrefWidth(150);
		aiuda = new Button("Aiuda");
		aiuda.setPrefWidth(150);
		
		ToggleGroup grupo = new ToggleGroup();// no es una caja en si mismo, solo le da las propiedades ( uno pulsado al mismo tiempo) 
		grupo.getToggles().addAll(mayusyminus, expresion, buscaratras, resaltar);
		
		GridPane grupo2 = new GridPane();
		grupo2.addRow(0, mayusyminus, buscaratras);
		grupo2.addRow(1, expresion, resaltar);
		
		VBox root = new VBox();  // cajita donde meter las cosas que queremos visualizar, siempre en orden de arriba a abajo.
		root.getChildren().addAll(reemplazartodo, cerrar, aiuda);
		root.setAlignment(Pos.BASELINE_CENTER);
		
		GridPane view = new GridPane();
		view.setHgap(5);
		view.setVgap(5);
		view.setAlignment(Pos.BASELINE_CENTER);
		view.addRow(0, buscar, buscarTexto, buscarboton);
		view.addRow(1, reemplazar, reemplazarTexto, reemplazarboton);
		view.addRow(2, new Label (""), grupo2,root);
		
		ColumnConstraints[] constrain1 = {new ColumnConstraints(),new ColumnConstraints()};
		constrain1[0].setHalignment(HPos.LEFT);
		grupo2.getColumnConstraints().setAll(constrain1);
		
		Scene principal = new Scene(view, 500, 300);
		primaryStage.setTitle("BuscaryreemplazarApp.fxml");
		primaryStage.setScene(principal);
		primaryStage.show();
	}


	
	public static void main(String[] args) { // en el main de esta clase siempre se pone launch args
		launch(args);
		}
}
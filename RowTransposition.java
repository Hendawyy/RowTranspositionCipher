package rowtransposition;



import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;


public class RowTransposition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label ltitle=new Label("Row Transposition ");
        Label lr=new Label("Result");
        lr.setTextFill(Color.GREEN);
        lr.setFont(new Font("Arial", 24));
        Button encryptButton=new Button();
        encryptButton.setStyle("-fx-background-color:#746AB0;-fx-text-fill: #ffffff;-fx-border-color: #ffffff; -fx-border-width: 8px;");
        Text t1=new Text("Plain Text \t");
        t1.setFont(Font.font("Arial", FontWeight.MEDIUM, 24));
        t1.setFill(Color.FUCHSIA);
        TextField tf1=new TextField();
        Button decryptButton=new Button();
        decryptButton.setStyle("-fx-background-color:#288BA8;-fx-text-fill: #ffffff;-fx-border-color: #ffffff; -fx-border-width: 8px;");
        Text t2=new Text("Key");
        t2.setFont(Font.font("Arial", FontWeight.MEDIUM, 24));
        t2.setFill(Color.BLUE);
        TextField tf2=new TextField();
        tf1.setStyle("-fx-text-inner-color: FUCHSIA;");
        tf2.setStyle("-fx-text-inner-color: BLUE;");
        TextArea ta=new TextArea();
        ta.setStyle("-fx-text-inner-color: GREEN;");
        Text terror=new Text();
        terror.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        terror.setFill(Color.RED);
        RowTransClass RT=new RowTransClass();
        GridPane GP=new GridPane();
        GridPane GP1=new GridPane();
        //  button encrypt
        encryptButton.setText("Encrypt");
        encryptButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            	String str1=tf1.getText();
            	String str2=tf2.getText();
            	
                
                if((str1.equals("") || str2.equals(""))){
                    terror.setText("Plain Text Or Key is Empty.\nPlease Enter It.");
                }
                if(str2.matches("[a-zA-Z]+")) {
                	terror.setText("Must Be Numeric");
                }
                else{
                    ta.clear();
                    ta.appendText("Cipher text \n");
                    ta.appendText(RT.Encrypt(str1, str2));
                    terror.setText("");
                    
                    tf1.clear();
                    tf2.clear();
                }
            }
        });
        
        decryptButton.setText("Decrypt");
        decryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str1=tf1.getText();
                String str2=tf2.getText();
                if(str1.equals("") || str2.equals("")){
                    terror.setText("Plain Text Or Key is Empty.\nPlease Enter It.");
                }if(str2.matches("[a-zA-Z]+")) {
                	terror.setText("Must Be Numeric");
                }else{
                    ta.clear();
                    ta.appendText("Plain text  \n");
                    ta.appendText(RT.Decrypt(tf1.getText(), tf2.getText()));
                    terror.setText("");
                    tf1.clear();
                    tf2.clear();
                    
                }
                
            }
        });
        
        
        GP.setAlignment(Pos.CENTER);
        GP.add(terror, 1, 0);
        GP.add(t1, 0, 1);
        GP.add(tf1, 1, 1);
        GP.add(t2, 0, 2);
        GP.add(tf2, 1, 2);
        GP.add(GP1, 1, 3);
        GP1.setAlignment(Pos.BOTTOM_CENTER);
        GP1.add(encryptButton, 0, 0);
        GP1.add(decryptButton, 1, 0);
        GP.add(lr, 0, 4);
        GP.add(ta, 1, 4);
        Scene scene = new Scene(GP, 700, 450);
        primaryStage.setTitle("Row transposition ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}

package src.version2;

import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


/*10*(8-6)+4*/
public class version2Controller implements Initializable {
	 ArrayList<Integer> list = new ArrayList<Integer>();
	 InfixInToSuffix infixInToSuffix = new InfixInToSuffix();
	 Alert alert = new Alert(AlertType.INFORMATION);
	 Experssion exp = new Experssion();
		Thinker ti = new Thinker(exp);
		ArrayList<Integer> card = new ArrayList<Integer>();
		int sum = 24;
	 
   @FXML
   private HBox hb;
   @FXML
   private Button myButton;
   @FXML
   private TextField tf;
   @FXML
   private TextField tf2;
   @FXML
   private TextField tf3;
   @FXML
   private TextField tf4;
   @FXML
   private TextField tf5;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   
	   for (int i = 1; i <= 52; i++) {
		      list.add(i);
		    }
	   
	    java.util.Collections.shuffle(list);
	    
	    
       // TODO (don't really need to do anything here).
	    hb.getChildren().add(new ImageView("file:card/" + list.get(0) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(1) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(2) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(3) + ".png"));
	    hb.setAlignment(Pos.CENTER);

   }
   
@FXML 
public void btn1(ActionEvent e){
	hb.getChildren().clear();
	 java.util.Collections.shuffle(list);
	  hb.getChildren().add(new ImageView("file:card/" + list.get(0) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(1) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(2) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(3) + ".png"));
	    hb.setAlignment(Pos.CENTER);
}


@FXML
public void btn2(ActionEvent e) {
	
	String text = tf.getText();
	  String a = infixInToSuffix.toSuffix(text);//���� һ�� ������ʽ  
	         
	          if(infixInToSuffix.dealEquation(a).equals("24.0") ) {
	        	  alert.setContentText("correct");
	          }
	          
	          else
	        	  alert.setContentText("incorrectNumbers");
	        	  
	           alert.show();
	           	
}
@FXML 
public void btn3(ActionEvent e) {
	String text1  = tf2.getText();
	String text2  = tf3.getText();
	String text3  = tf4.getText();
	String text4  = tf5.getText();
	
	card.add(Integer.parseInt(text1));
	System.out.println(Integer.parseInt(text1));
	card.add(Integer.parseInt(text2));
	System.out.println(Integer.parseInt(text2));
	card.add(Integer.parseInt(text3));
	System.out.println(Integer.parseInt(text3));
	card.add(Integer.parseInt(text4));
	System.out.println(Integer.parseInt(text4));
	ti.count(card, card.size() - 1, sum);
	
	
	System.out.println(ti.s.toString());
	if(ti.s.toString().equals(" ")||ti.s.toString().equals(null)||ti.s.toString().hashCode() == 0) {
		alert.setContentText("no solution");
	}
	else
		alert.setContentText(ti.s.toString());
	
	alert.show();
	
	
	
}


}
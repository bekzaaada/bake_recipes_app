package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Ellipse boardEllipse = new Ellipse(200, 50, 140, 45);
        boardEllipse.setFill(Color.WHITE);
        Rectangle cap = new Rectangle(110, 40, 30,25);
        cap.setFill(Color.GRAY);
        Ellipse capsEllipse = new Ellipse(125, 30, 25,15);
        capsEllipse.setFill(Color.GRAY);
        Line line = new Line(153, 20,153, 65 );
        line.setFill(Color.BLUE);
        line.setStrokeWidth(5);
        line.setStartX(153);
        line.setStartY(20);
        Ellipse labelsPart1 = new Ellipse(175, 30, 20, 13 );
        labelsPart1.setFill(Color.BLUE);
        Ellipse labelsPart2 = new Ellipse(175, 50, 20, 14 );
        labelsPart2.setFill(Color.BLUE);
        Label recipes = new Label("RECIPES");
       // recipes.setFont(Verdana);



        HBox hbox = new HBox(30);
        hbox.setPrefSize(400, 400);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(boardEllipse, cap, capsEllipse, line, labelsPart1, labelsPart2);


        Pane pane = new Pane(boardEllipse, cap, capsEllipse, line, labelsPart1, labelsPart2);
        Scene scene = new Scene(pane, 400, 400);
        scene.setFill(Color.BROWN);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

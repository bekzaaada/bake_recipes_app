package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    static Cake[] cakes = new Cake[5];
    public void init(){
        cakes[0]= new Cake("Медовик", "125 г маргарина или масла\n" +
                "1 стакан сахарного песка\n" +
                "2-3 ст. л. меда\n" +
                "1 ч. л. соды не гашеной\n" +
                "2 яйца\n" +
                "3,5-4 стакана муки","0,5 кг сметаны 15-20%\n" +
                "1 стакан сахарного песка","Сахарная помадка\n"+
                "Маршмеллоу, или жевательный зефир\n"+
                "Масляная глазурь", "4 часа",
                new Image("File:///C:/Users/bekza/Desktop/examples/projects/medovik.png"));
        cakes[1]= new Cake("Вупипай", "Мука пшеничная / Мука — 250 г\n" +
                "Сахар — 250 г\n" +
                "Молоко — 125 мл\n" +
                "Масло сливочное — 120 г\n" +
                "Яйцо куриное — 2 шт\n" +
                "Какао-порошок — 4 ст. л.\n" +
                "Вода (Горячая) — 70 мл\n" +
                "Сода — 1 ч. л", "Сыр творожный — 500 г\n" +
                "Сливки (33%) — 500 мл\n" +
                "Сахарная пудра — 150 г","Шоколад темный — 200 г\n" +
                "Масло сливочное — 50 г\n" +
                "Молоко — 30 мл", "150 минут",
                new Image("File:///C:/Users/bekza/Desktop/examples/projects/whoopi.png"));
        cakes[2]= new Cake("Milky girl", "Для коржей:\n" +
                "Сгущенное молоко - 300 г\n" +
                "Яйцо - 3 шт. (общий вес со скорлупой - 195 г)\n" +
                "Соль - 1 щепотка\n" +
                "Мука пшеничная - 180 г\n" +
                "Разрыхлитель - 10 г\n" +
                "Масло сливочное - для смазывания пергамента или силиконового коврика", "Сливки 33% - 500 г\n" +
                "Сгущенное молоко - 80 г\n" +
                "Ванильный сахар - 10 г",
                "крем чиз\n"+"шоколад — 200 гр.\n"+
                "любые ягоды\n"+"фрукты\n"+"цукаты или орешки.", "1,5 часа + 6 часов для пропитки коржей",
                new Image("File:///C:/Users/bekza/Desktop/examples/projects/milk.png"));
        cakes[3]= new Cake("Red velvet", "Мука - 340 г\n" +
                "Сахар - 300 г\n" +
                "Какао - 1 ст. ложка\n" +
                "Соль - 1/4 ч. ложки\n" +
                "Разрыхлитель - 2 ч. ложки\n" +
                "Сода - 1 ч. ложка\n" +
                "Яйца - 3 шт.\n" +
                "Кефир 3,2% - 200 мл\n" +
                "Сливки 33% - 80 г\n" +
                "Масло подсолнечное - 300 г\n" +
                "Краситель пищевой красный (гелевый) - 2 ч. ложки", "Масло сливочное 82,5% - 100 г\n" +
                "Пудра сахарная - 100 г\n" +
                "Сыр сливочный (Филадельфия) - 350 г", "шоколад — 200 гр.\n"+"любые ягоды\n"+"фрукты", "130 минут",
                new Image("File:///C:/Users/bekza/Desktop/examples/projects/redvelvet.png"));
        cakes[4]=new Cake("Сникерс", "Мука - 190 г\n" +
                "Яйцо куриное - 1 шт.\n" +
                "Сахар - 200 г\n" +
                "Какао-порошок - 45 г\n" +
                "Масло растительное - 75 мл\n" +
                "Молоко - 75 мл\n" +
                "Кофе растворимый - 2 ст. л.\n" +
                "Вода (кипяток) - 200 мл\n" +
                "Разрыхлитель - 1 ч. л.\n" +
                "Сода - 1/4 ч. л", "Сгущёнка варёная - 380 г\n" +
                "Масло сливочное - 180 г\n"+
                "Шоколад тёмный - 180 г\n" +
                "Сливки жирные (от 30%) - 180 г\n"+
                "Арахис жареный (солёный) ~ 200 г\n" +
                "Карамель солёная домашняя ~ 200 г", "Конфетами и арахисом", "3 часа",
                new Image("File:///C:/Users/bekza/Desktop/examples/projects/snikers1.jpg"));

    }
    public static void createStage(String cakeName){
        GridPane gridPane = new GridPane();
        Label ingredients = new Label("Ингридиенты для");
        ingredients.setFont(Font.font("Britannic Bold", 20));
        ingredients.setTextFill(Color.BLACK);
        gridPane.add(ingredients, 0,0);
        ComboBox<Cake> cakeComboBox = new ComboBox<>();
        cakeComboBox.setMaxSize(270,20);
        cakeComboBox.setStyle("-fx-background-color:rgb(34, 186, 193)");
        cakeComboBox.setStyle("-fx-border-color:rgb(34, 186, 193)");
        cakeComboBox.getItems().addAll(cakes);
        cakeComboBox.setValue(cakes[0]);
        gridPane.add(cakeComboBox, 1, 0);
        Label forDough = new Label("Для теста:");
        forDough.setFont(Font.font("Britannic Bold", 16));
        gridPane.add(forDough, 0, 1);
        TextArea textAreaForRecipe = new TextArea();
        textAreaForRecipe.setMaxSize(270, 200);
        textAreaForRecipe.setEditable(false);
        gridPane.add(textAreaForRecipe, 1, 1);
        Label forCream = new Label("Для крема:");
        forCream.setFont(Font.font("Britannic Bold", 16));
        gridPane.add(forCream, 0, 2);
        TextArea textAreaForCream = new TextArea();
        textAreaForCream.setMaxSize(270, 150);
        textAreaForCream.setEditable(false);
        gridPane.add(textAreaForCream, 1, 2);
        TextArea textAreaForDecoration = new TextArea();
        textAreaForDecoration.setMaxSize(270, 80);
        textAreaForDecoration.setEditable(false);
        gridPane.add(textAreaForDecoration, 1, 3);
        Label forDecoration = new Label("Для украшения:");
        forDecoration.setFont(Font.font("Britannic Bold", 16));
        gridPane.add(forDecoration, 0, 3);
        TextArea textAreaForTime = new TextArea();
        textAreaForTime.setStyle("-fx-background-color:rgb(34, 186, 193)");
        textAreaForTime.setEditable(false);
        gridPane.add(textAreaForTime, 1, 5);
        textAreaForTime.setMaxSize(270, 50);
        Label forTime = new Label("Время приготовления:");
        forTime.setFont(Font.font("Britannic Bold", 16));
        gridPane.add(forTime, 0, 5);
        ImageView imageView1 = new ImageView();
        imageView1.setX(0);
        imageView1.setFitWidth(360);
        imageView1.setFitHeight(463);
        imageView1.setY(2);
        gridPane.setStyle("-fx-background-color: rgb(227, 165, 209)");
        Pane pictures = new Pane(imageView1);
        BorderPane position = new BorderPane();
        position.setTop(new Logo());
        position.setTop(CustomPane.getHBox());
        position.setLeft(CustomPane.getVBox());
        position.setLeft(gridPane);
        position.setRight(pictures);
        Stage stage = new Stage();
        stage.setScene(new Scene(position, 800,600));
        stage.show();
        cakeComboBox.setOnAction(event->{
            Cake cake = cakeComboBox.getValue();
            textAreaForRecipe.setText(cake.testoRecipe);
            textAreaForCream.setText(cake.creamRecipe);
            textAreaForDecoration.setText(cake.forDecoration);
            textAreaForTime.setText(cake.time);
            imageView1.setImage(cake.image1);
        });
    }

    @Override
    public void start(Stage primaryStage){
       // backgroundMusic();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new CustomPane(" "));
        //borderPane.setRight(new CustomPane(" "));
        borderPane.setLeft(new CustomPane(" "));
        //borderPane.setBottom(new StarPane(20,200, Color.BLUE));
        borderPane.setCenter(new CustomPane(" "));

        borderPane.setTop(CustomPane.getHBox());
        borderPane.setLeft(CustomPane.getVBox());
        borderPane.setCenter(CustomPane.getImage());

        Pane stars = StarPane.getAnimation();
        stars.setMaxSize(600,540);
        stars.setLayoutX(0);
        stars.setLayoutY(530);
        Scene scene = new Scene(new Pane(borderPane, stars));

        primaryStage.setTitle("Recipes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    MediaPlayer mediaPlayer;
//    public void backgroundMusic(){
//        String audioPath = "C:\\Users\\bekza\\Desktop\\examples\\projects\\together.mp3";
//        Media music = new Media(new File(audioPath).toURI().toString());
//        mediaPlayer = new MediaPlayer(music);
//        mediaPlayer.play();
//
//    }
    public static void main(String[] args) {
        launch(args);
    }


}
class CustomPane extends StackPane{
    public CustomPane(String title){
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: blue");
        setPadding(new Insets(12));
    }
    public static HBox getHBox(){
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setStyle("-fx-background-color: rgb(137, 149, 243)");
        Logo logotip = new Logo();

        hBox.getChildren().addAll(logotip);

        return hBox;
    }

    public static HBox getImage(){
        HBox mainPageImage = new HBox(20);
        mainPageImage.setPadding(new Insets(2));
        Image mainCakes = new Image("File:///C:/Users/bekza/Desktop/examples/projects/newOneMain.png");
        ImageView imageView = new ImageView(mainCakes);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        imageView.setLayoutX(400);
        imageView.setLayoutY(150);
        mainPageImage.getChildren().addAll(imageView);
        return mainPageImage;

    }
    public static VBox getVBox() {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20));
        vBox.setStyle("-fx-background-color: rgb(227, 165, 209)");
        Label products = new Label("Торты: ");
        products.setFont(Font.font("Arial Rounded MT Bold", 25));
        products.setTextFill(Color.BLUE);
        //products.setUnderline(true);
        vBox.getChildren().add(products);

        Button[] cakes = {new Button("Медовик"), new Button("Вупипай"),
                new Button("Milky girl"), new Button("Red velvet"), new Button("Сникерс")};
        for (Button cake : cakes) {
            VBox.setMargin(cake, new Insets(5));
            cake.setFont(Font.font("Bahnschrift SemiBold"));
            cake.setPrefSize(100, 30);
            cakes[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Main.createStage("Медовик");
                }
            });
            cakes[1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Main.createStage("Вупипай");
                }
            });
            cakes[2].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Main.createStage("Milky girl");
                }
            });
            cakes[3].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Main.createStage("Red velvet");
                }
            });
            cakes[4].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Main.createStage("Сникерс");
                }
            });
            vBox.getChildren().add(cake);
        }
        return vBox;
    }


}
class Logo extends Pane {
    public Logo(){
        Ellipse boardEllipse = new Ellipse(250, 50, 200, 45);
        boardEllipse.setFill(Color.WHITE);
        Rectangle cap = new Rectangle(160, 40, 30,25);
        cap.setFill(Color.GRAY);
        Ellipse capsEllipse = new Ellipse(175, 30, 25,15);
        capsEllipse.setFill(Color.GRAY);
        Line line = new Line(203, 20,203, 65);
        line.setFill(Color.BLUE);
        line.setStroke(new LinearGradient(0d, -5d, 0d, 5d, false,
                CycleMethod.NO_CYCLE, new Stop(0,Color.BLUE)));
        line.setStrokeWidth(5);
        line.setStartX(203);
        line.setStartY(20);
        Ellipse labelsPart1 = new Ellipse(225, 30, 20, 14 );
        labelsPart1.setFill(Color.BLUE);
        Ellipse labelsInnerPart1 = new Ellipse(225, 30, 15,9);
        labelsInnerPart1.setFill(Color.WHITE);
        Ellipse labelsPart2 = new Ellipse(225, 53, 20, 14 );
        labelsPart2.setFill(Color.BLUE);
        Ellipse labelsInnerPart2 = new Ellipse(225, 53, 15,9);
        labelsInnerPart2.setFill(Color.WHITE);
        Label recipes = new Label("Рецепты");
        recipes.setLayoutX(246);
        recipes.setLayoutY(41);
        recipes.setFont(Font.font("Broadway", 25));
        recipes.setTextFill(Color.BLACK);



//        HBox hbox = new HBox(30);
//        hbox.setPrefSize(400, 400);
//        hbox.setAlignment(Pos.BOTTOM_CENTER);
//        hbox.getChildren().addAll(boardEllipse, cap, capsEllipse, line, labelsPart1, labelsInnerPart1, labelsPart2, labelsInnerPart2, recipes);

        getChildren().addAll(boardEllipse, cap, capsEllipse, line, labelsPart1,labelsInnerPart1, labelsPart2, labelsInnerPart2, recipes);
    }
}

class StarPane extends Pane {
    Polyline stars;

    public StarPane(int x, int y, Color color) {
        stars= new Polyline(
                new double[]{
                        x-4, y+1,
                        x-7, y-2,
                        x-2, y-3,
                        x, y-6,
                        x+2, y-3,
                        x+7, y-2,
                        x+4, y+1,
                        x+5, y+5,
                        x, y+3,
                        x-5, y+5,
                        x-4, y+1
                }
        );
        stars.setFill(color);
        getChildren().add(stars);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();

                if(stars.getLayoutX()>=550){
                    setLayoutX(0);
                    }
            }
        };
        timer.start();
    }
    public void move(){
             setLayoutX(getLayoutX()+1.5);
        }
    public static Pane getAnimation(){
        Pane animation = new Pane();
        StarPane stars1 = new StarPane(20,15, Color.BLUE);
        StarPane stars2 = new StarPane(40,15, Color.BLUE);
        StarPane stars3 = new StarPane(60,15, Color.BLUE);
        StarPane stars4 = new StarPane(80,15, Color.BLUE);
        StarPane stars5 = new StarPane(100,15, Color.BLUE);
        StarPane stars6 = new StarPane(120,15, Color.BLUE);
        StarPane stars7 = new StarPane(140,15, Color.BLUE);
        StarPane stars8 = new StarPane(160,15, Color.BLUE);
        StarPane stars9 = new StarPane(180,15, Color.BLUE);
        StarPane stars10 = new StarPane(200,15, Color.BLUE);
        StarPane stars11 = new StarPane(220,15, Color.BLUE);
        StarPane stars12 = new StarPane(240,15, Color.BLUE);
        StarPane stars13 = new StarPane(260,15, Color.BLUE);
        StarPane stars14 = new StarPane(280,15, Color.BLUE);
        StarPane stars15 = new StarPane(300,15, Color.BLUE);
        StarPane stars16 = new StarPane(320,15, Color.BLUE);
        StarPane stars17 = new StarPane(340,15, Color.BLUE);
        StarPane stars18 = new StarPane(360,15, Color.BLUE);
        StarPane stars19 = new StarPane(380,15, Color.BLUE);
        StarPane stars20 = new StarPane(400,15, Color.BLUE);
        animation.getChildren().addAll(stars1, stars2, stars3, stars4, stars5,
                stars6, stars7, stars8, stars9,stars10, stars11, stars12, stars13,
                stars14, stars15, stars16, stars17, stars18, stars19, stars20);
        return animation;
    }
}
class Cake{
    String name;
    String testoRecipe;
    String creamRecipe;
    String forDecoration;
    String time;
    Image image1;
   // Image image2;

    public Cake(String name, String testoRecipe, String creamRecipe, String forDecoration, String time, Image image1) {
        this.name = name;
        this.testoRecipe = testoRecipe;
        this.creamRecipe = creamRecipe;
        this.forDecoration = forDecoration;
        this.time = time;
        this.image1 = image1;
       // this.image2 = image2;
    }

    @Override
    public String toString() {
        return name;
    }

}

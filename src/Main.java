import java.io.File;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{

	Group container;
	Scene scene;
	
	public void init() {
		container = new Group();
		scene = new Scene(container, 600, 400);
		
		//shapes
		Line line = new Line();
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(100);
		line.setEndY(200);

		//gradient
		Stop[] stops = new Stop[] {
			new Stop(0, Color.RED),
			new Stop(1, Color.BLUEVIOLET)
		}; 
		LinearGradient grad = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
		
		Rectangle rect = new Rectangle();
		rect.setX(200);
		rect.setY(300);
		rect.setHeight(100);
		rect.setWidth(50);
//		rect.setFill(Color.AQUA);
		rect.setFill(grad);
		
		Circle circ = new Circle();
		circ.setCenterX(200);
		circ.setCenterY(300);
		circ.setRadius(20);
		circ.setFill(Color.BROWN);
		circ.setStroke(Color.BLUE);
		circ.setOpacity(0.3);
		
		//animation
		RotateTransition rot = new RotateTransition();
		rot.setNode(rect);
		rot.setByAngle(90); //rotate sebanyak apa
		rot.setDuration(Duration.seconds(2));
		rot.setCycleCount(5);
		rot.play();
		
		TranslateTransition tran = new TranslateTransition();
		tran.setNode(line);
		tran.setByX(100); // geser sebanyak apa
		tran.setByY(100);
		tran.setDuration(Duration.seconds(3));
		tran.play();
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(circ);
		scale.setByX(1.5);
		scale.play();
		
		//Media
//		Image img = new Image("image_example.jpg"); 
		Image img = new Image(new File("image_example.jpg").toURI().toString()); 
		ImageView iv = new ImageView(img);
		iv.setX(100);
		iv.setY(100);
		iv.setFitHeight(200);
		iv.setPreserveRatio(true);
		
		Media med = new Media(new File("audio_example.wav").toURI().toString());
		MediaPlayer mp2 = new MediaPlayer(med);
		mp2.setStopTime(Duration.seconds(3));
		mp2.setVolume(0.3);
		mp2.play();
		
		Media vid = new Media(new File("video_example.mp4").toURI().toString());
		MediaPlayer mp = new MediaPlayer(vid);
		MediaView mv = new MediaView(mp);
//		mp.play();
		mv.setX(100);
		mv.setFitHeight(200);
		
		container.getChildren().add(line);
		container.getChildren().add(rect);
		container.getChildren().add(circ);
		container.getChildren().add(iv);
		container.getChildren().add(mv);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JAVAH4");
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
//		launch(args);
		SnakeGame.launch(SnakeGame.class);
	}
}

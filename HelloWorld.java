import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloWorld extends Application {
  @Override
  public void start(Stage stage) {
    Text text = new Text("Hello World");
    text.setFont(Font.font(60));
    text.setFill(Color.DARKBLUE);
    text.setX((500 - text.getLayoutBounds().getWidth()) / 2);
    text.setY((300 - text.getLayoutBounds().getHeight()) / 2 + text.getLayoutBounds().getHeight());

    ImageView imageView = new ImageView(new Image("https://play-lh.googleusercontent.com/AKLmTPMSU0uqZfsPO-YluyXcSg1uHAXTjhDOt3P2FjeCZF2iHyrWmSBGnx8leE--wp8i"));
    imageView.setOpacity(0);

    Group root = new Group(text, imageView);
    Scene scene = new Scene(root, imageView.getImage().getWidth(), imageView.getImage().getHeight());

    stage.setTitle("Hello World Animation");
    stage.setScene(scene);
    stage.show();

    FadeTransition fadeOutText = new FadeTransition(Duration.seconds(2), text);
    fadeOutText.setFromValue(1);
    fadeOutText.setToValue(0);

    FadeTransition fadeInImage = new FadeTransition(Duration.seconds(2), imageView);
    fadeInImage.setFromValue(0);
    fadeInImage.setToValue(1);

    SequentialTransition sequentialTransition = new SequentialTransition(fadeOutText, fadeInImage);
    sequentialTransition.play();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

package sample;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Dodecaedr dodecaedr = new Dodecaedr();
        MeshView dodecahedron = dodecaedr.createDodecahedron(75);
        dodecahedron.translateXProperty().set(900);
        dodecahedron.translateYProperty().set(350);
        dodecahedron.getTransforms().add(new Rotate(30, Rotate.X_AXIS));
        dodecahedron.getTransforms().add(new Rotate(30, Rotate.Y_AXIS));

        float[][] arrE = new float[6][4];
        int[][] arr1 = {{900, 400, 0, 1},
                {800, 300, 0, 1},
                {800, 400, -100, 1},
                {700, 400, 0, 1},
                {800, 400, 100, 1},
                {800, 500, 0, 1}};

        double[][] arr2 = {{Math.cos(0.5), 0, -Math.sin(0.5), 0},
                {0, 1, 0, 0},
                {Math.sin(0.5), 0, Math.cos(0.5), 0},
                {0, 0, 0, 1}};

        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2.length; k++) {
                for (int j = 0; j < arr2.length; j++) {
                    arrE[i][k] += arr1[i][j]*arr2[j][k];
                }
            }
        }


        TriangleMy t = new TriangleMy(500, 500, 100, 300, 300, 100, 300, 500, -100);

        TriangleMy t1 = new TriangleMy(500, 500, 100, 300, 300, 100, 500, 300, -100);

        TriangleMy t2 = new TriangleMy(300, 500, -100, 500, 300, -100, 500, 500, 100);

        TriangleMy t3 = new TriangleMy(300, 500, -100, 500, 300, -100, 300, 300, 100);


        TriangleMy tr1 = new TriangleMy(arrE[0][0],arrE[0][1], arrE[0][2], arrE[1][0],arrE[1][1], arrE[1][2], arrE[2][0],arrE[2][1], arrE[2][2]);

        TriangleMy tr2 = new TriangleMy(arrE[0][0],arrE[0][1], arrE[0][2], arrE[5][0],arrE[5][1], arrE[5][2], arrE[2][0],arrE[2][1], arrE[2][2]);

        TriangleMy tr3 = new TriangleMy(arrE[3][0],arrE[3][1], arrE[3][2], arrE[5][0],arrE[5][1], arrE[5][2], arrE[2][0],arrE[2][1], arrE[2][2]);

        TriangleMy tr4 = new TriangleMy(arrE[3][0],arrE[3][1], arrE[3][2], arrE[1][0],arrE[1][1], arrE[1][2], arrE[2][0],arrE[2][1], arrE[2][2]);

        TriangleMy tr5 = new TriangleMy(arrE[0][0],arrE[0][1], arrE[0][2], arrE[1][0],arrE[1][1], arrE[1][2], arrE[4][0],arrE[4][1], arrE[4][2]);

        TriangleMy tr6 = new TriangleMy(arrE[0][0],arrE[0][1], arrE[0][2], arrE[5][0],arrE[5][1], arrE[5][2], arrE[4][0],arrE[4][1], arrE[4][2]);

        TriangleMy tr7 = new TriangleMy(arrE[3][0],arrE[3][1], arrE[3][2], arrE[5][0],arrE[5][1], arrE[5][2], arrE[4][0],arrE[4][1], arrE[4][2]);

        TriangleMy tr8 = new TriangleMy(arrE[3][0],arrE[3][1], arrE[3][2], arrE[1][0],arrE[1][1], arrE[1][2], arrE[4][0],arrE[4][1], arrE[4][2]);




        Camera camera = new PerspectiveCamera(true);
        camera.setRotate(90);


        //куб
        Box box = new Box(200, 60, 100);
        Transform transform = new Rotate(65, new Point3D(1, 1, 0));
        box.getTransforms().add(transform);
        box.setTranslateX(150);
        box.setTranslateY(150);

        t.mes().setRotate(70);
        t1.mes().setRotate(70);
        t2.mes().setRotate(70);
        t3.mes().setRotate(70);
        t.mes().setRotationAxis(new Point3D(10, 10, 10));
        t1.mes().setRotationAxis(new Point3D(10, 10, 10));
        t2.mes().setRotationAxis(new Point3D(10, 10, 10));
        t3.mes().setRotationAxis(new Point3D(10, 10, 10));



        Group root = new Group(t.mes(),t1.mes(), t2.mes(), t3.mes(), tr1.mes(),tr2.mes(),tr3.mes(),tr4.mes(), tr5.mes(), tr6.mes(), tr7.mes(), tr8.mes(), dodecahedron, box);
        Scene scene = new Scene(root, 1200, 600);
        stage.setScene(scene);
        stage.setTitle("Фигуры");
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}




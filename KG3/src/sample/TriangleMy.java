package sample;

import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class TriangleMy {
    private MeshView meshView;
    final private float[] ARR = {0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f};
    final private int[] FACES = {0, 0, 2, 2, 1, 1, 0, 0, 1, 1, 2, 2};

    TriangleMy(float ... floats ){
        TriangleMesh t = new TriangleMesh();
        t.getPoints().addAll(floats);
        t.getTexCoords().addAll(ARR);
        t.getFaces().addAll(FACES);
        this.meshView = new MeshView();
        meshView.setMesh(t);
    }

    public MeshView mes() {
        return this.meshView;
    }


}

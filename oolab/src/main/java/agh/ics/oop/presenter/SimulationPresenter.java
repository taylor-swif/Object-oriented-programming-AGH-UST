package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import agh.ics.oop.Simulation;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class SimulationPresenter implements MapChangeListener {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField moveTextField;

    private WorldMap worldMap;

    @FXML
    private GridPane mapGrid;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
        drawMap();
    }

    @FXML
    private void onSimulationStartClicked() {
        String movesInput = moveTextField.getText();
        System.out.println(movesInput);
        List<MoveDirection> moves = OptionsParser.parse(movesInput.split(" "));
//        List<MoveDirection> moves = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD);

        Simulation simulation = new Simulation(List.of(new Vector2d(2, 2), new Vector2d(0, 0)), moves, worldMap);
        SimulationEngine engine = new SimulationEngine(new ArrayList<>(List.of(simulation)), 4);
        engine.runAsyncInThreadPool();
    }
    private String drawObject(Vector2d currentPosition) {
        if (worldMap.isOccupied(currentPosition)) {
            Object object = worldMap.objectAt(currentPosition);
            if (object != null) {
                return object.toString();
            }
        }
        return " ";
    }

    public void drawMap() {
        Platform.runLater(() -> {

            clearGrid();

            Boundary bounds = worldMap.getCurrentBounds();
            int columns = bounds.upperRight().getX() - bounds.lowerLeft().getX() + 1;
            int rows = bounds.upperRight().getY() - bounds.lowerLeft().getY() + 1;

            for (int col = 0; col < columns + 1; col++) {
                mapGrid.getColumnConstraints().add(new ColumnConstraints(50));
            }

            for (int row = 0; row < rows + 1; row++) {
                mapGrid.getRowConstraints().add(new RowConstraints(50));
            }
            for (int col = bounds.lowerLeft().getX(); col <= bounds.upperRight().getX(); col++) {
                mapGrid.add(new Label(String.valueOf(col)), col - bounds.lowerLeft().getX() + 1, 0);
            }
            for (int row = bounds.lowerLeft().getY(); row <= bounds.upperRight().getY(); row++) {
                mapGrid.add(new Label(String.valueOf(row)), 0, rows - (row - bounds.lowerLeft().getY()));
            }
            mapGrid.add(new Label("y\\x"), 0, 0);

            for (int col = bounds.lowerLeft().getX(); col <= bounds.upperRight().getX(); col++) {
                for (int row = bounds.lowerLeft().getY(); row <= bounds.upperRight().getY(); row++) {
                    Label label = new Label(drawObject(new Vector2d(col, row)));
                    GridPane.setHalignment(label, HPos.CENTER);
                    mapGrid.add(label, col - bounds.lowerLeft().getX() + 1, rows - (row - bounds.lowerLeft().getY()));
                }
            }
        });
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap();
    }
}

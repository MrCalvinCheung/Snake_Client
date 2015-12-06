package UI;

import SDK.Score;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by MrCalvinCheung on 02/12/2015.
 * This class creates the Jtable i used to display highscore
 *
 */
public class HighscoreTableModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private ArrayList<Score> highscores;
    private String[] columns = {"Name", "Score", "ID"};
    private int numberOfRows;

    public HighscoreTableModel(ArrayList<Score> highscores)
    {
        this.highscores = highscores;
        fireTableStructureChanged();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    @Override
    public int getRowCount() {
        numberOfRows = highscores.size();
        return numberOfRows;
    }

    public String getColumnName(int columnIndex) {

        return columns[columnIndex];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return highscores.get(rowIndex).getGame().getWinner().getUsername();
            case 1:
                return highscores.get(rowIndex).getScore();
            case 2:
                return highscores.get(rowIndex).getGame().getGameId();

        }

        return null;
    }

    }
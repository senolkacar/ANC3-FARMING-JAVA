package eu.epfc.anc3.model;

import java.util.ArrayList;
import java.util.List;

public class GameCaretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void saveState(GameFacade game) {
        mementos.add(game.createMemento());
    }

    public void restoreState(GameFacade game, int index) {
        if (index >= 0 && index < mementos.size()) {
            game.setMemento(mementos.get(index));
        }
    }

    public int getMementoCount() {
        return mementos.size();
    }

}

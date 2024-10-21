package hva.app.habitat;

import hva.app.exception.UnknownHabitatKeyException;
import hva.app.exception.UnknownTreeKeyException;
import hva.core.Arvore;
import hva.core.Habitats;
import hva.core.Hotel;
import hva.core.exception.NoArvoreKeyException;
import hva.core.exception.NoHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Add a new tree to a given habitat of the current zoo hotel.
 **/
class DoAddTreeToHabitat extends Command<Hotel> {

  DoAddTreeToHabitat(Hotel receiver) {
    super(Label.ADD_TREE_TO_HABITAT, receiver);
  }

  @Override
  protected void execute() throws CommandException {
    // Solicitar os dados da árvore
    String habitatId = Form.requestString(Prompt.habitatKey());
    String treeId = Form.requestString(Prompt.treeKey());
    String treeName = Form.requestString(Prompt.treeName());
    int treeAge = Form.requestInteger(Prompt.treeAge());
    String leafType = Form.requestString(Prompt.treeType());
    int cleaningDifficulty = Form.requestInteger(Prompt.treeDifficulty());

    try {
      Habitats habitat = _receiver.findHabitatById(habitatId);
      // **Criação da árvore antes de adicionar ao habitat**
      Arvore tree = new Arvore(treeId, treeName, treeAge, leafType, cleaningDifficulty, _receiver.getCurrentSeason());

      _receiver.addTreeToHabitat(habitatId, treeId);
      habitat.addTree(tree);

      _display.addLine("Árvore adicionada ao habitat|" + treeId + "|" + treeName);
    } catch (NoHabitatKeyException e) {
      throw new UnknownHabitatKeyException(habitatId);
    } catch (NoArvoreKeyException e) {
      throw new UnknownTreeKeyException(treeId);
    }

    _display.display();
  }
}

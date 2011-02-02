/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mathematics.Graph.Builder;

import Mathematics.Graph.TreeNode;
import Mathematics.Result.Result;

/**
 * Interface for a class for making/building/constructing
 * <a href="http://en.wikipedia.org/wiki/Tree_%28data_structure%29">trees</a> or
 * <a href="http://en.wikipedia.org/wiki/Lattice_graph">lattices</a>.
 * @author Rune Dahl Iversen
 * @param <TypeOfState> Type of state.
 * @param <TypeOfValue> Type of value.
 */
public interface TreeBuilder<TypeOfState, TypeOfValue> {
    /**
     * Build a tree originating from the specified {@see TreeNode origin}
     * and return any {@see Result result} from the building-proces.
     * @param origin Node of origin.
     * @return       Result from the building process.
     */
    public Result Build(TreeNode<TypeOfState, TypeOfValue> origin);
}
package SEAS.Model.shared;

import java.util.List;

public interface FileJsonInterface<E> {
    /**
     * Method to get objects from a file
     * @param pathFile
     * @param classOfT
     * @return
     */
    List<E> getObjects(String pathFile, Class<E[]> classOfT);

    /**
     * Method to write objects to a file
     * @param pathFile
     * @param objects
     * @return
     */
    Boolean writeObjects(String pathFile, List<E> objects);
}

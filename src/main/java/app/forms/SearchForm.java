package app.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mega- on 22.04.2017.
 */
public class SearchForm {

    private String searchTerm;

    public String getSearchTerm(){
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm){
        this.searchTerm = searchTerm;
    }
}

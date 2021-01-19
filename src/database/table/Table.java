package database.table;

import java.util.ArrayList;

public interface Table {

    void view_table();

    void delete(int id);

    void clean_table();

    void initial_table(ArrayList list);
}

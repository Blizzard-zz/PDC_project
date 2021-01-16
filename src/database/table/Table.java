package database.table;

import java.util.ArrayList;

public interface Table {

    void view_table();

    void delete(int id, String table_name);

    void clean_table(String table_name);

    void initial_table(ArrayList list);
}

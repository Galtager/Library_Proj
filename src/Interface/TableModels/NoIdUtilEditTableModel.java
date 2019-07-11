package Interface.TableModels;

import javax.swing.table.DefaultTableModel;

public class NoIdUtilEditTableModel extends DefaultTableModel {

	public NoIdUtilEditTableModel(Object[][] objects, String[] strings) {
		// TODO Auto-generated constructor stub
		super(objects, strings);
	}

	@Override
    public boolean isCellEditable(int row, int column){  
        if(column == 0 || column == 5)
        	return false;
        
        return true;
	}
}

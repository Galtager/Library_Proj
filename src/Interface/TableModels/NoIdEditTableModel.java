package Interface.TableModels;

import javax.swing.table.DefaultTableModel;

public class NoIdEditTableModel extends DefaultTableModel {
	
	public NoIdEditTableModel(Object[][] objects, String[] strings) {
		// TODO Auto-generated constructor stub
		super(objects, strings);
	}

	@Override
    public boolean isCellEditable(int row, int column){  
        if(column == 0)
        	return false;
        
        return true;
    }
}

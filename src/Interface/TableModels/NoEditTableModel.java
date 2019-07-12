package Interface.TableModels;

import javax.swing.table.DefaultTableModel;

public class NoEditTableModel extends DefaultTableModel {
	
	public NoEditTableModel(Object[][] objects, String[] strings) {
		// TODO Auto-generated constructor stub
		super(objects, strings);
	}
	
	@Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }

}

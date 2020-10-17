package Swing_1;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellrenderer extends DefaultTableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		// TODO Auto-generated method stub
			Component comp =null;
			
			comp=new JButton("1");
			return comp;
	}
}

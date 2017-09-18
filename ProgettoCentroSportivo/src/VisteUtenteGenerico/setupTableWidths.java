package VisteUtenteGenerico;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;




public class setupTableWidths {
	
public static JTable setupTableWidths(JTable table){
JTableHeader tableHeader = table.getTableHeader();
TableModel model = table.getModel();
TableColumnModel columnModel = table.getColumnModel();
Dimension spacing = table.getIntercellSpacing();

table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

int columns = model.getColumnCount();
int rows = model.getRowCount();

for (int c = 0; c < columns; c++) {
int viewCol = table.convertColumnIndexToView(c);

if (viewCol != -1) {
TableColumn tableColumn = columnModel.getColumn(viewCol);

TableCellRenderer headRend = tableColumn.getHeaderRenderer();

if (headRend == null) {
headRend = tableHeader.getDefaultRenderer();
}

TableCellRenderer cellRend = tableColumn.getCellRenderer();

if (cellRend == null) {
cellRend = table.getDefaultRenderer(model.getColumnClass(c));
}

Component headComp = headRend.getTableCellRendererComponent(table,
tableColumn.getHeaderValue(), false, false, 0, c);

int maxWidth = headComp.getPreferredSize().width;

for (int r = 0; r < rows; r++) {
Component comp = cellRend.getTableCellRendererComponent(table,
model.getValueAt(r, c), false, false, r, c);

int w = comp.getPreferredSize().width;

if (w > maxWidth) {
maxWidth = w;
}
}

maxWidth += spacing.width;

tableColumn.setPreferredWidth(maxWidth);
}}
return table;


}}

package gui;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import model.Gast;

public class GästeListeDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable tbGaeste;
    private JPanel contentPane;

    public GästeListeDialog() {
	setTitle("Gästeliste");
	setResizable(false);
	setBounds(100, 100, 453, 287);
	setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	setModal(true);
	setAlwaysOnTop(true);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 11, 424, 239);
	contentPane.add(scrollPane);

	tbGaeste = new JTable(new GaesteTableModel());
	scrollPane.setViewportView(tbGaeste);
	
	DefaultTableCellRenderer tbGaesteRenderer = new DefaultTableCellRenderer();
	tbGaesteRenderer.setHorizontalAlignment(JLabel.CENTER);
	tbGaeste.setDefaultRenderer(String.class, tbGaesteRenderer);
	tbGaeste.setDefaultRenderer(Integer.class, tbGaesteRenderer);
    }
    
    public void setGäste(List<Gast> gäste) {
	((GaesteTableModel)tbGaeste.getModel()).setGäste(gäste);
    }
}

package gui;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import model.Gast;
import javax.swing.JButton;

public class WaehleGastDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable tbGaeste;
    private JPanel contentPane;
    private JButton btnGastAuswhlen;

    public WaehleGastDialog(ActionListener listener) {
	setTitle("Gast auswählen");
	setResizable(false);
	setBounds(100, 100, 453, 320);
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
	
	btnGastAuswhlen = new JButton("Gast auswählen");
	btnGastAuswhlen.setBounds(153, 261, 153, 23);
	btnGastAuswhlen.addActionListener(listener);
	contentPane.add(btnGastAuswhlen);
	
	DefaultTableCellRenderer tbGaesteRenderer = new DefaultTableCellRenderer();
	tbGaesteRenderer.setHorizontalAlignment(JLabel.CENTER);
	tbGaeste.setDefaultRenderer(String.class, tbGaesteRenderer);
	tbGaeste.setDefaultRenderer(Integer.class, tbGaesteRenderer);
	
	tbGaeste.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            btnGastAuswhlen.setEnabled(true);
	        }
	    });
    }
    
    public Gast getGastID() {
	return ((GaesteTableModel)tbGaeste.getModel()).getGast(tbGaeste.getSelectedRow());
    }
    
    public void setGäste(List<Gast> gäste) {
	((GaesteTableModel)tbGaeste.getModel()).setGäste(gäste);
	btnGastAuswhlen.setEnabled(false);
    }
}
